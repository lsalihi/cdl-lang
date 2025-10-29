package com.cdl.ast;

import java.util.List;
import java.util.Map;

public class TypeReference {
    private String name;
    private List<Parameter> parameters; // for parameterized types like Money(EUR)

    public TypeReference(String name) {
        this.name = name;
        this.parameters = null;
    }

    public TypeReference(String name, List<Parameter> parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    public String getName() { return name; }

    public List<Parameter> getParameters() { return parameters; }

    public boolean isParameterized() { return parameters != null; }
}
