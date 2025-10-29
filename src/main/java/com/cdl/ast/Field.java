package com.cdl.ast;

public class Field {
    private String name;
    private TypeReference typeRef;
    private Expression constraint;

    public Field(String name, TypeReference typeRef, Expression constraint) {
        this.name = name;
        this.typeRef = typeRef;
        this.constraint = constraint;
    }

    public String getName() { return name; }

    public TypeReference getTypeRef() { return typeRef; }

    public Expression getConstraint() { return constraint; }
}
