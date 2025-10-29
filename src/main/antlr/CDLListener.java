// Generated from src/main/antlr/CDL.g4 by ANTLR 4.13.1


import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CDLParser}.
 */
public interface CDLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CDLParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CDLParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CDLParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CDLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CDLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#intent}.
	 * @param ctx the parse tree
	 */
	void enterIntent(CDLParser.IntentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#intent}.
	 * @param ctx the parse tree
	 */
	void exitIntent(CDLParser.IntentContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#rule}.
	 * @param ctx the parse tree
	 */
	void enterRule(CDLParser.RuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#rule}.
	 * @param ctx the parse tree
	 */
	void exitRule(CDLParser.RuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#policy}.
	 * @param ctx the parse tree
	 */
	void enterPolicy(CDLParser.PolicyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#policy}.
	 * @param ctx the parse tree
	 */
	void exitPolicy(CDLParser.PolicyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#flow}.
	 * @param ctx the parse tree
	 */
	void enterFlow(CDLParser.FlowContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#flow}.
	 * @param ctx the parse tree
	 */
	void exitFlow(CDLParser.FlowContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#mapping}.
	 * @param ctx the parse tree
	 */
	void enterMapping(CDLParser.MappingContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#mapping}.
	 * @param ctx the parse tree
	 */
	void exitMapping(CDLParser.MappingContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#typeDef}.
	 * @param ctx the parse tree
	 */
	void enterTypeDef(CDLParser.TypeDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#typeDef}.
	 * @param ctx the parse tree
	 */
	void exitTypeDef(CDLParser.TypeDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(CDLParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(CDLParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#typeRef}.
	 * @param ctx the parse tree
	 */
	void enterTypeRef(CDLParser.TypeRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#typeRef}.
	 * @param ctx the parse tree
	 */
	void exitTypeRef(CDLParser.TypeRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#parameterizedType}.
	 * @param ctx the parse tree
	 */
	void enterParameterizedType(CDLParser.ParameterizedTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#parameterizedType}.
	 * @param ctx the parse tree
	 */
	void exitParameterizedType(CDLParser.ParameterizedTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(CDLParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(CDLParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(CDLParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(CDLParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CDLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CDLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(CDLParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(CDLParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(CDLParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(CDLParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#comparisonOp}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOp(CDLParser.ComparisonOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#comparisonOp}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOp(CDLParser.ComparisonOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(CDLParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(CDLParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(CDLParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(CDLParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#meta}.
	 * @param ctx the parse tree
	 */
	void enterMeta(CDLParser.MetaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#meta}.
	 * @param ctx the parse tree
	 */
	void exitMeta(CDLParser.MetaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#key}.
	 * @param ctx the parse tree
	 */
	void enterKey(CDLParser.KeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#key}.
	 * @param ctx the parse tree
	 */
	void exitKey(CDLParser.KeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(CDLParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(CDLParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(CDLParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(CDLParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#step}.
	 * @param ctx the parse tree
	 */
	void enterStep(CDLParser.StepContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#step}.
	 * @param ctx the parse tree
	 */
	void exitStep(CDLParser.StepContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(CDLParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(CDLParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#target}.
	 * @param ctx the parse tree
	 */
	void enterTarget(CDLParser.TargetContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#target}.
	 * @param ctx the parse tree
	 */
	void exitTarget(CDLParser.TargetContext ctx);
}