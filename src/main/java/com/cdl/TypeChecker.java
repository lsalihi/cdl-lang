package com.cdl;

import com.cdl.ast.*;
import java.util.*;

public class TypeChecker {
    private List<CDError> errors = new ArrayList<>();
    private Map<String, TypeDefinition> typeRegistry = new HashMap<>();
    private Set<String> visiting = new HashSet<>();

    public void check(Program program, SymbolTable symbolTable) {
        // First pass: collect all type definitions
        collectTypeDefinitions(program);

        // Second pass: check for circular references
        checkCircularReferences();

        // Third pass: validate all statements
        for (Statement stmt : program.getStatements()) {
            if (stmt instanceof TypeDefinition) {
                checkTypeDefinition((TypeDefinition) stmt);
            } else if (stmt instanceof Intent) {
                checkIntent((Intent) stmt);
            } else if (stmt instanceof Rule) {
                checkRule((Rule) stmt);
            }
        }
    }

    private void collectTypeDefinitions(Program program) {
        for (Statement stmt : program.getStatements()) {
            if (stmt instanceof TypeDefinition) {
                TypeDefinition typeDef = (TypeDefinition) stmt;
                if (typeRegistry.containsKey(typeDef.getId())) {
                    errors.add(new CDError(CDError.Code.DUPLICATE_ID,
                        "Duplicate type definition: " + typeDef.getId(), 0, 0));
                } else {
                    typeRegistry.put(typeDef.getId(), typeDef);
                }
            }
        }
    }

    private void checkCircularReferences() {
        for (TypeDefinition typeDef : typeRegistry.values()) {
            checkCircularReference(typeDef.getId(), new HashSet<>());
        }
    }

    private void checkCircularReference(String typeName, Set<String> path) {
        if (path.contains(typeName)) {
            errors.add(new CDError(CDError.Code.CIRCULAR_REFERENCE,
                "Circular type reference: " + String.join(" -> ", path) + " -> " + typeName, 0, 0));
            return;
        }

        if (!typeRegistry.containsKey(typeName) || visiting.contains(typeName)) {
            return;
        }

        visiting.add(typeName);
        path.add(typeName);

        TypeDefinition typeDef = typeRegistry.get(typeName);
        for (Field field : typeDef.getFields()) {
            String fieldTypeName = field.getTypeRef().getName();
            if (typeRegistry.containsKey(fieldTypeName)) {
                checkCircularReference(fieldTypeName, new HashSet<>(path));
            }
        }

        visiting.remove(typeName);
    }

    private void checkTypeDefinition(TypeDefinition typeDef) {
        for (Field field : typeDef.getFields()) {
            // Check that field type exists
            String fieldTypeName = field.getTypeRef().getName();
            if (!isBuiltInType(fieldTypeName) && !typeRegistry.containsKey(fieldTypeName)) {
                errors.add(new CDError(CDError.Code.TYPE_NOT_FOUND,
                    "Type '" + fieldTypeName + "' not found in field '" + field.getName() + "' of type '" + typeDef.getId() + "'", 0, 0));
            }

            // Check parameterized types
            if (field.getTypeRef().isParameterized()) {
                checkParameterizedType(field.getTypeRef(), field.getName(), typeDef.getId());
            }

            // Check constraints
            if (field.getConstraint() != null) {
                checkConstraint(field.getConstraint(), field.getTypeRef());
            }
        }
    }

    private void checkParameterizedType(TypeReference typeRef, String fieldName, String typeId) {
        String baseType = typeRef.getName();
        // For now, only Money is supported as parameterized type
        if (!baseType.equals("Money")) {
            errors.add(new CDError(CDError.Code.INVALID_TYPE,
                "Parameterized type '" + baseType + "' not supported in field '" + fieldName + "' of type '" + typeId + "'", 0, 0));
        }

        // Check parameter types
        for (Parameter param : typeRef.getParameters()) {
            String paramTypeName = param.getTypeRef().getName();
            if (!isBuiltInType(paramTypeName) && !typeRegistry.containsKey(paramTypeName)) {
                errors.add(new CDError(CDError.Code.TYPE_NOT_FOUND,
                    "Parameter type '" + paramTypeName + "' not found in parameterized type '" + baseType + "'", 0, 0));
            }
        }
    }

    private void checkIntent(Intent intent) {
        // Check input types
        for (TypedParameter param : intent.getInputs()) {
            checkTypedParameter(param, "input", intent.getId());
        }

        // Check output types
        for (TypedParameter param : intent.getOutputs()) {
            checkTypedParameter(param, "output", intent.getId());
        }

        // Check legacy metadata validation
        Map<String, Object> meta = intent.getMeta();
        if (meta.containsKey("goal")) {
            if (!(meta.get("goal") instanceof String)) {
                errors.add(new CDError(CDError.Code.INVALID_TYPE, "goal must be string in " + intent.getId(), 0, 0));
            }
        }
    }

    private void checkTypedParameter(TypedParameter param, String direction, String intentId) {
        String typeName = param.getTypeRef().getName();
        if (!isBuiltInType(typeName) && !typeRegistry.containsKey(typeName)) {
            errors.add(new CDError(CDError.Code.TYPE_NOT_FOUND,
                direction + " parameter '" + param.getName() + "' references unknown type '" + typeName + "' in intent '" + intentId + "'", 0, 0));
        }

        if (param.getConstraint() != null) {
            checkConstraint(param.getConstraint(), param.getTypeRef());
        }
    }

    private void checkConstraint(Expression constraint, TypeReference typeRef) {
        String expr = constraint.getExpression();
        String typeName = typeRef.getName();

        // Basic validation of expression syntax
        if (!isValidExpression(expr)) {
            errors.add(new CDError(CDError.Code.INVALID_CONSTRAINT,
                "Invalid constraint expression: " + expr, 0, 0));
            return;
        }

        // Type-specific constraint validation
        if (typeName.equals("string")) {
            validateStringConstraint(expr);
        } else if (typeName.equals("int") || typeName.equals("decimal")) {
            validateNumericConstraint(expr);
        } else if (typeName.equals("date") || typeName.equals("datetime")) {
            validateDateConstraint(expr);
        }
    }

    private boolean isValidExpression(String expr) {
        // Basic syntax check - ensure balanced parentheses and valid operators
        int parenCount = 0;
        for (char c : expr.toCharArray()) {
            if (c == '(') parenCount++;
            else if (c == ')') parenCount--;
            if (parenCount < 0) return false;
        }
        return parenCount == 0;
    }

    private void validateStringConstraint(String expr) {
        // Allow length(), contains(), startsWith(), endsWith(), in operations
        if (!(expr.contains("length(") || expr.contains("contains(") ||
              expr.contains("startsWith(") || expr.contains("endsWith(") ||
              expr.contains(" in ") || isComparisonOp(expr))) {
            errors.add(new CDError(CDError.Code.INVALID_CONSTRAINT,
                "Invalid string constraint: " + expr + ". Valid operations: length(), contains(), startsWith(), endsWith(), in, comparisons", 0, 0));
        }
    }

    private void validateNumericConstraint(String expr) {
        // Allow arithmetic comparisons and range checks
        if (!isComparisonOp(expr)) {
            errors.add(new CDError(CDError.Code.INVALID_CONSTRAINT,
                "Invalid numeric constraint: " + expr + ". Valid operations: >, <, >=, <=, ==, !=", 0, 0));
        }
    }

    private void validateDateConstraint(String expr) {
        // Allow date comparisons and functions like today()
        if (!(isComparisonOp(expr) || expr.contains("today()"))) {
            errors.add(new CDError(CDError.Code.INVALID_CONSTRAINT,
                "Invalid date constraint: " + expr + ". Valid operations: comparisons, today()", 0, 0));
        }
    }

    private boolean isComparisonOp(String expr) {
        return expr.contains("==") || expr.contains("!=") || expr.contains("<") ||
               expr.contains(">") || expr.contains("<=") || expr.contains(">=");
    }

    private boolean isBuiltInType(String typeName) {
        return typeName.equals("string") || typeName.equals("int") || typeName.equals("decimal") ||
               typeName.equals("bool") || typeName.equals("date") || typeName.equals("datetime") ||
               typeName.equals("Email") || typeName.equals("Money");
    }

    private void checkRule(Rule rule) {
        Map<String, Object> meta = rule.getMeta();
        if (meta.containsKey("statement")) {
            if (!(meta.get("statement") instanceof String)) {
                errors.add(new CDError(CDError.Code.INVALID_TYPE, "statement must be string in " + rule.getId(), 0, 0));
            }
        }
    }

    public List<CDError> getErrors() {
        return errors;
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }
}
