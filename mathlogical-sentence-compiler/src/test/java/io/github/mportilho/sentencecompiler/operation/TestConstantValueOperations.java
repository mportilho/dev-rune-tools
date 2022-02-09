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

package io.github.mportilho.sentencecompiler.operation;

import io.github.mportilho.sentencecompiler.operation.value.constant.*;
import io.github.mportilho.sentencecompiler.operation.value.constant.precise.PreciseEulerNumberConstantValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.constant.precise.PrecisePiNumberConstantValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.constant.precise.PreciseNumberConstantValueOperation;
import io.github.mportilho.sentencecompiler.syntaxtree.OperationContext;
import io.github.mportilho.sentencecompiler.testutils.MathSentenceCompilerMockupFactory;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;

public class TestConstantValueOperations {

    private final OperationContext context = MathSentenceCompilerMockupFactory.getPreciseOperationContext();

    @Test
    public void testBooleanConstantValueOperation() {
        AbstractConstantValueOperation operation;

        operation = new BooleanConstantValueOperation("true");
        assertThat((Boolean) operation.evaluate(context)).isTrue();

        operation = new BooleanConstantValueOperation("false");
        assertThat((Boolean) operation.evaluate(context)).isFalse();
    }

    @Test
    public void testDateConstantValueOperation() {
        AbstractConstantValueOperation operation;

        operation = new DateConstantValueOperation("2001-04-12");
        assertThat((LocalDate) operation.evaluate(context)).isEqualTo(LocalDate.of(2001, 4, 12));
    }

    @Test
    public void testTimeConstantValueOperation() {
        AbstractConstantValueOperation operation;

        operation = new TimeConstantValueOperation("04:12:33");
        assertThat((LocalTime) operation.evaluate(context)).isEqualTo(LocalTime.of(4, 12, 33));
    }

    @Test
    public void testDateTimeConstantValueOperation() {
        AbstractConstantValueOperation operation;

        operation = new DateTimeConstantValueOperation("2001-04-12T04:12:33");
        assertThat(operation.<ZonedDateTime>evaluate(context))
                .isEqualTo(ZonedDateTime.of(2001, 4, 12, 4, 12, 33, 0, context.currentDateTime().getZone()));
    }

    @Test
    public void testEulerNumberConstantValueOperation() {
        AbstractConstantValueOperation operation;

        operation = new PreciseEulerNumberConstantValueOperation();
        assertThat((BigDecimal) operation.evaluate(context)).isEqualTo(BigDecimal.valueOf(2.718281828459045));
    }

    @Test
    public void testPiNumberConstantValueOperation() {
        AbstractConstantValueOperation operation;

        operation = new PrecisePiNumberConstantValueOperation();
        assertThat((BigDecimal) operation.evaluate(context)).isEqualTo(BigDecimal.valueOf(3.141592653589793));
    }

    @Test
    public void testPreciseNumberConstantValueOperation() {
        AbstractConstantValueOperation operation;

        operation = new PreciseNumberConstantValueOperation("3.141592653589793");
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualTo(BigDecimal.valueOf(3.141592653589793));

        operation = new PreciseNumberConstantValueOperation("-3.141592653589793");
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualTo(BigDecimal.valueOf(-3.141592653589793));

        operation = new PreciseNumberConstantValueOperation("0");
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualTo(BigDecimal.valueOf(0));
    }

    @Test
    public void testStringConstantValueOperation() {
        AbstractConstantValueOperation operation;

        operation = new StringConstantValueOperation("3.141592653589793");
        assertThat((String) operation.evaluate(context)).isEqualTo("3.141592653589793");

        operation = new StringConstantValueOperation("-3.141592653589793");
        assertThat((String) operation.evaluate(context)).isEqualTo("-3.141592653589793");

        operation = new StringConstantValueOperation("AB.CD-e");
        assertThat((String) operation.evaluate(context)).isEqualTo("AB.CD-e");
    }

}
