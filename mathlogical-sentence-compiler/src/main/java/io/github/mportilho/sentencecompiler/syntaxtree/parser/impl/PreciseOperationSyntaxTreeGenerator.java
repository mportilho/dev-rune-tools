/*******************************************************************************
 * MIT License
 *
 * Copyright (c) 2021-2022. Marcelo Silva Portilho
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/

package io.github.mportilho.sentencecompiler.syntaxtree.parser.impl;

import io.github.mportilho.sentencecompiler.grammar.MathematicalSentenceParserGrammarParser.*;
import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.math.precise.*;
import io.github.mportilho.sentencecompiler.operation.math.precise.PreciseNumberRoundingOperation.RoundingEnum;
import io.github.mportilho.sentencecompiler.operation.math.precise.logarithm.PreciseBinaryLogarithmOperation;
import io.github.mportilho.sentencecompiler.operation.math.precise.logarithm.PreciseCommonLogarithmOperation;
import io.github.mportilho.sentencecompiler.operation.math.precise.logarithm.PreciseLogarithmOperation;
import io.github.mportilho.sentencecompiler.operation.math.precise.logarithm.PreciseNaturalLogarithmOperation;
import io.github.mportilho.sentencecompiler.operation.other.DecisionOperation;
import io.github.mportilho.sentencecompiler.operation.value.constant.precise.PreciseEulerNumberConstantValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.constant.precise.PreciseNumberConstantValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.constant.precise.PrecisePiNumberConstantValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.variable.SequenceVariableValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.variable.VariableValueOperation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static java.util.Objects.nonNull;

public class PreciseOperationSyntaxTreeGenerator extends AbstractOperationSyntaxTreeGenerator {

    public PreciseOperationSyntaxTreeGenerator() {
        super();
    }

    @Override
    public AbstractOperation visitSequenceExpression(SequenceExpressionContext ctx) {
        if (sequenceVariableStack == null) {
            sequenceVariableStack = new Stack<>();
        }
        return super.visitSequenceExpression(ctx);
    }

    @Override
    public AbstractOperation visitModulusExpression(ModulusExpressionContext ctx) {
        return new PreciseModulusOperation(ctx.mathExpression().accept(this));
    }

    @Override
    public AbstractOperation visitMathParenthesis(MathParenthesisContext ctx) {
        AbstractOperation operation = ctx.mathExpression().accept(this);
        operation.applyingParenthesis();
        return operation;
    }

    @Override
    public AbstractOperation visitSquareRootExpression(SquareRootExpressionContext ctx) {
        return new PreciseSquareRootOperation(ctx.mathExpression().accept(this));
    }

    @Override
    public AbstractOperation visitRootExpression(RootExpressionContext ctx) {
        return new PreciseRootOperation(ctx.mathExpression(1).accept(this), ctx.mathExpression(0).accept(this));
    }

    @Override
    public AbstractOperation visitMultiplicationExpression(MultiplicationExpressionContext ctx) {
        if (ctx.MULT() != null) {
            return new PreciseMultiplicationOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this));
        } else if (nonNull(ctx.DIV())) {
            return new PreciseDivisionOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this));
        } else if (nonNull(ctx.MODULO())) {
            return new PreciseModuloOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this));
        }
        throw new IllegalStateException(String.format("Operation %s not implemented", ctx.getText()));
    }

    @Override
    public AbstractOperation visitFactorialExpression(FactorialExpressionContext ctx) {
        return new PreciseFactorialOperation(ctx.mathExpression().accept(this));
    }

    @Override
    public AbstractOperation visitNegateMathParenthesis(NegateMathParenthesisContext ctx) {
        AbstractOperation operation = ctx.mathExpression().accept(this);
        operation.applyingParenthesis();
        return new PreciseNegativeOperation(operation);
    }

    @Override
    public AbstractOperation visitPercentExpression(PercentExpressionContext ctx) {
        return new PrecisePercentualOperation(ctx.mathExpression().accept(this));
    }

    @Override
    public AbstractOperation visitSumExpression(SumExpressionContext ctx) {
        if (ctx.PLUS() != null) {
            return new PreciseAdditionOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this));
        } else if (nonNull(ctx.MINUS())) {
            return new PreciseSubtractionOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this));
        }
        throw new IllegalStateException(String.format("Operation %s not implemented", ctx.getText()));
    }

    @Override
    public AbstractOperation visitExponentiationExpression(ExponentiationExpressionContext ctx) {
        return new PreciseExponentialOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this));
    }

    @Override
    public AbstractOperation visitFixedLogarithm(FixedLogarithmContext ctx) {
        if (nonNull(ctx.BINARY_LOGARITHM())) {
            return new PreciseBinaryLogarithmOperation(ctx.mathExpression().accept(this));
        } else if (nonNull(ctx.COMMOM_LOGARITHM())) {
            return new PreciseCommonLogarithmOperation(ctx.mathExpression().accept(this));
        } else if (nonNull(ctx.NATURAL_LOGARITHM())) {
            return new PreciseNaturalLogarithmOperation(ctx.mathExpression().accept(this));
        }
        throw new IllegalStateException(String.format("Operation %s not implemented", ctx.getText()));
    }

    @Override
    public AbstractOperation visitVariableLogarithm(VariableLogarithmContext ctx) {
        return new PreciseLogarithmOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this));
    }

    @Override
    public AbstractOperation visitRoundingFunction(RoundingFunctionContext ctx) {
        if (ctx.R_HALF_EVEN() != null) {
            return new PreciseNumberRoundingOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this), RoundingEnum.HALF_EVEN);
        } else if (ctx.R_DOWN() != null) {
            return new PreciseNumberRoundingOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this), RoundingEnum.DOWN);
        } else if (ctx.R_CEILING() != null) {
            return new PreciseNumberRoundingOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this), RoundingEnum.CEILING);
        } else if (ctx.R_FLOOR() != null) {
            return new PreciseNumberRoundingOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this), RoundingEnum.FLOOR);
        } else if (ctx.R_HALF_UP() != null) {
            return new PreciseNumberRoundingOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this), RoundingEnum.HALF_UP);
        } else if (ctx.R_UP() != null) {
            return new PreciseNumberRoundingOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this), RoundingEnum.UP);
        } else if (ctx.R_HALF_DOWN() != null) {
            return new PreciseNumberRoundingOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this), RoundingEnum.HALF_DOWN);
        } else if (ctx.R_UNNECESSARY() != null) {
            return new PreciseNumberRoundingOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this), RoundingEnum.UNNECESSARY);
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
            return new PreciseSummationOperation(startIndexOperation, endIndexOperation, mathExpression, sequenceVariable);
        } else if (ctx.PRODUCT_SEQUENCE() != null) {
            return new PreciseProductOfSequenceOperation(startIndexOperation, endIndexOperation, mathExpression, sequenceVariable);
        }
        throw new IllegalStateException(String.format("Operation %s not implemented", ctx.getText()));
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
        return new DecisionOperation(true, operations).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitMathFunctionDecisionExpression(MathFunctionDecisionExpressionContext ctx) {
        List<AbstractOperation> operations = new ArrayList<>();
        List<LogicalExpressionContext> logicalExpressions = ctx.logicalExpression();
        List<MathExpressionContext> mathExpressions = ctx.mathExpression();

        for (int i = 0; i < logicalExpressions.size(); i++) {
            operations.add(logicalExpressions.get(i).accept(this));
            operations.add(mathExpressions.get(i).accept(this));
        }
        operations.add(mathExpressions.get(mathExpressions.size() - 1).accept(this));
        return new DecisionOperation(false, operations).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitEulerConstant(EulerConstantContext ctx) {
        return new PreciseEulerNumberConstantValueOperation();
    }

    @Override
    public AbstractOperation visitPiConstant(PiConstantContext ctx) {
        return new PrecisePiNumberConstantValueOperation();
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
        return new PreciseNumberConstantValueOperation(ctx.getText());
    }

    @Override
    public AbstractOperation visitNumericFunctionResult(NumericFunctionResultContext ctx) {
        return ctx.function().accept(this).expectedType(BigDecimal.class);
    }

    @Override
    public AbstractOperation visitNumericVariable(NumericVariableContext ctx) {
        if (nonNull(ctx.IDENTIFIER())) {
            return createNewUserVariable(ctx).expectedType(BigDecimal.class);
        } else if (nonNull(ctx.NEGATIVE_IDENTIFIER())) {
            return new PreciseNegativeOperation(createNewUserVariable(ctx,
                    name -> new VariableValueOperation(name).expectedType(BigDecimal.class),
                    () -> ctx.getText().substring(1)));
        }
        throw new IllegalStateException("Invalid numeric operation: " + ctx.getText());
    }

}
