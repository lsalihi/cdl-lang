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