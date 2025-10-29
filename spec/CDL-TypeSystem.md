# CDL Type System Specification v0.6

## Overview

CDL v0.6 introduces a comprehensive type system that enables type-safe specifications of business logic. The type system supports both built-in primitive types and user-defined composite types with constraints.

## Type System Goals

- **Type Safety**: Prevent type mismatches in intent inputs/outputs
- **Expressiveness**: Support complex business data structures
- **Extensibility**: Allow custom types for domain-specific needs
- **Validation**: Runtime type checking and validation
- **Documentation**: Self-documenting APIs through type definitions

## Built-in Primitive Types

### Basic Types

| Type | Description | Examples | OpenAPI Schema |
|------|-------------|----------|----------------|
| `string` | Text values | `"John Doe"`, `"EUR"` | `{"type": "string"}` |
| `int` | Integer numbers | `42`, `-100` | `{"type": "integer"}` |
| `decimal` | Decimal numbers | `19.99`, `3.14159` | `{"type": "number"}` |
| `bool` | Boolean values | `true`, `false` | `{"type": "boolean"}` |

### Temporal Types

| Type | Description | Format | Examples |
|------|-------------|--------|----------|
| `date` | Date values | YYYY-MM-DD | `2023-12-25` |
| `datetime` | Date and time | ISO 8601 | `2023-12-25T14:30:00Z` |

## Extended Types

### Monetary Type
```cdl
Money(currency: string)
```

**Parameters:**
- `currency`: ISO 4217 currency code (e.g., "EUR", "USD")

**Examples:**
```cdl
amount: Money(EUR)  # European Euro
price: Money(USD)   # US Dollar
```

**Generated OpenAPI:**
```yaml
amount:
  type: object
  properties:
    amount:
      type: number
      format: decimal
    currency:
      type: string
      enum: [EUR]
  required: [amount, currency]
```

### Email Type
```cdl
Email
```

**Validation:** RFC 5322 compliant email format

**Example:**
```cdl
contactEmail: Email
```

### Geographic Types
```cdl
GeoPoint        # Latitude/Longitude coordinates
GeoAddress      # Full address with geocoding
```

## User-Defined Types

### Type Definition Syntax

```cdl
type TypeName
  field1: Type1
  field2: Type2 where condition
  field3: Type3
end
```

### Examples

#### Customer Type
```cdl
type Customer
  id: string
  name: string
  email: Email
  registrationDate: date
  isActive: bool
end
```

#### Order Type
```cdl
type Order
  id: string
  customerId: string
  items: list<OrderItem>
  totalAmount: Money(EUR) where totalAmount > 0
  orderDate: datetime
  status: string where status in ["PENDING", "CONFIRMED", "SHIPPED", "DELIVERED"]
end

type OrderItem
  productId: string
  quantity: int where quantity > 0
  unitPrice: Money(EUR)
  totalPrice: Money(EUR)
end
```

## Type Constraints

### Where Clauses

Constraints use `where` clauses with expressions:

```cdl
fieldName: Type where condition
```

**Supported Operators:**
- Comparison: `>`, `<`, `>=`, `<=`, `==`, `!=`
- Logical: `and`, `or`, `not`
- Membership: `in [value1, value2, ...]`
- String: `contains`, `startsWith`, `endsWith`
- Numeric: Range checks

### Examples

#### Numeric Constraints
```cdl
age: int where age >= 18 and age <= 120
price: decimal where price > 0
```

#### String Constraints
```cdl
countryCode: string where countryCode in ["FR", "DE", "IT", "ES"]
status: string where status in ["ACTIVE", "INACTIVE", "SUSPENDED"]
```

#### Complex Constraints
```cdl
email: string where contains(email, "@") and not contains(email, " ")
iban: string where startsWith(iban, "FR") and length(iban) == 27
```

## Type References in Intents

### Input/Output Type References

```cdl
intent PROCESS_ORDER
  inputs: "[
    customer: Customer,
    order: Order,
    paymentMethod: string where paymentMethod in ['CARD', 'BANK_TRANSFER']
  ]"
  outputs: "[
    orderId: string,
    confirmation: OrderConfirmation,
    estimatedDelivery: date
  ]"
end

type OrderConfirmation
  orderId: string
  status: string
  totalAmount: Money(EUR)
  estimatedDelivery: date
end
```

## Type System Implementation

### AST Extensions

```java
// New AST nodes
TypeDefinition     // type Customer { ... }
TypeReference      // Customer, Money(EUR)
TypeConstraint     // where age > 18
ParameterizedType  // Money(currency: string)

// Enhanced Intent
Intent.inputs: List<TypedParameter>
Intent.outputs: List<TypedParameter>

// TypedParameter
class TypedParameter {
    String name;
    TypeReference type;
    Optional<TypeConstraint> constraint;
}
```

### Validation Rules

1. **Type Resolution**: All type references must resolve to defined types
2. **Constraint Validation**: Where clauses must be type-compatible
3. **Circular References**: No circular type dependencies
4. **Parameter Binding**: Intent inputs/outputs must match type signatures

### Error Model

```java
enum TypeError {
    TYPE_NOT_FOUND(2001, "Type '{type}' not found"),
    INVALID_CONSTRAINT(2002, "Invalid constraint for type {type}: {constraint}"),
    CIRCULAR_REFERENCE(2003, "Circular type reference detected: {typePath}"),
    PARAMETER_MISMATCH(2004, "Parameter type mismatch: expected {expected}, got {actual}")
}
```

## OpenAPI Generation

### Type Mapping

| CDL Type | OpenAPI Schema |
|----------|----------------|
| `string` | `{"type": "string"}` |
| `int` | `{"type": "integer"}` |
| `decimal` | `{"type": "number", "format": "decimal"}` |
| `bool` | `{"type": "boolean"}` |
| `date` | `{"type": "string", "format": "date"}` |
| `datetime` | `{"type": "string", "format": "date-time"}` |
| `Email` | `{"type": "string", "format": "email"}` |
| `Money(EUR)` | Complex object schema |

### Example Generated Schema

For `Money(EUR)`:
```yaml
type: object
properties:
  amount:
    type: number
    format: decimal
    minimum: 0
  currency:
    type: string
    enum: [EUR]
required: [amount, currency]
```

## Migration from v0.5

### Backward Compatibility

- Existing `string`, `int`, `decimal`, `bool` types remain unchanged
- New temporal types are additive
- Type definitions are optional (existing specs work without them)

### Migration Path

1. **Phase 1**: Add type definitions alongside existing specs
2. **Phase 2**: Gradually add type annotations to intent parameters
3. **Phase 3**: Enable strict type checking in compiler

## Implementation Roadmap

### v0.6.0 (Current Sprint)
- [ ] Basic type definitions (`type` blocks)
- [ ] Primitive types + temporal types
- [ ] Type references in intent parameters
- [ ] Basic OpenAPI schema generation

### v0.6.1 (Next Sprint)
- [ ] Extended types (`Money`, `Email`, `GeoPoint`)
- [ ] Type constraints (`where` clauses)
- [ ] Constraint validation
- [ ] Enhanced error reporting

### v0.6.2 (Following Sprint)
- [ ] Parameterized types (`Money(currency)`)
- [ ] Complex constraints (expressions)
- [ ] Type inference
- [ ] CTK type system tests

---

**Status**: Draft - Implementation in Progress
**Authors**: CDL Team
**Last Updated**: October 2025
