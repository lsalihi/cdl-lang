# CDL - Cognitive Domain Language

A DSL for defining business logic in a declarative, traceable, and executable way.

## What is CDL?

CDL (Cognitive Domain Language) allows you to describe business intents, rules, policies, and flows with metadata for evidence and trust. It's designed for executable specifications that can generate APIs, policies, and tests.

## Key Features

- **Parser**: ANTLR-based lexer and parser for CDL syntax
- **AST Builder**: Constructs abstract syntax tree
- **Symbol Table**: Detects duplicate IDs
- **Type Checker**: Basic validation of meta values
- **IR Generation**: Intermediate representation
- **OpenAPI Backend**: Generates API specs from intents/mappings
- **Rego Backend**: Generates OPA policies
- **Linter**: Checks for errors with codes
- **Formatter**: Consistent style formatting
- **CLI**: Unified command-line interface

## Quick Start

```bash
# Clone the repo
git clone https://github.com/lsalihi/cdl-lang.git
cd cdl-lang

# Build
./gradlew build

# Run demo
./demo.sh

# Use CLI
java -cp build/classes/java/main:antlr-4.13.1-complete.jar com.cdl.CDLCLI gen openapi -i sample.cdl -o api.yaml
```

## Installation

### Docker

```bash
docker run --rm -v "$PWD":/w ghcr.io/lsalihi/cdl-lang:latest \
  cdl gen openapi -i /w/sample.cdl -o /w/api.yaml
```

### Local Build

```bash
./gradlew build
java -cp build/classes/java/main:antlr-4.13.1-complete.jar com.cdl.CDLCLI --help
```

## Community

- [GitHub Repository](https://github.com/lsalihi/cdl-lang)
- [Issues](https://github.com/lsalihi/cdl-lang/issues)
- [Discussions](https://github.com/lsalihi/cdl-lang/discussions)
