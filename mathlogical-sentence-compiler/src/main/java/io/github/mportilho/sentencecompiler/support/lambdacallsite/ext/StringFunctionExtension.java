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

package io.github.mportilho.sentencecompiler.support.lambdacallsite.ext;

import io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaCallSite;

import java.lang.invoke.MethodType;
import java.util.HashMap;
import java.util.Map;

public class StringFunctionExtension {

    private static final Map<String, LambdaCallSite> INSTANCE = internalStringFunctionsFactory();

    public static Map<String, LambdaCallSite> stringFunctionsFactory() {
        return INSTANCE;
    }

    private static Map<String, LambdaCallSite> internalStringFunctionsFactory() {
        Map<String, LambdaCallSite> extensions = new HashMap<>();
        LambdaCallSite callSite;

        callSite = new LambdaCallSite("concat", MethodType.methodType(String.class, String[].class),
                (context, parameters) -> String.join("", (String[]) parameters[0]));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("trim", MethodType.methodType(String.class, String.class),
                (context, parameters) -> ((String) parameters[0]).trim());
        extensions.put(callSite.getKeyName(), callSite);

        return extensions;
    }

}