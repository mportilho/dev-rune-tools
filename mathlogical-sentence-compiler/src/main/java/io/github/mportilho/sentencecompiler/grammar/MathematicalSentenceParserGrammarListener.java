// Generated from D:/dev/git/dev-rune-tools/mathlogical-sentence-compiler/src/main/resources\MathematicalSentenceParserGrammar.g4 by ANTLR 4.9.2

    package io.github.mportilho.sentencecompiler.grammar;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MathematicalSentenceParserGrammarParser}.
 */
public interface MathematicalSentenceParserGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MathematicalSentenceParserGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(MathematicalSentenceParserGrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MathematicalSentenceParserGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(MathematicalSentenceParserGrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link MathematicalSentenceParserGrammarParser#mathStart}.
	 * @param ctx the parse tree
	 */
	void enterMathStart(MathematicalSentenceParserGrammarParser.MathStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MathematicalSentenceParserGrammarParser#mathStart}.
	 * @param ctx the parse tree
	 */
	void exitMathStart(MathematicalSentenceParserGrammarParser.MathStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link MathematicalSentenceParserGrammarParser#logicalStart}.
	 * @param ctx the parse tree
	 */
	void enterLogicalStart(MathematicalSentenceParserGrammarParser.LogicalStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MathematicalSentenceParserGrammarParser#logicalStart}.
	 * @param ctx the parse tree
	 */
	void exitLogicalStart(MathematicalSentenceParserGrammarParser.LogicalStartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignOperation}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignOperation(MathematicalSentenceParserGrammarParser.AssignOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignOperation}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignOperation(MathematicalSentenceParserGrammarParser.AssignOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dateTimeExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterDateTimeExpression(MathematicalSentenceParserGrammarParser.DateTimeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dateTimeExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitDateTimeExpression(MathematicalSentenceParserGrammarParser.DateTimeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(MathematicalSentenceParserGrammarParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(MathematicalSentenceParserGrammarParser.StringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vectorExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterVectorExpression(MathematicalSentenceParserGrammarParser.VectorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vectorExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitVectorExpression(MathematicalSentenceParserGrammarParser.VectorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalValue}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalValue(MathematicalSentenceParserGrammarParser.LogicalValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalValue}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalValue(MathematicalSentenceParserGrammarParser.LogicalValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicExpression(MathematicalSentenceParserGrammarParser.LogicExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicExpression(MathematicalSentenceParserGrammarParser.LogicExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dateExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterDateExpression(MathematicalSentenceParserGrammarParser.DateExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dateExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitDateExpression(MathematicalSentenceParserGrammarParser.DateExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(MathematicalSentenceParserGrammarParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(MathematicalSentenceParserGrammarParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparisonMathExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonMathExpression(MathematicalSentenceParserGrammarParser.ComparisonMathExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparisonMathExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonMathExpression(MathematicalSentenceParserGrammarParser.ComparisonMathExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code timeExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterTimeExpression(MathematicalSentenceParserGrammarParser.TimeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code timeExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitTimeExpression(MathematicalSentenceParserGrammarParser.TimeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalParenthesis}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalParenthesis(MathematicalSentenceParserGrammarParser.LogicalParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalParenthesis}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalParenthesis(MathematicalSentenceParserGrammarParser.LogicalParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code modulusExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void enterModulusExpression(MathematicalSentenceParserGrammarParser.ModulusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code modulusExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void exitModulusExpression(MathematicalSentenceParserGrammarParser.ModulusExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mathParenthesis}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void enterMathParenthesis(MathematicalSentenceParserGrammarParser.MathParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mathParenthesis}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void exitMathParenthesis(MathematicalSentenceParserGrammarParser.MathParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicationExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationExpression(MathematicalSentenceParserGrammarParser.MultiplicationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicationExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationExpression(MathematicalSentenceParserGrammarParser.MultiplicationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mathSpecificExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void enterMathSpecificExpression(MathematicalSentenceParserGrammarParser.MathSpecificExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mathSpecificExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void exitMathSpecificExpression(MathematicalSentenceParserGrammarParser.MathSpecificExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factorialExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void enterFactorialExpression(MathematicalSentenceParserGrammarParser.FactorialExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factorialExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void exitFactorialExpression(MathematicalSentenceParserGrammarParser.FactorialExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negateMathParenthesis}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void enterNegateMathParenthesis(MathematicalSentenceParserGrammarParser.NegateMathParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negateMathParenthesis}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void exitNegateMathParenthesis(MathematicalSentenceParserGrammarParser.NegateMathParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code squareRootExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void enterSquareRootExpression(MathematicalSentenceParserGrammarParser.SquareRootExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code squareRootExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void exitSquareRootExpression(MathematicalSentenceParserGrammarParser.SquareRootExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code percentExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void enterPercentExpression(MathematicalSentenceParserGrammarParser.PercentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code percentExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void exitPercentExpression(MathematicalSentenceParserGrammarParser.PercentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rootExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void enterRootExpression(MathematicalSentenceParserGrammarParser.RootExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rootExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void exitRootExpression(MathematicalSentenceParserGrammarParser.RootExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sumExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void enterSumExpression(MathematicalSentenceParserGrammarParser.SumExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sumExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void exitSumExpression(MathematicalSentenceParserGrammarParser.SumExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code degreeExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void enterDegreeExpression(MathematicalSentenceParserGrammarParser.DegreeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code degreeExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void exitDegreeExpression(MathematicalSentenceParserGrammarParser.DegreeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberValue}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void enterNumberValue(MathematicalSentenceParserGrammarParser.NumberValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberValue}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void exitNumberValue(MathematicalSentenceParserGrammarParser.NumberValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exponentiationExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void enterExponentiationExpression(MathematicalSentenceParserGrammarParser.ExponentiationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exponentiationExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void exitExponentiationExpression(MathematicalSentenceParserGrammarParser.ExponentiationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logarithmExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathSpecificFunction}.
	 * @param ctx the parse tree
	 */
	void enterLogarithmExpression(MathematicalSentenceParserGrammarParser.LogarithmExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logarithmExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathSpecificFunction}.
	 * @param ctx the parse tree
	 */
	void exitLogarithmExpression(MathematicalSentenceParserGrammarParser.LogarithmExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code roundingExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathSpecificFunction}.
	 * @param ctx the parse tree
	 */
	void enterRoundingExpression(MathematicalSentenceParserGrammarParser.RoundingExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code roundingExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathSpecificFunction}.
	 * @param ctx the parse tree
	 */
	void exitRoundingExpression(MathematicalSentenceParserGrammarParser.RoundingExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sequenceExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathSpecificFunction}.
	 * @param ctx the parse tree
	 */
	void enterSequenceExpression(MathematicalSentenceParserGrammarParser.SequenceExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sequenceExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#mathSpecificFunction}.
	 * @param ctx the parse tree
	 */
	void exitSequenceExpression(MathematicalSentenceParserGrammarParser.SequenceExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fixedLogarithm}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logarithmFunction}.
	 * @param ctx the parse tree
	 */
	void enterFixedLogarithm(MathematicalSentenceParserGrammarParser.FixedLogarithmContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fixedLogarithm}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logarithmFunction}.
	 * @param ctx the parse tree
	 */
	void exitFixedLogarithm(MathematicalSentenceParserGrammarParser.FixedLogarithmContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableLogarithm}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logarithmFunction}.
	 * @param ctx the parse tree
	 */
	void enterVariableLogarithm(MathematicalSentenceParserGrammarParser.VariableLogarithmContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableLogarithm}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logarithmFunction}.
	 * @param ctx the parse tree
	 */
	void exitVariableLogarithm(MathematicalSentenceParserGrammarParser.VariableLogarithmContext ctx);
	/**
	 * Enter a parse tree produced by {@link MathematicalSentenceParserGrammarParser#roundingFunction}.
	 * @param ctx the parse tree
	 */
	void enterRoundingFunction(MathematicalSentenceParserGrammarParser.RoundingFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MathematicalSentenceParserGrammarParser#roundingFunction}.
	 * @param ctx the parse tree
	 */
	void exitRoundingFunction(MathematicalSentenceParserGrammarParser.RoundingFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MathematicalSentenceParserGrammarParser#sequenceFunction}.
	 * @param ctx the parse tree
	 */
	void enterSequenceFunction(MathematicalSentenceParserGrammarParser.SequenceFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MathematicalSentenceParserGrammarParser#sequenceFunction}.
	 * @param ctx the parse tree
	 */
	void exitSequenceFunction(MathematicalSentenceParserGrammarParser.SequenceFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dateParenthesis}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateOperation}.
	 * @param ctx the parse tree
	 */
	void enterDateParenthesis(MathematicalSentenceParserGrammarParser.DateParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dateParenthesis}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateOperation}.
	 * @param ctx the parse tree
	 */
	void exitDateParenthesis(MathematicalSentenceParserGrammarParser.DateParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dateFunction}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateOperation}.
	 * @param ctx the parse tree
	 */
	void enterDateFunction(MathematicalSentenceParserGrammarParser.DateFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dateFunction}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateOperation}.
	 * @param ctx the parse tree
	 */
	void exitDateFunction(MathematicalSentenceParserGrammarParser.DateFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code timeParenthesis}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#timeOperation}.
	 * @param ctx the parse tree
	 */
	void enterTimeParenthesis(MathematicalSentenceParserGrammarParser.TimeParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code timeParenthesis}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#timeOperation}.
	 * @param ctx the parse tree
	 */
	void exitTimeParenthesis(MathematicalSentenceParserGrammarParser.TimeParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code timeFunction}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#timeOperation}.
	 * @param ctx the parse tree
	 */
	void enterTimeFunction(MathematicalSentenceParserGrammarParser.TimeFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code timeFunction}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#timeOperation}.
	 * @param ctx the parse tree
	 */
	void exitTimeFunction(MathematicalSentenceParserGrammarParser.TimeFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dateTimeParenthesis}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateTimeOperation}.
	 * @param ctx the parse tree
	 */
	void enterDateTimeParenthesis(MathematicalSentenceParserGrammarParser.DateTimeParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dateTimeParenthesis}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateTimeOperation}.
	 * @param ctx the parse tree
	 */
	void exitDateTimeParenthesis(MathematicalSentenceParserGrammarParser.DateTimeParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dateTimeFunction}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateTimeOperation}.
	 * @param ctx the parse tree
	 */
	void enterDateTimeFunction(MathematicalSentenceParserGrammarParser.DateTimeFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dateTimeFunction}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateTimeOperation}.
	 * @param ctx the parse tree
	 */
	void exitDateTimeFunction(MathematicalSentenceParserGrammarParser.DateTimeFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MathematicalSentenceParserGrammarParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(MathematicalSentenceParserGrammarParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MathematicalSentenceParserGrammarParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(MathematicalSentenceParserGrammarParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vectorContainsOperation}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorFunction}.
	 * @param ctx the parse tree
	 */
	void enterVectorContainsOperation(MathematicalSentenceParserGrammarParser.VectorContainsOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vectorContainsOperation}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorFunction}.
	 * @param ctx the parse tree
	 */
	void exitVectorContainsOperation(MathematicalSentenceParserGrammarParser.VectorContainsOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MathematicalSentenceParserGrammarParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(MathematicalSentenceParserGrammarParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MathematicalSentenceParserGrammarParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(MathematicalSentenceParserGrammarParser.ComparisonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MathematicalSentenceParserGrammarParser#logicalOperator}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOperator(MathematicalSentenceParserGrammarParser.LogicalOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MathematicalSentenceParserGrammarParser#logicalOperator}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOperator(MathematicalSentenceParserGrammarParser.LogicalOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MathematicalSentenceParserGrammarParser#allEntityTypes}.
	 * @param ctx the parse tree
	 */
	void enterAllEntityTypes(MathematicalSentenceParserGrammarParser.AllEntityTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MathematicalSentenceParserGrammarParser#allEntityTypes}.
	 * @param ctx the parse tree
	 */
	void exitAllEntityTypes(MathematicalSentenceParserGrammarParser.AllEntityTypesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalConstant}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalEntity}.
	 * @param ctx the parse tree
	 */
	void enterLogicalConstant(MathematicalSentenceParserGrammarParser.LogicalConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalConstant}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalEntity}.
	 * @param ctx the parse tree
	 */
	void exitLogicalConstant(MathematicalSentenceParserGrammarParser.LogicalConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalEntity}.
	 * @param ctx the parse tree
	 */
	void enterLogicalDecisionExpression(MathematicalSentenceParserGrammarParser.LogicalDecisionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalEntity}.
	 * @param ctx the parse tree
	 */
	void exitLogicalDecisionExpression(MathematicalSentenceParserGrammarParser.LogicalDecisionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalFunctionDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalEntity}.
	 * @param ctx the parse tree
	 */
	void enterLogicalFunctionDecisionExpression(MathematicalSentenceParserGrammarParser.LogicalFunctionDecisionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalFunctionDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalEntity}.
	 * @param ctx the parse tree
	 */
	void exitLogicalFunctionDecisionExpression(MathematicalSentenceParserGrammarParser.LogicalFunctionDecisionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalFunctionResult}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalEntity}.
	 * @param ctx the parse tree
	 */
	void enterLogicalFunctionResult(MathematicalSentenceParserGrammarParser.LogicalFunctionResultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalFunctionResult}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalEntity}.
	 * @param ctx the parse tree
	 */
	void exitLogicalFunctionResult(MathematicalSentenceParserGrammarParser.LogicalFunctionResultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalEntity}.
	 * @param ctx the parse tree
	 */
	void enterLogicalVariable(MathematicalSentenceParserGrammarParser.LogicalVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#logicalEntity}.
	 * @param ctx the parse tree
	 */
	void exitLogicalVariable(MathematicalSentenceParserGrammarParser.LogicalVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mathDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 */
	void enterMathDecisionExpression(MathematicalSentenceParserGrammarParser.MathDecisionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mathDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 */
	void exitMathDecisionExpression(MathematicalSentenceParserGrammarParser.MathDecisionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mathFunctionDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 */
	void enterMathFunctionDecisionExpression(MathematicalSentenceParserGrammarParser.MathFunctionDecisionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mathFunctionDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 */
	void exitMathFunctionDecisionExpression(MathematicalSentenceParserGrammarParser.MathFunctionDecisionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eulerConstant}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 */
	void enterEulerConstant(MathematicalSentenceParserGrammarParser.EulerConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eulerConstant}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 */
	void exitEulerConstant(MathematicalSentenceParserGrammarParser.EulerConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code piConstant}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 */
	void enterPiConstant(MathematicalSentenceParserGrammarParser.PiConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code piConstant}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 */
	void exitPiConstant(MathematicalSentenceParserGrammarParser.PiConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code summationVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 */
	void enterSummationVariable(MathematicalSentenceParserGrammarParser.SummationVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code summationVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 */
	void exitSummationVariable(MathematicalSentenceParserGrammarParser.SummationVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code productSequenceVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 */
	void enterProductSequenceVariable(MathematicalSentenceParserGrammarParser.ProductSequenceVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code productSequenceVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 */
	void exitProductSequenceVariable(MathematicalSentenceParserGrammarParser.ProductSequenceVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numericConstant}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 */
	void enterNumericConstant(MathematicalSentenceParserGrammarParser.NumericConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numericConstant}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 */
	void exitNumericConstant(MathematicalSentenceParserGrammarParser.NumericConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numericFunctionResult}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 */
	void enterNumericFunctionResult(MathematicalSentenceParserGrammarParser.NumericFunctionResultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numericFunctionResult}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 */
	void exitNumericFunctionResult(MathematicalSentenceParserGrammarParser.NumericFunctionResultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numericVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 */
	void enterNumericVariable(MathematicalSentenceParserGrammarParser.NumericVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numericVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#numericEntity}.
	 * @param ctx the parse tree
	 */
	void exitNumericVariable(MathematicalSentenceParserGrammarParser.NumericVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#stringEntity}.
	 * @param ctx the parse tree
	 */
	void enterStringDecisionExpression(MathematicalSentenceParserGrammarParser.StringDecisionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#stringEntity}.
	 * @param ctx the parse tree
	 */
	void exitStringDecisionExpression(MathematicalSentenceParserGrammarParser.StringDecisionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringFunctionDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#stringEntity}.
	 * @param ctx the parse tree
	 */
	void enterStringFunctionDecisionExpression(MathematicalSentenceParserGrammarParser.StringFunctionDecisionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringFunctionDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#stringEntity}.
	 * @param ctx the parse tree
	 */
	void exitStringFunctionDecisionExpression(MathematicalSentenceParserGrammarParser.StringFunctionDecisionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringConstant}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#stringEntity}.
	 * @param ctx the parse tree
	 */
	void enterStringConstant(MathematicalSentenceParserGrammarParser.StringConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringConstant}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#stringEntity}.
	 * @param ctx the parse tree
	 */
	void exitStringConstant(MathematicalSentenceParserGrammarParser.StringConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringFunctionResult}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#stringEntity}.
	 * @param ctx the parse tree
	 */
	void enterStringFunctionResult(MathematicalSentenceParserGrammarParser.StringFunctionResultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringFunctionResult}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#stringEntity}.
	 * @param ctx the parse tree
	 */
	void exitStringFunctionResult(MathematicalSentenceParserGrammarParser.StringFunctionResultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#stringEntity}.
	 * @param ctx the parse tree
	 */
	void enterStringVariable(MathematicalSentenceParserGrammarParser.StringVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#stringEntity}.
	 * @param ctx the parse tree
	 */
	void exitStringVariable(MathematicalSentenceParserGrammarParser.StringVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dateDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateEntity}.
	 * @param ctx the parse tree
	 */
	void enterDateDecisionExpression(MathematicalSentenceParserGrammarParser.DateDecisionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dateDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateEntity}.
	 * @param ctx the parse tree
	 */
	void exitDateDecisionExpression(MathematicalSentenceParserGrammarParser.DateDecisionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dateFunctionDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateEntity}.
	 * @param ctx the parse tree
	 */
	void enterDateFunctionDecisionExpression(MathematicalSentenceParserGrammarParser.DateFunctionDecisionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dateFunctionDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateEntity}.
	 * @param ctx the parse tree
	 */
	void exitDateFunctionDecisionExpression(MathematicalSentenceParserGrammarParser.DateFunctionDecisionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dateConstant}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateEntity}.
	 * @param ctx the parse tree
	 */
	void enterDateConstant(MathematicalSentenceParserGrammarParser.DateConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dateConstant}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateEntity}.
	 * @param ctx the parse tree
	 */
	void exitDateConstant(MathematicalSentenceParserGrammarParser.DateConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dateCurrentValue}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateEntity}.
	 * @param ctx the parse tree
	 */
	void enterDateCurrentValue(MathematicalSentenceParserGrammarParser.DateCurrentValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dateCurrentValue}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateEntity}.
	 * @param ctx the parse tree
	 */
	void exitDateCurrentValue(MathematicalSentenceParserGrammarParser.DateCurrentValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dateVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateEntity}.
	 * @param ctx the parse tree
	 */
	void enterDateVariable(MathematicalSentenceParserGrammarParser.DateVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dateVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateEntity}.
	 * @param ctx the parse tree
	 */
	void exitDateVariable(MathematicalSentenceParserGrammarParser.DateVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dateFunctionResult}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateEntity}.
	 * @param ctx the parse tree
	 */
	void enterDateFunctionResult(MathematicalSentenceParserGrammarParser.DateFunctionResultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dateFunctionResult}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateEntity}.
	 * @param ctx the parse tree
	 */
	void exitDateFunctionResult(MathematicalSentenceParserGrammarParser.DateFunctionResultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code timeDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#timeEntity}.
	 * @param ctx the parse tree
	 */
	void enterTimeDecisionExpression(MathematicalSentenceParserGrammarParser.TimeDecisionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code timeDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#timeEntity}.
	 * @param ctx the parse tree
	 */
	void exitTimeDecisionExpression(MathematicalSentenceParserGrammarParser.TimeDecisionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code timeFunctionDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#timeEntity}.
	 * @param ctx the parse tree
	 */
	void enterTimeFunctionDecisionExpression(MathematicalSentenceParserGrammarParser.TimeFunctionDecisionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code timeFunctionDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#timeEntity}.
	 * @param ctx the parse tree
	 */
	void exitTimeFunctionDecisionExpression(MathematicalSentenceParserGrammarParser.TimeFunctionDecisionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code timeConstant}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#timeEntity}.
	 * @param ctx the parse tree
	 */
	void enterTimeConstant(MathematicalSentenceParserGrammarParser.TimeConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code timeConstant}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#timeEntity}.
	 * @param ctx the parse tree
	 */
	void exitTimeConstant(MathematicalSentenceParserGrammarParser.TimeConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code timeCurrentValue}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#timeEntity}.
	 * @param ctx the parse tree
	 */
	void enterTimeCurrentValue(MathematicalSentenceParserGrammarParser.TimeCurrentValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code timeCurrentValue}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#timeEntity}.
	 * @param ctx the parse tree
	 */
	void exitTimeCurrentValue(MathematicalSentenceParserGrammarParser.TimeCurrentValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code timeVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#timeEntity}.
	 * @param ctx the parse tree
	 */
	void enterTimeVariable(MathematicalSentenceParserGrammarParser.TimeVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code timeVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#timeEntity}.
	 * @param ctx the parse tree
	 */
	void exitTimeVariable(MathematicalSentenceParserGrammarParser.TimeVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code timeFunctionResult}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#timeEntity}.
	 * @param ctx the parse tree
	 */
	void enterTimeFunctionResult(MathematicalSentenceParserGrammarParser.TimeFunctionResultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code timeFunctionResult}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#timeEntity}.
	 * @param ctx the parse tree
	 */
	void exitTimeFunctionResult(MathematicalSentenceParserGrammarParser.TimeFunctionResultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dateTimeDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateTimeEntity}.
	 * @param ctx the parse tree
	 */
	void enterDateTimeDecisionExpression(MathematicalSentenceParserGrammarParser.DateTimeDecisionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dateTimeDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateTimeEntity}.
	 * @param ctx the parse tree
	 */
	void exitDateTimeDecisionExpression(MathematicalSentenceParserGrammarParser.DateTimeDecisionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dateTimeFunctionDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateTimeEntity}.
	 * @param ctx the parse tree
	 */
	void enterDateTimeFunctionDecisionExpression(MathematicalSentenceParserGrammarParser.DateTimeFunctionDecisionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dateTimeFunctionDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateTimeEntity}.
	 * @param ctx the parse tree
	 */
	void exitDateTimeFunctionDecisionExpression(MathematicalSentenceParserGrammarParser.DateTimeFunctionDecisionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dateTimeConstant}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateTimeEntity}.
	 * @param ctx the parse tree
	 */
	void enterDateTimeConstant(MathematicalSentenceParserGrammarParser.DateTimeConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dateTimeConstant}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateTimeEntity}.
	 * @param ctx the parse tree
	 */
	void exitDateTimeConstant(MathematicalSentenceParserGrammarParser.DateTimeConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dateTimeCurrentValue}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateTimeEntity}.
	 * @param ctx the parse tree
	 */
	void enterDateTimeCurrentValue(MathematicalSentenceParserGrammarParser.DateTimeCurrentValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dateTimeCurrentValue}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateTimeEntity}.
	 * @param ctx the parse tree
	 */
	void exitDateTimeCurrentValue(MathematicalSentenceParserGrammarParser.DateTimeCurrentValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dateTimeVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateTimeEntity}.
	 * @param ctx the parse tree
	 */
	void enterDateTimeVariable(MathematicalSentenceParserGrammarParser.DateTimeVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dateTimeVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateTimeEntity}.
	 * @param ctx the parse tree
	 */
	void exitDateTimeVariable(MathematicalSentenceParserGrammarParser.DateTimeVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dateTimeFunctionResult}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateTimeEntity}.
	 * @param ctx the parse tree
	 */
	void enterDateTimeFunctionResult(MathematicalSentenceParserGrammarParser.DateTimeFunctionResultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dateTimeFunctionResult}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#dateTimeEntity}.
	 * @param ctx the parse tree
	 */
	void exitDateTimeFunctionResult(MathematicalSentenceParserGrammarParser.DateTimeFunctionResultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vectorDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 */
	void enterVectorDecisionExpression(MathematicalSentenceParserGrammarParser.VectorDecisionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vectorDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 */
	void exitVectorDecisionExpression(MathematicalSentenceParserGrammarParser.VectorDecisionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vectorFunctionDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 */
	void enterVectorFunctionDecisionExpression(MathematicalSentenceParserGrammarParser.VectorFunctionDecisionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vectorFunctionDecisionExpression}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 */
	void exitVectorFunctionDecisionExpression(MathematicalSentenceParserGrammarParser.VectorFunctionDecisionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vectorOfNumbers}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 */
	void enterVectorOfNumbers(MathematicalSentenceParserGrammarParser.VectorOfNumbersContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vectorOfNumbers}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 */
	void exitVectorOfNumbers(MathematicalSentenceParserGrammarParser.VectorOfNumbersContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vectorOfBooleans}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 */
	void enterVectorOfBooleans(MathematicalSentenceParserGrammarParser.VectorOfBooleansContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vectorOfBooleans}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 */
	void exitVectorOfBooleans(MathematicalSentenceParserGrammarParser.VectorOfBooleansContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vectorOfStrings}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 */
	void enterVectorOfStrings(MathematicalSentenceParserGrammarParser.VectorOfStringsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vectorOfStrings}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 */
	void exitVectorOfStrings(MathematicalSentenceParserGrammarParser.VectorOfStringsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vectorOfDates}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 */
	void enterVectorOfDates(MathematicalSentenceParserGrammarParser.VectorOfDatesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vectorOfDates}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 */
	void exitVectorOfDates(MathematicalSentenceParserGrammarParser.VectorOfDatesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vectorOfTimes}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 */
	void enterVectorOfTimes(MathematicalSentenceParserGrammarParser.VectorOfTimesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vectorOfTimes}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 */
	void exitVectorOfTimes(MathematicalSentenceParserGrammarParser.VectorOfTimesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vectorOfDateTimes}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 */
	void enterVectorOfDateTimes(MathematicalSentenceParserGrammarParser.VectorOfDateTimesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vectorOfDateTimes}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 */
	void exitVectorOfDateTimes(MathematicalSentenceParserGrammarParser.VectorOfDateTimesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vectorOfVariables}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 */
	void enterVectorOfVariables(MathematicalSentenceParserGrammarParser.VectorOfVariablesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vectorOfVariables}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 */
	void exitVectorOfVariables(MathematicalSentenceParserGrammarParser.VectorOfVariablesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vectorOfFunctionResult}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 */
	void enterVectorOfFunctionResult(MathematicalSentenceParserGrammarParser.VectorOfFunctionResultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vectorOfFunctionResult}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 */
	void exitVectorOfFunctionResult(MathematicalSentenceParserGrammarParser.VectorOfFunctionResultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vectorFromFunction}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 */
	void enterVectorFromFunction(MathematicalSentenceParserGrammarParser.VectorFromFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vectorFromFunction}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 */
	void exitVectorFromFunction(MathematicalSentenceParserGrammarParser.VectorFromFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vectorVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 */
	void enterVectorVariable(MathematicalSentenceParserGrammarParser.VectorVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vectorVariable}
	 * labeled alternative in {@link MathematicalSentenceParserGrammarParser#vectorEntity}.
	 * @param ctx the parse tree
	 */
	void exitVectorVariable(MathematicalSentenceParserGrammarParser.VectorVariableContext ctx);
}