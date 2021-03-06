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

package io.github.mportilho.sentencecompiler.operation.impl;

import io.github.mportilho.sentencecompiler.operation.CloningContext;
import io.github.mportilho.sentencecompiler.operation.datetime.*;
import io.github.mportilho.sentencecompiler.operation.math.precise.PreciseMultiplicationOperation;
import io.github.mportilho.sentencecompiler.operation.math.precise.PreciseNumberRoundingOperation;
import io.github.mportilho.sentencecompiler.operation.math.precise.PreciseNumberRoundingOperation.RoundingEnum;
import io.github.mportilho.sentencecompiler.operation.value.constant.DateConstantValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.constant.DateTimeConstantValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.constant.precise.PreciseNumberConstantValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.constant.TimeConstantValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.variable.SequenceVariableValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.variable.VariableValueOperation;
import io.github.mportilho.sentencecompiler.OperationContext;
import io.github.mportilho.sentencecompiler.testutils.MathSentenceCompilerMockupFactory;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;

public class TestCopingOperations {

    private final OperationContext context = MathSentenceCompilerMockupFactory.getPreciseOperationContext();

    @Test
    public void testCopingUnaryOperation() throws Throwable {
        GenericOperationOne genericOperationOne = new GenericOperationOne();
        GenericUnaryOperation operation = new GenericUnaryOperation(genericOperationOne);

        GenericUnaryOperation copyOperation = (GenericUnaryOperation) operation.copy(new CloningContext());
        GenericOperationOne copyGenericOperationOne = (GenericOperationOne) copyOperation.getOperand();

        GenericUnaryOperation copyOperation2 = (GenericUnaryOperation) copyOperation.copy(new CloningContext());
        GenericOperationOne copyGenericOperationOne2 = (GenericOperationOne) copyOperation2.getOperand();

        assertThat(operation).isNotEqualTo(copyOperation);
        assertThat(genericOperationOne).isNotEqualTo(copyGenericOperationOne);

        assertThat(copyOperation2).isNotEqualTo(copyOperation);
        assertThat(copyGenericOperationOne2).isNotEqualTo(copyGenericOperationOne);
    }

    @Test
    public void testCopingBinaryOperation() throws Throwable {
        GenericOperationOne genericOperationOne = new GenericOperationOne();
        GenericOperationTwo genericOperationTwo = new GenericOperationTwo();
        GenericBinaryOperation operation = new GenericBinaryOperation(genericOperationOne, genericOperationTwo);

        GenericBinaryOperation copyOperation = (GenericBinaryOperation) operation.copy(new CloningContext());
        GenericOperationOne copyGenericOperationOne = (GenericOperationOne) copyOperation.getLeftOperand();
        GenericOperationTwo copyGenericOperationTwo = (GenericOperationTwo) copyOperation.getRightOperand();

        GenericBinaryOperation copyOperation2 = (GenericBinaryOperation) operation.copy(new CloningContext());
        GenericOperationOne copyGenericOperationOne_2 = (GenericOperationOne) copyOperation2.getLeftOperand();
        GenericOperationTwo copyGenericOperationTwo_2 = (GenericOperationTwo) copyOperation2.getRightOperand();

        assertThat(operation).isNotEqualTo(copyOperation);
        assertThat(genericOperationOne).isNotEqualTo(copyGenericOperationOne);
        assertThat(genericOperationTwo).isNotEqualTo(copyGenericOperationTwo);

        assertThat(copyOperation2).isNotEqualTo(copyOperation);
        assertThat(copyGenericOperationOne_2).isNotEqualTo(copyGenericOperationOne);
        assertThat(copyGenericOperationTwo_2).isNotEqualTo(copyGenericOperationTwo);
    }

    @Test
    public void testCopingImplicitMultiplicationOperation() throws Throwable {
        PreciseMultiplicationOperation operation = new PreciseMultiplicationOperation(new PreciseNumberConstantValueOperation("2"),
                new PreciseNumberConstantValueOperation("3"), true);
        PreciseMultiplicationOperation copy = (PreciseMultiplicationOperation) operation.copy(new CloningContext());

        assertThat(operation).isNotEqualTo(copy);
        assertThat(operation.isImplicit()).isEqualTo(copy.isImplicit());
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("6");
        assertThat(copy.<BigDecimal>evaluate(context)).isEqualByComparingTo("6");
    }

    @Test
    public void testCopingPreciseRoundingOperation() throws Throwable {
        PreciseNumberRoundingOperation operation = new PreciseNumberRoundingOperation(new PreciseNumberConstantValueOperation("2.355"),
                new PreciseNumberConstantValueOperation("2"), RoundingEnum.HALF_EVEN);
        PreciseNumberRoundingOperation copy = (PreciseNumberRoundingOperation) operation.copy(new CloningContext());

        assertThat(operation).isNotEqualTo(copy);
        assertThat(operation.getRoundingEnum()).isEqualTo(copy.getRoundingEnum());
        assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("2.36");
        assertThat(copy.<BigDecimal>evaluate(context)).isEqualByComparingTo("2.36");
    }

    @Test
    public void testCopingConstantValueOperation() throws Throwable {
        PreciseNumberConstantValueOperation operation = new PreciseNumberConstantValueOperation("3");
        PreciseNumberConstantValueOperation copyOperation = (PreciseNumberConstantValueOperation) operation.copy(new CloningContext());
        assertThat(copyOperation).isNotEqualTo(operation);
        assertThat(copyOperation.getValue()).isEqualTo(((PreciseNumberConstantValueOperation) operation).getValue());
    }

    @Test
    public void testCopingDateOperations() throws Throwable {
        OperationContext context = MathSentenceCompilerMockupFactory.getPreciseOperationContext(true);
        AbstractDateTimeOperation operation;
        AbstractDateTimeOperation copyOperation;

        operation = new DateAdditionOperation(new DateConstantValueOperation(LocalDate.now().toString()),
                new PreciseNumberConstantValueOperation("2"), DateElementEnum.DAY);
        copyOperation = (AbstractDateTimeOperation) operation.copy(new CloningContext());
        assertThat(operation.<LocalDate>evaluate(context)).isNotNull().isEqualTo(LocalDate.now().plusDays(2));
        assertThat(copyOperation).isNotEqualTo(operation);
        assertThat(copyOperation.<LocalDate>evaluate(context)).isNotNull().isEqualTo(LocalDate.now().plusDays(2));

        operation = new DateTimeAdditionOperation(new DateTimeConstantValueOperation(LocalDateTime.now().toString(), null),
                new PreciseNumberConstantValueOperation("2"),
                DateElementEnum.DAY);
        copyOperation = (AbstractDateTimeOperation) operation.copy(new CloningContext());
        assertThat(operation.<ZonedDateTime>evaluate(context).toLocalDate()).isNotNull().isEqualTo(LocalDate.now().plusDays(2));
        assertThat(copyOperation).isNotEqualTo(operation);
        assertThat(copyOperation.<ZonedDateTime>evaluate(context).toLocalDate()).isNotNull().isEqualTo(LocalDate.now().plusDays(2));

        operation = new TimeAdditionOperation(new TimeConstantValueOperation(LocalTime.now().toString()),
                new PreciseNumberConstantValueOperation("2"), DateElementEnum.MINUTE);
        copyOperation = (AbstractDateTimeOperation) operation.copy(new CloningContext());
        assertThat(operation.<LocalTime>evaluate(context).getMinute()).isNotNull().isEqualTo(LocalTime.now().plusMinutes(2).getMinute());
        assertThat(copyOperation).isNotEqualTo(operation);
        assertThat(copyOperation.<LocalTime>evaluate(context).getMinute()).isNotNull().isEqualTo(LocalTime.now().plusMinutes(2).getMinute());
    }

    @Test
    public void testCopingProvidedVariableValueOperations() throws Throwable {
        OperationContext context = MathSentenceCompilerMockupFactory.getPreciseOperationContext(true);
        VariableValueOperation operation;
        VariableValueOperation copy;

        operation = new VariableValueOperation("A");
        operation.configureCaching(false);

        copy = (VariableValueOperation) operation.copy(new CloningContext());
        assertThat(copy).isNotEqualTo(operation);
        assertThat(copy.getVariableName()).isEqualTo(operation.getVariableName());
        assertThat(operation.<Object>evaluate(context)).isNull();
        assertThat(copy.<Object>evaluate(context)).isNull();

        operation.setValue(3);
        assertThat(copy).isNotEqualTo(operation);
        assertThat(copy.getVariableName()).isEqualTo(operation.getVariableName());
        assertThat(operation.<Object>evaluate(context)).isNotNull().isEqualTo(3);
        assertThat(copy.<Object>evaluate(context)).isNull();

        operation.setValue(4);
        copy = (VariableValueOperation) operation.copy(new CloningContext());
        assertThat(copy).isNotEqualTo(operation);
        assertThat(copy.getVariableName()).isEqualTo(operation.getVariableName());
        assertThat(operation.<Object>evaluate(context)).isNotNull().isEqualTo(4);
        assertThat(copy.<Object>evaluate(context)).isNotNull().isEqualTo(4);
    }

    @Test
    public void testCopingSequenceVariableValueOperations() throws Throwable {
        OperationContext context = MathSentenceCompilerMockupFactory.getPreciseOperationContext(true);
        SequenceVariableValueOperation operation;
        SequenceVariableValueOperation copy;

        operation = new SequenceVariableValueOperation("A");
        operation.configureCaching(false);

        copy = (SequenceVariableValueOperation) operation.copy(new CloningContext());
        assertThat(copy).isNotEqualTo(operation);
        assertThat(copy.getVariableName()).isEqualTo(operation.getVariableName());
        assertThat(operation.<Object>evaluate(context)).isNull();
        assertThat(copy.<Object>evaluate(context)).isNull();

        operation.setValue(3);
        assertThat(copy).isNotEqualTo(operation);
        assertThat(copy.getVariableName()).isEqualTo(operation.getVariableName());
        assertThat(operation.<Object>evaluate(context)).isNotNull().isEqualTo(3);
        assertThat(copy.<Object>evaluate(context)).isNull();

        operation.setValue(4);
        copy = (SequenceVariableValueOperation) operation.copy(new CloningContext());
        assertThat(copy).isNotEqualTo(operation);
        assertThat(copy.getVariableName()).isEqualTo(operation.getVariableName());
        assertThat(operation.<Object>evaluate(context)).isNotNull().isEqualTo(4);
        assertThat(copy.<Object>evaluate(context)).isNotNull().isEqualTo(4);
    }

}
