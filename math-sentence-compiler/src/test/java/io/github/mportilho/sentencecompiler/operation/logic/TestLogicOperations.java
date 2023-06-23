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

import io.github.mportilho.sentencecompiler.OperationContext;
import io.github.mportilho.sentencecompiler.operation.impl.GenericValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.constant.BooleanConstantValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.constant.StringConstantValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.constant.precise.PreciseNumberConstantValueOperation;
import io.github.mportilho.sentencecompiler.testutils.MathSentenceCompilerMockupFactory;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class TestLogicOperations {

    private final OperationContext context = MathSentenceCompilerMockupFactory.getPreciseOperationContext();

    @Test
    public void testAndOperation() {
        AndOperation operation;

        operation = new AndOperation(new BooleanConstantValueOperation("true"), new BooleanConstantValueOperation("true"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new AndOperation(new BooleanConstantValueOperation("false"), new BooleanConstantValueOperation("true"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new AndOperation(new BooleanConstantValueOperation("true"), new BooleanConstantValueOperation("false"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new AndOperation(new BooleanConstantValueOperation("false"), new BooleanConstantValueOperation("false"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();
    }

    @Test
    public void testOrOperation() {
        OrOperation operation;

        operation = new OrOperation(new BooleanConstantValueOperation("true"), new BooleanConstantValueOperation("true"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new OrOperation(new BooleanConstantValueOperation("false"), new BooleanConstantValueOperation("true"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new OrOperation(new BooleanConstantValueOperation("true"), new BooleanConstantValueOperation("false"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new OrOperation(new BooleanConstantValueOperation("false"), new BooleanConstantValueOperation("false"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();
    }

    @Test
    public void testNandOperation() {
        NandOperation operation;

        operation = new NandOperation(new BooleanConstantValueOperation("true"), new BooleanConstantValueOperation("true"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new NandOperation(new BooleanConstantValueOperation("false"), new BooleanConstantValueOperation("true"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new NandOperation(new BooleanConstantValueOperation("true"), new BooleanConstantValueOperation("false"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new NandOperation(new BooleanConstantValueOperation("false"), new BooleanConstantValueOperation("false"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();
    }

    @Test
    public void testNorOperation() {
        NorOperation operation;

        operation = new NorOperation(new BooleanConstantValueOperation("true"), new BooleanConstantValueOperation("true"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new NorOperation(new BooleanConstantValueOperation("false"), new BooleanConstantValueOperation("true"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new NorOperation(new BooleanConstantValueOperation("true"), new BooleanConstantValueOperation("false"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new NorOperation(new BooleanConstantValueOperation("false"), new BooleanConstantValueOperation("false"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();
    }

    @Test
    public void testXnorOperation() {
        XnorOperation operation;

        operation = new XnorOperation(new BooleanConstantValueOperation("true"), new BooleanConstantValueOperation("true"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new XnorOperation(new BooleanConstantValueOperation("false"), new BooleanConstantValueOperation("true"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new XnorOperation(new BooleanConstantValueOperation("true"), new BooleanConstantValueOperation("false"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new XnorOperation(new BooleanConstantValueOperation("false"), new BooleanConstantValueOperation("false"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();
    }

    @Test
    public void testXorOperation() {
        XorOperation operation;

        operation = new XorOperation(new BooleanConstantValueOperation("true"), new BooleanConstantValueOperation("true"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new XorOperation(new BooleanConstantValueOperation("false"), new BooleanConstantValueOperation("true"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new XorOperation(new BooleanConstantValueOperation("true"), new BooleanConstantValueOperation("false"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new XorOperation(new BooleanConstantValueOperation("false"), new BooleanConstantValueOperation("false"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();
    }

    @Test
    public void testEqualsOperationWithComparable() {
        EqualsOperation operation;

        operation = new EqualsOperation(new StringConstantValueOperation("A"), new StringConstantValueOperation("A"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new EqualsOperation(new StringConstantValueOperation("A"), new StringConstantValueOperation("AB"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new EqualsOperation(new PreciseNumberConstantValueOperation("1"), new PreciseNumberConstantValueOperation("1"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new EqualsOperation(new PreciseNumberConstantValueOperation("2"), new PreciseNumberConstantValueOperation("3"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new EqualsOperation(new PreciseNumberConstantValueOperation("0"), new PreciseNumberConstantValueOperation("0"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new EqualsOperation(new PreciseNumberConstantValueOperation("0"), new PreciseNumberConstantValueOperation("1"));
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
    public void testNotEqualsOperationWithComparable() {
        NotEqualsOperation operation;

        operation = new NotEqualsOperation(new StringConstantValueOperation("A"), new StringConstantValueOperation("A"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new NotEqualsOperation(new StringConstantValueOperation("A"), new StringConstantValueOperation("AB"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new NotEqualsOperation(new PreciseNumberConstantValueOperation("1"), new PreciseNumberConstantValueOperation("1"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new NotEqualsOperation(new PreciseNumberConstantValueOperation("2"), new PreciseNumberConstantValueOperation("3"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new NotEqualsOperation(new PreciseNumberConstantValueOperation("0"), new PreciseNumberConstantValueOperation("0"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new NotEqualsOperation(new PreciseNumberConstantValueOperation("0"), new PreciseNumberConstantValueOperation("1"));
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

        operation = new GreaterOperation(new StringConstantValueOperation("A"), new StringConstantValueOperation("A"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new GreaterOperation(new StringConstantValueOperation("A"), new StringConstantValueOperation("AB"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new GreaterOperation(new StringConstantValueOperation("AB"), new StringConstantValueOperation("A"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new GreaterOperation(new PreciseNumberConstantValueOperation("1"), new PreciseNumberConstantValueOperation("1"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new GreaterOperation(new PreciseNumberConstantValueOperation("2"), new PreciseNumberConstantValueOperation("3"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new GreaterOperation(new PreciseNumberConstantValueOperation("3"), new PreciseNumberConstantValueOperation("2"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new GreaterOperation(new PreciseNumberConstantValueOperation("0"), new PreciseNumberConstantValueOperation("0"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new GreaterOperation(new PreciseNumberConstantValueOperation("0"), new PreciseNumberConstantValueOperation("1"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new GreaterOperation(new PreciseNumberConstantValueOperation("1"), new PreciseNumberConstantValueOperation("0"));
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

        operation = new GreaterOrEqualsOperation(new StringConstantValueOperation("A"), new StringConstantValueOperation("A"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new GreaterOrEqualsOperation(new StringConstantValueOperation("A"), new StringConstantValueOperation("AB"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new GreaterOrEqualsOperation(new StringConstantValueOperation("AB"), new StringConstantValueOperation("A"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new GreaterOrEqualsOperation(new PreciseNumberConstantValueOperation("1"), new PreciseNumberConstantValueOperation("1"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new GreaterOrEqualsOperation(new PreciseNumberConstantValueOperation("2"), new PreciseNumberConstantValueOperation("3"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new GreaterOrEqualsOperation(new PreciseNumberConstantValueOperation("3"), new PreciseNumberConstantValueOperation("2"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new GreaterOrEqualsOperation(new PreciseNumberConstantValueOperation("0"), new PreciseNumberConstantValueOperation("0"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new GreaterOrEqualsOperation(new PreciseNumberConstantValueOperation("0"), new PreciseNumberConstantValueOperation("1"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new GreaterOrEqualsOperation(new PreciseNumberConstantValueOperation("1"), new PreciseNumberConstantValueOperation("0"));
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

        operation = new LessOperation(new StringConstantValueOperation("A"), new StringConstantValueOperation("A"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new LessOperation(new StringConstantValueOperation("A"), new StringConstantValueOperation("AB"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new LessOperation(new StringConstantValueOperation("AB"), new StringConstantValueOperation("A"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new LessOperation(new PreciseNumberConstantValueOperation("1"), new PreciseNumberConstantValueOperation("1"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new LessOperation(new PreciseNumberConstantValueOperation("2"), new PreciseNumberConstantValueOperation("3"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new LessOperation(new PreciseNumberConstantValueOperation("3"), new PreciseNumberConstantValueOperation("2"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new LessOperation(new PreciseNumberConstantValueOperation("0"), new PreciseNumberConstantValueOperation("0"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new LessOperation(new PreciseNumberConstantValueOperation("0"), new PreciseNumberConstantValueOperation("1"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new LessOperation(new PreciseNumberConstantValueOperation("1"), new PreciseNumberConstantValueOperation("0"));
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

        operation = new LessOrEqualsOperation(new StringConstantValueOperation("A"), new StringConstantValueOperation("A"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new LessOrEqualsOperation(new StringConstantValueOperation("A"), new StringConstantValueOperation("AB"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new LessOrEqualsOperation(new StringConstantValueOperation("AB"), new StringConstantValueOperation("A"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new LessOrEqualsOperation(new PreciseNumberConstantValueOperation("1"), new PreciseNumberConstantValueOperation("1"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new LessOrEqualsOperation(new PreciseNumberConstantValueOperation("2"), new PreciseNumberConstantValueOperation("3"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new LessOrEqualsOperation(new PreciseNumberConstantValueOperation("3"), new PreciseNumberConstantValueOperation("2"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new LessOrEqualsOperation(new PreciseNumberConstantValueOperation("0"), new PreciseNumberConstantValueOperation("0"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new LessOrEqualsOperation(new PreciseNumberConstantValueOperation("0"), new PreciseNumberConstantValueOperation("1"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();

        operation = new LessOrEqualsOperation(new PreciseNumberConstantValueOperation("1"), new PreciseNumberConstantValueOperation("0"));
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

        operation = new NegationOperation(new BooleanConstantValueOperation("true"));
        assertThat(operation.<Boolean>evaluate(context)).isFalse();

        operation = new NegationOperation(new BooleanConstantValueOperation("false"));
        assertThat(operation.<Boolean>evaluate(context)).isTrue();
    }

}
