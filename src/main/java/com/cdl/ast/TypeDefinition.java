package com.cdl.ast;

import java.util.List;

public class TypeDefinition extends Statement {
    private String id;
    private List<Field> fields;

    public TypeDefinition(String id, List<Field> fields) {
        this.id = id;
        this.fields = fields;
    }

    @Override
    public String getId() { return id; }

    public List<Field> getFields() { return fields; }
}
