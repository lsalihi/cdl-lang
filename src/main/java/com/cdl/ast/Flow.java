package com.cdl.ast;

import java.util.List;
import java.util.Map;

public class Flow extends Statement {
    private String id;
    private Map<String, Object> meta;
    private List<String> steps;

    public Flow(String id, Map<String, Object> meta, List<String> steps) {
        this.id = id;
        this.meta = meta;
        this.steps = steps;
    }

    @Override
    public String getId() { return id; }

    public Map<String, Object> getMeta() { return meta; }

    public List<String> getSteps() { return steps; }
}
