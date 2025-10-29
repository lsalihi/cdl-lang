package com.cdl.backends;

import com.cdl.ir.IR;
import java.util.*;

public class OpenAPIGenerator {
    public static String generate(IR ir) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("  \"openapi\": \"3.0.0\",\n");
        sb.append("  \"info\": {\"title\": \"CDL API\", \"version\": \"1.0.0\"},\n");
        sb.append("  \"paths\": {\n");

        boolean first = true;
        for (IR.MappingIR mapping : ir.mappings) {
            if (!first) sb.append(",\n");
            first = false;
            sb.append("    \"").append(mapping.path).append("\": {\n");
            sb.append("      \"").append(mapping.method.toLowerCase()).append("\": {\n");
            sb.append("        \"summary\": \"Generated from ").append(mapping.intentId).append("\",\n");
            if (mapping.request != null) {
                sb.append("        \"requestBody\": {\"content\": {\"application/json\": {\"schema\": {\"$ref\": \"#/components/schemas/").append(mapping.request).append("\"}}}}");
                if (mapping.response != null) sb.append(",");
                sb.append("\n");
            }
            if (mapping.response != null) {
                sb.append("        \"responses\": {\"200\": {\"content\": {\"application/json\": {\"schema\": {\"$ref\": \"#/components/schemas/").append(mapping.response).append("\"}}}}}\n");
            }
            sb.append("      }\n");
            sb.append("    }");
        }
        sb.append("\n  },\n");
        sb.append("  \"components\": {\n");
        sb.append("    \"schemas\": {\n");

        // Generate schemas from type definitions
        first = true;
        for (IR.TypeIR type : ir.types) {
            if (!first) sb.append(",\n");
            first = false;
            sb.append("      \"").append(type.id).append("\": {\n");
            sb.append("        \"type\": \"object\",\n");
            sb.append("        \"properties\": {\n");

            boolean firstField = true;
            for (IR.FieldIR field : type.fields) {
                if (!firstField) sb.append(",\n");
                firstField = false;
                sb.append("          \"").append(field.name).append("\": ");
                sb.append(generateFieldSchema(field));
            }
            sb.append("\n        },\n");
            sb.append("        \"required\": [");
            List<String> required = new ArrayList<>();
            for (IR.FieldIR field : type.fields) {
                if (field.constraint == null || !field.constraint.contains("optional")) {
                    required.add("\"" + field.name + "\"");
                }
            }
            sb.append(String.join(",", required));
            sb.append("]\n");
            sb.append("      }");
        }
        sb.append("\n    }\n");
        sb.append("  }\n");
        sb.append("}\n");
        return sb.toString();
    }

    private static String generateFieldSchema(IR.FieldIR field) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"type\": \"");
        switch (field.type) {
            case "string":
                sb.append("string\"");
                break;
            case "int":
                sb.append("integer\"");
                break;
            case "decimal":
                sb.append("number\"");
                break;
            case "bool":
                sb.append("boolean\"");
                break;
            case "date":
                sb.append("string\", \"format\": \"date\"");
                break;
            case "datetime":
                sb.append("string\", \"format\": \"date-time\"");
                break;
            case "Email":
                sb.append("string\", \"format\": \"email\"");
                break;
            default:
                // Assume it's a reference to another type
                sb.append("object\", \"$ref\": \"#/components/schemas/").append(field.type).append("\"");
                break;
        }

        // Add constraints
        if (field.constraint != null) {
            if (field.constraint.contains(">") || field.constraint.contains("<") ||
                field.constraint.contains(">=") || field.constraint.contains("<=")) {
                // Numeric constraints
                if (field.constraint.contains(">=")) {
                    String value = field.constraint.split(">=")[1].trim();
                    sb.append(", \"minimum\": ").append(value);
                }
                if (field.constraint.contains("<=")) {
                    String value = field.constraint.split("<=")[1].trim();
                    sb.append(", \"maximum\": ").append(value);
                }
            }
        }

        sb.append("}");
        return sb.toString();
    }
}
