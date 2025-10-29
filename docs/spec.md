# Specification

## Overview

CDL (Cognitive Domain Language) is a DSL for defining business logic in a declarative, traceable, and executable way. It focuses on intents, rules, policies, flows, and mappings with metadata for evidence and trust. Version 0.6.0 adds a complete type system for type-safe specifications.

## Concepts

- **Intent**: Describes a business goal with typed inputs, outputs, evidence, and trust scores.
- **Rule**: Defines validation or business rules with conditions.
- **Policy**: Governance policies for compliance.
- **Flow**: Sequences of steps with guards.
- **Mapping**: Binds intents to external APIs or systems.
- **Type**: Custom data types with field constraints (v0.6.0+).

## Type System (v0.6.0)

### Built-in Types
- `string`: Text values
- `int`: Integer numbers
- `decimal`: Decimal numbers
- `bool`: Boolean values
- `date`: Date values (YYYY-MM-DD)
- `datetime`: DateTime values (ISO 8601)
- `Email`: Email addresses with validation
- `Money`: Monetary values (amount + currency)

### Type Definitions
```cdl
type Customer
  id: string
  name: string where length(name) >= 2
  email: Email
  age: int where age >= 18
end
```

### Constraints
- Comparison operators: `>`, `<`, `>=`, `<=`, `==`, `!=`
- String functions: `length()`, `contains()`, `startsWith()`, `endsWith()`
- Logical operators: `and`, `or`, `not`
- Special functions: `today()`, `in [values]`

### Typed Intents
```cdl
intent CREATE_USER
  inputs: "[profile: Customer, password: string]"
  outputs: "[userId: string, token: string]"
end
```

## Grammar

See `src/main/antlr/CDL.g4` for the ANTLR grammar.

## IR (Intermediate Representation)

JSON structure with type information:
```json
{
  "types": [...],
  "intents": [...],
  "mappings": [...]
}
```

## Backends

- **OpenAPI 3.0**: Generates type-safe API specs with validation schemas
- **Rego**: Generates OPA policies with type constraints

## Error Codes

- E001: Duplicate ID
- E002: Invalid type
- E003: Missing evidence
- E004: Type not found
- E005: Invalid constraint
- E006: Circular type reference
- E007: Parameter type mismatch

## Versioning

SemVer: v0.6.0 (Type System)
