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

package io.github.mportilho.sentencecompiler.sentence.copy;

import io.github.mportilho.sentencecompiler.MathSentence;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TestFunctionOperationCopy {

    @Test
    public void testFunctionOperationsWithExternalDateMethods() {
        MathSentence mathSentence;

        mathSentence = new MathSentence("$.extractedDate() = currDate");
        mathSentence.addFunctionFromObject(new FunctionProviderClass());
        MathSentence mathSentenceCopy1 = mathSentence.copy();
        assertThat(mathSentence.<Boolean>compute()).isTrue();
        assertThat(mathSentenceCopy1.<Boolean>compute()).isTrue();
    }

    @Test
    public void testFunctionOperationsWithExternalTimeMethods_NoCache() {
        MathSentence mathSentence;

        mathSentence = new MathSentence("extractedTime() = 02:03:00");
        mathSentence.addFunctionFromObject(new FunctionProviderClass());
        MathSentence mathSentenceCopy1 = mathSentence.copy();
        assertThat(mathSentence.<Boolean>compute()).isTrue();
        assertThat(mathSentenceCopy1.<Boolean>compute()).isTrue();
    }

    @Test
    public void testFunctionOperationsWithNumberExternalMethods_MultipleParameters() {
        MathSentence mathSentence;

        mathSentence = new MathSentence("$.add(3, 4 + 2 - $.extractedNumber())");
        mathSentence.addFunctionFromObject(new FunctionProviderClass());
        MathSentence mathSentenceCopy1 = mathSentence.copy();
        assertThat(mathSentence.<BigDecimal>compute()).isEqualByComparingTo(BigDecimal.valueOf(8));
        assertThat(mathSentenceCopy1.<BigDecimal>compute()).isEqualByComparingTo(BigDecimal.valueOf(8));
    }

    public static class FunctionProviderClass {

        public BigDecimal extractedNumber() {
            return BigDecimal.ONE;
        }

        public LocalDate extractedDate() {
            return LocalDate.now();
        }

        public LocalTime extractedTime() {
            return LocalTime.of(2, 3, 0);
        }

        public LocalDateTime extractedDateTime() {
            return LocalDateTime.of(LocalDate.now(), LocalTime.of(2, 3, 0));
        }

        public String extractedString() {
            return "food";
        }

        public Boolean extractedBoolean() {
            return Boolean.TRUE;
        }

        public BigDecimal add(BigDecimal a, BigDecimal b) {
            return a.add(b);
        }
    }

}
