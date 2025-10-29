package com.cdl.ast;

public class Parameter {
    private String name;
    private TypeReference typeRef;

    public Parameter(String name, TypeReference typeRef) {
        this.name = name;
        this.typeRef = typeRef;
    }

    public String getName() { return name; }

    public TypeReference getTypeRef() { return typeRef; }
}
