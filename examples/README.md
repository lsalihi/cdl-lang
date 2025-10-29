# CDL Examples Repository

This directory contains practical examples of CDL usage across different domains and use cases.

## Structure

Each example includes:
- **`.cdl` file**: CDL specification
- **`README.md`**: Detailed explanation and benefits
- **Generated artifacts**: OpenAPI specs, test cases, etc.

## Examples by Domain

### Banking & Finance
- **[SEPA Payment Processing](banking/sepa-payment.cdl)**: European payment system with regulatory compliance
- *Future: Credit scoring, fraud detection, regulatory reporting*

### Healthcare
- **[Patient Data Anonymization](healthcare/patient-anonymization.cdl)**: GDPR-compliant data anonymization for research
- *Future: Clinical decision support, medical device integration*

### E-commerce
- *Future: Order processing, inventory management, recommendation systems*

## How to Use Examples

### 1. Generate OpenAPI
```bash
cd examples/banking
cdl gen openapi -i sepa-payment.cdl -o sepa-payment-api.yaml
```

### 2. Run Tests
```bash
cdl build -i sepa-payment.cdl -o sepa-payment.ir.json
cdl lint -i sepa-payment.cdl
```

### 3. View Generated API
The generated OpenAPI specs can be imported into:
- Swagger UI for documentation
- Postman for testing
- Code generation tools

## Contributing Examples

To add a new example:

1. **Create domain directory** if needed
2. **Write CDL specification** following the patterns
3. **Add comprehensive README** explaining:
   - Business context
   - CDL concepts used
   - Generated outputs
   - Benefits achieved
4. **Test the example** with CTK
5. **Submit PR** with clear description

## Example Quality Criteria

- **Real-world relevance**: Based on actual business needs
- **Educational value**: Demonstrates CDL concepts clearly
- **Completeness**: Includes intents, rules, policies, mappings
- **Documentation**: Well-explained benefits and use cases
- **Testability**: Works with current CDL implementation

## Learning Path

Start with simpler examples and progress to complex ones:

1. **Basic Intent**: Simple API endpoint
2. **With Rules**: Add validation logic
3. **With Policies**: Include governance requirements
4. **Multi-Intent**: Complex workflows
5. **Cross-Domain**: Industry-specific patterns

## Getting Help

- **Issues**: Report problems with examples
- **Discussions**: Share your own examples
- **Documentation**: Check [cdl-lang docs](https://lsalihi.github.io/cdl-lang/)

---

*These examples showcase CDL's versatility across industries and use cases.*
