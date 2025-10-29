// Generated from src/main/antlr/CDL.g4 by ANTLR 4.13.1


import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CDLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CDLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CDLParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CDLParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CDLParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#intent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntent(CDLParser.IntentContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule(CDLParser.RuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#policy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPolicy(CDLParser.PolicyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#flow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlow(CDLParser.FlowContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#mapping}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapping(CDLParser.MappingContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#typeDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDef(CDLParser.TypeDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(CDLParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#typeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeRef(CDLParser.TypeRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#parameterizedType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterizedType(CDLParser.ParameterizedTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(CDLParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(CDLParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CDLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(CDLParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(CDLParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#comparisonOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOp(CDLParser.ComparisonOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(CDLParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(CDLParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#meta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeta(CDLParser.MetaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKey(CDLParser.KeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(CDLParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(CDLParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#step}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStep(CDLParser.StepContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(CDLParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTarget(CDLParser.TargetContext ctx);
}