#!/bin/bash

# CTK Test Script

echo "Running CTK..."
# Test case01
echo "Testing case01..."
./gradlew jar -q
java -jar build/libs/cdl-1.0-SNAPSHOT.jar gen openapi -i ctk/case01.cdl -o /tmp/case01.yaml
if diff -u ctk/case01.openapi.yaml /tmp/case01.yaml; then
  echo "CTK case01: PASS"
else
  echo "CTK case01: FAIL"
  exit 1
fi

echo "CTK complete."
