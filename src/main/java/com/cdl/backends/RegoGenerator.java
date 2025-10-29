package com.cdl.backends;

import com.cdl.ir.IR;
import java.util.*;

public class RegoGenerator {
    public static String generate(IR ir) {
        StringBuilder sb = new StringBuilder();
        sb.append("package cdl.policies\n\n");

        for (IR.MappingIR mapping : ir.mappings) {
            sb.append("# Policy for ").append(mapping.intentId).append("\n");
            sb.append("allow {\n");
            sb.append("    input.method == \"").append(mapping.method.toUpperCase()).append("\"\n");
            sb.append("    input.path == \"").append(mapping.path).append("\"\n");
            sb.append("    # Add more conditions here\n");
            sb.append("}\n\n");
        }
        return sb.toString();
    }
}
