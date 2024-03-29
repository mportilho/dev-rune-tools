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

package io.github.mportilho.sentencecompiler.operation.math.precise;

import io.github.mportilho.sentencecompiler.exceptions.SentenceExecutionException;
import io.github.mportilho.sentencecompiler.operation.impl.GenericValueOperation;
import io.github.mportilho.sentencecompiler.operation.math.precise.PreciseNumberRoundingOperation.RoundingEnum;
import io.github.mportilho.sentencecompiler.OperationContext;
import io.github.mportilho.sentencecompiler.testutils.MathSentenceCompilerMockupFactory;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;

public class TestPreciseComplexMathOperations {

    private final OperationContext context = MathSentenceCompilerMockupFactory.getPreciseOperationContext();

    @Test
    public void testExponentialOperation() {
        PreciseExponentialOperation operation;

        operation = new PreciseExponentialOperation(new GenericValueOperation(BigDecimal.ZERO), new GenericValueOperation(BigDecimal.ZERO));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("1");

        operation = new PreciseExponentialOperation(new GenericValueOperation(BigDecimal.ONE), new GenericValueOperation(BigDecimal.ONE));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("1");

        operation = new PreciseExponentialOperation(new GenericValueOperation(valueOf(-1)), new GenericValueOperation(valueOf(1)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("-1");

        operation = new PreciseExponentialOperation(new GenericValueOperation(valueOf(-1)), new GenericValueOperation(valueOf(-1)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("-1");

        operation = new PreciseExponentialOperation(new GenericValueOperation(valueOf(1)), new GenericValueOperation(valueOf(2)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("1");

        operation = new PreciseExponentialOperation(new GenericValueOperation(valueOf(2)), new GenericValueOperation(valueOf(4)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("16");

        operation = new PreciseExponentialOperation(new GenericValueOperation(valueOf(2)), new GenericValueOperation(valueOf(-3)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("0.125");

        operation = new PreciseExponentialOperation(new GenericValueOperation(valueOf(2)), new GenericValueOperation(valueOf(-2)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("0.25");

        operation = new PreciseExponentialOperation(new GenericValueOperation(valueOf(2)), new GenericValueOperation(valueOf(-1)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("0.5");

        operation = new PreciseExponentialOperation(new GenericValueOperation(valueOf(2)), new GenericValueOperation(valueOf(0)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("1");

        operation = new PreciseExponentialOperation(new GenericValueOperation(valueOf(2)), new GenericValueOperation(valueOf(1)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("2");

        operation = new PreciseExponentialOperation(new GenericValueOperation(valueOf(2)), new GenericValueOperation(valueOf(2)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("4");

        operation = new PreciseExponentialOperation(new GenericValueOperation(valueOf(2)), new GenericValueOperation(valueOf(3)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("8");
    }

    @Test
    public void testFactorialOperation() {
        PreciseFactorialOperation operation;

        PreciseFactorialOperation throwsExceptionOperation = new PreciseFactorialOperation(new GenericValueOperation(valueOf(-1)));
        assertThatThrownBy(() -> throwsExceptionOperation.<BigDecimal>evaluate(context)).isInstanceOf(SentenceExecutionException.class);

        operation = new PreciseFactorialOperation(new GenericValueOperation(valueOf(0)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("1");

        operation = new PreciseFactorialOperation(new GenericValueOperation(valueOf(1)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("1");

        operation = new PreciseFactorialOperation(new GenericValueOperation(valueOf(2)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("2");

        operation = new PreciseFactorialOperation(new GenericValueOperation(valueOf(3)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("6");

        operation = new PreciseFactorialOperation(new GenericValueOperation(valueOf(4)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("24");
    }

    @Test
    public void testModuloOperation() {
        PreciseModuloOperation operation;

        operation = new PreciseModuloOperation(new GenericValueOperation(valueOf(4)), new GenericValueOperation(valueOf(4)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("0");

        operation = new PreciseModuloOperation(new GenericValueOperation(valueOf(8)), new GenericValueOperation(valueOf(4)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("0");

        operation = new PreciseModuloOperation(new GenericValueOperation(valueOf(3)), new GenericValueOperation(valueOf(2)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("1");

        operation = new PreciseModuloOperation(new GenericValueOperation(valueOf(5)), new GenericValueOperation(valueOf(3)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("2");
    }

    @Test
    public void testModulusOperation() {
        PreciseModulusOperation operation;

        operation = new PreciseModulusOperation(new GenericValueOperation(valueOf(4)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("4");

        operation = new PreciseModulusOperation(new GenericValueOperation(valueOf(-4)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("4");
    }

    @Test
    public void testNegativeOperation() {
        PreciseNegativeOperation operation;

        operation = new PreciseNegativeOperation(new GenericValueOperation(valueOf(4)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("-4");
        assertThat(operation.isNegatingValue()).isTrue();

        operation = new PreciseNegativeOperation(new GenericValueOperation(valueOf(-4)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("4");
        assertThat(operation.isNegatingValue()).isTrue();

        operation = new PreciseNegativeOperation(new GenericValueOperation(valueOf(4)));
        operation.negatingValue(false);
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("4");
        assertThat(operation.isNegatingValue()).isFalse();

        operation = new PreciseNegativeOperation(new GenericValueOperation(valueOf(-4)));
        operation.negatingValue(false);
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("-4");
        assertThat(operation.isNegatingValue()).isFalse();
    }

    @Test
    public void testNumberRoundingOperation() {
        PreciseNumberRoundingOperation operation;

        operation = new PreciseNumberRoundingOperation(new GenericValueOperation(valueOf(0.353333)), new GenericValueOperation(valueOf(2)),
                RoundingEnum.CEILING);
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("0.36");

        operation = new PreciseNumberRoundingOperation(new GenericValueOperation(valueOf(0.353333)), new GenericValueOperation(valueOf(2)),
                RoundingEnum.DOWN);
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("0.35");

        operation = new PreciseNumberRoundingOperation(new GenericValueOperation(valueOf(0.353333)), new GenericValueOperation(valueOf(2)),
                RoundingEnum.FLOOR);
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("0.35");

        operation = new PreciseNumberRoundingOperation(new GenericValueOperation(valueOf(0.353333)), new GenericValueOperation(valueOf(2)),
                RoundingEnum.HALF_DOWN);
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("0.35");

        operation = new PreciseNumberRoundingOperation(new GenericValueOperation(valueOf(0.354333)), new GenericValueOperation(valueOf(2)),
                RoundingEnum.HALF_EVEN);
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("0.35");

        operation = new PreciseNumberRoundingOperation(new GenericValueOperation(valueOf(0.3540)), new GenericValueOperation(valueOf(2)),
                RoundingEnum.HALF_EVEN);
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("0.35");

        operation = new PreciseNumberRoundingOperation(new GenericValueOperation(valueOf(0.355333)), new GenericValueOperation(valueOf(2)),
                RoundingEnum.HALF_EVEN);
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("0.36");

        operation = new PreciseNumberRoundingOperation(new GenericValueOperation(valueOf(0.356333)), new GenericValueOperation(valueOf(2)),
                RoundingEnum.HALF_EVEN);
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("0.36");

        operation = new PreciseNumberRoundingOperation(new GenericValueOperation(valueOf(0.353333)), new GenericValueOperation(valueOf(2)),
                RoundingEnum.HALF_UP);
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("0.35");

        operation = new PreciseNumberRoundingOperation(new GenericValueOperation(valueOf(0.353333)), new GenericValueOperation(valueOf(2)),
                RoundingEnum.UP);
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("0.36");

        PreciseNumberRoundingOperation operationThrowing = new PreciseNumberRoundingOperation(new GenericValueOperation(valueOf(0.353333)),
                new GenericValueOperation(valueOf(2)), RoundingEnum.UNNECESSARY);
        assertThatThrownBy(() -> operationThrowing.<BigDecimal>evaluate(context)).isInstanceOf(SentenceExecutionException.class);
    }

    @Test
    public void testPrecisePercentualOperation() {
        PrecisePercentualOperation operation;

        operation = new PrecisePercentualOperation(new GenericValueOperation(valueOf(4)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("0.04");

        operation = new PrecisePercentualOperation(new GenericValueOperation(valueOf(-4)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("-0.04");

        operation = new PrecisePercentualOperation(new GenericValueOperation(valueOf(0)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("0");

        operation = new PrecisePercentualOperation(new GenericValueOperation(valueOf(100)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("1");
    }

    @Test
    public void testPreciseRootOperation() {
        PreciseRootOperation operation;

        operation = new PreciseRootOperation(new GenericValueOperation(valueOf(4)), new GenericValueOperation(valueOf(2)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("2");

        operation = new PreciseRootOperation(new GenericValueOperation(valueOf(144)), new GenericValueOperation(valueOf(2)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("12");

        operation = new PreciseRootOperation(new GenericValueOperation(valueOf(64)), new GenericValueOperation(valueOf(3)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("4");
    }

    @Test
    public void testPreciseSquareRootOperation() {
        PreciseSquareRootOperation operation;

        operation = new PreciseSquareRootOperation(new GenericValueOperation(valueOf(4)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("2");

        operation = new PreciseSquareRootOperation(new GenericValueOperation(valueOf(144)));
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("12");
    }

//    @Test
//    public void testSummationOperation() {
//        SequenceVariableValueOperation index_0 = new SequenceVariableValueOperation("0");
//        SequenceVariableValueOperation index_2 = new SequenceVariableValueOperation("2");
//        index_0.setValue(valueOf(0));
//        index_2.setValue(valueOf(2));
//
//        SequenceVariableValueOperation sequenceVariable;
//        AbstractOperation summationOperation;
//        AbstractOperation operation;
//
//        sequenceVariable = new SequenceVariableValueOperation("S");
//        summationOperation = new PreciseExponentialOperation(index_2, sequenceVariable);
//        operation = new PreciseSummationOperation(index_0, index_2, summationOperation, sequenceVariable);
//        operation.accept(new InitialConfigurationOperationVisitor());
//        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("7");
//
//        sequenceVariable = new SequenceVariableValueOperation("S");
//        summationOperation = new PreciseExponentialOperation(new PreciseAdditionOperation(new SequenceVariableValueOperation("2"), sequenceVariable),
//                sequenceVariable);
//        operation = new PreciseSummationOperation(index_0, index_2, summationOperation, sequenceVariable);
//        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("20");
//    }

//    @Test
//    public void testProductOfSequenceOperation() {
//        GenericValueOperation startIndex = new GenericValueOperation(valueOf(0));
//        GenericValueOperation endIndex = new GenericValueOperation(valueOf(2));
//        SequenceVariableValueOperation sequenceVariable;
//        AbstractOperation productOfSequenceOperation;
//        AbstractOperation operation;
//
//        sequenceVariable = new SequenceVariableValueOperation("P");
//        productOfSequenceOperation = new PreciseExponentialOperation(
//                new PreciseAdditionOperation(new GenericValueOperation(valueOf(2)), sequenceVariable), sequenceVariable);
//        operation = new PreciseProductOfSequenceOperation(startIndex, endIndex, productOfSequenceOperation, sequenceVariable);
//        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("48");
//    }

}
