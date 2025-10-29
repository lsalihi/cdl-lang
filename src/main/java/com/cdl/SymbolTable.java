package com.cdl;

import com.cdl.ast.*;
import java.util.*;

public class SymbolTable {
    private Map<String, Statement> symbols = new HashMap<>();
    private List<CDError> errors = new ArrayList<>();

    public void build(Program program) {
        for (Statement stmt : program.getStatements()) {
            String id = stmt.getId();
            if (symbols.containsKey(id)) {
                errors.add(new CDError(CDError.Code.DUPLICATE_ID, id, 0, 0));
            } else {
                symbols.put(id, stmt);
            }
        }
    }

    public Statement resolve(String id) {
        return symbols.get(id);
    }

    public List<CDError> getErrors() {
        return errors;
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }
}
