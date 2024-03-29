// Generated from C:/dev/git/dev-rune-tools/mathlogical-sentence-compiler/src/main/resources\MathematicalSentenceParserGrammar.g4 by ANTLR 4.12.0

    package io.github.mportilho.sentencecompiler.grammar;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MathematicalSentenceParserGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MathematicalSentenceParserGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MathematicalSentenceParserGrammarParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(MathematicalSentenceParserGrammarParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link MathematicalSentenceParserGrammarParser#mathStart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathStart(MathematicalSentenceParserGrammarParser.MathStartContext ctx);
	/**
	 * Visit a parse tree produced by {@link MathematicalSentenceParserGrammarParser#logicalStart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalStart(MathematicalSentenceParserGrammarParser.LogicalStartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignOperation}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignOperation(MathematicalSentenceParserGrammarParser.AssignOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code destructuringAssignment}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDestructuringAssignment(MathematicalSentenceParserGrammarParser.DestructuringAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateTimeExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateTimeExpression(MathematicalSentenceParserGrammarParser.DateTimeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpression(MathematicalSentenceParserGrammarParser.StringExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalValue}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalValue(MathematicalSentenceParserGrammarParser.LogicalValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExpression(MathematicalSentenceParserGrammarParser.LogicExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateExpression(MathematicalSentenceParserGrammarParser.DateExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(MathematicalSentenceParserGrammarParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonMathExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonMathExpression(MathematicalSentenceParserGrammarParser.ComparisonMathExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timeExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeExpression(MathematicalSentenceParserGrammarParser.TimeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalParenthesis}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalParenthesis(MathematicalSentenceParserGrammarParser.LogicalParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code daysSubtractionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDaysSubtractionExpression(MathematicalSentenceParserGrammarParser.DaysSubtractionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code modulusExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModulusExpression(MathematicalSentenceParserGrammarParser.ModulusExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mathParenthesis}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathParenthesis(MathematicalSentenceParserGrammarParser.MathParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicationExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpression(MathematicalSentenceParserGrammarParser.MultiplicationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mathSpecificExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathSpecificExpression(MathematicalSentenceParserGrammarParser.MathSpecificExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code factorialExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorialExpression(MathematicalSentenceParserGrammarParser.FactorialExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negateMathParenthesis}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegateMathParenthesis(MathematicalSentenceParserGrammarParser.NegateMathParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code squareRootExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSquareRootExpression(MathematicalSentenceParserGrammarParser.SquareRootExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code percentExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPercentExpression(MathematicalSentenceParserGrammarParser.PercentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rootExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRootExpression(MathematicalSentenceParserGrammarParser.RootExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sumExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumExpression(MathematicalSentenceParserGrammarParser.SumExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code degreeExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDegreeExpression(MathematicalSentenceParserGrammarParser.DegreeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberValue}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberValue(MathematicalSentenceParserGrammarParser.NumberValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exponentiationExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExponentiationExpression(MathematicalSentenceParserGrammarParser.ExponentiationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logarithmExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathSpecificFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogarithmExpression(MathematicalSentenceParserGrammarParser.LogarithmExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code roundingExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathSpecificFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoundingExpression(MathematicalSentenceParserGrammarParser.RoundingExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sequenceExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathSpecificFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequenceExpression(MathematicalSentenceParserGrammarParser.SequenceExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fixedLogarithm}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logarithmFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFixedLogarithm(MathematicalSentenceParserGrammarParser.FixedLogarithmContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableLogarithm}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logarithmFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableLogarithm(MathematicalSentenceParserGrammarParser.VariableLogarithmContext ctx);
	/**
	 * Visit a parse tree produced by {@link MathematicalSentenceParserGrammarParser#roundingFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoundingFunction(MathematicalSentenceParserGrammarParser.RoundingFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MathematicalSentenceParserGrammarParser#sequenceFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequenceFunction(MathematicalSentenceParserGrammarParser.SequenceFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateParenthesis}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateParenthesis(MathematicalSentenceParserGrammarParser.DateParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateFunction}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateFunction(MathematicalSentenceParserGrammarParser.DateFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timeParenthesis}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#timeOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeParenthesis(MathematicalSentenceParserGrammarParser.TimeParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timeFunction}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#timeOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeFunction(MathematicalSentenceParserGrammarParser.TimeFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateTimeParenthesis}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateTimeOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateTimeParenthesis(MathematicalSentenceParserGrammarParser.DateTimeParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateTimeFunction}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateTimeOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateTimeFunction(MathematicalSentenceParserGrammarParser.DateTimeFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MathematicalSentenceParserGrammarParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(MathematicalSentenceParserGrammarParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MathematicalSentenceParserGrammarParser#comparisonOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOperator(MathematicalSentenceParserGrammarParser.ComparisonOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MathematicalSentenceParserGrammarParser#logicalOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOperator(MathematicalSentenceParserGrammarParser.LogicalOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MathematicalSentenceParserGrammarParser#allEntityTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllEntityTypes(MathematicalSentenceParserGrammarParser.AllEntityTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MathematicalSentenceParserGrammarParser#scalarEntityTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScalarEntityTypes(MathematicalSentenceParserGrammarParser.ScalarEntityTypesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalConstant}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalConstant(MathematicalSentenceParserGrammarParser.LogicalConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalDecisionExpression(MathematicalSentenceParserGrammarParser.LogicalDecisionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalFunctionDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalFunctionDecisionExpression(MathematicalSentenceParserGrammarParser.LogicalFunctionDecisionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalFunctionResult}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalFunctionResult(MathematicalSentenceParserGrammarParser.LogicalFunctionResultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalVariable(MathematicalSentenceParserGrammarParser.LogicalVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mathDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathDecisionExpression(MathematicalSentenceParserGrammarParser.MathDecisionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mathFunctionDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathFunctionDecisionExpression(MathematicalSentenceParserGrammarParser.MathFunctionDecisionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eulerConstant}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEulerConstant(MathematicalSentenceParserGrammarParser.EulerConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code piConstant}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPiConstant(MathematicalSentenceParserGrammarParser.PiConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code summationVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSummationVariable(MathematicalSentenceParserGrammarParser.SummationVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code productSequenceVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProductSequenceVariable(MathematicalSentenceParserGrammarParser.ProductSequenceVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numericConstant}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericConstant(MathematicalSentenceParserGrammarParser.NumericConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numericFunctionResult}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericFunctionResult(MathematicalSentenceParserGrammarParser.NumericFunctionResultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numericVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericVariable(MathematicalSentenceParserGrammarParser.NumericVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#stringEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringDecisionExpression(MathematicalSentenceParserGrammarParser.StringDecisionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringFunctionDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#stringEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringFunctionDecisionExpression(MathematicalSentenceParserGrammarParser.StringFunctionDecisionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringConstant}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#stringEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConstant(MathematicalSentenceParserGrammarParser.StringConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringFunctionResult}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#stringEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringFunctionResult(MathematicalSentenceParserGrammarParser.StringFunctionResultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#stringEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringVariable(MathematicalSentenceParserGrammarParser.StringVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateDecisionExpression(MathematicalSentenceParserGrammarParser.DateDecisionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateFunctionDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateFunctionDecisionExpression(MathematicalSentenceParserGrammarParser.DateFunctionDecisionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateConstant}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateConstant(MathematicalSentenceParserGrammarParser.DateConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateCurrentValue}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateCurrentValue(MathematicalSentenceParserGrammarParser.DateCurrentValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateVariable(MathematicalSentenceParserGrammarParser.DateVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateFunctionResult}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateFunctionResult(MathematicalSentenceParserGrammarParser.DateFunctionResultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timeDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#timeEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeDecisionExpression(MathematicalSentenceParserGrammarParser.TimeDecisionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timeFunctionDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#timeEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeFunctionDecisionExpression(MathematicalSentenceParserGrammarParser.TimeFunctionDecisionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timeConstant}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#timeEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeConstant(MathematicalSentenceParserGrammarParser.TimeConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timeCurrentValue}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#timeEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeCurrentValue(MathematicalSentenceParserGrammarParser.TimeCurrentValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timeVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#timeEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeVariable(MathematicalSentenceParserGrammarParser.TimeVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timeFunctionResult}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#timeEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeFunctionResult(MathematicalSentenceParserGrammarParser.TimeFunctionResultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateTimeDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateTimeEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateTimeDecisionExpression(MathematicalSentenceParserGrammarParser.DateTimeDecisionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateTimeFunctionDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateTimeEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateTimeFunctionDecisionExpression(MathematicalSentenceParserGrammarParser.DateTimeFunctionDecisionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateTimeConstant}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateTimeEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateTimeConstant(MathematicalSentenceParserGrammarParser.DateTimeConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateTimeCurrentValue}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateTimeEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateTimeCurrentValue(MathematicalSentenceParserGrammarParser.DateTimeCurrentValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateTimeVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateTimeEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateTimeVariable(MathematicalSentenceParserGrammarParser.DateTimeVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateTimeFunctionResult}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateTimeEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateTimeFunctionResult(MathematicalSentenceParserGrammarParser.DateTimeFunctionResultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vectorOfNumbers}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVectorOfNumbers(MathematicalSentenceParserGrammarParser.VectorOfNumbersContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vectorOfBooleans}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVectorOfBooleans(MathematicalSentenceParserGrammarParser.VectorOfBooleansContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vectorOfStrings}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVectorOfStrings(MathematicalSentenceParserGrammarParser.VectorOfStringsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vectorOfDates}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVectorOfDates(MathematicalSentenceParserGrammarParser.VectorOfDatesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vectorOfTimes}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVectorOfTimes(MathematicalSentenceParserGrammarParser.VectorOfTimesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vectorOfDateTimes}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVectorOfDateTimes(MathematicalSentenceParserGrammarParser.VectorOfDateTimesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vectorOfExpressions}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVectorOfExpressions(MathematicalSentenceParserGrammarParser.VectorOfExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vectorVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVectorVariable(MathematicalSentenceParserGrammarParser.VectorVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MathematicalSentenceParserGrammarParser#vectorOfVariables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVectorOfVariables(MathematicalSentenceParserGrammarParser.VectorOfVariablesContext ctx);
}