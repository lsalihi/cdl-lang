package com.cdl.ast;

import java.util.Map;

public class Mapping extends Statement {
    private String id;
    private String target;
    private Map<String, Object> meta;

    public Mapping(String id, String target, Map<String, Object> meta) {
        this.id = id;
        this.target = target;
        this.meta = meta;
    }

    @Override
    public String getId() { return id; }

    public String getTarget() { return target; }

    public Map<String, Object> getMeta() { return meta; }
}
