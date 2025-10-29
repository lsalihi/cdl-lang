package com.cdl;

import java.io.FileWriter;
import java.io.IOException;

public class CDLCLI {
    public static void main(String[] args) {
        if (args.length == 0) {
            printUsage();
            return;
        }

        String command = args[0];
        switch (command) {
            case "build":
                handleBuild(args);
                break;
            case "gen":
                if (args.length > 1 && "openapi".equals(args[1])) {
                    handleGenOpenAPI(args);
                } else {
                    System.err.println("Unknown gen subcommand. Use: cdl gen openapi");
                }
                break;
            case "fmt":
                handleFmt(args);
                break;
            case "lint":
                handleLint(args);
                break;
            default:
                System.err.println("Unknown command: " + command);
                printUsage();
        }
    }

    private static void handleBuild(String[] args) {
        String input = null, output = null;
        for (int i = 1; i < args.length; i++) {
            if ("-i".equals(args[i]) && i + 1 < args.length) {
                input = args[++i];
            } else if ("-o".equals(args[i]) && i + 1 < args.length) {
                output = args[++i];
            }
        }
        if (input == null || output == null) {
            System.err.println("Usage: cdl build -i <input.cdl> -o <output.ir.json>");
            return;
        }
        try {
            Compiler.Result result = Compiler.compile(input);
            if (result.symbolTable.hasErrors() || result.typeChecker.hasErrors()) {
                System.err.println("Cannot build due to errors.");
                return;
            }
            // For now, write a simple JSON IR
            String irJson = "{ \"intents\": " + result.ir.intents.size() + ", \"mappings\": " + result.ir.mappings.size() + " }";
            try (FileWriter fw = new FileWriter(output)) {
                fw.write(irJson);
            }
            System.out.println("Built IR to " + output);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void handleGenOpenAPI(String[] args) {
        String input = null, output = null;
        for (int i = 2; i < args.length; i++) {
            if ("-i".equals(args[i]) && i + 1 < args.length) {
                input = args[++i];
            } else if ("-o".equals(args[i]) && i + 1 < args.length) {
                output = args[++i];
            }
        }
        if (input == null || output == null) {
            System.err.println("Usage: cdl gen openapi -i <input.cdl> -o <output.yaml>");
            return;
        }
        try {
            Compiler.Result result = Compiler.compile(input);
            if (result.symbolTable.hasErrors() || result.typeChecker.hasErrors()) {
                System.err.println("Cannot generate due to errors.");
                return;
            }
            try (FileWriter fw = new FileWriter(output)) {
                fw.write(result.openapi);
            }
            System.out.println("Generated OpenAPI to " + output);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void handleFmt(String[] args) {
        String input = null, output = null;
        for (int i = 1; i < args.length; i++) {
            if ("-i".equals(args[i]) && i + 1 < args.length) {
                input = args[++i];
            } else if ("-o".equals(args[i]) && i + 1 < args.length) {
                output = args[++i];
            }
        }
        if (input == null) {
            System.err.println("Usage: cdl fmt -i <input.cdl> [-o <output.cdl>]");
            return;
        }
        try {
            Compiler.Result result = Compiler.compile(input);
            if (result.symbolTable.hasErrors() || result.typeChecker.hasErrors()) {
                System.err.println("Cannot format due to errors.");
                return;
            }
            String formatted = Formatter.format(result.program);
            if (output != null) {
                try (FileWriter fw = new FileWriter(output)) {
                    fw.write(formatted);
                }
                System.out.println("Formatted to " + output);
            } else {
                System.out.print(formatted);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void handleLint(String[] args) {
        if (args.length != 3 || !"-i".equals(args[1])) {
            System.err.println("Usage: cdl lint -i <input.cdl>");
            return;
        }
        String input = args[2];
        try {
            Compiler.Result result = Compiler.compile(input);
            boolean hasErrors = result.symbolTable.hasErrors() || result.typeChecker.hasErrors();
            if (hasErrors) {
                result.symbolTable.getErrors().forEach(e -> System.err.println("Error: " + e));
                result.typeChecker.getErrors().forEach(e -> System.err.println("Error: " + e));
                System.exit(1);
            } else {
                System.out.println("Linting passed.");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }

    private static void printUsage() {
        System.out.println("CDL CLI v0.5");
        System.out.println("Usage:");
        System.out.println("  cdl build -i <input.cdl> -o <output.ir.json>");
        System.out.println("  cdl gen openapi -i <input.cdl> -o <output.yaml>");
        System.out.println("  cdl fmt -i <input.cdl> [-o <output.cdl>]");
        System.out.println("  cdl lint -i <input.cdl>");
    }
}
