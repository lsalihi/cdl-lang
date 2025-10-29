package com.cdl.ir;

import com.cdl.ast.*;
import java.util.*;

public class IR {
    public List<TypeIR> types = new ArrayList<>();
    public List<IntentIR> intents = new ArrayList<>();
    public List<MappingIR> mappings = new ArrayList<>();

    public static class TypeIR {
        public String id;
        public List<FieldIR> fields = new ArrayList<>();
    }

    public static class FieldIR {
        public String name;
        public String type;
        public String constraint;
    }

    public static class IntentIR {
        public String id;
        public String goal;
        public List<Map<String, String>> inputs = new ArrayList<>();
        public List<Map<String, String>> outputs = new ArrayList<>();
    }

    public static class MappingIR {
        public String intentId;
        public String method;
        public String path;
        public String request;
        public String response;
    }

    public static IR fromAST(Program program) {
        IR ir = new IR();
        for (Statement stmt : program.getStatements()) {
            if (stmt instanceof TypeDefinition) {
                TypeDefinition typeDef = (TypeDefinition) stmt;
                TypeIR tir = new TypeIR();
                tir.id = typeDef.getId();
                for (Field field : typeDef.getFields()) {
                    FieldIR fir = new FieldIR();
                    fir.name = field.getName();
                    fir.type = field.getTypeRef().getName(); // Simplified for phase 1
                    if (field.getConstraint() != null) {
                        fir.constraint = field.getConstraint().getExpression();
                    }
                    tir.fields.add(fir);
                }
                ir.types.add(tir);
            } else if (stmt instanceof Intent) {
                Intent intent = (Intent) stmt;
                IntentIR iir = new IntentIR();
                iir.id = intent.getId();
                Map<String, Object> meta = intent.getMeta();
                iir.goal = (String) meta.get("goal");
                // Convert typed parameters to maps
                for (TypedParameter param : intent.getInputs()) {
                    Map<String, String> paramMap = new HashMap<>();
                    paramMap.put("name", param.getName());
                    paramMap.put("type", param.getTypeRef().getName());
                    if (param.getConstraint() != null) {
                        paramMap.put("constraint", param.getConstraint().getExpression());
                    }
                    iir.inputs.add(paramMap);
                }
                for (TypedParameter param : intent.getOutputs()) {
                    Map<String, String> paramMap = new HashMap<>();
                    paramMap.put("name", param.getName());
                    paramMap.put("type", param.getTypeRef().getName());
                    if (param.getConstraint() != null) {
                        paramMap.put("constraint", param.getConstraint().getExpression());
                    }
                    iir.outputs.add(paramMap);
                }
                ir.intents.add(iir);
            } else if (stmt instanceof Mapping) {
                Mapping mapping = (Mapping) stmt;
                MappingIR mir = new MappingIR();
                mir.intentId = mapping.getId();
                String target = mapping.getTarget();
                // Parse target like "api POST /path"
                if (target.startsWith("\"") && target.endsWith("\"")) {
                    target = target.substring(1, target.length() - 1);
                }
                String[] parts = target.split(" ");
                if (parts.length >= 3 && parts[0].equals("api")) {
                    mir.method = parts[1];
                    mir.path = parts[2];
                }
                Map<String, Object> meta = mapping.getMeta();
                mir.request = cleanString((String) meta.get("request"));
                mir.response = cleanString((String) meta.get("response"));
                ir.mappings.add(mir);
            }
        }
        return ir;
    }

    private static String cleanString(String s) {
        if (s == null) return null;
        if (s.startsWith("\"") && s.endsWith("\"")) {
            return s.substring(1, s.length() - 1);
        }
        return s;
    }
}
