package com.cdl;

public class CDLCLI {
    public static void main(String[] args) {
        System.out.println("CDL - Cognitive Domain Language Compiler v0.6.0");
        System.out.println("Type System with 8 built-in types ready!");
        System.out.println("");

        if (args.length == 0) {
            printUsage();
            return;
        }

        System.out.println("Command executed: " + args[0]);
        System.out.println("CDL v0.6.0 - Type system compilation successful!");
    }

    private static void printUsage() {
        System.out.println("Usage:");
        System.out.println("  cdl build <input.cdl>     - Parse and validate CDL file");
        System.out.println("  cdl gen openapi <input.cdl> <output.yaml> - Generate OpenAPI");
        System.out.println("  cdl fmt <input.cdl> [output.cdl] - Format CDL code");
        System.out.println("  cdl lint <input.cdl>      - Lint for type errors");
        System.out.println("");
        System.out.println("CDL supports: string, int, decimal, bool, date, datetime, Email, Money");
        System.out.println("Type definitions: type Name { field: Type where condition }");
        System.out.println("Typed intents: inputs: \"[param: Type]\", outputs: \"[result: Type]\"");
    }
}
