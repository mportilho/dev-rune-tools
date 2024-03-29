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

package io.github.mportilho.sentencecompiler.sentence.text;

import io.github.mportilho.sentencecompiler.MathSentence;
import io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaCallSite;
import org.junit.jupiter.api.Test;

import java.lang.invoke.MethodType;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class TestOtherOperationsTextualRepresentation {

    @Test
    public void testAssingedVariablesOnlyBaseOperationTextRepresentation() {
        MathSentence mathSentence;

        mathSentence = new MathSentence("a = 3; b = 5;");
        assertThat(mathSentence.toString()).isEqualTo("a = 3;\nb = 5;");
        mathSentence.compute();
        assertThat(mathSentence.toString()).isEqualTo("a = 3;\nb = 5;");

        mathSentence = new MathSentence("a = 3; b = 5; a + b");
        assertThat(mathSentence.toString()).isEqualTo("a = 3;\nb = 5;\na + b");
        mathSentence.compute();
        assertThat(mathSentence.toString()).isEqualTo("a = 3;\nb = 5;\n3 + 5");
    }

    @Test
    public void testFullBaseOperationsTextualRepresentation() {
        MathSentence mathSentence;

        String builder = "a = 3 - 2;" +
                "b = 5 * 2;" +
                "a + b";
        mathSentence = new MathSentence(builder);
        assertThat(mathSentence.toString()).isEqualTo("a = 3 - 2;\nb = 5 * 2;\na + b");
        mathSentence.compute();
        assertThat(mathSentence.toString()).isEqualTo("a = 3 - 2;\nb = 5 * 2;\n1 + 10");
    }

    @Test
    public void testDecisionOperationTextRepresentation() {
        MathSentence mathSentence;

        mathSentence = new MathSentence("if true then 1 else 0 endif");
        assertThat(mathSentence.toString()).isEqualTo("if true then 1 else 0 endif");
        mathSentence.compute();
        assertThat(mathSentence.toString()).isEqualTo("if true then 1 else 0 endif");

        mathSentence = new MathSentence("if true then 0 elsif false then 1 else if true then 1 else 0 endif endif");
        assertThat(mathSentence.toString()).isEqualTo("if true then 0 elsif false then 1 else if true then 1 else 0 endif endif");
        mathSentence.compute();
        assertThat(mathSentence.toString()).isEqualTo("if true then 0 elsif false then 1 else if true then 1 else 0 endif endif");
    }

    @Test
    public void testDecisionOperation_FunctionLikeTextRepresentation() {
        MathSentence mathSentence;

        mathSentence = new MathSentence("if(true, 1, 0)");
        assertThat(mathSentence.toString()).isEqualTo("if(true, 1, 0)");
        mathSentence.compute();
        assertThat(mathSentence.toString()).isEqualTo("if(true, 1, 0)");

        mathSentence = new MathSentence("if(true, 0, false, 1, if(true, 1, 0))");
        assertThat(mathSentence.toString()).isEqualTo("if(true, 0, false, 1, if(true, 1, 0))");
        mathSentence.compute();
        assertThat(mathSentence.toString()).isEqualTo("if(true, 0, false, 1, if(true, 1, 0))");
    }

    @Test
    public void testFunctionOperationWithOneParameterTextRepresentation() {
        MathSentence mathSentence;

        LambdaCallSite callSite1 = new LambdaCallSite("function1",
                MethodType.methodType(BigDecimal.class, BigDecimal.class), (context, parameters) -> 5);
        LambdaCallSite callSite2 = new LambdaCallSite("function2",
                MethodType.methodType(BigDecimal.class, BigDecimal.class), (context, parameters) -> 6);

        mathSentence = new MathSentence("$.function1(1 * 2) + $.function2(3 / 4)");
        mathSentence.addFunction(callSite1);
        mathSentence.addFunction(callSite2);
        assertThat(mathSentence.toString()).isEqualTo("function1(1 * 2) + function2(3 / 4)");
        mathSentence.compute();
        assertThat(mathSentence.toString()).isEqualTo("function1(1 * 2) + function2(3 / 4)");

        mathSentence = new MathSentence("$.function1(1 * 2) + function2(3 / 4)");
        mathSentence.addFunction(callSite1);
        mathSentence.addFunction(callSite2);
        assertThat(mathSentence.toString()).isEqualTo("function1(1 * 2) + function2(3 / 4)");
        mathSentence.compute();
        assertThat(mathSentence.toString()).isEqualTo("function1(1 * 2) + function2(3 / 4)");
    }

    @Test
    public void testFunctionOperationWithMultipleParametersTextRepresentation() {
        MathSentence mathSentence;
        LambdaCallSite callSite1 = new LambdaCallSite("function1",
                MethodType.methodType(BigDecimal.class, BigDecimal.class), (context, parameters) -> 5);
        LambdaCallSite callSite2 = new LambdaCallSite("function2",
                MethodType.methodType(BigDecimal.class, BigDecimal.class, BigDecimal.class), (context, parameters) -> 6);

        mathSentence = new MathSentence("$.function1(1 * 2) + function2(3 / 4, 7)");
        mathSentence.addFunction(callSite1);
        mathSentence.addFunction(callSite2);
        assertThat(mathSentence.toString()).isEqualTo("function1(1 * 2) + function2(3 / 4, 7)");
        mathSentence.compute();
        assertThat(mathSentence.toString()).isEqualTo("function1(1 * 2) + function2(3 / 4, 7)");
    }

}
