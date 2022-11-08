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
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class TestDecisionOperations {

    @Test
    void testDecisionOperations() {
        MathSentence mathSentence;

        mathSentence = new MathSentence("if true then 1 else 0 endif");
        assertThat(mathSentence.<BigDecimal>compute()).isEqualByComparingTo("1");
        mathSentence = new MathSentence("if(true, 1, 0)");
        assertThat(mathSentence.<BigDecimal>compute()).isEqualByComparingTo("1");

        mathSentence = new MathSentence("if false then 1 else 0 endif");
        assertThat(mathSentence.<BigDecimal>compute()).isEqualByComparingTo("0");
        mathSentence = new MathSentence("if(false, 1, 0)");
        assertThat(mathSentence.<BigDecimal>compute()).isEqualByComparingTo("0");

        mathSentence = new MathSentence("if true then 7 elsif false then 1 else if true then 1 else 0 endif endif");
        assertThat(mathSentence.<BigDecimal>compute()).isEqualByComparingTo("7");
        mathSentence = new MathSentence("if(true, 7, false, 1, if(true, 1, 0))");
        assertThat(mathSentence.<BigDecimal>compute()).isEqualByComparingTo("7");

        mathSentence = new MathSentence("if false then 0 elsif false then 1 else if true then 7 else 0 endif endif");
        assertThat(mathSentence.<BigDecimal>compute()).isEqualByComparingTo("7");
        mathSentence = new MathSentence("if(false, 0, false, 1, if(true, 7, 0))");
        assertThat(mathSentence.<BigDecimal>compute()).isEqualByComparingTo("7");
    }

}
