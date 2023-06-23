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

package io.github.mportilho.sentencecompiler.operation.math.fast;

import io.github.mportilho.sentencecompiler.exceptions.SentenceExecutionException;
import io.github.mportilho.sentencecompiler.operation.impl.GenericValueOperation;
import io.github.mportilho.sentencecompiler.operation.math.fast.FastNumberRoundingOperation.RoundingEnum;
import io.github.mportilho.sentencecompiler.OperationContext;
import io.github.mportilho.sentencecompiler.testutils.MathSentenceCompilerMockupFactory;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class TestFastComplexMathOperations {

    private final OperationContext context = MathSentenceCompilerMockupFactory.getFastOperationContext();

    @Test
    public void testExponentialOperation() {
        FastExponentialOperation operation;

        operation = new FastExponentialOperation(new GenericValueOperation(0d), new GenericValueOperation(0d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(1d);

        operation = new FastExponentialOperation(new GenericValueOperation(1d), new GenericValueOperation(1d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(1d);

        operation = new FastExponentialOperation(new GenericValueOperation(-1d), new GenericValueOperation(1d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(-1d);

        operation = new FastExponentialOperation(new GenericValueOperation(-1d), new GenericValueOperation(-1d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(-1d);

        operation = new FastExponentialOperation(new GenericValueOperation(1d), new GenericValueOperation(2d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(1d);

        operation = new FastExponentialOperation(new GenericValueOperation(2d), new GenericValueOperation(4d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(16d);

        operation = new FastExponentialOperation(new GenericValueOperation(2d), new GenericValueOperation(-3d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(0.125d);

        operation = new FastExponentialOperation(new GenericValueOperation(2d), new GenericValueOperation(-2d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(0.25d);

        operation = new FastExponentialOperation(new GenericValueOperation(2d), new GenericValueOperation(-1d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(0.5d);

        operation = new FastExponentialOperation(new GenericValueOperation(2d), new GenericValueOperation(0d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(1d);

        operation = new FastExponentialOperation(new GenericValueOperation(2d), new GenericValueOperation(1d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(2d);

        operation = new FastExponentialOperation(new GenericValueOperation(2d), new GenericValueOperation(2d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(4d);

        operation = new FastExponentialOperation(new GenericValueOperation(2d), new GenericValueOperation(3d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(8d);
    }

    @Test
    public void testFactorialOperation() {
        FastFactorialOperation operation;

        FastFactorialOperation throwsExceptionOperation = new FastFactorialOperation(new GenericValueOperation(-1d).expectedType(Double.class));
        assertThatThrownBy(() -> throwsExceptionOperation.<Double>evaluate(context)).isInstanceOf(SentenceExecutionException.class);

        operation = new FastFactorialOperation(new GenericValueOperation(0d).expectedType(Double.class));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(1d);

        operation = new FastFactorialOperation(new GenericValueOperation(1d).expectedType(Double.class));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(1d);

        operation = new FastFactorialOperation(new GenericValueOperation(2d).expectedType(Double.class));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(2d);

        operation = new FastFactorialOperation(new GenericValueOperation(3d).expectedType(Double.class));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(6d);

        operation = new FastFactorialOperation(new GenericValueOperation(4d).expectedType(Double.class));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(24d);

        operation = new FastFactorialOperation(new GenericValueOperation(102d).expectedType(Double.class));
        assertThat(operation.<Double>evaluate(context).toString()).startsWith("9.614466");
    }

    @Test
    public void testModuloOperation() {
        FastModuloOperation operation;

        operation = new FastModuloOperation(new GenericValueOperation(4d), new GenericValueOperation(4d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(0d);

        operation = new FastModuloOperation(new GenericValueOperation(8d), new GenericValueOperation(4d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(0d);

        operation = new FastModuloOperation(new GenericValueOperation(3d), new GenericValueOperation(2d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(1d);

        operation = new FastModuloOperation(new GenericValueOperation(5d), new GenericValueOperation(3d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(2d);
    }

    @Test
    public void testModulusOperation() {
        FastModulusOperation operation;

        operation = new FastModulusOperation(new GenericValueOperation(4d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(4d);

        operation = new FastModulusOperation(new GenericValueOperation(-4d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(4d);
    }

    @Test
    public void testNegativeOperation() {
        FastNegativeOperation operation;

        operation = new FastNegativeOperation(new GenericValueOperation(4d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(-4d);
        assertThat(operation.isNegatingValue()).isTrue();

        operation = new FastNegativeOperation(new GenericValueOperation(-4d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(4d);
        assertThat(operation.isNegatingValue()).isTrue();

        operation = new FastNegativeOperation(new GenericValueOperation(4d));
        operation.negatingValue(false);
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(4d);
        assertThat(operation.isNegatingValue()).isFalse();

        operation = new FastNegativeOperation(new GenericValueOperation(-4d));
        operation.negatingValue(false);
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(-4d);
        assertThat(operation.isNegatingValue()).isFalse();
    }

    @Test
    public void testNumberRoundingOperation() {
        FastNumberRoundingOperation operation;

        operation = new FastNumberRoundingOperation(new GenericValueOperation(0.353333d), new GenericValueOperation(2d),
                RoundingEnum.CEILING);
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(0.36d);

        operation = new FastNumberRoundingOperation(new GenericValueOperation(0.353333d), new GenericValueOperation(2d),
                RoundingEnum.DOWN);
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(0.35d);

        operation = new FastNumberRoundingOperation(new GenericValueOperation(0.353333d), new GenericValueOperation(2d),
                RoundingEnum.FLOOR);
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(0.35d);

        operation = new FastNumberRoundingOperation(new GenericValueOperation(0.353333d), new GenericValueOperation(2d),
                RoundingEnum.HALF_DOWN);
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(0.35d);

        operation = new FastNumberRoundingOperation(new GenericValueOperation(0.354333d), new GenericValueOperation(2d),
                RoundingEnum.HALF_EVEN);
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(0.35d);

        operation = new FastNumberRoundingOperation(new GenericValueOperation(0.3540), new GenericValueOperation(2d),
                RoundingEnum.HALF_EVEN);
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(0.35d);

        operation = new FastNumberRoundingOperation(new GenericValueOperation(0.355333), new GenericValueOperation(2d),
                RoundingEnum.HALF_EVEN);
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(0.36d);

        operation = new FastNumberRoundingOperation(new GenericValueOperation(0.356333), new GenericValueOperation(2d),
                RoundingEnum.HALF_EVEN);
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(0.36d);

        operation = new FastNumberRoundingOperation(new GenericValueOperation(0.353333d), new GenericValueOperation(2d),
                RoundingEnum.HALF_UP);
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(0.35d);

        operation = new FastNumberRoundingOperation(new GenericValueOperation(0.353333d), new GenericValueOperation(2d),
                RoundingEnum.UP);
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(0.36d);

        FastNumberRoundingOperation operationThrowing = new FastNumberRoundingOperation(new GenericValueOperation(0.353333d),
                new GenericValueOperation(2d), RoundingEnum.UNNECESSARY);
        assertThatThrownBy(() -> operationThrowing.<Double>evaluate(context)).isInstanceOf(SentenceExecutionException.class);
    }

    @Test
    public void testFastPercentualOperation() {
        FastPercentualOperation operation;

        operation = new FastPercentualOperation(new GenericValueOperation(4d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(0.04d);

        operation = new FastPercentualOperation(new GenericValueOperation(-4d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(-0.04d);

        operation = new FastPercentualOperation(new GenericValueOperation(0d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(0d);

        operation = new FastPercentualOperation(new GenericValueOperation(100d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(1d);
    }

    @Test
    public void testFastRootOperation() {
        FastRootOperation operation;

        operation = new FastRootOperation(new GenericValueOperation(4d), new GenericValueOperation(2d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(2d);

        operation = new FastRootOperation(new GenericValueOperation(144d), new GenericValueOperation(2d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(12d);

        operation = new FastRootOperation(new GenericValueOperation(64d), new GenericValueOperation(3d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(4d);
    }

    @Test
    public void testFastSquareRootOperation() {
        FastSquareRootOperation operation;

        operation = new FastSquareRootOperation(new GenericValueOperation(4d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(2d);

        operation = new FastSquareRootOperation(new GenericValueOperation(144d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(12d);
    }

//    @Test
//    public void testSummationOperation() {
//        GenericValueOperation startIndex = new GenericValueOperation(0d).expectedType(Double.class);
//        GenericValueOperation endIndex = new GenericValueOperation(2d).expectedType(Double.class);
//        SequenceVariableValueOperation sequenceVariable;
//        AbstractOperation summationOperation;
//        AbstractOperation operation;
//
//        sequenceVariable = new SequenceVariableValueOperation("S").expectedType(Double.class);
//        summationOperation = new FastExponentialOperation(new GenericValueOperation(2d).expectedType(Double.class), sequenceVariable).expectedType(Double.class);
//        operation = new FastSummationOperation(startIndex, endIndex, summationOperation, sequenceVariable).expectedType(Double.class);
//        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(7d);
//
//        sequenceVariable = new SequenceVariableValueOperation("S");
//        summationOperation = new FastExponentialOperation(new FastAdditionOperation(new GenericValueOperation(2d), sequenceVariable),
//                sequenceVariable);
//        operation = new FastSummationOperation(startIndex, endIndex, summationOperation, sequenceVariable);
//        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(20d);
//
//    }

//    @Test
//    public void testProductOfSequenceOperation() {
//        GenericValueOperation startIndex = new GenericValueOperation(0d);
//        GenericValueOperation endIndex = new GenericValueOperation(2d);
//        SequenceVariableValueOperation sequenceVariable;
//        AbstractOperation productOfSequenceOperation;
//        AbstractOperation operation;
//
//        sequenceVariable = new SequenceVariableValueOperation("P");
//        productOfSequenceOperation = new FastExponentialOperation(
//                new FastAdditionOperation(new GenericValueOperation(2d), sequenceVariable), sequenceVariable);
//        operation = new FastProductOfSequenceOperation(startIndex, endIndex, productOfSequenceOperation, sequenceVariable);
//        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(48d);
//    }

}
