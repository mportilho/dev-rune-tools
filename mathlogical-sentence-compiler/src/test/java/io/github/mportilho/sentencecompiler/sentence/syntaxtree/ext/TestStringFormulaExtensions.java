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

package io.github.mportilho.sentencecompiler.sentence.syntaxtree.ext;

import io.github.mportilho.sentencecompiler.syntaxtree.function.FunctionContext;
import io.github.mportilho.sentencecompiler.syntaxtree.function.LambdaCallSite;
import org.junit.jupiter.api.Test;

import java.math.MathContext;

import static io.github.mportilho.sentencecompiler.syntaxtree.ext.StringFunctionExtension.stringFunctionsFactory;
import static io.github.mportilho.sentencecompiler.syntaxtree.function.LambdaCallSite.keyName;
import static io.github.mportilho.sentencecompiler.syntaxtree.function.MethodMetadataFactory.VARARGS;
import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.TEN;
import static org.assertj.core.api.Assertions.assertThat;

public class TestStringFormulaExtensions {

    private static final FunctionContext CONTEXT = new FunctionContext(MathContext.DECIMAL64, null);

    @Test
    public void test_concat_Function() {
        LambdaCallSite concat = stringFunctionsFactory().get(keyName("concat", VARARGS));
        assertThat((String) concat.call(CONTEXT, new Object[]{new Object[]{ONE, TEN, "teste", "123"}}))
                .isEqualTo("110teste123");
    }

    @Test
    public void test_trim_Function() {
        LambdaCallSite trim = stringFunctionsFactory().get(keyName("trim", 1));

        assertThat((String) trim.call(CONTEXT, new Object[]{" a 12  3  "}))
                .isEqualTo("a 12  3");
    }

}
