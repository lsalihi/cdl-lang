package com.cdl.ast;

public class Expression {
    // For phase 1, keep it simple - just store the raw expression string
    // In future phases, this will be a proper AST for expressions
    private String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    public String getExpression() { return expression; }
}
