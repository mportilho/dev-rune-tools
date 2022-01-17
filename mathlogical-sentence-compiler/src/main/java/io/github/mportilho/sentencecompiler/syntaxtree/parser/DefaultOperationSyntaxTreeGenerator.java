/*MIT License

Copyright (c) 2021 Marcelo Portilho

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.*/

package io.github.mportilho.sentencecompiler.syntaxtree.parser;

import io.github.mportilho.sentencecompiler.grammar.MathematicalSentenceParserGrammarBaseVisitor;
import io.github.mportilho.sentencecompiler.grammar.MathematicalSentenceParserGrammarLexer;
import io.github.mportilho.sentencecompiler.grammar.MathematicalSentenceParserGrammarParser.*;
import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.BaseOperation;
import io.github.mportilho.sentencecompiler.operation.datetime.*;
import io.github.mportilho.sentencecompiler.operation.logic.*;
import io.github.mportilho.sentencecompiler.operation.other.AssignedVariableOperation;
import io.github.mportilho.sentencecompiler.operation.other.DecisionOperation;
import io.github.mportilho.sentencecompiler.operation.other.FunctionOperation;
import io.github.mportilho.sentencecompiler.operation.precise.math.*;
import io.github.mportilho.sentencecompiler.operation.precise.math.PreciseNumberRoundingOperation.RoundingEnum;
import io.github.mportilho.sentencecompiler.operation.precise.math.logarithm.BinaryLogarithmOperation;
import io.github.mportilho.sentencecompiler.operation.precise.math.logarithm.CommonLogarithmOperation;
import io.github.mportilho.sentencecompiler.operation.precise.math.logarithm.LogarithmOperation;
import io.github.mportilho.sentencecompiler.operation.precise.math.logarithm.NaturalLogarithmOperation;
import io.github.mportilho.sentencecompiler.operation.precise.math.trigonometry.*;
import io.github.mportilho.sentencecompiler.operation.value.constant.*;
import io.github.mportilho.sentencecompiler.operation.value.variable.AbstractVariableValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.variable.SequenceVariableValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.variable.VariableValueOperation;
import io.github.mportilho.sentencecompiler.syntaxtree.SyntaxTreeData;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

import static io.github.mportilho.sentencecompiler.grammar.MathematicalSentenceParserGrammarLexer.MINUS_DAYS;
import static io.github.mportilho.sentencecompiler.grammar.MathematicalSentenceParserGrammarLexer.PLUS_DAYS;
import static io.github.mportilho.sentencecompiler.grammar.MathematicalSentenceParserGrammarLexer.PLUS_MONTHS;
import static io.github.mportilho.sentencecompiler.grammar.MathematicalSentenceParserGrammarLexer.PLUS_YEARS;
import static io.github.mportilho.sentencecompiler.grammar.MathematicalSentenceParserGrammarLexer.VOCABULARY;
import static java.util.Objects.nonNull;

public class DefaultOperationSyntaxTreeGenerator extends MathematicalSentenceParserGrammarBaseVisitor<AbstractOperation>
        implements OperationSyntaxTreeGenerator {

    //    private final OperationSyntaxTreeContext parserContext;
    private final Map<String, AbstractVariableValueOperation> userVariables;
    private final Map<String, AssignedVariableOperation> assignedVariables;
    private Stack<List<SequenceVariableValueOperation>> sequenceVariableStack;

    public DefaultOperationSyntaxTreeGenerator() {
        this.userVariables = new HashMap<>();
        this.assignedVariables = new HashMap<>();
    }

    @Override
    public SyntaxTreeData createOperationSyntaxTree(StartContext startContext) {
        return new SyntaxTreeData(visit(startContext), userVariables, assignedVariables);
    }

    @Override
    public AbstractOperation visitErrorNode(ErrorNode node) {
        return super.visitErrorNode(node);
    }

    @Override
    public AbstractOperation visitMathStart(MathStartContext ctx) {
        for (AssignmentExpressionContext expressionContext : ctx.assignmentExpression()) {
            AssignedVariableOperation operator = (AssignedVariableOperation) expressionContext.accept(this);
            assignedVariables.put(operator.getVariableName(), operator);
        }
        AbstractOperation mathOperation = ctx.mathExpression() != null ? ctx.mathExpression().accept(this) : null;
        return new BaseOperation(mathOperation, assignedVariables).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitLogicalStart(LogicalStartContext ctx) {
        for (AssignmentExpressionContext expressionContext : ctx.assignmentExpression()) {
            AssignedVariableOperation operator = (AssignedVariableOperation) expressionContext.accept(this);
            assignedVariables.put(operator.getVariableName(), operator);
        }
        AbstractOperation logicalOperation = ctx.logicalExpression() != null ? ctx.logicalExpression().accept(this) : null;
        return new BaseOperation(logicalOperation, assignedVariables).expectedType(Boolean.class);
    }

    @Override
    public AbstractOperation visitAssignOperation(AssignOperationContext ctx) {
        AbstractOperation abstractOperation = ctx.allEntityTypes().accept(this);
        return new AssignedVariableOperation(ctx.IDENTIFIER().getText(), abstractOperation)
                .expectedType(abstractOperation.getExpectedType());
    }

    @Override
    public AbstractOperation visitDateTimeExpression(DateTimeExpressionContext ctx) {
        if (nonNull(ctx.comparisonOperator().GT())) {
            return new GreaterOperation(ctx.dateTimeOperation(0).accept(this), ctx.dateTimeOperation(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.comparisonOperator().GE())) {
            return new GreaterOrEqualsOperation(ctx.dateTimeOperation(0).accept(this), ctx.dateTimeOperation(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.comparisonOperator().LT())) {
            return new LessOperation(ctx.dateTimeOperation(0).accept(this), ctx.dateTimeOperation(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.comparisonOperator().LE())) {
            return new LessOrEqualsOperation(ctx.dateTimeOperation(0).accept(this), ctx.dateTimeOperation(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.comparisonOperator().EQ())) {
            return new EqualsOperation(ctx.dateTimeOperation(0).accept(this), ctx.dateTimeOperation(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.comparisonOperator().NEQ())) {
            return new NotEqualsOperation(ctx.dateTimeOperation(0).accept(this), ctx.dateTimeOperation(1).accept(this)).expectedType(Boolean.class);
        }
        throw new IllegalStateException(String.format("Operation %s not implemented", ctx.getText()));
    }

    @Override
    public AbstractOperation visitStringExpression(StringExpressionContext ctx) {
        if (nonNull(ctx.comparisonOperator().GT())) {
            return new GreaterOperation(ctx.stringEntity(0).accept(this), ctx.stringEntity(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.comparisonOperator().GE())) {
            return new GreaterOrEqualsOperation(ctx.stringEntity(0).accept(this), ctx.stringEntity(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.comparisonOperator().LT())) {
            return new LessOperation(ctx.stringEntity(0).accept(this), ctx.stringEntity(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.comparisonOperator().LE())) {
            return new LessOrEqualsOperation(ctx.stringEntity(0).accept(this), ctx.stringEntity(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.comparisonOperator().EQ())) {
            return new EqualsOperation(ctx.stringEntity(0).accept(this), ctx.stringEntity(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.comparisonOperator().NEQ())) {
            return new NotEqualsOperation(ctx.stringEntity(0).accept(this), ctx.stringEntity(1).accept(this)).expectedType(Boolean.class);
        }
        throw new IllegalStateException(String.format("Operação não implementada: %s", ctx.getText()));
    }

    @Override
    public AbstractOperation visitLogicExpression(LogicExpressionContext ctx) {
        if (nonNull(ctx.logicalOperator().AND())) {
            return new AndOperation(ctx.logicalExpression(0).accept(this), ctx.logicalExpression(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.logicalOperator().OR())) {
            return new OrOperation(ctx.logicalExpression(0).accept(this), ctx.logicalExpression(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.logicalOperator().XOR())) {
            return new XorOperation(ctx.logicalExpression(0).accept(this), ctx.logicalExpression(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.logicalOperator().XNOR())) {
            return new XnorOperation(ctx.logicalExpression(0).accept(this), ctx.logicalExpression(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.logicalOperator().NOR())) {
            return new NorOperation(ctx.logicalExpression(0).accept(this), ctx.logicalExpression(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.logicalOperator().NAND())) {
            return new NandOperation(ctx.logicalExpression(0).accept(this), ctx.logicalExpression(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.logicalOperator().EQ())) {
            return new EqualsOperation(ctx.logicalExpression(0).accept(this), ctx.logicalExpression(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.logicalOperator().NEQ())) {
            return new NotEqualsOperation(ctx.logicalExpression(0).accept(this), ctx.logicalExpression(1).accept(this)).expectedType(Boolean.class);
        }
        throw new IllegalStateException(String.format("Operation %s not implemented", ctx.getText()));
    }

    @Override
    public AbstractOperation visitDateExpression(DateExpressionContext ctx) {
        if (nonNull(ctx.comparisonOperator().GT())) {
            return new GreaterOperation(ctx.dateOperation(0).accept(this), ctx.dateOperation(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.comparisonOperator().GE())) {
            return new GreaterOrEqualsOperation(ctx.dateOperation(0).accept(this), ctx.dateOperation(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.comparisonOperator().LT())) {
            return new LessOperation(ctx.dateOperation(0).accept(this), ctx.dateOperation(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.comparisonOperator().LE())) {
            return new LessOrEqualsOperation(ctx.dateOperation(0).accept(this), ctx.dateOperation(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.comparisonOperator().EQ())) {
            return new EqualsOperation(ctx.dateOperation(0).accept(this), ctx.dateOperation(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.comparisonOperator().NEQ())) {
            return new NotEqualsOperation(ctx.dateOperation(0).accept(this), ctx.dateOperation(1).accept(this)).expectedType(Boolean.class);
        }
        throw new IllegalStateException(String.format("Operation %s not implemented", ctx.getText()));
    }

    @Override
    public AbstractOperation visitNotExpression(NotExpressionContext ctx) {
        return new NegationOperation(ctx.logicalExpression().accept(this)).expectedType(Boolean.class);
    }

    @Override
    public AbstractOperation visitComparisonMathExpression(ComparisonMathExpressionContext ctx) {
        if (nonNull(ctx.comparisonOperator().GT())) {
            return new GreaterOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.comparisonOperator().GE())) {
            return new GreaterOrEqualsOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.comparisonOperator().LT())) {
            return new LessOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.comparisonOperator().LE())) {
            return new LessOrEqualsOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.comparisonOperator().EQ())) {
            return new EqualsOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.comparisonOperator().NEQ())) {
            return new NotEqualsOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this)).expectedType(Boolean.class);
        }
        throw new IllegalStateException(String.format("Operation %s not implemented", ctx.getText()));
    }

    @Override
    public AbstractOperation visitTimeExpression(TimeExpressionContext ctx) {
        if (nonNull(ctx.comparisonOperator().GT())) {
            return new GreaterOperation(ctx.timeOperation(0).accept(this), ctx.timeOperation(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.comparisonOperator().GE())) {
            return new GreaterOrEqualsOperation(ctx.timeOperation(0).accept(this), ctx.timeOperation(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.comparisonOperator().LT())) {
            return new LessOperation(ctx.timeOperation(0).accept(this), ctx.timeOperation(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.comparisonOperator().LE())) {
            return new LessOrEqualsOperation(ctx.timeOperation(0).accept(this), ctx.timeOperation(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.comparisonOperator().EQ())) {
            return new EqualsOperation(ctx.timeOperation(0).accept(this), ctx.timeOperation(1).accept(this)).expectedType(Boolean.class);
        } else if (nonNull(ctx.comparisonOperator().NEQ())) {
            return new NotEqualsOperation(ctx.timeOperation(0).accept(this), ctx.timeOperation(1).accept(this)).expectedType(Boolean.class);
        }
        throw new IllegalStateException(String.format("Operation %s not implemented", ctx.getText()));
    }

    @Override
    public AbstractOperation visitLogicalParenthesis(LogicalParenthesisContext ctx) {
        AbstractOperation operation = ctx.logicalExpression().accept(this);
        operation.applyingParenthesis();
        return operation.expectedType(Boolean.class);
    }

    @Override
    public AbstractOperation visitInverseHyperbolicSineExpression(InverseHyperbolicSineExpressionContext ctx) {
        return new InverseHyperbolicSineOperation(ctx.mathExpression().accept(this)).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitSequenceExpression(SequenceExpressionContext ctx) {
        if (sequenceVariableStack == null) {
            sequenceVariableStack = new Stack<>();
        }
        return super.visitSequenceExpression(ctx).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitHyperbolicSineExpression(HyperbolicSineExpressionContext ctx) {
        return new HyperbolicSineOperation(ctx.mathExpression().accept(this)).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitInverseHyperbolicCosineExpression(InverseHyperbolicCosineExpressionContext ctx) {
        return new InverseHyperbolicCosineOperation(ctx.mathExpression().accept(this)).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitModulusExpression(ModulusExpressionContext ctx) {
        return new PreciseModulusOperation(ctx.mathExpression().accept(this)).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitMathParenthesis(MathParenthesisContext ctx) {
        AbstractOperation operation = ctx.mathExpression().accept(this);
        operation.applyingParenthesis();
        return operation.expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitTangentExpression(TangentExpressionContext ctx) {
        return new TangentOperation(ctx.mathExpression().accept(this)).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitArctangent2Expression(Arctangent2ExpressionContext ctx) {
        return new Arctangent2Operation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this)).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitSquareRootExpression(SquareRootExpressionContext ctx) {
        return new PreciseSquareRootOperation(ctx.mathExpression().accept(this)).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitRootExpression(RootExpressionContext ctx) {
        return new PreciseRootOperation(ctx.mathExpression(1).accept(this), ctx.mathExpression(0).accept(this)).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitHyperbolicTangentExpression(HyperbolicTangentExpressionContext ctx) {
        return new HyperbolicTangentOperation(ctx.mathExpression().accept(this)).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitHyperbolicCosineExpression(HyperbolicCosineExpressionContext ctx) {
        return new HyperbolicCosineOperation(ctx.mathExpression().accept(this)).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitImplicitMultiplicationExpression(ImplicitMultiplicationExpressionContext ctx) {
        AbstractOperation leftOperation = ctx.mathExpression(0).accept(this);
        AbstractOperation rightOperation = ctx.mathExpression(1).accept(this);

        if (rightOperation instanceof PreciseNegativeOperation) {
            ((PreciseNegativeOperation) rightOperation).negatingValue(false);
            return new PreciseSubtractionOperation(leftOperation, rightOperation).expectedType(BigDecimal.class);
        } else if ((rightOperation instanceof PreciseNumberConstantValueOperation
                && ((PreciseNumberConstantValueOperation) rightOperation).getValue().startsWith("-"))) {
            ((PreciseNumberConstantValueOperation) rightOperation).transformToPositiveValue();
            return new PreciseSubtractionOperation(leftOperation, rightOperation).expectedType(BigDecimal.class);
        }
        return new PreciseMultiplicationOperation(leftOperation, rightOperation, true).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitMultiplicationExpression(MultiplicationExpressionContext ctx) {
        if (ctx.MULT() != null) {
            return new PreciseMultiplicationOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this)).expectedType(BigDecimal.class);
        } else if (nonNull(ctx.DIV())) {
            return new PreciseDivisionOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this)).expectedType(BigDecimal.class);
        } else if (nonNull(ctx.MODULO())) {
            return new PreciseModuloOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this)).expectedType(BigDecimal.class);
        }
        throw new IllegalStateException(String.format("Operation %s not implemented", ctx.getText()));
    }

    @Override
    public AbstractOperation visitFactorialExpression(FactorialExpressionContext ctx) {
        return new PreciseFactorialOperation(ctx.mathExpression().accept(this)).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitNegateMathParenthesis(NegateMathParenthesisContext ctx) {
        AbstractOperation operation = ctx.mathExpression().accept(this);
        operation.applyingParenthesis();
        return new PreciseNegativeOperation(operation).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitPercentExpression(PercentExpressionContext ctx) {
        return new PrecisePercentualOperation(ctx.mathExpression().accept(this)).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitSineExpression(SineExpressionContext ctx) {
        return new SineOperation(ctx.mathExpression().accept(this)).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitCosineExpression(CosineExpressionContext ctx) {
        return new CosineOperation(ctx.mathExpression().accept(this)).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitArctangentExpression(ArctangentExpressionContext ctx) {
        return new ArctangentOperation(ctx.mathExpression().accept(this)).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitSumExpression(SumExpressionContext ctx) {
        if (ctx.PLUS() != null) {
            return new PreciseAdditionOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this)).expectedType(BigDecimal.class);
        } else if (nonNull(ctx.MINUS())) {
            return new PreciseSubtractionOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this)).expectedType(BigDecimal.class);
        }
        throw new IllegalStateException(String.format("Operation %s not implemented", ctx.getText()));
    }

    @Override
    public AbstractOperation visitInverseHyperbolicTangentExpression(InverseHyperbolicTangentExpressionContext ctx) {
        return new InverseHyperbolicTangentOperation(ctx.mathExpression().accept(this)).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitDegreeExpression(DegreeExpressionContext ctx) {
        return new DeggreOperation(ctx.mathExpression().accept(this)).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitExponentiationExpression(ExponentiationExpressionContext ctx) {
        return new PreciseExponentialOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this)).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitArccosineExpression(ArccosineExpressionContext ctx) {
        return new ArccosineOperation(ctx.mathExpression().accept(this)).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitArcsineExpression(ArcsineExpressionContext ctx) {
        return new ArcsineOperation(ctx.mathExpression().accept(this)).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitFixedLogarithm(FixedLogarithmContext ctx) {
        if (nonNull(ctx.BINARY_LOGARITHM())) {
            return new BinaryLogarithmOperation(ctx.mathExpression().accept(this)).expectedType(BigDecimal.class);
        } else if (nonNull(ctx.COMMOM_LOGARITHM())) {
            return new CommonLogarithmOperation(ctx.mathExpression().accept(this)).expectedType(BigDecimal.class);
        } else if (nonNull(ctx.NATURAL_LOGARITHM())) {
            return new NaturalLogarithmOperation(ctx.mathExpression().accept(this)).expectedType(BigDecimal.class);
        }
        throw new IllegalStateException(String.format("Operation %s not implemented", ctx.getText()));
    }

    @Override
    public AbstractOperation visitVariableLogarithm(VariableLogarithmContext ctx) {
        return new LogarithmOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this)).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitRoundingFunction(RoundingFunctionContext ctx) {
        if (ctx.R_HALF_EVEN() != null) {
            return new PreciseNumberRoundingOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this), RoundingEnum.HALF_EVEN).expectedType(BigDecimal.class);
        } else if (ctx.R_DOWN() != null) {
            return new PreciseNumberRoundingOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this), RoundingEnum.DOWN).expectedType(BigDecimal.class);
        } else if (ctx.R_CEILING() != null) {
            return new PreciseNumberRoundingOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this), RoundingEnum.CEILING).expectedType(BigDecimal.class);
        } else if (ctx.R_FLOOR() != null) {
            return new PreciseNumberRoundingOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this), RoundingEnum.FLOOR).expectedType(BigDecimal.class);
        } else if (ctx.R_HALF_UP() != null) {
            return new PreciseNumberRoundingOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this), RoundingEnum.HALF_UP).expectedType(BigDecimal.class);
        } else if (ctx.R_UP() != null) {
            return new PreciseNumberRoundingOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this), RoundingEnum.UP).expectedType(BigDecimal.class);
        } else if (ctx.R_HALF_DOWN() != null) {
            return new PreciseNumberRoundingOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this), RoundingEnum.HALF_DOWN).expectedType(BigDecimal.class);
        } else if (ctx.R_UNNECESSARY() != null) {
            return new PreciseNumberRoundingOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this), RoundingEnum.UNNECESSARY).expectedType(BigDecimal.class);
        } else {
            throw new IllegalStateException("No rounding method defined for operation " + ctx.getText());
        }
    }

    @Override
    public AbstractOperation visitSequenceFunction(SequenceFunctionContext ctx) {
        if (sequenceVariableStack == null) {
            sequenceVariableStack = new Stack<>();
        }
        sequenceVariableStack.add(new ArrayList<>());

        AbstractOperation startIndexOperation = ctx.mathExpression(0).accept(this);
        AbstractOperation endIndexOperation = ctx.mathExpression(1).accept(this);
        AbstractOperation mathExpression = ctx.mathExpression(2).accept(this);

        List<SequenceVariableValueOperation> sequenceVariableContainer = sequenceVariableStack.pop();
        SequenceVariableValueOperation sequenceVariable = sequenceVariableContainer.isEmpty() ? null : sequenceVariableContainer.get(0);
        if (ctx.SUMMATION() != null) {
            return new PreciseSummationOperation(startIndexOperation, endIndexOperation, mathExpression, sequenceVariable)
                    .expectedType(BigDecimal.class);
        } else if (ctx.PRODUCT_SEQUENCE() != null) {
            return new PreciseProductOfSequenceOperation(startIndexOperation, endIndexOperation, mathExpression, sequenceVariable)
                    .expectedType(BigDecimal.class);
        }
        throw new IllegalStateException(String.format("Operation %s not implemented", ctx.getText()));
    }

    @Override
    public AbstractOperation visitDateParenthesis(DateParenthesisContext ctx) {
        AbstractOperation operation = ctx.dateOperation().accept(this);
        operation.applyingParenthesis();
        return operation.expectedType(LocalDate.class);
    }

    @Override
    public AbstractOperation visitDateFunction(DateFunctionContext ctx) {
        AbstractOperation leftOperand = ctx.dateEntity().accept(this);
        int count = ctx.DATE_OPERATIONS().size();

        for (int i = 0; i < count; i++) { //@formatter:off
            String text = "'" + ctx.DATE_OPERATIONS(i).getSymbol().getText() + "'";
            if (VOCABULARY.getDisplayName(PLUS_DAYS).equals(text)) {
                leftOperand = new DateAdditionOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.DAY);
            } else if (VOCABULARY.getDisplayName(PLUS_MONTHS).equals(text)) {
                leftOperand = new DateAdditionOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.MONTH);
            } else if (VOCABULARY.getDisplayName(PLUS_YEARS).equals(text)) {
                leftOperand = new DateAdditionOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.YEAR);
            } else if (VOCABULARY.getDisplayName(MINUS_DAYS).equals(text)) {
                leftOperand = new DateSubtractionOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.DAY);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.MINUS_MONTHS).equals(text)) {
                leftOperand = new DateSubtractionOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.MONTH);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.MINUS_YEARS).equals(text)) {
                leftOperand = new DateSubtractionOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.YEAR);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.SET_DAYS).equals(text)) {
                leftOperand = new DateSetOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.DAY);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.SET_MONTHS).equals(text)) {
                leftOperand = new DateSetOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.MONTH);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.SET_YEARS).equals(text)) {
                leftOperand = new DateSetOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.YEAR);
            } else {
                throw new IllegalStateException(String.format("Operation %s not implemented", ctx.DATE_OPERATIONS(i).getText()));
            }//@formatter:on
        }
        return leftOperand.expectedType(LocalDate.class);
    }

    @Override
    public AbstractOperation visitTimeParenthesis(TimeParenthesisContext ctx) {
        AbstractOperation operation = ctx.timeOperation().accept(this);
        operation.applyingParenthesis();
        return operation.expectedType(LocalTime.class);
    }

    @Override
    public AbstractOperation visitTimeFunction(TimeFunctionContext ctx) {
        AbstractOperation leftOperand = ctx.timeEntity().accept(this);
        int count = ctx.TIME_OPERATIONS().size();

        for (int i = 0; i < count; i++) { //@formatter:off
            String text = "'" + ctx.TIME_OPERATIONS(i).getSymbol().getText() + "'";
            if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.PLUS_HOURS).equals(text)) {
                leftOperand = new TimeAdditionOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.HOUR);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.PLUS_MINUTES).equals(text)) {
                leftOperand = new TimeAdditionOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.MINUTE);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.PLUS_SECONDS).equals(text)) {
                leftOperand = new TimeAdditionOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.SECOND);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.MINUS_HOURS).equals(text)) {
                leftOperand = new TimeSubtractionOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.HOUR);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.MINUS_MINUTES).equals(text)) {
                leftOperand = new TimeSubtractionOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.MINUTE);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.MINUS_SECONDS).equals(text)) {
                leftOperand = new TimeSubtractionOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.SECOND);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.SET_HOURS).equals(text)) {
                leftOperand = new TimeSetOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.HOUR);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.SET_MINUTES).equals(text)) {
                leftOperand = new TimeSetOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.MINUTE);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.SET_SECONDS).equals(text)) {
                leftOperand = new TimeSetOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.SECOND);
            } else {
                throw new IllegalStateException(String.format("Operation %s not implemented", ctx.TIME_OPERATIONS(i).getText()));
            }
        }//@formatter:on
        return leftOperand.expectedType(LocalTime.class);
    }

    @Override
    public AbstractOperation visitDateTimeParenthesis(DateTimeParenthesisContext ctx) {
        AbstractOperation operation = ctx.dateTimeOperation().accept(this);
        operation.applyingParenthesis();
        return operation.expectedType(LocalDateTime.class);
    }

    @Override
    public AbstractOperation visitDateTimeFunction(DateTimeFunctionContext ctx) {
        AbstractOperation leftOperand = ctx.dateTimeEntity().accept(this);//@formatter:off
        int count = ctx.DATE_OPERATIONS().size() + ctx.TIME_OPERATIONS().size();

        for (int i = 0; i < count; i++) {
            String text = "'" + ctx.getChild(1 + (2 * i)).getText() + "'";
            if (VOCABULARY.getDisplayName(PLUS_DAYS).equals(text)) {
                leftOperand = new DateTimeAdditionOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.DAY);
            } else if (VOCABULARY.getDisplayName(PLUS_MONTHS).equals(text)) {
                leftOperand = new DateTimeAdditionOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.MONTH);
            } else if (VOCABULARY.getDisplayName(PLUS_YEARS).equals(text)) {
                leftOperand = new DateTimeAdditionOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.YEAR);
            } else if (VOCABULARY.getDisplayName(MINUS_DAYS).equals(text)) {
                leftOperand = new DateTimeSubtractionOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.DAY);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.MINUS_MONTHS).equals(text)) {
                leftOperand = new DateTimeSubtractionOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.MONTH);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.MINUS_YEARS).equals(text)) {
                leftOperand = new DateTimeSubtractionOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.YEAR);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.SET_DAYS).equals(text)) {
                leftOperand = new DateTimeSetOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.DAY);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.SET_MONTHS).equals(text)) {
                leftOperand = new DateTimeSetOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.MONTH);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.SET_YEARS).equals(text)) {
                leftOperand = new DateTimeSetOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.YEAR);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.PLUS_HOURS).equals(text)) {
                leftOperand = new DateTimeAdditionOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.HOUR);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.PLUS_MINUTES).equals(text)) {
                leftOperand = new DateTimeAdditionOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.MINUTE);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.PLUS_SECONDS).equals(text)) {
                leftOperand = new DateTimeAdditionOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.SECOND);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.MINUS_HOURS).equals(text)) {
                leftOperand = new DateTimeSubtractionOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.HOUR);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.MINUS_MINUTES).equals(text)) {
                leftOperand = new DateTimeSubtractionOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.MINUTE);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.MINUS_SECONDS).equals(text)) {
                leftOperand = new DateTimeSubtractionOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.SECOND);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.SET_HOURS).equals(text)) {
                leftOperand = new DateTimeSetOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.HOUR);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.SET_MINUTES).equals(text)) {
                leftOperand = new DateTimeSetOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.MINUTE);
            } else if (VOCABULARY.getDisplayName(MathematicalSentenceParserGrammarLexer.SET_SECONDS).equals(text)) {
                leftOperand = new DateTimeSetOperation(leftOperand, ctx.mathExpression(i).accept(this), DateElementEnum.SECOND);
            } else {
                throw new IllegalStateException(String.format("Operation %s not implemented", ctx.DATE_OPERATIONS(i).getText()));
            }//@formatter:on
        }
        return leftOperand.expectedType(LocalDateTime.class);
    }

    @Override
    public AbstractOperation visitFunction(FunctionContext ctx) {
        List<AbstractOperation> parameters = new ArrayList<>();
        for (AllEntityTypesContext entityType : ctx.allEntityTypes()) {
            parameters.add(entityType.accept(this));
        }
        return new FunctionOperation(ctx.IDENTIFIER().getText(), parameters, ctx.NO_CACHE_FUNCTION_PREFIX() == null);
    }

    @Override
    public AbstractOperation visitLogicalConstant(LogicalConstantContext ctx) {
        return new BooleanConstantValueOperation(ctx.getText()).expectedType(Boolean.class);
    }

    @Override
    public AbstractOperation visitLogicalDecisionExpression(LogicalDecisionExpressionContext ctx) {
        List<AbstractOperation> operations = new ArrayList<>();
        List<LogicalExpressionContext> logicalExpressions = ctx.logicalExpression();

        for (int i = 0; i < logicalExpressions.size() - 1; i += 2) {
            operations.add(logicalExpressions.get(i).accept(this));
            operations.add(logicalExpressions.get(i + 1).accept(this));
        }
        operations.add(logicalExpressions.get(logicalExpressions.size() - 1).accept(this));
        return new DecisionOperation(operations).expectedType(Boolean.class);
    }

    @Override
    public AbstractOperation visitLogicalFunctionResult(LogicalFunctionResultContext ctx) {
        return ctx.function().accept(this).expectedType(Boolean.class);
    }

    @Override
    public AbstractOperation visitLogicalVariable(LogicalVariableContext ctx) {
        return createNewVariable(ctx, Boolean.class).expectedType(Boolean.class);
    }

    @Override
    public AbstractOperation visitMathDecisionExpression(MathDecisionExpressionContext ctx) {
        List<AbstractOperation> operations = new ArrayList<>();
        List<LogicalExpressionContext> logicalExpressions = ctx.logicalExpression();
        List<MathExpressionContext> mathExpressions = ctx.mathExpression();

        for (int i = 0; i < logicalExpressions.size(); i++) {
            operations.add(logicalExpressions.get(i).accept(this));
            operations.add(mathExpressions.get(i).accept(this));
        }
        operations.add(mathExpressions.get(mathExpressions.size() - 1).accept(this));
        return new DecisionOperation(operations).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitEulerConstant(EulerConstantContext ctx) {
        return new EulerNumberConstantValueOperation().expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitPiConstant(PiConstantContext ctx) {
        return new PiNumberConstantValueOperation().expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitSummationVariable(SummationVariableContext ctx) {
        if (sequenceVariableStack.peek().isEmpty()) {
            SequenceVariableValueOperation sequenceVariable = new SequenceVariableValueOperation("S");
            sequenceVariableStack.peek().add(sequenceVariable);
            return sequenceVariable;
        }
        return sequenceVariableStack.peek().get(0).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitProductSequenceVariable(ProductSequenceVariableContext ctx) {
        if (sequenceVariableStack.peek().isEmpty()) {
            SequenceVariableValueOperation sequenceVariable = new SequenceVariableValueOperation("P");
            sequenceVariableStack.peek().add(sequenceVariable);
            return sequenceVariable;
        }
        return sequenceVariableStack.peek().get(0).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitNumericConstant(NumericConstantContext ctx) {
        return new PreciseNumberConstantValueOperation(ctx.getText()).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitNumericFunctionResult(NumericFunctionResultContext ctx) {
        return ctx.function().accept(this).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitNumericVariable(NumericVariableContext ctx) {
        if (nonNull(ctx.IDENTIFIER())) {
            return createNewVariable(ctx, BigDecimal.class);
        } else if (nonNull(ctx.NEGATIVE_IDENTIFIER())) {
            return new PreciseNegativeOperation(createNewVariable(ctx,
                    name -> new VariableValueOperation(name, BigDecimal.class),
                    () -> ctx.getText().substring(1)));
        }
        throw new IllegalStateException("Invalid numeric operation: " + ctx.getText());
    }

    @Override
    public AbstractOperation visitStringDecisionExpression(StringDecisionExpressionContext ctx) {
        List<AbstractOperation> operations = new ArrayList<>();
        List<LogicalExpressionContext> logicalExpressions = ctx.logicalExpression();
        List<StringEntityContext> stringEntities = ctx.stringEntity();

        for (int i = 0; i < logicalExpressions.size(); i++) {
            operations.add(logicalExpressions.get(i).accept(this));
            operations.add(stringEntities.get(i).accept(this));
        }
        operations.add(stringEntities.get(stringEntities.size() - 1).accept(this));
        return new DecisionOperation(operations).expectedType(String.class);
    }

    @Override
    public AbstractOperation visitStringConstant(StringConstantContext ctx) {
        return new StringConstantValueOperation(ctx.getText().substring(1, ctx.getText().length() - 1)).expectedType(String.class);
    }

    @Override
    public AbstractOperation visitStringFunctionResult(StringFunctionResultContext ctx) {
        return ctx.function().accept(this).expectedType(String.class);
    }

    @Override
    public AbstractOperation visitStringVariable(StringVariableContext ctx) {
        return createNewVariable(ctx, String.class);
    }

    @Override
    public AbstractOperation visitDateDecisionExpression(DateDecisionExpressionContext ctx) {
        List<AbstractOperation> operations = new ArrayList<>();
        List<LogicalExpressionContext> logicalExpressions = ctx.logicalExpression();
        List<DateOperationContext> dateOperations = ctx.dateOperation();

        for (int i = 0; i < logicalExpressions.size(); i++) {
            operations.add(logicalExpressions.get(i).accept(this));
            operations.add(dateOperations.get(i).accept(this));
        }
        operations.add(dateOperations.get(dateOperations.size() - 1).accept(this));
        return new DecisionOperation(operations).expectedType(LocalDate.class);
    }

    @Override
    public AbstractOperation visitDateConstant(DateConstantContext ctx) {
        return new DateConstantValueOperation(ctx.getText()).expectedType(LocalDate.class);
    }

    @Override
    public AbstractOperation visitDateCurrentValue(DateCurrentValueContext ctx) {
        return new DateConstantValueOperation().expectedType(LocalDate.class);
    }

    @Override
    public AbstractOperation visitDateVariable(DateVariableContext ctx) {
        return createNewVariable(ctx, LocalDate.class).expectedType(LocalDate.class);
    }

    @Override
    public AbstractOperation visitDateFunctionResult(DateFunctionResultContext ctx) {
        return ctx.function().accept(this).expectedType(LocalDate.class);
    }

    @Override
    public AbstractOperation visitTimeDecisionExpression(TimeDecisionExpressionContext ctx) {
        List<AbstractOperation> operations = new ArrayList<>();
        List<LogicalExpressionContext> logicalExpressions = ctx.logicalExpression();
        List<TimeOperationContext> timeOperations = ctx.timeOperation();

        for (int i = 0; i < logicalExpressions.size(); i++) {
            operations.add(logicalExpressions.get(i).accept(this));
            operations.add(timeOperations.get(i).accept(this));
        }
        operations.add(timeOperations.get(timeOperations.size() - 1).accept(this));
        return new DecisionOperation(operations).expectedType(LocalTime.class);
    }

    @Override
    public AbstractOperation visitTimeConstant(TimeConstantContext ctx) {
        return new TimeConstantValueOperation(ctx.getText()).expectedType(LocalTime.class);
    }

    @Override
    public AbstractOperation visitTimeCurrentValue(TimeCurrentValueContext ctx) {
        return new TimeConstantValueOperation().expectedType(LocalTime.class);
    }

    @Override
    public AbstractOperation visitTimeVariable(TimeVariableContext ctx) {
        return createNewVariable(ctx, LocalTime.class);
    }

    @Override
    public AbstractOperation visitTimeFunctionResult(TimeFunctionResultContext ctx) {
        return ctx.function().accept(this).expectedType(LocalTime.class);
    }

    @Override
    public AbstractOperation visitDateTimeDecisionExpression(DateTimeDecisionExpressionContext ctx) {
        List<AbstractOperation> operations = new ArrayList<>();
        List<LogicalExpressionContext> logicalExpressions = ctx.logicalExpression();
        List<DateTimeOperationContext> dateTimeOperations = ctx.dateTimeOperation();

        for (int i = 0; i < logicalExpressions.size(); i++) {
            operations.add(logicalExpressions.get(i).accept(this));
            operations.add(dateTimeOperations.get(i).accept(this));
        }
        operations.add(dateTimeOperations.get(dateTimeOperations.size() - 1).accept(this));
        return new DecisionOperation(operations).expectedType(LocalDateTime.class);
    }

    @Override
    public AbstractOperation visitDateTimeConstant(DateTimeConstantContext ctx) {
        return new DateTimeConstantValueOperation(ctx.getText()).expectedType(LocalDateTime.class);
    }

    @Override
    public AbstractOperation visitDateTimeCurrentValue(DateTimeCurrentValueContext ctx) {
        return new DateTimeConstantValueOperation().expectedType(LocalDateTime.class);
    }

    @Override
    public AbstractOperation visitDateTimeVariable(DateTimeVariableContext ctx) {
        return createNewVariable(ctx, LocalDateTime.class);
    }

    @Override
    public AbstractOperation visitDateTimeFunctionResult(DateTimeFunctionResultContext ctx) {
        return ctx.function().accept(this).expectedType(LocalDateTime.class);
    }

    private AbstractOperation createNewVariable(ParserRuleContext context, Class<?> variableType) {
        return createNewVariable(context, name -> new VariableValueOperation(name, variableType), null);
    }

    private AbstractOperation createNewVariable(
            ParserRuleContext context, Function<String, AbstractVariableValueOperation> supplier,
            Supplier<String> nameSupplier) {
        String name;
        if (nameSupplier != null) {
            name = nameSupplier.get();
        } else {
            if (context.getChildCount() == 2) {
                name = context.getChild(1).getText();
            } else {
                name = context.getText();
            }
        }

        boolean containsAssignedVariable = assignedVariables.containsKey(name);
        boolean containsVariable = userVariables.containsKey(name);
        if (containsAssignedVariable && containsVariable) {
            throw new IllegalStateException(String.format("Duplicate variables named '%s' on current sentence", name));
        }

        if (containsAssignedVariable) {
            AssignedVariableOperation valueOperation = assignedVariables.get(name);
            if (valueOperation == null) {
                throw new IllegalStateException(
                        String.format("Assigned variable '%s' is not declared before the operation '%s'", name, context.getParent().getText()));
            }
            return valueOperation;
        } else {
            if (!userVariables.containsKey(name)) {
                userVariables.put(name, supplier.apply(name));
            }
            return userVariables.get(name);
        }
    }

}
