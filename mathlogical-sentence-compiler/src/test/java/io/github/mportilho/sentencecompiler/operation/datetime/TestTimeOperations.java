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

package io.github.mportilho.sentencecompiler.operation.datetime;

import io.github.mportilho.sentencecompiler.exceptions.SyntaxExecutionException;
import io.github.mportilho.sentencecompiler.operation.impl.GenericValueOperation;
import io.github.mportilho.sentencecompiler.syntaxtree.OperationContext;
import io.github.mportilho.sentencecompiler.testutils.MathSentenceCompilerMockupFactory;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import static java.math.BigDecimal.valueOf;

public class TestTimeOperations {

    private final OperationContext context = MathSentenceCompilerMockupFactory.getOperationContext();

    @Test
    public void testTimeAdditionOperation() {
        TimeAdditionOperation operation;

        operation = new TimeAdditionOperation(new GenericValueOperation(LocalTime.of(23, 55, 50)), new GenericValueOperation(valueOf(2)),
                DateElementEnum.HOUR);
        assertThat(operation.<LocalTime>evaluate(context)).isEqualTo("01:55:50");

        operation = new TimeAdditionOperation(new GenericValueOperation(LocalTime.of(23, 55, 50)), new GenericValueOperation(valueOf(2)),
                DateElementEnum.MINUTE);
        assertThat(operation.<LocalTime>evaluate(context)).isEqualTo("23:57:50");

        operation = new TimeAdditionOperation(new GenericValueOperation(LocalTime.of(23, 55, 50)), new GenericValueOperation(valueOf(2)),
                DateElementEnum.SECOND);
        assertThat(operation.<LocalTime>evaluate(context)).isEqualTo("23:55:52");
    }

    @Test
    public void testTimeSetOperation() {
        TimeSetOperation operation;

        operation = new TimeSetOperation(new GenericValueOperation(LocalTime.of(23, 55, 50)), new GenericValueOperation(valueOf(2)),
                DateElementEnum.HOUR);
        assertThat(operation.<LocalTime>evaluate(context)).isEqualTo("02:55:50");

        operation = new TimeSetOperation(new GenericValueOperation(LocalTime.of(23, 55, 50)), new GenericValueOperation(valueOf(2)),
                DateElementEnum.MINUTE);
        assertThat(operation.<LocalTime>evaluate(context)).isEqualTo("23:02:50");

        operation = new TimeSetOperation(new GenericValueOperation(LocalTime.of(23, 55, 50)), new GenericValueOperation(valueOf(2)),
                DateElementEnum.SECOND);
        assertThat(operation.<LocalTime>evaluate(context)).isEqualTo("23:55:02");
    }

    @Test
    public void testTimeSubtractionOperation() {
        TimeSubtractionOperation operation;

        operation = new TimeSubtractionOperation(new GenericValueOperation(LocalTime.of(23, 55, 50)), new GenericValueOperation(valueOf(2)),
                DateElementEnum.HOUR);
        assertThat(operation.<LocalTime>evaluate(context)).isEqualTo("21:55:50");

        operation = new TimeSubtractionOperation(new GenericValueOperation(LocalTime.of(23, 55, 50)), new GenericValueOperation(valueOf(2)),
                DateElementEnum.MINUTE);
        assertThat(operation.<LocalTime>evaluate(context)).isEqualTo("23:53:50");

        operation = new TimeSubtractionOperation(new GenericValueOperation(LocalTime.of(23, 55, 50)), new GenericValueOperation(valueOf(2)),
                DateElementEnum.SECOND);
        assertThat(operation.<LocalTime>evaluate(context)).isEqualTo("23:55:48");
    }

    @Test
    public void testTimeAdditionOperation_WithInvalidDateElement() {
        TimeAdditionOperation operation1 = new TimeAdditionOperation(
                new GenericValueOperation(LocalTime.of(23, 55, 50)),
                new GenericValueOperation(valueOf(2)), DateElementEnum.DAY);
        assertThatThrownBy(() -> operation1.<LocalDate>evaluate(context)).isInstanceOf(SyntaxExecutionException.class);

        TimeAdditionOperation operation2 = new TimeAdditionOperation(
                new GenericValueOperation(LocalTime.of(23, 55, 50)),
                new GenericValueOperation(valueOf(2)), DateElementEnum.MONTH);
        assertThatThrownBy(() -> operation2.<LocalDate>evaluate(context)).isInstanceOf(SyntaxExecutionException.class);

        TimeAdditionOperation operation3 = new TimeAdditionOperation(
                new GenericValueOperation(LocalTime.of(23, 55, 50)),
                new GenericValueOperation(valueOf(2)), DateElementEnum.YEAR);
        assertThatThrownBy(() -> operation3.<LocalDate>evaluate(context)).isInstanceOf(SyntaxExecutionException.class);
    }

    @Test
    public void testTimeSetOperation_WithInvalidDateElement() {
        TimeSetOperation operation1 = new TimeSetOperation(
                new GenericValueOperation(LocalTime.of(23, 55, 50)), new GenericValueOperation(valueOf(2)),
                DateElementEnum.DAY);
        assertThatThrownBy(() -> operation1.<LocalDate>evaluate(context)).isInstanceOf(SyntaxExecutionException.class);

        TimeSetOperation operation2 = new TimeSetOperation(
                new GenericValueOperation(LocalTime.of(23, 55, 50)), new GenericValueOperation(valueOf(2)),
                DateElementEnum.MONTH);
        assertThatThrownBy(() -> operation2.<LocalDate>evaluate(context)).isInstanceOf(SyntaxExecutionException.class);

        TimeSetOperation operation3 = new TimeSetOperation(
                new GenericValueOperation(LocalTime.of(23, 55, 50)), new GenericValueOperation(valueOf(2)),
                DateElementEnum.YEAR);
        assertThatThrownBy(() -> operation3.<LocalDate>evaluate(context)).isInstanceOf(SyntaxExecutionException.class);
    }

    @Test
    public void testTimeSubtractionOperation_WithInvalidDateElement() {
        TimeSubtractionOperation operation1 = new TimeSubtractionOperation(
                new GenericValueOperation(LocalTime.of(23, 55, 50)),
                new GenericValueOperation(valueOf(2)), DateElementEnum.DAY);
        assertThatThrownBy(() -> operation1.<LocalDate>evaluate(context)).isInstanceOf(SyntaxExecutionException.class);

        TimeSubtractionOperation operation2 = new TimeSubtractionOperation(
                new GenericValueOperation(LocalTime.of(23, 55, 50)),
                new GenericValueOperation(valueOf(2)), DateElementEnum.MONTH);
        assertThatThrownBy(() -> operation2.<LocalDate>evaluate(context)).isInstanceOf(SyntaxExecutionException.class);

        TimeSubtractionOperation operation3 = new TimeSubtractionOperation(
                new GenericValueOperation(LocalTime.of(23, 55, 50)),
                new GenericValueOperation(valueOf(2)), DateElementEnum.YEAR);
        assertThatThrownBy(() -> operation3.<LocalDate>evaluate(context)).isInstanceOf(SyntaxExecutionException.class);
    }

}
