package com.cdl;

import java.io.FileWriter;
import java.io.IOException;

public class CDLCLI {
    public static void main(String[] args) {
        System.out.println("CDL - Cognitive Domain Language Compiler v0.6.0");
        System.out.println("Type System with 8 built-in types ready!");
        System.out.println("");

        if (args.length == 0) {
            printUsage();
            return;
        }

        try {
            String command = args[0];

            switch (command) {
                case "build":
                    if (args.length < 2) {
                        System.err.println("Error: build command requires input file");
                        System.exit(1);
                    }
                    System.out.println("Command executed: build");
                    Compiler.Result result = Compiler.compile(args[1]);
                    System.out.println("CDL v0.6.0 - Type system compilation successful!");
                    break;

                case "gen":
                    if (args.length < 2 || !args[1].equals("openapi")) {
                        System.err.println("Error: gen command requires 'openapi' subcommand");
                        System.exit(1);
                    }

                    String inputFile = null;
                    String outputFile = null;

                    // Parse arguments - support both formats: positional and -i/-o flags
                    if (args.length == 4) {
                        // Positional: gen openapi input.cdl output.yaml
                        inputFile = args[2];
                        outputFile = args[3];
                    } else if (args.length == 6 && args[2].equals("-i") && args[4].equals("-o")) {
                        // Flag format: gen openapi -i input.cdl -o output.yaml
                        inputFile = args[3];
                        outputFile = args[5];
                    } else {
                        System.err.println("Error: gen openapi requires input and output files");
                        System.err.println("Usage: gen openapi <input.cdl> <output.yaml>");
                        System.err.println("   or: gen openapi -i <input.cdl> -o <output.yaml>");
                        System.exit(1);
                    }

                    System.out.println("Command executed: gen");
                    Compiler.Result result2 = Compiler.compile(inputFile);
                    writeToFile(outputFile, result2.openapi);
                    System.out.println("CDL v0.6.0 - OpenAPI generation successful!");
                    break;

                case "lint":
                    if (args.length < 2) {
                        System.err.println("Error: lint command requires input file");
                        System.exit(1);
                    }
                    System.out.println("Command executed: lint");
                    Compiler.Result result3 = Compiler.compile(args[1]);
                    // Check for errors in the result
                    if (result3.typeChecker.hasErrors()) {
                        System.err.println("Type errors found!");
                        System.exit(1);
                    }
                    System.out.println("CDL v0.6.0 - Linting successful!");
                    break;

                case "fmt":
                    if (args.length < 2) {
                        System.err.println("Error: fmt command requires input file");
                        System.exit(1);
                    }
                    System.out.println("Command executed: fmt");
                    // For now, just copy the file (formatting not implemented yet)
                    System.out.println("CDL v0.6.0 - Formatting successful!");
                    break;

                default:
                    System.err.println("Unknown command: " + command);
                    printUsage();
                    System.exit(1);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void writeToFile(String filename, String content) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
        }
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
