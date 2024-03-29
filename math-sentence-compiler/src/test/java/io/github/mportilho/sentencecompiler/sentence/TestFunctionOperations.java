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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class TestFunctionOperations {

    @Test
    void testFunctionOperationsWithExternalNumberMethods() {
        MathSentence mathSentence;

        mathSentence = new MathSentence("$.extractedNumber() + 2");
        mathSentence.addFunctionFromObject(new FunctionProviderClass());
        assertThat(mathSentence.<BigDecimal>compute()).isEqualByComparingTo("3");
    }

    @Test
    void testFunctionOperationsWithExternalStringMethods() {
        MathSentence mathSentence;

        mathSentence = new MathSentence("$.extractedString() = 'food'");
        mathSentence.addFunctionFromObject(new FunctionProviderClass());
        assertThat(mathSentence.<Boolean>compute()).isTrue();
    }

    @Test
    void testFunctionOperationsWithExternalDateMethods() {
        MathSentence mathSentence;

        mathSentence = new MathSentence("$.extractedDate() = currDate");
        mathSentence.addFunctionFromObject(new FunctionProviderClass());
        assertThat(mathSentence.<Boolean>compute()).isTrue();
    }

    @Test
    void testFunctionOperationsWithExternalTimeMethods() {
        MathSentence mathSentence;

        mathSentence = new MathSentence("$.extractedTime() = 02:03:00");
        mathSentence.addFunctionFromObject(new FunctionProviderClass());
        assertThat(mathSentence.<Boolean>compute()).isTrue();
    }

    @Test
    void testFunctionOperationsWithExternalDateTimeMethods() {
        MathSentence mathSentence;
        mathSentence = new MathSentence("$.extractedDateTime() = (currDateTime setHours 2 setMinutes 3 setSeconds 0)");
        mathSentence.addFunctionFromObject(new FunctionProviderClass());
        assertThat(mathSentence.<Boolean>compute()).isFalse();
    }

    @Test
    void testFunctionOperationsWithExternalBooleanMethods() {
        MathSentence mathSentence;

        mathSentence = new MathSentence("extractedBoolean()");
        mathSentence.addFunctionFromObject(new FunctionProviderClass());
        assertThat(mathSentence.<Boolean>compute()).isTrue();
    }

    @Test
    void testFunctionOperationsWithNumberExternalMethods_MultipleParameters() {
        MathSentence mathSentence;
        mathSentence = new MathSentence("$.add(3, 4 + 2 - $.extractedNumber())");
        mathSentence.addFunctionFromObject(new FunctionProviderClass());
        assertThat(mathSentence.<BigDecimal>compute()).isEqualByComparingTo(BigDecimal.valueOf(8));
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
