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
import io.github.mportilho.sentencecompiler.exceptions.SentenceExecutionException;
import io.github.mportilho.sentencecompiler.operation.value.constant.DateConstantValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.constant.precise.PreciseNumberConstantValueOperation;
import io.github.mportilho.sentencecompiler.testutils.MathSentenceCompilerMockupFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestDateOperations {

    private final OperationContext context = MathSentenceCompilerMockupFactory.getPreciseOperationContext();

    @Test
    public void testDateAdditionOperation() {
        DateAdditionOperation operation;

        operation = new DateAdditionOperation(new DateConstantValueOperation("2000-03-02"), new PreciseNumberConstantValueOperation("2"),
                DateElementEnum.DAY);
        assertThat(operation.<LocalDate>evaluate(context)).isEqualTo("2000-03-04");

        operation = new DateAdditionOperation(new DateConstantValueOperation("2000-03-02"), new PreciseNumberConstantValueOperation("2"),
                DateElementEnum.MONTH);
        assertThat(operation.<LocalDate>evaluate(context)).isEqualTo("2000-05-02");

        operation = new DateAdditionOperation(new DateConstantValueOperation("2000-03-02"), new PreciseNumberConstantValueOperation("2"),
                DateElementEnum.YEAR);
        assertThat(operation.<LocalDate>evaluate(context)).isEqualTo("2002-03-02");
    }

    @Test
    public void testDateSetOperation() {
        DateSetOperation operation;

        operation = new DateSetOperation(new DateConstantValueOperation("2000-03-25"), new PreciseNumberConstantValueOperation("2"),
                DateElementEnum.DAY);
        assertThat(operation.<LocalDate>evaluate(context)).isEqualTo("2000-03-02");

        operation = new DateSetOperation(new DateConstantValueOperation("2000-03-02"), new PreciseNumberConstantValueOperation("2"),
                DateElementEnum.MONTH);
        assertThat(operation.<LocalDate>evaluate(context)).isEqualTo("2000-02-02");

        operation = new DateSetOperation(new DateConstantValueOperation("2000-03-02"), new PreciseNumberConstantValueOperation("2020"),
                DateElementEnum.YEAR);
        assertThat(operation.<LocalDate>evaluate(context)).isEqualTo("2020-03-02");
    }

    @Test
    public void testDateSubtractionOperation() {
        DateSubtractionOperation operation;

        operation = new DateSubtractionOperation(new DateConstantValueOperation("2000-03-02"), new PreciseNumberConstantValueOperation("2"),
                DateElementEnum.DAY);
        assertThat(operation.<LocalDate>evaluate(context)).isEqualTo("2000-02-29");

        operation = new DateSubtractionOperation(new DateConstantValueOperation("2000-03-02"), new PreciseNumberConstantValueOperation("2"),
                DateElementEnum.MONTH);
        assertThat(operation.<LocalDate>evaluate(context)).isEqualTo("2000-01-02");

        operation = new DateSubtractionOperation(new DateConstantValueOperation("2000-03-02"), new PreciseNumberConstantValueOperation("2"),
                DateElementEnum.YEAR);
        assertThat(operation.<LocalDate>evaluate(context)).isEqualTo("1998-03-02");
    }

    @Test
    public void testDateAdditionOperation_WithInvalidDateElement() {
        DateAdditionOperation operation1 = new DateAdditionOperation(new DateConstantValueOperation("2000-03-02"),
                new PreciseNumberConstantValueOperation("2"), DateElementEnum.HOUR);
        assertThatThrownBy(() -> operation1.<LocalDate>evaluate(context)).isInstanceOf(SentenceExecutionException.class);

        DateAdditionOperation operation2 = new DateAdditionOperation(new DateConstantValueOperation("2000-03-02"),
                new PreciseNumberConstantValueOperation("2"), DateElementEnum.MINUTE);
        assertThatThrownBy(() -> operation2.<LocalDate>evaluate(context)).isInstanceOf(SentenceExecutionException.class);

        DateAdditionOperation operation3 = new DateAdditionOperation(new DateConstantValueOperation("2000-03-02"),
                new PreciseNumberConstantValueOperation("2"), DateElementEnum.SECOND);
        assertThatThrownBy(() -> operation3.<LocalDate>evaluate(context)).isInstanceOf(SentenceExecutionException.class);

    }

    @Test
    public void testDateSetOperation_WithInvalidDateElement() {
        DateSetOperation operation4 = new DateSetOperation(new DateConstantValueOperation("2000-03-25"),
                new PreciseNumberConstantValueOperation("2"), DateElementEnum.HOUR);
        assertThatThrownBy(() -> operation4.<LocalDate>evaluate(context)).isInstanceOf(SentenceExecutionException.class);

        DateSetOperation operation5 = new DateSetOperation(new DateConstantValueOperation("2000-03-02"), new PreciseNumberConstantValueOperation("2"),
                DateElementEnum.MINUTE);
        assertThatThrownBy(() -> operation5.<LocalDate>evaluate(context)).isInstanceOf(SentenceExecutionException.class);

        DateSetOperation operation6 = new DateSetOperation(new DateConstantValueOperation("2000-03-02"),
                new PreciseNumberConstantValueOperation("2020"), DateElementEnum.SECOND);
        assertThatThrownBy(() -> operation6.<LocalDate>evaluate(context)).isInstanceOf(SentenceExecutionException.class);
    }

    @Test
    public void testDateSubtractionOperation_WithInvalidDateElement() {
        DateSubtractionOperation operation7 = new DateSubtractionOperation(new DateConstantValueOperation("2000-03-02"),
                new PreciseNumberConstantValueOperation("2"), DateElementEnum.HOUR);
        assertThatThrownBy(() -> operation7.<LocalDate>evaluate(context)).isInstanceOf(SentenceExecutionException.class);

        DateSubtractionOperation operation8 = new DateSubtractionOperation(new DateConstantValueOperation("2000-03-02"),
                new PreciseNumberConstantValueOperation("2"), DateElementEnum.MINUTE);
        assertThatThrownBy(() -> operation8.<LocalDate>evaluate(context)).isInstanceOf(SentenceExecutionException.class);

        DateSubtractionOperation operation9 = new DateSubtractionOperation(new DateConstantValueOperation("2000-03-02"),
                new PreciseNumberConstantValueOperation("2"), DateElementEnum.SECOND);
        assertThatThrownBy(() -> operation9.<LocalDate>evaluate(context)).isInstanceOf(SentenceExecutionException.class);
    }

}
