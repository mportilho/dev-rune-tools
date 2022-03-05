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

import io.github.mportilho.sentencecompiler.operation.impl.GenericValueOperation;
import io.github.mportilho.sentencecompiler.OperationContext;
import io.github.mportilho.sentencecompiler.testutils.MathSentenceCompilerMockupFactory;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class TestFastBasicMathOperations {

    private final OperationContext context = MathSentenceCompilerMockupFactory.getFastOperationContext();

    @Test
    public void testFastAdditionOperation() {
        FastAdditionOperation operation;

        operation = new FastAdditionOperation(new GenericValueOperation(0d), new GenericValueOperation(0d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(0d);

        operation = new FastAdditionOperation(new GenericValueOperation(1d), new GenericValueOperation(1d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(2d);

        operation = new FastAdditionOperation(new GenericValueOperation(-1d), new GenericValueOperation(1d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(0d);

        operation = new FastAdditionOperation(new GenericValueOperation(-1d), new GenericValueOperation(-1d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(-2d);

        operation = new FastAdditionOperation(new GenericValueOperation(1d), new GenericValueOperation(2d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(3d);
    }

    @Test
    public void testFastDivisionOperation() {
        FastSubtractionOperation operation;

        operation = new FastSubtractionOperation(new GenericValueOperation(0d), new GenericValueOperation(0d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(0d);

        operation = new FastSubtractionOperation(new GenericValueOperation(1d), new GenericValueOperation(1d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(0d);

        operation = new FastSubtractionOperation(new GenericValueOperation(-1d), new GenericValueOperation(1d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(-2d);

        operation = new FastSubtractionOperation(new GenericValueOperation(-1d), new GenericValueOperation(-1d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(0d);

        operation = new FastSubtractionOperation(new GenericValueOperation(1d), new GenericValueOperation(2d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(-1d);
    }

    @Test
    public void testFastMultiplicationOperation() {
        FastMultiplicationOperation operation;

        operation = new FastMultiplicationOperation(new GenericValueOperation(0d), new GenericValueOperation(0d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(0d);

        operation = new FastMultiplicationOperation(new GenericValueOperation(1d), new GenericValueOperation(1d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(1d);

        operation = new FastMultiplicationOperation(new GenericValueOperation(-1d), new GenericValueOperation(1d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(-1d);

        operation = new FastMultiplicationOperation(new GenericValueOperation(-1d), new GenericValueOperation(-1d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(1d);

        operation = new FastMultiplicationOperation(new GenericValueOperation(1d), new GenericValueOperation(2d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(2d);
    }

    @Test
    public void testFastImplicitMultiplicationOperation() {
        FastMultiplicationOperation operation;

        operation = new FastMultiplicationOperation(new GenericValueOperation(2d), new GenericValueOperation(3d), true);
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(6d);
    }

    @Test
    public void testFastSubtraction_DividingByZero() {
        FastDivisionOperation divisionByZeroOperation = new FastDivisionOperation(new GenericValueOperation(0d),
                new GenericValueOperation(0d));
        assertThat(divisionByZeroOperation.<Double>evaluate(context)).isEqualByComparingTo(Double.NaN);
    }

    @Test
    public void testFastSubtractionOperation() {
        FastDivisionOperation operation;

        operation = new FastDivisionOperation(new GenericValueOperation(1d), new GenericValueOperation(1d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(1d);

        operation = new FastDivisionOperation(new GenericValueOperation(-1d), new GenericValueOperation(1d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(-1d);

        operation = new FastDivisionOperation(new GenericValueOperation(-1d), new GenericValueOperation(-1d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(1d);

        operation = new FastDivisionOperation(new GenericValueOperation(1d), new GenericValueOperation(2d));
        assertThat(operation.<Double>evaluate(context)).isEqualByComparingTo(0.5d);
    }

}
