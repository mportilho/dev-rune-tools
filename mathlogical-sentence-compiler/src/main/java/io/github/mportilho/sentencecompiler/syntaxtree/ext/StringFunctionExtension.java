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

package io.github.mportilho.sentencecompiler.syntaxtree.ext;

import io.github.mportilho.sentencecompiler.syntaxtree.function.OperationLambdaCaller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.github.mportilho.sentencecompiler.syntaxtree.function.MethodMetadataFactory.VARARGS;
import static io.github.mportilho.sentencecompiler.syntaxtree.function.MethodMetadataFactory.keyName;

public class StringFunctionExtension {

    private static final Map<String, OperationLambdaCaller> INSTANCE = internalStringFunctionsFactory();

    public static Map<String, OperationLambdaCaller> stringFunctionsFactory() {
        return INSTANCE;
    }

    private static Map<String, OperationLambdaCaller> internalStringFunctionsFactory() {
        Map<String, OperationLambdaCaller> extensions = new HashMap<>();

        extensions.put(keyName("concat", VARARGS), (context, params) -> Stream.of(params)
                .filter(Objects::nonNull)
                .map(p -> context.conversionService().convert(p, String.class)).collect(Collectors.joining()));

        extensions.put(keyName("trim", 1), (context, params) ->
                context.conversionService().convert(params[0], String.class).trim());

        return extensions;
    }

}
