/*******************************************************************************
 * MIT License
 *
 * Copyright (c) 2022. Marcelo Silva Portilho
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

package io.github.mportilho.sentencecompiler.sentence;

import io.github.mportilho.sentencecompiler.MathSentence;
import io.github.mportilho.sentencecompiler.exceptions.SyntaxExecutionException;
import io.github.mportilho.sentencecompiler.OperationSupportData;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

public class TestOperationSupportData {

    @Test
    public void test_overrideVariable_with_InternalDictionary_case_1() {
        MathSentence compiler;

        compiler = new MathSentence("a + 5 * b");
        assertThatThrownBy(compiler::compute)
                .isInstanceOf(SyntaxExecutionException.class).hasMessage("Variable [a] requires a value");

        compiler
                .addDictionaryEntry("a", 3)
                .addDictionaryEntry("b", 5);
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("28");
    }

    @Test
    public void test_overrideVariable_with_InternalDictionary_case_2() {
        MathSentence compiler;

        compiler = new MathSentence("a + 5 * b");
        compiler.setVariable("a", 3);
        assertThatThrownBy(compiler::compute)
                .isInstanceOf(SyntaxExecutionException.class).hasMessage("Variable [b] requires a value");

        compiler.addDictionaryEntry("b", 5);
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("28");
    }

    @Test
    public void test_overrideVariable_with_InternalDictionary_case_3() {
        MathSentence compiler;

        compiler = new MathSentence("a + 5 * b");
        compiler
                .addDictionaryEntry("a", 3)
                .addDictionaryEntry("b", 5);

        compiler.setVariable("a", 5);
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("30");

        compiler.setVariable("a", 1);
        compiler.setVariable("b", 1);
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("6");
    }

    @Test
    public void test_overrideVariable_with_UserDictionary_case_1() {
        MathSentence compiler;
        OperationSupportData data = new OperationSupportData();

        compiler = new MathSentence("a + 5 * b");
        assertThatThrownBy(compiler::compute)
                .isInstanceOf(SyntaxExecutionException.class).hasMessage("Variable [a] requires a value");

        data.putDictionary("a", BigDecimal.valueOf(3));
        assertThatThrownBy(() -> compiler.compute(data))
                .isInstanceOf(SyntaxExecutionException.class).hasMessage("Variable [b] requires a value");

        data.putDictionary("b", 10);
        assertThat(compiler.<BigDecimal>compute(data)).isEqualByComparingTo("53");
    }

    @Test
    public void test_overrideVariable_with_UserDictionary_case_2() {
        MathSentence compiler;
        OperationSupportData data = new OperationSupportData();

        compiler = new MathSentence("a + 5 * b");
        compiler.setVariable("a", 3);

        data.putDictionary("b", 10);
        assertThat(compiler.<BigDecimal>compute(data)).isEqualByComparingTo("53");
    }

    @Test
    public void test_overrideVariable_with_UserDictionary_case_3() {
        MathSentence compiler;
        OperationSupportData data = new OperationSupportData();

        compiler = new MathSentence("a + 5 * b");
        compiler.setVariable("a", 1);
        compiler.setVariable("b", 2);

        assertThat(compiler.<BigDecimal>compute(data)).isEqualByComparingTo("11");

        data.putDictionary("a", 3);
        assertThat(compiler.<BigDecimal>compute(data)).isEqualByComparingTo("13");

        data.putDictionary("b", 10);
        assertThat(compiler.<BigDecimal>compute(data)).isEqualByComparingTo("53");
    }

    @Test
    public void test_overrideVariable_with_UserDictionary_case_4() {
        MathSentence compiler;
        OperationSupportData data = new OperationSupportData();

        compiler = new MathSentence("a + 5 * b");
        compiler.setVariable("a", 3);
        compiler.setVariable("b", 5);
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("28");

        data.putDictionary("a", 1);
        data.putDictionary("b", 2);
        assertThat(compiler.<BigDecimal>compute(data)).isEqualByComparingTo("11");

        data.putDictionary("a", 5);
        data.putDictionary("b", 10);
        assertThat(compiler.<BigDecimal>compute(data)).isEqualByComparingTo("55");

        data.putDictionary("a", 6);
        assertThat(compiler.<BigDecimal>compute(data)).isEqualByComparingTo("56");

        data.getDictionary().remove("a");
        data.getDictionary().remove("b");
        assertThat(compiler.<BigDecimal>compute(data)).isEqualByComparingTo("28");

        // not passing user dictionary
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("28");
    }

}
