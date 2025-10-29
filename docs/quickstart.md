# Quickstart

Get started with CDL in 5 minutes.

## Prerequisites

- Java 17+
- Gradle (or use wrapper)

## Installation

### Option 1: Docker (Recommended)

```bash
# Pull the image
docker pull ghcr.io/lsalihi/cdl-lang:latest

# Run a command
docker run --rm -v "$PWD":/w ghcr.io/lsalihi/cdl-lang:latest \
  cdl gen openapi -i /w/sample.cdl -o /w/api.yaml
```

### Option 2: Local Build

```bash
# Clone
git clone https://github.com/lsalihi/cdl-lang.git
cd cdl-lang

# Build
./gradlew build

# Verify
java -cp build/classes/java/main:antlr-4.13.1-complete.jar com.cdl.CDLCLI --help
```

## Your First CDL File

Create `myintent.cdl`:

```cdl
intent PROCESS_PAYMENT
goal: "Process a payment transaction"
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

## Generate OpenAPI

```bash
cdl gen openapi -i myintent.cdl -o api.yaml
```

This creates a valid OpenAPI 3.0 spec you can import into Swagger or Postman.

## Run Tests

```bash
# Lint for errors
cdl lint -i myintent.cdl

# Format the file
cdl fmt -i myintent.cdl
```

## Next Steps

- Explore [examples](examples.md)
- Read the [specification](spec.md)
- Check [API reference](api.md)
