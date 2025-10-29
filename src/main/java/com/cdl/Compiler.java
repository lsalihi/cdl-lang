package com.cdl;

import com.cdl.ast.Program;
import com.cdl.ir.IR;
import com.cdl.backends.OpenAPIGenerator;
import com.cdl.backends.RegoGenerator;
import org.antlr.v4.runtime.*;

public class Compiler {
    public static Result compile(String fileName) throws Exception {
        CharStream input = CharStreams.fromFileName(fileName);
        CDLLexer lexer = new CDLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CDLParser parser = new CDLParser(tokens);
        var tree = parser.program();

        ASTBuilder builder = new ASTBuilder();
        Program program = builder.build(tree);

        SymbolTable symbolTable = new SymbolTable();
        symbolTable.build(program);

        TypeChecker typeChecker = new TypeChecker();
        typeChecker.check(program, symbolTable);

        IR ir = IR.fromAST(program);
        String openapi = OpenAPIGenerator.generate(ir);
        String rego = RegoGenerator.generate(ir);

        return new Result(program, symbolTable, typeChecker, ir, openapi, rego);
    }

    public static class Result {
        public final Program program;
        public final SymbolTable symbolTable;
        public final TypeChecker typeChecker;
        public final IR ir;
        public final String openapi;
        public final String rego;

        public Result(Program program, SymbolTable symbolTable, TypeChecker typeChecker, IR ir, String openapi, String rego) {
            this.program = program;
            this.symbolTable = symbolTable;
            this.typeChecker = typeChecker;
            this.ir = ir;
            this.openapi = openapi;
            this.rego = rego;
        }
    }
}
