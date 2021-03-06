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

package io.github.mportilho.sentencecompiler.sentence;

import io.github.mportilho.sentencecompiler.MathSentence;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;

public class TestAssignedVariableOperations {

    public void computeMathSentence(String sentence, BigDecimal expectedValue) {
        assertThat(new MathSentence(sentence).<BigDecimal>compute()).isEqualByComparingTo(expectedValue);
    }

    @Test
    public void testAssignedVariable() {
        StringBuilder sb;

        sb = new StringBuilder();
        sb.append("a = 1 + 2;");
        sb.append("a * 5");
        computeMathSentence(sb.toString(), valueOf(15));
    }

    @Test
    public void testMultipleAssignedVariables() {
        StringBuilder sb;

        sb = new StringBuilder();
        sb.append("a = 1 + 2;");
        sb.append("b = 5;");
        sb.append("a * b");
        computeMathSentence(sb.toString(), valueOf(15));
    }

    @Test
    public void testObtainAssignedVariable() {
        StringBuilder sb;

        sb = new StringBuilder();
        sb.append("a = 1 + 2;");
        sb.append("b = 5;");
        MathSentence ms = new MathSentence(sb.toString());

        assertThat(ms.<Boolean>compute()).isFalse();
        assertThat((BigDecimal) ms.listAssignedVariables().get("a")).isEqualByComparingTo(valueOf(3));
        assertThat((BigDecimal) ms.listAssignedVariables().get("b")).isEqualByComparingTo(valueOf(5));
    }

    @Test
    public void testObtainAssignedVariableNoCache() {
        StringBuilder sb;

        sb = new StringBuilder();
        sb.append("a = 1 + 2;");
        sb.append("b = a + 5;");
        MathSentence ms = new MathSentence(sb.toString());
        assertThat((BigDecimal) ms.listAssignedVariables().get("b")).isNull();
    }

}
