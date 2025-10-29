package com.cdl;

public class CDLFormatter {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: java CDLFormatter <cdl-file>");
            System.exit(1);
        }
        String fileName = args[0];

        Compiler.Result result = Compiler.compile(fileName);

        if (result.symbolTable.hasErrors() || result.typeChecker.hasErrors()) {
            System.err.println("Cannot format due to errors.");
            System.exit(1);
        }

        String formatted = Formatter.format(result.program);
        System.out.print(formatted);
    }
}
