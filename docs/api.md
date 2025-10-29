# API Reference

## CLI Commands

### cdl build

Parse CDL to IR.

```bash
cdl build -i <input.cdl> -o <output.ir.json>
```

### cdl gen openapi

Generate OpenAPI spec.

```bash
cdl gen openapi -i <input.cdl> -o <output.yaml>
```

### cdl fmt

Format CDL file.

```bash
cdl fmt -i <input.cdl> [-o <output.cdl>]
```

### cdl lint

Lint for errors.

```bash
cdl lint -i <input.cdl>
```

## Java API

### Compiler

```java
import com.cdl.Compiler;

Compiler.Result result = Compiler.compile("file.cdl");
String openapi = result.openapi;
```

### Backends

```java
import com.cdl.backends.OpenAPIGenerator;
import com.cdl.backends.RegoGenerator;

String openapi = OpenAPIGenerator.generate(ir);
String rego = RegoGenerator.generate(ir);
```

## Error Codes

- E001: Duplicate ID
- E002: Invalid type
