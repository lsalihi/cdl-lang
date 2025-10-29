package com.cdl.ast;

import java.util.List;
import java.util.Map;

public class Intent extends Statement {
    private String id;
    private Map<String, Object> meta;
    private List<TypedParameter> inputs;
    private List<TypedParameter> outputs;

    public Intent(String id, Map<String, Object> meta, List<TypedParameter> inputs, List<TypedParameter> outputs) {
        this.id = id;
        this.meta = meta;
        this.inputs = inputs;
        this.outputs = outputs;
    }

    @Override
    public String getId() { return id; }

    public Map<String, Object> getMeta() { return meta; }

    public List<TypedParameter> getInputs() { return inputs; }

    public List<TypedParameter> getOutputs() { return outputs; }
}
