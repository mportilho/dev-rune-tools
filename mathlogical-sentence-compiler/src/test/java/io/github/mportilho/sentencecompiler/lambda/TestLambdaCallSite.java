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

package io.github.mportilho.sentencecompiler.lambda;

import io.github.mportilho.sentencecompiler.syntaxtree.function.FunctionContext;
import io.github.mportilho.sentencecompiler.syntaxtree.function.LambdaCallSite;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.invoke.MethodType;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.stream.Stream;

import static java.math.BigDecimal.*;

public class TestLambdaCallSite {

    private static final FunctionContext context = new FunctionContext(MathContext.DECIMAL64, null);

    @Test
    public void testCallingSimpleMethod() {
        LambdaCallSite site = new LambdaCallSite(
                "addOne",
                MethodType.methodType(BigDecimal.class, BigDecimal.class),
                (context, parameters) -> ((BigDecimal) parameters[0]).add(ONE));
        Assertions.assertThat(site.<BigDecimal>call(context, new BigDecimal[]{ONE})).isEqualByComparingTo("2");
    }

    @Test
    public void testCallingSimpleMethod_DifferentParamSourceTypes() {
        LambdaCallSite site = new LambdaCallSite(
                "addThreeNumbers",
                MethodType.methodType(BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> ((BigDecimal) parameters[0]).add(((BigDecimal) parameters[1])).add(((BigDecimal) parameters[2])));
        Assertions.assertThat(site.<BigDecimal>call(context, new Object[]{ONE, 2, "3"})).isEqualByComparingTo("6");
    }

    @Test
    public void testCallingMethod_withArrayParam() {
        LambdaCallSite site = new LambdaCallSite(
                "sumArray",
                MethodType.methodType(BigDecimal.class, BigDecimal[].class),
                (context, parameters) -> Stream.of(((BigDecimal[]) parameters[0])).reduce(ZERO, BigDecimal::add));
        Assertions.assertThat(site.<BigDecimal>call(context, new Object[]{new Object[]{ONE, 2, "3"}})).isEqualByComparingTo("6");
    }

    @Test
    public void testCallingMethod_addingTwoArrays() {
        LambdaCallSite site = new LambdaCallSite(
                "sumArrays",
                MethodType.methodType(BigDecimal[].class, BigDecimal[].class, BigDecimal[].class),
                (context, parameters) -> {
                    BigDecimal[] a1 = (BigDecimal[]) parameters[0];
                    BigDecimal[] a2 = (BigDecimal[]) parameters[1];
                    BigDecimal[] r = new BigDecimal[a1.length];
                    for (int i = 0, a1Length = a1.length; i < a1Length; i++) {
                        r[i] = a1[i].add(a2[i]).setScale(0, RoundingMode.HALF_EVEN);
                    }
                    return r;
                });
        Assertions.assertThat(site.<BigDecimal[]>call(context, new Object[]{
                new Object[]{ONE, 2, "3"},
                new Object[]{4d, 5f, (short) 4}
        })).containsExactly(valueOf(5), valueOf(7), valueOf(7));
    }

}
