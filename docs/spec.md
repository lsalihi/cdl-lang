# Specification

## Overview

CDL (Cognitive Domain Language) is a DSL for defining business logic in a declarative, traceable, and executable way. It focuses on intents, rules, policies, flows, and mappings with metadata for evidence and trust.

## Concepts

- **Intent**: Describes a business goal with inputs, outputs, evidence, and trust scores.
- **Rule**: Defines validation or business rules with conditions.
- **Policy**: Governance policies for compliance.
- **Flow**: Sequences of steps with guards.
- **Mapping**: Binds intents to external APIs or systems.

## Grammar

See `src/main/antlr/CDL.g4` for the ANTLR grammar.

## IR (Intermediate Representation)

JSON structure:
```json
{
  "intents": [...],
  "mappings": [...]
}
```

## Backends

- **OpenAPI 3.0**: Generates API specs from intents/mappings.
- **Rego**: Generates OPA policies.

## Error Codes

- E001: Duplicate ID
- E002: Invalid type

## Versioning

SemVer: v0.5-MVP
