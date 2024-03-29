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

package io.github.mportilho.sentencecompiler.operation.datetime;

import io.github.mportilho.sentencecompiler.OperationContext;
import io.github.mportilho.sentencecompiler.operation.value.constant.DateTimeConstantValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.constant.precise.PreciseNumberConstantValueOperation;
import io.github.mportilho.sentencecompiler.testutils.MathSentenceCompilerMockupFactory;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class TestDateTimeOperations {

    private final OperationContext context = MathSentenceCompilerMockupFactory.getPreciseOperationContext();

    @Test
    public void testDateTimeAdditionOperation() {
        DateTimeAdditionOperation operation;

        operation = new DateTimeAdditionOperation(
                new DateTimeConstantValueOperation("2000-03-02T23:55:50", null),
                new PreciseNumberConstantValueOperation("2"), DateElementEnum.DAY);
        assertThat(operation.<ZonedDateTime>evaluate(context).toLocalDateTime()).isEqualTo("2000-03-04T23:55:50");

        operation = new DateTimeAdditionOperation(new DateTimeConstantValueOperation("2000-03-02T23:55:50", null),
                new PreciseNumberConstantValueOperation("2"), DateElementEnum.MONTH);
        assertThat(operation.<ZonedDateTime>evaluate(context).toLocalDateTime()).isEqualTo("2000-05-02T23:55:50");

        operation = new DateTimeAdditionOperation(new DateTimeConstantValueOperation("2000-03-02T23:55:50", null),
                new PreciseNumberConstantValueOperation("2"), DateElementEnum.YEAR);
        assertThat(operation.<ZonedDateTime>evaluate(context).toLocalDateTime()).isEqualTo("2002-03-02T23:55:50");

        operation = new DateTimeAdditionOperation(new DateTimeConstantValueOperation("2000-03-02T23:55:50", null),
                new PreciseNumberConstantValueOperation("2"), DateElementEnum.HOUR);
        assertThat(operation.<ZonedDateTime>evaluate(context).toLocalDateTime()).isEqualTo("2000-03-03T01:55:50");

        operation = new DateTimeAdditionOperation(new DateTimeConstantValueOperation("2000-03-02T23:55:50", null),
                new PreciseNumberConstantValueOperation("2"), DateElementEnum.MINUTE);
        assertThat(operation.<ZonedDateTime>evaluate(context).toLocalDateTime()).isEqualTo("2000-03-02T23:57:50");

        operation = new DateTimeAdditionOperation(new DateTimeConstantValueOperation("2000-03-02T23:55:50", null),
                new PreciseNumberConstantValueOperation("2"), DateElementEnum.SECOND);
        assertThat(operation.<ZonedDateTime>evaluate(context).toLocalDateTime()).isEqualTo("2000-03-02T23:55:52");
    }

    @Test
    public void testDateTimeSetOperation() {
        DateTimeSetOperation operation;

        operation = new DateTimeSetOperation(new DateTimeConstantValueOperation("2000-03-02T23:55:50", null),
                new PreciseNumberConstantValueOperation("2"), DateElementEnum.DAY);
        assertThat(operation.<ZonedDateTime>evaluate(context).toLocalDateTime()).isEqualTo("2000-03-02T23:55:50");

        operation = new DateTimeSetOperation(new DateTimeConstantValueOperation("2000-03-02T23:55:50", null),
                new PreciseNumberConstantValueOperation("2"), DateElementEnum.MONTH);
        assertThat(operation.<ZonedDateTime>evaluate(context).toLocalDateTime()).isEqualTo("2000-02-02T23:55:50");

        operation = new DateTimeSetOperation(new DateTimeConstantValueOperation("2000-03-02T23:55:50", null),
                new PreciseNumberConstantValueOperation("2020"), DateElementEnum.YEAR);
        assertThat(operation.<ZonedDateTime>evaluate(context).toLocalDateTime()).isEqualTo("2020-03-02T23:55:50");

        operation = new DateTimeSetOperation(new DateTimeConstantValueOperation("2000-03-02T23:55:50", null),
                new PreciseNumberConstantValueOperation("2"), DateElementEnum.HOUR);
        assertThat(operation.<ZonedDateTime>evaluate(context).toLocalDateTime()).isEqualTo("2000-03-02T02:55:50");

        operation = new DateTimeSetOperation(new DateTimeConstantValueOperation("2000-03-02T23:55:50", null),
                new PreciseNumberConstantValueOperation("2"), DateElementEnum.MINUTE);
        assertThat(operation.<ZonedDateTime>evaluate(context).toLocalDateTime()).isEqualTo("2000-03-02T23:02:50");

        operation = new DateTimeSetOperation(new DateTimeConstantValueOperation("2000-03-02T23:55:50", null),
                new PreciseNumberConstantValueOperation("2"), DateElementEnum.SECOND);
        assertThat(operation.<ZonedDateTime>evaluate(context).toLocalDateTime()).isEqualTo("2000-03-02T23:55:02");
    }

    @Test
    public void testDateTimeSubtractionOperation() {
        DateTimeSubtractionOperation operation;

        operation = new DateTimeSubtractionOperation(new DateTimeConstantValueOperation("2000-03-02T23:55:50", null),
                new PreciseNumberConstantValueOperation("2"), DateElementEnum.DAY);
        assertThat(operation.<ZonedDateTime>evaluate(context).toLocalDateTime()).isEqualTo("2000-02-29T23:55:50");

        operation = new DateTimeSubtractionOperation(new DateTimeConstantValueOperation("2000-03-02T23:55:50", null),
                new PreciseNumberConstantValueOperation("2"), DateElementEnum.MONTH);
        assertThat(operation.<ZonedDateTime>evaluate(context).toLocalDateTime()).isEqualTo("2000-01-02T23:55:50");

        operation = new DateTimeSubtractionOperation(new DateTimeConstantValueOperation("2000-03-02T23:55:50", null),
                new PreciseNumberConstantValueOperation("2"), DateElementEnum.YEAR);
        assertThat(operation.<ZonedDateTime>evaluate(context).toLocalDateTime()).isEqualTo("1998-03-02T23:55:50");

        operation = new DateTimeSubtractionOperation(new DateTimeConstantValueOperation("2000-03-02T23:55:50", null),
                new PreciseNumberConstantValueOperation("2"), DateElementEnum.HOUR);
        assertThat(operation.<ZonedDateTime>evaluate(context).toLocalDateTime()).isEqualTo("2000-03-02T21:55:50");

        operation = new DateTimeSubtractionOperation(new DateTimeConstantValueOperation("2000-03-02T23:55:50", null),
                new PreciseNumberConstantValueOperation("2"), DateElementEnum.MINUTE);
        assertThat(operation.<ZonedDateTime>evaluate(context).toLocalDateTime()).isEqualTo("2000-03-02T23:53:50");

        operation = new DateTimeSubtractionOperation(new DateTimeConstantValueOperation("2000-03-02T23:55:50", null),
                new PreciseNumberConstantValueOperation("2"), DateElementEnum.SECOND);
        assertThat(operation.<ZonedDateTime>evaluate(context).toLocalDateTime()).isEqualTo("2000-03-02T23:55:48");
    }

}
