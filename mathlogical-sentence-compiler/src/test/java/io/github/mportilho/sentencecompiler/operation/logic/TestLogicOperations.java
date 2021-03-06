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

package io.github.mportilho.sentencecompiler.operation.logic;

import io.github.mportilho.sentencecompiler.operation.impl.GenericValueOperation;
import io.github.mportilho.sentencecompiler.OperationContext;
import io.github.mportilho.sentencecompiler.testutils.MathSentenceCompilerMockupFactory;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TestLogicOperations {

    private final OperationContext context = MathSentenceCompilerMockupFactory.getPreciseOperationContext();

    @Test
    public void testAndOperation() {
        AndOperation operation;

        operation = new AndOperation(new GenericValueOperation(Boolean.TRUE), new GenericValueOperation(Boolean.TRUE));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new AndOperation(new GenericValueOperation(Boolean.FALSE), new GenericValueOperation(Boolean.TRUE));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new AndOperation(new GenericValueOperation(Boolean.TRUE), new GenericValueOperation(Boolean.FALSE));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new AndOperation(new GenericValueOperation(Boolean.FALSE), new GenericValueOperation(Boolean.FALSE));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();
    }

    @Test
    public void testOrOperation() {
        OrOperation operation;

        operation = new OrOperation(new GenericValueOperation(Boolean.TRUE), new GenericValueOperation(Boolean.TRUE));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new OrOperation(new GenericValueOperation(Boolean.FALSE), new GenericValueOperation(Boolean.TRUE));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new OrOperation(new GenericValueOperation(Boolean.TRUE), new GenericValueOperation(Boolean.FALSE));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new OrOperation(new GenericValueOperation(Boolean.FALSE), new GenericValueOperation(Boolean.FALSE));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();
    }

    @Test
    public void testNandOperation() {
        NandOperation operation;

        operation = new NandOperation(new GenericValueOperation(Boolean.TRUE), new GenericValueOperation(Boolean.TRUE));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new NandOperation(new GenericValueOperation(Boolean.FALSE), new GenericValueOperation(Boolean.TRUE));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new NandOperation(new GenericValueOperation(Boolean.TRUE), new GenericValueOperation(Boolean.FALSE));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new NandOperation(new GenericValueOperation(Boolean.FALSE), new GenericValueOperation(Boolean.FALSE));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();
    }

    @Test
    public void testNorOperation() {
        NorOperation operation;

        operation = new NorOperation(new GenericValueOperation(Boolean.TRUE), new GenericValueOperation(Boolean.TRUE));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new NorOperation(new GenericValueOperation(Boolean.FALSE), new GenericValueOperation(Boolean.TRUE));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new NorOperation(new GenericValueOperation(Boolean.TRUE), new GenericValueOperation(Boolean.FALSE));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new NorOperation(new GenericValueOperation(Boolean.FALSE), new GenericValueOperation(Boolean.FALSE));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();
    }

    @Test
    public void testXnorOperation() {
        XnorOperation operation;

        operation = new XnorOperation(new GenericValueOperation(Boolean.TRUE), new GenericValueOperation(Boolean.TRUE));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new XnorOperation(new GenericValueOperation(Boolean.FALSE), new GenericValueOperation(Boolean.TRUE));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new XnorOperation(new GenericValueOperation(Boolean.TRUE), new GenericValueOperation(Boolean.FALSE));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new XnorOperation(new GenericValueOperation(Boolean.FALSE), new GenericValueOperation(Boolean.FALSE));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();
    }

    @Test
    public void testXorOperation() {
        XorOperation operation;

        operation = new XorOperation(new GenericValueOperation(Boolean.TRUE), new GenericValueOperation(Boolean.TRUE));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new XorOperation(new GenericValueOperation(Boolean.FALSE), new GenericValueOperation(Boolean.TRUE));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new XorOperation(new GenericValueOperation(Boolean.TRUE), new GenericValueOperation(Boolean.FALSE));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new XorOperation(new GenericValueOperation(Boolean.FALSE), new GenericValueOperation(Boolean.FALSE));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();
    }

    @Test
    public void testEqualsOperationWithComparables() {
        EqualsOperation operation;

        operation = new EqualsOperation(new GenericValueOperation("A"), new GenericValueOperation("A"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new EqualsOperation(new GenericValueOperation("A"), new GenericValueOperation("AB"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new EqualsOperation(new GenericValueOperation(1), new GenericValueOperation(1));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new EqualsOperation(new GenericValueOperation(2), new GenericValueOperation(3));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new EqualsOperation(new GenericValueOperation(BigDecimal.ZERO), new GenericValueOperation(new BigDecimal(0)));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new EqualsOperation(new GenericValueOperation(BigDecimal.ZERO), new GenericValueOperation(new BigDecimal(1)));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();
    }

    @Test
    public void testEqualsOperationWithInstances() {
        EqualsOperation operation;

        Object obj1 = new Object();
        Object obj2 = new Object();

        operation = new EqualsOperation(new GenericValueOperation(obj1), new GenericValueOperation(obj1));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new EqualsOperation(new GenericValueOperation(obj1), new GenericValueOperation(obj2));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();
    }

    @Test
    public void testNotEqualsOperationWithComparables() {
        NotEqualsOperation operation;

        operation = new NotEqualsOperation(new GenericValueOperation("A"), new GenericValueOperation("A"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new NotEqualsOperation(new GenericValueOperation("A"), new GenericValueOperation("AB"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new NotEqualsOperation(new GenericValueOperation(1), new GenericValueOperation(1));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new NotEqualsOperation(new GenericValueOperation(2), new GenericValueOperation(3));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new NotEqualsOperation(new GenericValueOperation(BigDecimal.ZERO), new GenericValueOperation(new BigDecimal(0)));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new NotEqualsOperation(new GenericValueOperation(BigDecimal.ZERO), new GenericValueOperation(new BigDecimal(1)));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();
    }

    @Test
    public void testNotEqualsOperationWithInstances() {
        NotEqualsOperation operation;

        Object obj1 = new Object();
        Object obj2 = new Object();

        operation = new NotEqualsOperation(new GenericValueOperation(obj1), new GenericValueOperation(obj1));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new NotEqualsOperation(new GenericValueOperation(obj1), new GenericValueOperation(obj2));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();
    }

    @Test
    public void testGreaterOperation() {
        GreaterOperation operation;

        operation = new GreaterOperation(new GenericValueOperation("A"), new GenericValueOperation("A"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new GreaterOperation(new GenericValueOperation("A"), new GenericValueOperation("AB"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new GreaterOperation(new GenericValueOperation("AB"), new GenericValueOperation("A"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new GreaterOperation(new GenericValueOperation(1), new GenericValueOperation(1));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new GreaterOperation(new GenericValueOperation(2), new GenericValueOperation(3));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new GreaterOperation(new GenericValueOperation(3), new GenericValueOperation(2));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new GreaterOperation(new GenericValueOperation(BigDecimal.ZERO), new GenericValueOperation(new BigDecimal(0)));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new GreaterOperation(new GenericValueOperation(BigDecimal.ZERO), new GenericValueOperation(new BigDecimal(1)));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new GreaterOperation(new GenericValueOperation(new BigDecimal(1)), new GenericValueOperation(BigDecimal.ZERO));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new GreaterOperation(new GenericValueOperation(LocalDate.of(2000, 1, 5)), new GenericValueOperation(LocalDate.of(2000, 1, 5)));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new GreaterOperation(new GenericValueOperation(LocalDate.of(2000, 1, 1)), new GenericValueOperation(LocalDate.of(2000, 1, 5)));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new GreaterOperation(new GenericValueOperation(LocalDate.of(2000, 1, 15)), new GenericValueOperation(LocalDate.of(2000, 1, 5)));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();
    }

    @Test
    public void testGreaterOrEqualsOperation() {
        GreaterOrEqualsOperation operation;

        operation = new GreaterOrEqualsOperation(new GenericValueOperation("A"), new GenericValueOperation("A"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new GreaterOrEqualsOperation(new GenericValueOperation("A"), new GenericValueOperation("AB"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new GreaterOrEqualsOperation(new GenericValueOperation("AB"), new GenericValueOperation("A"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new GreaterOrEqualsOperation(new GenericValueOperation(1), new GenericValueOperation(1));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new GreaterOrEqualsOperation(new GenericValueOperation(2), new GenericValueOperation(3));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new GreaterOrEqualsOperation(new GenericValueOperation(3), new GenericValueOperation(2));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new GreaterOrEqualsOperation(new GenericValueOperation(BigDecimal.ZERO), new GenericValueOperation(new BigDecimal(0)));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new GreaterOrEqualsOperation(new GenericValueOperation(BigDecimal.ZERO), new GenericValueOperation(new BigDecimal(1)));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new GreaterOrEqualsOperation(new GenericValueOperation(new BigDecimal(1)), new GenericValueOperation(BigDecimal.ZERO));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new GreaterOrEqualsOperation(new GenericValueOperation(LocalDate.of(2000, 1, 5)),
                new GenericValueOperation(LocalDate.of(2000, 1, 5)));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new GreaterOrEqualsOperation(new GenericValueOperation(LocalDate.of(2000, 1, 1)),
                new GenericValueOperation(LocalDate.of(2000, 1, 5)));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new GreaterOrEqualsOperation(new GenericValueOperation(LocalDate.of(2000, 1, 15)),
                new GenericValueOperation(LocalDate.of(2000, 1, 5)));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();
    }

    @Test
    public void testLessOperation() {
        LessOperation operation;

        operation = new LessOperation(new GenericValueOperation("A"), new GenericValueOperation("A"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new LessOperation(new GenericValueOperation("A"), new GenericValueOperation("AB"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new LessOperation(new GenericValueOperation("AB"), new GenericValueOperation("A"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new LessOperation(new GenericValueOperation(1), new GenericValueOperation(1));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new LessOperation(new GenericValueOperation(2), new GenericValueOperation(3));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new LessOperation(new GenericValueOperation(3), new GenericValueOperation(2));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new LessOperation(new GenericValueOperation(BigDecimal.ZERO), new GenericValueOperation(new BigDecimal(0)));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new LessOperation(new GenericValueOperation(BigDecimal.ZERO), new GenericValueOperation(new BigDecimal(1)));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new LessOperation(new GenericValueOperation(new BigDecimal(1)), new GenericValueOperation(BigDecimal.ZERO));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new LessOperation(new GenericValueOperation(LocalDate.of(2000, 1, 5)), new GenericValueOperation(LocalDate.of(2000, 1, 5)));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new LessOperation(new GenericValueOperation(LocalDate.of(2000, 1, 1)), new GenericValueOperation(LocalDate.of(2000, 1, 5)));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new LessOperation(new GenericValueOperation(LocalDate.of(2000, 1, 15)), new GenericValueOperation(LocalDate.of(2000, 1, 5)));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();
    }

    @Test
    public void testLessOrEqualsOperation() {
        LessOrEqualsOperation operation;

        operation = new LessOrEqualsOperation(new GenericValueOperation("A"), new GenericValueOperation("A"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new LessOrEqualsOperation(new GenericValueOperation("A"), new GenericValueOperation("AB"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new LessOrEqualsOperation(new GenericValueOperation("AB"), new GenericValueOperation("A"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new LessOrEqualsOperation(new GenericValueOperation(1), new GenericValueOperation(1));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new LessOrEqualsOperation(new GenericValueOperation(2), new GenericValueOperation(3));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new LessOrEqualsOperation(new GenericValueOperation(3), new GenericValueOperation(2));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new LessOrEqualsOperation(new GenericValueOperation(BigDecimal.ZERO), new GenericValueOperation(new BigDecimal(0)));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new LessOrEqualsOperation(new GenericValueOperation(BigDecimal.ZERO), new GenericValueOperation(new BigDecimal(1)));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new LessOrEqualsOperation(new GenericValueOperation(new BigDecimal(1)), new GenericValueOperation(BigDecimal.ZERO));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new LessOrEqualsOperation(new GenericValueOperation(LocalDate.of(2000, 1, 5)),
                new GenericValueOperation(LocalDate.of(2000, 1, 5)));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new LessOrEqualsOperation(new GenericValueOperation(LocalDate.of(2000, 1, 1)),
                new GenericValueOperation(LocalDate.of(2000, 1, 5)));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new LessOrEqualsOperation(new GenericValueOperation(LocalDate.of(2000, 1, 15)),
                new GenericValueOperation(LocalDate.of(2000, 1, 5)));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();
    }

    @Test
    public void testNegationOperation() {
        NegationOperation operation;

        operation = new NegationOperation(new GenericValueOperation(Boolean.TRUE));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new NegationOperation(new GenericValueOperation(Boolean.FALSE));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();
    }

}
