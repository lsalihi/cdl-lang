package com.cdl.ast;

import java.util.Map;

public class Rule extends Statement {
    private String id;
    private Map<String, Object> meta;

    public Rule(String id, Map<String, Object> meta) {
        this.id = id;
        this.meta = meta;
    }

    @Override
    public String getId() { return id; }

    public Map<String, Object> getMeta() { return meta; }
}
