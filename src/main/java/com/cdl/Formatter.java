package com.cdl;

import com.cdl.ast.*;
import java.util.*;

public class Formatter {
    public static String format(Program program) {
        StringBuilder sb = new StringBuilder();
        for (Statement stmt : program.getStatements()) {
            if (stmt instanceof Intent) {
                formatIntent(sb, (Intent) stmt);
            } else if (stmt instanceof Rule) {
                formatRule(sb, (Rule) stmt);
            } else if (stmt instanceof Mapping) {
                formatMapping(sb, (Mapping) stmt);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static void formatIntent(StringBuilder sb, Intent intent) {
        sb.append("intent ").append(intent.getId()).append("\n");
        formatMeta(sb, intent.getMeta());
        sb.append("end");
    }

    private static void formatRule(StringBuilder sb, Rule rule) {
        sb.append("rule ").append(rule.getId()).append("\n");
        formatMeta(sb, rule.getMeta());
        sb.append("end");
    }

    private static void formatMapping(StringBuilder sb, Mapping mapping) {
        sb.append("mapping ").append(mapping.getId()).append(" -> \"").append(mapping.getTarget()).append("\"\n");
        formatMeta(sb, mapping.getMeta());
        sb.append("end");
    }

    private static void formatMeta(StringBuilder sb, Map<String, Object> meta) {
        List<String> keys = new ArrayList<>(meta.keySet());
        Collections.sort(keys); // sorted for consistency
        for (String key : keys) {
            Object value = meta.get(key);
            sb.append("  ").append(key).append(": ");
            if (value instanceof String) {
                sb.append("\"").append(value).append("\"");
            } else {
                sb.append(value);
            }
            sb.append("\n");
        }
    }
}
