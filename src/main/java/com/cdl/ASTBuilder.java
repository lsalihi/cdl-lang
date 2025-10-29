package com.cdl;

import com.cdl.ast.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.util.*;

public class ASTBuilder extends CDLBaseListener {
    private Program program;
    private List<Statement> statements = new ArrayList<>();
    private Map<String, Object> currentMeta = new HashMap<>();
    private List<String> currentSteps = new ArrayList<>();
    private String currentTarget = "";
    private List<TypedParameter> currentInputs = new ArrayList<>();
    private List<TypedParameter> currentOutputs = new ArrayList<>();

    @Override
    public void enterIntent(CDLParser.IntentContext ctx) {
        currentMeta.clear();
    }

    @Override
    public void exitIntent(CDLParser.IntentContext ctx) {
        String id = ctx.ID().getText();
        // For phase 1, parse inputs/outputs from meta if they exist
        List<TypedParameter> inputs = parseTypedParameters((String) currentMeta.get("inputs"));
        List<TypedParameter> outputs = parseTypedParameters((String) currentMeta.get("outputs"));
        statements.add(new Intent(id, new HashMap<>(currentMeta), inputs, outputs));
    }

    @Override
    public void enterRule(CDLParser.RuleContext ctx) {
        currentMeta.clear();
    }

    @Override
    public void exitRule(CDLParser.RuleContext ctx) {
        String id = ctx.ID().getText();
        statements.add(new Rule(id, new HashMap<>(currentMeta)));
    }

    @Override
    public void enterPolicy(CDLParser.PolicyContext ctx) {
        currentMeta.clear();
    }

    @Override
    public void exitPolicy(CDLParser.PolicyContext ctx) {
        String id = ctx.ID().getText();
        statements.add(new Policy(id, new HashMap<>(currentMeta)));
    }

    @Override
    public void enterFlow(CDLParser.FlowContext ctx) {
        currentMeta.clear();
        currentSteps.clear();
    }

    @Override
    public void exitFlow(CDLParser.FlowContext ctx) {
        String id = ctx.ID().getText();
        statements.add(new Flow(id, new HashMap<>(currentMeta), new ArrayList<>(currentSteps)));
    }

    @Override
    public void enterMapping(CDLParser.MappingContext ctx) {
        currentMeta.clear();
        currentTarget = ctx.target().getText();
    }

    @Override
    public void exitMapping(CDLParser.MappingContext ctx) {
        String id = ctx.ID().getText();
        statements.add(new Mapping(id, currentTarget, new HashMap<>(currentMeta)));
    }

    @Override
    public void enterTypeDef(CDLParser.TypeDefContext ctx) {
        currentFields.clear();
    }

    @Override
    public void exitTypeDef(CDLParser.TypeDefContext ctx) {
        String id = ctx.ID().getText();
        statements.add(new TypeDefinition(id, new ArrayList<>(currentFields)));
    }

    @Override
    public void exitField(CDLParser.FieldContext ctx) {
        String name = ctx.LOWER_ID().getText();
        // For now, create a simple type reference from the first ID
        String typeName = ctx.typeRef().ID().getText();
        TypeReference typeRef = new TypeReference(typeName);
        Expression constraint = null;
        if (ctx.expression() != null) {
            constraint = new Expression(ctx.expression().getText());
        }
        currentFields.add(new Field(name, typeRef, constraint));
    }

    @Override
    public void exitMeta(CDLParser.MetaContext ctx) {
        String key = ctx.key().getText();
        String value = ctx.value().getText();
        if (value.startsWith("\"") && value.endsWith("\"")) {
            value = value.substring(1, value.length() - 1);
        }
        currentMeta.put(key, value);
    }

    private List<TypedParameter> parseTypedParameters(String paramString) {
        List<TypedParameter> params = new ArrayList<>();
        if (paramString == null || paramString.trim().isEmpty()) {
            return params;
        }

        // Remove surrounding brackets if present
        paramString = paramString.trim();
        if (paramString.startsWith("[") && paramString.endsWith("]")) {
            paramString = paramString.substring(1, paramString.length() - 1);
        }

        // Split by comma
        String[] paramParts = paramString.split(",");
        for (String paramPart : paramParts) {
            paramPart = paramPart.trim();
            if (paramPart.isEmpty()) continue;

            // Parse "name: Type" or "name: Type where constraint"
            String[] parts = paramPart.split(":");
            if (parts.length >= 2) {
                String name = parts[0].trim();
                String typePart = parts[1].trim();

                // Check for constraint
                Expression constraint = null;
                if (typePart.contains(" where ")) {
                    String[] typeConstraint = typePart.split(" where ", 2);
                    typePart = typeConstraint[0].trim();
                    constraint = new Expression(typeConstraint[1].trim());
                }

                // Parse type reference
                TypeReference typeRef = parseTypeReference(typePart);
                params.add(new TypedParameter(name, typeRef, constraint));
            }
        }

        return params;
    }

    private TypeReference parseTypeReference(String typeString) {
        // Simple parsing for phase 1
        if (typeString.contains("(") && typeString.contains(")")) {
            // Parameterized type like Money(EUR)
            int parenStart = typeString.indexOf("(");
            int parenEnd = typeString.indexOf(")");
            String baseType = typeString.substring(0, parenStart).trim();
            String paramString = typeString.substring(parenStart + 1, parenEnd).trim();

            // For now, assume single parameter
            TypeReference paramType = new TypeReference(paramString);
            List<Parameter> params = Arrays.asList(new Parameter("", paramType));
            return new TypeReference(baseType, params);
        } else {
            // Simple type
            return new TypeReference(typeString);
        }
    }
}
