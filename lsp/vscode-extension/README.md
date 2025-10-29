# CDL Language Support (VS Code)

**CDL (Cognitive Domain Language)** is a declarative DSL for defining business logic, APIs, and data models with type safety.

## Features

### Syntax Highlighting
- **Keywords**: `intent`, `rule`, `policy`, `flow`, `mapping`, `type`, `end`
- **Type System**: Built-in types (`string`, `int`, `decimal`, `bool`, `date`, `datetime`, `Email`, `Money`)
- **Operators**: `where`, `and`, `or`, `not`, `in`, comparison operators (`>`, `<`, `==`, etc.)
- **Functions**: `length()`, `contains()`, `startsWith()`, `endsWith()`, `today()`
- **Literals**: Strings, numbers, booleans

### IntelliSense & Snippets
- **Type definitions**: `type`, `typec` (with constraints), `typemoney`
- **Intents**: `intent` (basic), `intentc` (complex with multiple parameters)
- **Rules & Mappings**: Auto-complete templates

### Hover Information
Hover over keywords and types for documentation:
- Built-in type descriptions and examples
- Keyword usage with code examples
- Function signatures and usage

### Diagnostics & Linting
- **Real-time type checking** with structured error codes
- **On-save linting** (configurable)
- **Error classification**: Type errors as warnings, syntax errors as errors

### Commands
- **CDL: Generate OpenAPI** - Generate OpenAPI 3.0 spec from CDL
- **CDL: Lint** - Run type checker and validation
- **CDL: Build IR** - Generate intermediate representation

## Type System Support

The extension now fully supports CDL's type system introduced in v0.6:

### Type Definitions
```cdl
type Customer
  name: string where length(name) >= 2
  email: Email
  age: int where age >= 18
end

type Money
  amount: decimal where amount >= 0
  currency: string
end
```

### Typed Intent Parameters
```cdl
intent PROCESS_PAYMENT
  inputs: "[customer: Customer, amount: Money]"
  outputs: "[id: string, status: string]"
end
```

### Constraint Validation
The extension highlights and validates:
- Type references
- Constraint expressions
- Parameterized types (`Money(EUR)`)
- Circular type dependencies

## Requirements
- **CDL CLI**: Install and ensure `cdl` is on your PATH
- **VS Code**: ^1.85.0

## Settings
- `cdl.cliPath`: Path to `cdl` executable (default: `cdl`)
- `cdl.openapiOutput`: Output path for generated OpenAPI (default: `out/api.openapi.yaml`)
- `cdl.enableOnSave`: Run lint on save (default: `true`)

## Development
```bash
npm install
npm run watch
# Press F5 in VS Code to run Extension Development Host
```

## Packaging
```bash
npm run package
# produces cdl-language-support-0.1.0.vsix
```
