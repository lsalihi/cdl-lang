# CDL — Cognitive Domain Language

[![CI](https://github.com/lsalihi/cdl-lang/actions/workflows/ci.yml/badge.svg)](https://github.com/lsalihi/cdl-lang/actions/workflows/ci.yml)
[![codecov](https://codecov.io/gh/lsalihi/cdl-lang/branch/main/graph/badge.svg)](https://codecov.io/gh/lsalihi/cdl-lang)
[![CTK](https://img.shields.io/badge/CTK-10%20tests-passing)](https://github.com/lsalihi/cdl-lang/tree/main/ctk)

A DSL for defining business logic in a declarative, traceable, and executable way.

## Quick Demo

```bash
./demo.sh
```

This builds, generates IR/OpenAPI, lints, and formats.

## Features

- **Parser**: ANTLR-based lexer and parser for CDL syntax with type system support.
- **AST Builder**: Constructs abstract syntax tree from parse tree with type information.
- **Symbol Table**: Detects duplicate IDs across all definitions.
- **Type Checker**: Comprehensive validation of types, constraints, and references.
- **IR Generation**: Intermediate representation from AST with full type metadata.
- **OpenAPI Generator**: Generates OpenAPI 3.0 specs from intents with type-safe schemas.
- **Rego Generator**: Generates OPA Rego policies from mappings.
- **Linter**: Checks for errors, duplicates, and type violations with detailed error codes.
- **Formatter**: Formats CDL files with consistent style.
- **Compiler Pipeline**: End-to-end compilation from CDL to multiple backends.

### Type System (v0.6.0)
- **Type Definitions**: Custom types with field constraints
- **Built-in Types**: `string`, `int`, `decimal`, `bool`, `date`, `datetime`, `Email`, `Money`
- **Constraints**: `where` clauses with functions like `length()`, `contains()`, `today()`
- **Type References**: Strong typing for intent inputs/outputs
- **Validation**: Compile-time type checking and circular reference detection

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
