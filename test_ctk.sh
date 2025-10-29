#!/bin/bash

# CTK Test Script

echo "Running CTK..."

# Function to test a case
test_case() {
    local case_num=$1
    echo "Testing case${case_num}..."
    ./gradlew jar -q
    java -jar build/libs/cdl-1.0-SNAPSHOT.jar gen openapi -i ctk/case${case_num}/cdl -o /tmp/case${case_num}.yaml
    if diff -u ctk/case${case_num}/openapi.yaml /tmp/case${case_num}.yaml; then
      echo "CTK case${case_num}: PASS"
    else
      echo "CTK case${case_num}: FAIL"
      exit 1
    fi
}

# Test all cases
test_case "01"
test_case "02"
test_case "03"
test_case "04"
test_case "05"
test_case "06"
test_case "07"
test_case "08"
test_case "09"
test_case "10"

echo "CTK complete - All tests passed!"
