# CDL — Cognitive Domain Language

A DSL for defining business logic in a declarative, traceable, and executable way.

## Quick Demo

```bash
./demo.sh
```

This builds, generates IR/OpenAPI, lints, and formats.

## Features

- **Parser**: ANTLR-based lexer and parser for CDL syntax.
- **AST Builder**: Constructs abstract syntax tree from parse tree.
- **Symbol Table**: Detects duplicate IDs.
- **Type Checker**: Basic validation of meta values.
- **IR Generation**: Intermediate representation from AST.
- **OpenAPI Generator**: Generates OpenAPI spec from intents/mappings.
- **Rego Generator**: Generates OPA Rego policies from mappings.
- **Linter**: Checks for errors and duplicates with error codes.
- **Formatter**: Formats CDL files with consistent style.
- **Compiler Pipeline**: End-to-end compilation from CDL to backends.

## Build

```bash
gradle build
```

```bash
java -cp build/classes/java/main:antlr-4.13.1-complete.jar com.cdl.CDLCLI <command>
```

Commands:
- `cdl build -i <input.cdl> -o <output.ir.json>` - Parse to IR
- `cdl gen openapi -i <input.cdl> -o <output.yaml>` - Generate OpenAPI
- `cdl fmt -i <input.cdl> [-o <output.cdl>]` - Format CDL
- `cdl lint -i <input.cdl>` - Lint for errors

## Conformance Test Kit (CTK)

Run CTK to verify backends:

```bash
./test_ctk.sh
```

This ensures generated OpenAPI matches expected outputs.

## Examples

See `sample.cdl`, `example.cdl`, `rule_example.cdl`

## Grammar

See `src/main/antlr/CDL.g4`
