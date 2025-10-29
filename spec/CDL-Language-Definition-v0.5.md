# CDL Language Definition v0.5.0

## Cognitive Domain Language (CDL)

**Version:** 0.5.0 (MVP) - October 2025  
**License:** Apache 2.0  
**Specification:** https://github.com/lsalihi/cdl-lang/tree/main/spec

## Overview

CDL (Cognitive Domain Language) is a declarative universal language designed to express, structure, and execute the business logic or knowledge of any system. It provides a formal way to describe intentions, rules, policies, flows, and mappings that can be understood by both humans and machines.

CDL enables the creation of **executable specifications** that can generate APIs, policies, tests, and documentation from a single source of truth.

## Core Concepts

### 1. Intent
An intent represents a business goal or cognitive objective that the system must achieve.

```cdl
intent PROCESS_PAYMENT
  goal: "Process a payment transaction"
  inputs: "[amount: Money, account: String]"
  outputs: "[id: String]"
  evidence: "[legacy_code]"
  tags: "[finance]"
end
```

**Attributes:**
- `goal`: Human-readable description
- `inputs`: List of input parameters with types
- `outputs`: List of output parameters with types
- `evidence`: References to supporting documentation/code
- `tags`: Categorization labels
- `trust`: Optional confidence metrics (future)

### 2. Rule
A rule defines a validation or business constraint that must be satisfied.

```cdl
rule AMOUNT_MUST_BE_POSITIVE
  statement: "Payment amount must be greater than zero"
  applies_to: "PROCESS_PAYMENT"
  evidence: "[business_requirement_45]"
  test_hints: "amount <= 0 should return 400"
  type: "validation"
end
```

**Attributes:**
- `statement`: Human-readable rule description
- `applies_to`: Intent or context this rule applies to
- `evidence`: Supporting documentation
- `test_hints`: Guidance for testing
- `type`: Rule category (validation, business, etc.)

### 3. Policy
A policy defines governance or security constraints.

```cdl
policy GDPR_COMPLIANCE
  statement: "All personal data processing must comply with GDPR"
  applies_to: "USER_DATA_PROCESSING"
  evidence: "[gdpr_regulation_chapter_4]"
  type: "security"
end
```

### 4. Flow
A flow describes a sequence of steps or process orchestration.

```cdl
flow PAYMENT_PROCESS
  steps:
    - validate_payment
    - check_fraud
    - process_transaction
    - send_confirmation
  evidence: "[payment_flow_diagram_v2]"
end
```

### 5. Mapping
A mapping connects intents to external systems or APIs.

```cdl
mapping PROCESS_PAYMENT -> "api POST /api/payments"
  request: "PaymentRequest"
  response: "PaymentResponse"
end
```

## Type System

### Built-in Types
- `string`: Text values
- `int`: Integer numbers
- `decimal`: Decimal numbers
- `bool`: Boolean values
- `date`: Date values (YYYY-MM-DD)
- `datetime`: DateTime values (ISO 8601)

### Extended Types (v0.6+)
- `Money(currency)`: Monetary values (e.g., `Money(EUR)`)
- `Email`: Email addresses
- `GeoPoint`: Geographic coordinates
- Custom types via `type` declarations

### Type Constraints (v0.6+)
```cdl
type PaymentAmount
  value: decimal where value > 0
  currency: string where currency in ["EUR", "USD", "GBP"]
end
```

## Syntax Grammar

### Formal Grammar (ANTLR4)
```
cdlFile : (intent | rule | policy | flow | mapping)* EOF ;

intent : 'intent' ID
         ('goal:' STRING)?
         ('inputs:' typeList)?
         ('outputs:' typeList)?
         ('evidence:' stringList)?
         ('tags:' stringList)?
         ('trust:' jsonObject)?
         'end' ;

rule : 'rule' ID
       ('statement:' STRING)?
       ('applies_to:' ID)?
       ('evidence:' stringList)?
       ('test_hints:' STRING)?
       ('type:' ID)?
       'end' ;

mapping : 'mapping' ID '->' STRING
          ('request:' STRING)?
          ('response:' STRING)?
          'end' ;
```

### Reserved Keywords
`intent`, `rule`, `policy`, `flow`, `mapping`, `goal`, `inputs`, `outputs`, `evidence`, `tags`, `trust`, `statement`, `applies_to`, `test_hints`, `type`, `request`, `response`, `end`, `where`, `in`

### Naming Conventions
- **IDs**: PascalCase (e.g., `ProcessPayment`, `ValidateInput`)
- **Types**: PascalCase (e.g., `PaymentRequest`, `UserId`)
- **Strings**: Use double quotes: `"value"`
- **Lists**: Use square brackets: `[item1, item2]`

## Intermediate Representation (IR)

Every CDL file compiles to a JSON IR that captures the complete semantic meaning:

```json
{
  "version": "0.5.0",
  "intents": [
    {
      "id": "PROCESS_PAYMENT",
      "goal": "Process a payment transaction",
      "inputs": [
        {"name": "amount", "type": "Money"},
        {"name": "account", "type": "string"}
      ],
      "outputs": [
        {"name": "id", "type": "string"}
      ],
      "evidence": ["legacy_code"],
      "tags": ["finance"]
    }
  ],
  "rules": [...],
  "mappings": [...]
}
```

## Backends

### OpenAPI 3.0 Backend
Generates REST API specifications:
```yaml
openapi: 3.0.0
paths:
  /api/payments:
    post:
      summary: Process a payment transaction
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/PaymentRequest'
```

### Rego Policy Backend
Generates OPA policies for authorization and validation.

### Test Backend (CTK)
Generates test cases and validation scenarios.

## CLI Interface

```bash
cdl build -i input.cdl -o output.ir.json    # Parse to IR
cdl gen openapi -i input.cdl -o output.yaml # Generate API spec
cdl lint -i input.cdl                       # Check for errors
cdl fmt -i input.cdl [-o output.cdl]        # Format code
```

## Error Model

CDL uses a structured error reporting system:

- **E001**: Duplicate ID
- **E002**: Invalid type reference
- **E003**: Missing required field
- **E004**: Circular dependency

## Compatibility Policy

- **Forward Compatibility**: New features don't break existing valid CDL files
- **Version Pinning**: Each CDL file specifies its version
- **Migration Path**: Clear upgrade guides for breaking changes

## Governance

CDL follows an open governance model:
- **CEPs**: CDL Enhancement Proposals for new features
- **CTK**: Conformance Test Kit ensures implementation quality
- **Semantic Versioning**: Major.Minor.Patch releases

## Examples

### Complete Payment Processing
```cdl
intent PROCESS_PAYMENT
  goal: "Process a payment transaction"
  inputs: "[amount: Money(EUR), account: string]"
  outputs: "[transactionId: string, status: string]"
  evidence: "[payment_api_spec_v2]"
  tags: "[finance, payment]"
end

rule AMOUNT_POSITIVE
  statement: "Payment amount must be positive"
  applies_to: "PROCESS_PAYMENT"
  evidence: "[business_rule_br45]"
  type: "validation"
end

mapping PROCESS_PAYMENT -> "api POST /api/payments"
  request: "PaymentRequest"
  response: "PaymentResponse"
end
```

This specification can generate:
- OpenAPI spec for the payment API
- Validation rules for the payment service
- Test cases for the payment functionality
- Documentation for developers and stakeholders

## Future Directions

- **v0.6**: Enhanced type system with constraints
- **v0.8**: Complete Rego backend, advanced linting
- **v1.0**: Stable language specification, LSP support

---

**Authors:** Pulsaride Team  
**Contact:** salihi.lyazid@pulsaride.com  
**Repository:** https://github.com/lsalihi/cdl-lang
