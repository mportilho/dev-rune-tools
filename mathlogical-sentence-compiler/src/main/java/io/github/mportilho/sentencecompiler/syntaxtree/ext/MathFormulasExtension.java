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

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static io.github.mportilho.sentencecompiler.syntaxtree.function.FunctionMetadataFactory.VARARGS;
import static io.github.mportilho.sentencecompiler.syntaxtree.function.FunctionMetadataFactory.keyName;

public class MathFormulasExtension {

    private static final Map<String, OperationLambdaCaller> INSTANCE = internalMathFunctionsFactory();

    public static Map<String, OperationLambdaCaller> mathFunctionsFactory() {
        return INSTANCE;
    }

    private static Map<String, OperationLambdaCaller> internalMathFunctionsFactory() {
        Map<String, OperationLambdaCaller> extensions = new HashMap<>();

        extensions.put(keyName("max", VARARGS), (context, params) -> Stream.of(params)
                .filter(Objects::nonNull)
                .map(p -> context.conversionService().convert(p, BigDecimal.class)).max(BigDecimal::compareTo)
                .orElse(null));

        extensions.put(keyName("min", VARARGS), (context, params) -> Stream.of(params)
                .filter(Objects::nonNull)
                .map(p -> context.conversionService().convert(p, BigDecimal.class)).min(BigDecimal::compareTo)
                .orElse(null));

        extensions.put(keyName("avg", VARARGS), (context, params) -> {
            BigDecimal[] totalWithCount = Stream.of(params).filter(Objects::nonNull)
                    .map(p -> new BigDecimal[]{context.conversionService().convert(p, BigDecimal.class), BigDecimal.ONE})
                    .reduce((a, b) -> new BigDecimal[]{a[0].add(b[0], context.mathContext()), a[1].add(BigDecimal.ONE)})
                    .orElseThrow();
            return totalWithCount[0].divide(totalWithCount[1], context.mathContext());
        });

        //TODO implementar função para o [valor médio - median]

        extensions.put(keyName("rule3d", 3), (context, params) -> {
            BigDecimal p1 = context.conversionService().convert(params[0], BigDecimal.class);
            BigDecimal p2 = context.conversionService().convert(params[1], BigDecimal.class);
            BigDecimal px = context.conversionService().convert(params[2], BigDecimal.class);
            return px.multiply(p2, context.mathContext()).divide(p1, context.mathContext());
        });

        extensions.put(keyName("rule3i", 3), (context, params) -> {
            BigDecimal p1 = context.conversionService().convert(params[0], BigDecimal.class);
            BigDecimal p2 = context.conversionService().convert(params[1], BigDecimal.class);
            BigDecimal px = context.conversionService().convert(params[2], BigDecimal.class);
            return p1.multiply(p2, context.mathContext()).divide(px, context.mathContext());
        });

        return extensions;
    }


}
