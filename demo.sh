#!/bin/bash

# Demo script for CDL MVP

echo "CDL Demo - v0.5-MVP"
echo "==================="

# Build
echo "Building..."
gradle build -q

# Demo commands
echo ""
echo "1. Build IR from sample.cdl"
java -cp build/classes/java/main:antlr-4.13.1-complete.jar com.cdl.CDLCLI build -i sample.cdl -o demo.ir.json
echo "IR built: demo.ir.json"

echo ""
echo "2. Generate OpenAPI from sample.cdl"
java -cp build/classes/java/main:antlr-4.13.1-complete.jar com.cdl.CDLCLI gen openapi -i sample.cdl -o demo.openapi.yaml
echo "OpenAPI generated: demo.openapi.yaml"

echo ""
echo "3. Lint sample.cdl"
java -cp build/classes/java/main:antlr-4.13.1-complete.jar com.cdl.CDLCLI lint -i sample.cdl

echo ""
echo "4. Format sample.cdl"
java -cp build/classes/java/main:antlr-4.13.1-complete.jar com.cdl.CDLCLI fmt -i sample.cdl

echo ""
echo "Demo complete. Check demo.ir.json and demo.openapi.yaml"
