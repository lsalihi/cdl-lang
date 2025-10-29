# Examples

## Type Definitions (v0.6.0)

```cdl
type Money
  amount: decimal where amount >= 0
  currency: string
end

type Customer
  id: string
  name: string where length(name) >= 2
  email: Email
  age: int where age >= 18
end
```

## Typed Intent

```cdl
intent CREATE_CUSTOMER
  goal: "Create a new customer account"
  inputs: "[customer: Customer]"
  outputs: "[customerId: string, welcomeEmail: string]"
  evidence: "[customer_registration_policy]"
  tags: "[customer, registration]"
end
```

## Complex Types with Constraints

```cdl
type Order
  id: string
  customerId: string
  items: OrderItem
  totalAmount: Money where totalAmount.amount > 0
  orderDate: date
  deliveryDate: date where deliveryDate >= orderDate
end

type OrderItem
  productId: string
  quantity: int where quantity > 0 and quantity <= 100
  unitPrice: Money
  discount: decimal where discount >= 0.0 and discount <= 0.5
end
```

## Business Rules

```cdl
rule CUSTOMER_AGE_VALIDATION
  statement: "Customer must be of legal age"
  applies_to: "CREATE_CUSTOMER"
  evidence: "[gdpr_age_verification]"
  test_hints: "Age < 18 should be rejected"
  type: "validation"
end

rule ORDER_TOTAL_LIMIT
  statement: "Order total cannot exceed €100,000"
  applies_to: "CREATE_ORDER"
  evidence: "[fraud_prevention_policy]"
  test_hints: "Test with orders over limit"
  type: "business"
end
```

## API Mapping

```cdl
mapping CREATE_CUSTOMER -> "api POST /api/customers"
  request: "CustomerRegistrationRequest"
  response: "CustomerRegistrationResponse"
end

mapping CREATE_ORDER -> "api POST /api/orders"
  request: "OrderRequest"
  response: "OrderResponse"
end
```

## Generated OpenAPI

From the customer example:

```yaml
openapi: 3.0.0
info:
  title: Customer API
  version: 1.0.0

paths:
  /api/customers:
    post:
      summary: Create a new customer account
      operationId: createCustomer
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/CustomerRegistrationRequest'
      responses:
        '200':
          description: Customer created successfully
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/CustomerRegistrationResponse'

components:
  schemas:
    Customer:
      type: object
      required:
        - id
        - name
        - email
        - age
      properties:
        id:
          type: string
        name:
          type: string
          minLength: 2
        email:
          type: string
          format: email
        age:
          type: integer
          minimum: 18

    CustomerRegistrationRequest:
      type: object
      required:
        - customer
      properties:
        customer:
          $ref: '#/components/schemas/Customer'

    CustomerRegistrationResponse:
      type: object
      required:
        - customerId
        - welcomeEmail
      properties:
        customerId:
          type: string
        welcomeEmail:
          type: string
```
