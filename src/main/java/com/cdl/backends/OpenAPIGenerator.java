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
        sb.append("\n  }\n");
        sb.append("}\n");
        return sb.toString();
    }
}
