# Examples

## Basic Intent

```cdl
intent INTERBANK_TRANSFER
goal: "Process an SEPA interbank transfer"
inputs: "[accountId: String, amount: Money_EUR]"
outputs: "[paymentId: PaymentId]"
evidence: "[repo_legacy_PAYMENT_CBL_145_189, trace_POST_payments_at_2023_11_10]"
tags: "[payments, sepa]"
trust: "{confidence: 0.85, components: {evidence: 0.90, consistency: 0.80, tests: 0.75}}"
end
```

## With Mapping

```cdl
intent PROCESS_PAYMENT
goal: "Process a payment"
inputs: "[amount: Money, account: String]"
outputs: "[id: String]"
evidence: "[legacy_code]"
tags: "[finance]"
end

mapping PROCESS_PAYMENT -> "api POST /api/payments"
request: "PaymentRequest"
response: "PaymentResponse"
end
```

## Rule

```cdl
rule IBAN_MUST_BE_VALID
statement: "The IBAN must be valid before issuance"
applies_to: "INTERBANK_TRANSFER"
evidence: "[repo_legacy_VALIDATE_CBL_180_206]"
test_hints: "Invalid IBAN => 400"
type: "validation"
end
```

## Generated OpenAPI

From the payment example:

```yaml
openapi: 3.0.0
info:
  title: CDL API
  version: 1.0.0
paths:
  /api/payments:
    post:
      summary: Generated from PROCESS_PAYMENT
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/PaymentRequest'
      responses:
        '200':
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/PaymentResponse'
```
