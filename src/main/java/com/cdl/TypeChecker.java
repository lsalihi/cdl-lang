package com.cdl;

import com.cdl.ast.*;
import java.util.*;

public class TypeChecker {
    private List<CDError> errors = new ArrayList<>();

    public void check(Program program, SymbolTable symbolTable) {
        for (Statement stmt : program.getStatements()) {
            if (stmt instanceof Intent) {
                checkIntent((Intent) stmt);
            } else if (stmt instanceof Rule) {
                checkRule((Rule) stmt);
            }
            // Add others
        }
    }

    private void checkIntent(Intent intent) {
        Map<String, Object> meta = intent.getMeta();
        if (meta.containsKey("goal")) {
            if (!(meta.get("goal") instanceof String)) {
                errors.add(new CDError(CDError.Code.INVALID_TYPE, "goal must be string in " + intent.getId(), 0, 0));
            }
        }
        // Add more checks
    }

    private void checkRule(Rule rule) {
        Map<String, Object> meta = rule.getMeta();
        if (meta.containsKey("statement")) {
            if (!(meta.get("statement") instanceof String)) {
                errors.add(new CDError(CDError.Code.INVALID_TYPE, "statement must be string in " + rule.getId(), 0, 0));
            }
        }
    }

    public List<CDError> getErrors() {
        return errors;
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }
}
