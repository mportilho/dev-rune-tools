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
import io.github.mportilho.sentencecompiler.operation.math.DeggreOperation;
import io.github.mportilho.sentencecompiler.operation.math.fast.*;
import io.github.mportilho.sentencecompiler.operation.math.fast.FastNumberRoundingOperation.RoundingEnum;
import io.github.mportilho.sentencecompiler.operation.math.fast.logarithm.FastBinaryLogarithmOperation;
import io.github.mportilho.sentencecompiler.operation.math.fast.logarithm.FastCommonLogarithmOperation;
import io.github.mportilho.sentencecompiler.operation.math.fast.logarithm.FastLogarithmOperation;
import io.github.mportilho.sentencecompiler.operation.math.fast.logarithm.FastNaturalLogarithmOperation;
import io.github.mportilho.sentencecompiler.operation.other.DecisionOperation;
import io.github.mportilho.sentencecompiler.operation.value.constant.fast.FastEulerNumberConstantValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.constant.fast.FastNumberConstantValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.constant.fast.FastPiNumberConstantValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.variable.SequenceVariableValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.variable.VariableValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.variable.VectorValueOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static java.util.Objects.nonNull;

public class FastOperationSyntaxTreeGenerator extends AbstractOperationSyntaxTreeGenerator {

    public FastOperationSyntaxTreeGenerator() {
        super();
    }

    @Override
    public AbstractOperation visitSequenceExpression(SequenceExpressionContext ctx) {
        if (sequenceVariableStack == null) {
            sequenceVariableStack = new Stack<>();
        }
        return super.visitSequenceExpression(ctx).expectedType(Double.class);
    }

    @Override
    public AbstractOperation visitModulusExpression(ModulusExpressionContext ctx) {
        return new FastModulusOperation(ctx.mathExpression().accept(this)).expectedType(Double.class);
    }

    @Override
    public AbstractOperation visitMathParenthesis(MathParenthesisContext ctx) {
        AbstractOperation operation = ctx.mathExpression().accept(this);
        operation.applyingParenthesis();
        return operation.expectedType(Double.class);
    }

    @Override
    public AbstractOperation visitSquareRootExpression(SquareRootExpressionContext ctx) {
        return new FastSquareRootOperation(ctx.mathExpression().accept(this)).expectedType(Double.class);
    }

    @Override
    public AbstractOperation visitRootExpression(RootExpressionContext ctx) {
        return new FastRootOperation(ctx.mathExpression(1).accept(this), ctx.mathExpression(0).accept(this)).expectedType(Double.class);
    }

    @Override
    public AbstractOperation visitMultiplicationExpression(MultiplicationExpressionContext ctx) {
        if (ctx.MULT() != null) {
            return new FastMultiplicationOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this)).expectedType(Double.class);
        } else if (nonNull(ctx.DIV())) {
            return new FastDivisionOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this)).expectedType(Double.class);
        } else if (nonNull(ctx.MODULO())) {
            return new FastModuloOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this)).expectedType(Double.class);
        }
        throw new IllegalStateException(String.format("Operation %s not implemented", ctx.getText()));
    }

    @Override
    public AbstractOperation visitFactorialExpression(FactorialExpressionContext ctx) {
        return new FastFactorialOperation(ctx.mathExpression().accept(this)).expectedType(Double.class);
    }

    @Override
    public AbstractOperation visitNegateMathParenthesis(NegateMathParenthesisContext ctx) {
        AbstractOperation operation = ctx.mathExpression().accept(this);
        operation.applyingParenthesis();
        return new FastNegativeOperation(operation).expectedType(Double.class);
    }

    @Override
    public AbstractOperation visitPercentExpression(PercentExpressionContext ctx) {
        return new FastPercentualOperation(ctx.mathExpression().accept(this)).expectedType(Double.class);
    }

    @Override
    public AbstractOperation visitSumExpression(SumExpressionContext ctx) {
        if (ctx.PLUS() != null) {
            return new FastAdditionOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this)).expectedType(Double.class);
        } else if (nonNull(ctx.MINUS())) {
            return new FastSubtractionOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this)).expectedType(Double.class);
        }
        throw new IllegalStateException(String.format("Operation %s not implemented", ctx.getText()));
    }

    @Override
    public AbstractOperation visitDegreeExpression(DegreeExpressionContext ctx) {
        return new DeggreOperation(ctx.mathExpression().accept(this)).expectedType(Double.class);
    }

    @Override
    public AbstractOperation visitExponentiationExpression(ExponentiationExpressionContext ctx) {
        return new FastExponentialOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this)).expectedType(Double.class);
    }

    @Override
    public AbstractOperation visitFixedLogarithm(FixedLogarithmContext ctx) {
        if (nonNull(ctx.BINARY_LOGARITHM())) {
            return new FastBinaryLogarithmOperation(ctx.mathExpression().accept(this)).expectedType(Double.class);
        } else if (nonNull(ctx.COMMOM_LOGARITHM())) {
            return new FastCommonLogarithmOperation(ctx.mathExpression().accept(this)).expectedType(Double.class);
        } else if (nonNull(ctx.NATURAL_LOGARITHM())) {
            return new FastNaturalLogarithmOperation(ctx.mathExpression().accept(this)).expectedType(Double.class);
        }
        throw new IllegalStateException(String.format("Operation %s not implemented", ctx.getText()));
    }

    @Override
    public AbstractOperation visitVariableLogarithm(VariableLogarithmContext ctx) {
        return new FastLogarithmOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this)).expectedType(Double.class);
    }

    @Override
    public AbstractOperation visitRoundingFunction(RoundingFunctionContext ctx) {
        if (ctx.R_HALF_EVEN() != null) {
            return new FastNumberRoundingOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this), RoundingEnum.HALF_EVEN).expectedType(Double.class);
        } else if (ctx.R_DOWN() != null) {
            return new FastNumberRoundingOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this), RoundingEnum.DOWN).expectedType(Double.class);
        } else if (ctx.R_CEILING() != null) {
            return new FastNumberRoundingOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this), RoundingEnum.CEILING).expectedType(Double.class);
        } else if (ctx.R_FLOOR() != null) {
            return new FastNumberRoundingOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this), RoundingEnum.FLOOR).expectedType(Double.class);
        } else if (ctx.R_HALF_UP() != null) {
            return new FastNumberRoundingOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this), RoundingEnum.HALF_UP).expectedType(Double.class);
        } else if (ctx.R_UP() != null) {
            return new FastNumberRoundingOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this), RoundingEnum.UP).expectedType(Double.class);
        } else if (ctx.R_HALF_DOWN() != null) {
            return new FastNumberRoundingOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this), RoundingEnum.HALF_DOWN).expectedType(Double.class);
        } else if (ctx.R_UNNECESSARY() != null) {
            return new FastNumberRoundingOperation(ctx.mathExpression(0).accept(this), ctx.mathExpression(1).accept(this), RoundingEnum.UNNECESSARY).expectedType(Double.class);
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

        AbstractOperation input = ctx.vectorEntity().accept(this);
        AbstractOperation mathExpression = ctx.mathExpression().accept(this);

        List<SequenceVariableValueOperation> sequenceVariableContainer = sequenceVariableStack.pop();
        SequenceVariableValueOperation sequenceVariable = sequenceVariableContainer.isEmpty() ? null : sequenceVariableContainer.get(0);
        if (ctx.SUMMATION() != null) {
            return new FastSummationOperation(input, mathExpression, sequenceVariable)
                    .expectedType(Double.class);
        } else if (ctx.PRODUCT_SEQUENCE() != null) {
            return new FastProductOfSequenceOperation(input, mathExpression, sequenceVariable)
                    .expectedType(Double.class);
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
        return new DecisionOperation(true, operations.toArray(AbstractOperation[]::new)).expectedType(Double.class);
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
        return new DecisionOperation(false, operations.toArray(AbstractOperation[]::new)).expectedType(Double.class);
    }

    @Override
    public AbstractOperation visitEulerConstant(EulerConstantContext ctx) {
        return new FastEulerNumberConstantValueOperation().expectedType(Double.class);
    }

    @Override
    public AbstractOperation visitPiConstant(PiConstantContext ctx) {
        return new FastPiNumberConstantValueOperation().expectedType(Double.class);
    }

    @Override
    public AbstractOperation visitSummationVariable(SummationVariableContext ctx) {
        if (sequenceVariableStack.peek().isEmpty()) {
            SequenceVariableValueOperation sequenceVariable = new SequenceVariableValueOperation("S");
            sequenceVariableStack.peek().add(sequenceVariable);
            return sequenceVariable;
        }
        return sequenceVariableStack.peek().get(0).expectedType(Double.class);
    }

    @Override
    public AbstractOperation visitProductSequenceVariable(ProductSequenceVariableContext ctx) {
        if (sequenceVariableStack.peek().isEmpty()) {
            SequenceVariableValueOperation sequenceVariable = new SequenceVariableValueOperation("P");
            sequenceVariableStack.peek().add(sequenceVariable);
            return sequenceVariable;
        }
        return sequenceVariableStack.peek().get(0).expectedType(Double.class);
    }

    @Override
    public AbstractOperation visitNumericConstant(NumericConstantContext ctx) {
        return new FastNumberConstantValueOperation(ctx.getText()).expectedType(Double.class);
    }

    @Override
    public AbstractOperation visitNumericFunctionResult(NumericFunctionResultContext ctx) {
        return ctx.function().accept(this).expectedType(Double.class);
    }

    @Override
    public AbstractOperation visitNumericVariable(NumericVariableContext ctx) {
        if (nonNull(ctx.IDENTIFIER())) {
            return createNewUserVariable(ctx).expectedType(Double.class);
        } else if (nonNull(ctx.NEGATIVE_IDENTIFIER())) {
            return new FastNegativeOperation(createNewUserVariable(ctx,
                    name -> new VariableValueOperation(name).expectedType(Double.class),
                    () -> ctx.getText().substring(1)));
        }
        throw new IllegalStateException("Invalid numeric operation: " + ctx.getText());
    }

    @Override
    public AbstractOperation visitVectorOfNumbers(VectorOfNumbersContext ctx) {
        AbstractOperation[] operations = new AbstractOperation[ctx.numericEntity().size()];
        for (int i = 0, size = ctx.numericEntity().size(); i < size; i++) {
            operations[i] = ctx.numericEntity().get(i).accept(this);
        }
        return new VectorValueOperation(ctx.getText(), operations).expectedType(Double[].class);
    }

}
