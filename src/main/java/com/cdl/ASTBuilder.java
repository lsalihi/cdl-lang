package com.cdl;

import com.cdl.ast.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.util.*;

public class ASTBuilder extends CDLBaseListener {
    private Program program;
    private List<Statement> statements = new ArrayList<>();
    private Map<String, Object> currentMeta = new HashMap<>();
    private List<String> currentSteps = new ArrayList<>();
    private String currentTarget = "";

    @Override
    public void enterIntent(CDLParser.IntentContext ctx) {
        currentMeta.clear();
    }

    @Override
    public void exitIntent(CDLParser.IntentContext ctx) {
        String id = ctx.ID().getText();
        statements.add(new Intent(id, new HashMap<>(currentMeta)));
    }

    @Override
    public void enterRule(CDLParser.RuleContext ctx) {
        currentMeta.clear();
    }

    @Override
    public void exitRule(CDLParser.RuleContext ctx) {
        String id = ctx.ID().getText();
        statements.add(new Rule(id, new HashMap<>(currentMeta)));
    }

    @Override
    public void enterPolicy(CDLParser.PolicyContext ctx) {
        currentMeta.clear();
    }

    @Override
    public void exitPolicy(CDLParser.PolicyContext ctx) {
        String id = ctx.ID().getText();
        statements.add(new Policy(id, new HashMap<>(currentMeta)));
    }

    @Override
    public void enterFlow(CDLParser.FlowContext ctx) {
        currentMeta.clear();
        currentSteps.clear();
    }

    @Override
    public void exitFlow(CDLParser.FlowContext ctx) {
        String id = ctx.ID().getText();
        statements.add(new Flow(id, new HashMap<>(currentMeta), new ArrayList<>(currentSteps)));
    }

    @Override
    public void enterMapping(CDLParser.MappingContext ctx) {
        currentMeta.clear();
        currentTarget = ctx.target().getText();
    }

    @Override
    public void exitMapping(CDLParser.MappingContext ctx) {
        String id = ctx.ID().getText();
        statements.add(new Mapping(id, currentTarget, new HashMap<>(currentMeta)));
    }

    @Override
    public void exitMeta(CDLParser.MetaContext ctx) {
        String key = ctx.key().getText();
        String value = ctx.value().getText();
        if (value.startsWith("\"") && value.endsWith("\"")) {
            value = value.substring(1, value.length() - 1);
        }
        currentMeta.put(key, value);
    }

    @Override
    public void exitStep(CDLParser.StepContext ctx) {
        String step = ctx.getText();
        currentSteps.add(step);
    }

    public Program build(ParseTree tree) {
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this, tree);
        return new Program(statements);
    }
}
