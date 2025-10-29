package com.cdl;

import com.cdl.ast.Program;

public class CDLParserApp {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: java -jar cdl.jar <cdl-file>");
            System.exit(1);
        }
        String fileName = args[0];

        Compiler.Result result = Compiler.compile(fileName);

        System.out.println("Parsed program with " + result.program.getStatements().size() + " statements.");
        for (var stmt : result.program.getStatements()) {
            System.out.println("Statement: " + stmt.getClass().getSimpleName() + " " + stmt.getId());
        }

        if (result.symbolTable.hasErrors()) {
            System.out.println("Symbol Errors:");
            for (CDError error : result.symbolTable.getErrors()) {
                System.out.println("  " + error);
            }
        } else {
            System.out.println("No symbol errors.");
        }

        if (result.typeChecker.hasErrors()) {
            System.out.println("Type Errors:");
            for (CDError error : result.typeChecker.getErrors()) {
                System.out.println("  " + error);
            }
        } else {
            System.out.println("No type errors.");
        }

        System.out.println("Generated OpenAPI:");
        System.out.println(result.openapi);

        System.out.println("Generated Rego:");
        System.out.println(result.rego);
    }
}
