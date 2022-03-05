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

package io.github.mportilho.sentencecompiler.operation.value.constant;

import ch.obermuhlner.math.big.BigDecimalMath;
import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.value.variable.VectorValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.constant.precise.PreciseEulerNumberConstantValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.constant.precise.PreciseNumberConstantValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.constant.precise.PrecisePiNumberConstantValueOperation;
import io.github.mportilho.sentencecompiler.OperationContext;
import io.github.mportilho.sentencecompiler.testutils.MathSentenceCompilerMockupFactory;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.math.BigDecimal.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

public class TestConstantOperations {

    private final OperationContext context = MathSentenceCompilerMockupFactory.getPreciseOperationContext();

    @Test
    public void testBooleanConstantValueOperation() {
        assertThat(new BooleanConstantValueOperation("true").<Boolean>evaluate(context)).isTrue();
        assertThat(new BooleanConstantValueOperation("false").<Boolean>evaluate(context)).isFalse();
    }

    @Test
    public void testDateConstantValueOperation() {
        assertThat(new DateConstantValueOperation("2000-03-04").<LocalDate>evaluate(context)).isEqualTo("2000-03-04");
    }

    @Test
    public void testDateTimeConstantValueOperation() {
        assertThat(new DateTimeConstantValueOperation("2000-03-04T23:33:44", null).
                <ZonedDateTime>evaluate(context).toLocalDateTime())
                .isEqualTo("2000-03-04T23:33:44");
    }

    @Test
    public void testDateTimeConstantValueOperation_FullZonedDateTimeText_ErrorOndifferentOffset() {
        assertThat(new DateTimeConstantValueOperation("2000-03-04T23:33:44", "-02:00")
                .<ZonedDateTime>evaluate(context))
                .isNotEqualTo(ZonedDateTime.of(2000, 3, 4, 23, 33,
                        44, 0, ZoneOffset.of("-03:00")));
    }

    @Test
    public void testDateTimeConstantValueOperation_FullZonedDateTimeText() {
        assertThat(new DateTimeConstantValueOperation("2000-03-04T23:33:44", "-03:00")
                .<ZonedDateTime>evaluate(context))
                .isEqualTo(ZonedDateTime.of(2000, 3, 4, 23, 33,
                        44, 0, ZoneOffset.of("-03:00")));
    }

    @Test
    public void testEulerNumberConstantValueOperation() {
        assertThat(new PreciseEulerNumberConstantValueOperation().<BigDecimal>evaluate(context))
                .isEqualByComparingTo(BigDecimalMath.e(context.mathContext()));
    }

    @Test
    public void testPiNumberConstantValueOperation() {
        assertThat(new PrecisePiNumberConstantValueOperation().<BigDecimal>evaluate(context))
                .isEqualByComparingTo(BigDecimalMath.pi(context.mathContext()));
    }

    @Test
    public void testPreciseNumberConstantValueOperation() {
        assertThat(new PreciseNumberConstantValueOperation("0").<BigDecimal>evaluate(context)).isEqualByComparingTo("0");
        assertThat(new PreciseNumberConstantValueOperation("-0.3").<BigDecimal>evaluate(context)).isEqualByComparingTo("-0.3");
        assertThat(new PreciseNumberConstantValueOperation("0.3").<BigDecimal>evaluate(context)).isEqualByComparingTo("0.3");
        assertThat(new PreciseNumberConstantValueOperation("0.0003").<BigDecimal>evaluate(context)).isEqualByComparingTo("0.0003");

        PreciseNumberConstantValueOperation operation = new PreciseNumberConstantValueOperation("-0.3");
        operation.transformToPositiveValue();
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("0.3");
    }

    @Test
    public void testStringConstantValueOperation() {
        assertThat(new StringConstantValueOperation("ABC").<String>evaluate(context)).isEqualTo("ABC");
        assertThat(new StringConstantValueOperation("123").<String>evaluate(context)).isEqualTo("123");
        assertThat(new StringConstantValueOperation("ABC.-123").<String>evaluate(context)).isEqualTo("ABC.-123");
    }

    @Test
    public void testTimeConstantValueOperation() {
        assertThat(new TimeConstantValueOperation("13:11:44").<LocalTime>evaluate(context)).isEqualTo("13:11:44");
        assertThat(new TimeConstantValueOperation("02:12:46").<LocalTime>evaluate(context)).isEqualTo("02:12:46");
        assertThat(new TimeConstantValueOperation("23:13:47").<LocalTime>evaluate(context)).isEqualTo("23:13:47");
    }

    @Test
    public void testNumericVectorValueOperation() {
        assertThat(new VectorValueOperation("[1, 2, 3]", new AbstractOperation[]{
                new PreciseNumberConstantValueOperation("1"),
                new PreciseNumberConstantValueOperation("2"),
                new PreciseNumberConstantValueOperation("3")
        }).expectedType(BigDecimal[].class).<Object[]>evaluate(context))
                .hasSize(3).containsExactly(valueOf(1), valueOf(2), valueOf(3));
    }

    @Test
    public void testLogicalVectorValueOperation() {
        assertThat(new VectorValueOperation("[true, false, false]", new AbstractOperation[]{
                new BooleanConstantValueOperation("true"),
                new BooleanConstantValueOperation("false"),
                new BooleanConstantValueOperation("false")
        }).expectedType(Boolean[].class).<Object[]>evaluate(context))
                .hasSize(3).containsExactly(TRUE, FALSE, FALSE);
    }

    @Test
    public void testLocalDateVectorValueOperation() {
        assertThat(new VectorValueOperation("[2021-01-01, 2021-02-02, 2021-03-04]", new AbstractOperation[]{
                new DateConstantValueOperation("2021-01-01"),
                new DateConstantValueOperation("2021-02-02"),
                new DateConstantValueOperation("2021-03-04")
        }).expectedType(LocalDate[].class).<Object[]>evaluate(context))
                .hasSize(3).containsExactly(LocalDate.parse("2021-01-01"), LocalDate.parse("2021-02-02"), LocalDate.parse("2021-03-04"));
    }

}
