package com.cdl;

public class CDLLinter {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: java CDLLinter <cdl-file>");
            System.exit(1);
        }
        String fileName = args[0];

        Compiler.Result result = Compiler.compile(fileName);

        // Report symbol table errors
        if (result.symbolTable.hasErrors()) {
            for (CDError error : result.symbolTable.getErrors()) {
                System.out.println("Error: " + error);
            }
        }

        // Report type errors
        if (result.typeChecker.hasErrors()) {
            for (CDError error : result.typeChecker.getErrors()) {
                System.out.println("Error: " + error);
            }
        }

        if (!result.symbolTable.hasErrors() && !result.typeChecker.hasErrors()) {
            System.out.println("Linting passed.");
        }
    }
}
