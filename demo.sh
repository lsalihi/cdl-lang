#!/bin/bash

# Demo script for CDL MVP

echo "CDL Demo - v0.5-MVP"
echo "==================="

# Build
echo "Building..."
./gradlew jar -q

# Demo commands
echo ""
echo "1. Build IR from sample.cdl"
java -jar build/libs/cdl-1.0-SNAPSHOT.jar build -i sample.cdl -o demo.ir.json
echo "IR built: demo.ir.json"

echo ""
echo "2. Generate OpenAPI from sample.cdl"
java -jar build/libs/cdl-1.0-SNAPSHOT.jar gen openapi -i sample.cdl -o demo.openapi.yaml
echo "OpenAPI generated: demo.openapi.yaml"

echo ""
echo "3. Lint sample.cdl"
java -jar build/libs/cdl-1.0-SNAPSHOT.jar lint -i sample.cdl

echo ""
echo "4. Format sample.cdl"
java -jar build/libs/cdl-1.0-SNAPSHOT.jar fmt -i sample.cdl

echo ""
echo "Demo complete. Check demo.ir.json and demo.openapi.yaml"
