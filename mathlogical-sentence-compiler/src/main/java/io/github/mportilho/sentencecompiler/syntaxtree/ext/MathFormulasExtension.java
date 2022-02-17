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

import io.github.mportilho.sentencecompiler.syntaxtree.function.LambdaCallSite;

import java.lang.invoke.MethodType;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static java.math.BigDecimal.valueOf;

public class MathFormulasExtension {

    private static final Map<String, LambdaCallSite> INSTANCE = internalMathFunctionsFactory();

    public static Map<String, LambdaCallSite> mathFunctionsFactory() {
        return INSTANCE;
    }

    private static Map<String, LambdaCallSite> internalMathFunctionsFactory() {
        LambdaCallSite callSite;
        Map<String, LambdaCallSite> extensions = new HashMap<>();

        callSite = new LambdaCallSite("max", MethodType.methodType(BigDecimal.class, BigDecimal[].class),
                (context, parameters) -> {
                    if (parameters.length == 1) {
                        return parameters[0];
                    } else if (parameters.length == 2) {
                        return ((BigDecimal) parameters[0]).compareTo((BigDecimal) parameters[1]) >= 0 ?
                                parameters[0] : parameters[1];
                    }
                    BigDecimal maxOne = (BigDecimal) parameters[0];
                    for (int i = 1, parametersLength = parameters.length; i < parametersLength; i++) {
                        BigDecimal parameter = (BigDecimal) parameters[i];
                        if (maxOne.compareTo(parameter) < 0) {
                            maxOne = parameter;
                        }
                    }
                    return maxOne;
                });
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("min", MethodType.methodType(BigDecimal.class, BigDecimal[].class),
                (context, parameters) -> {
                    if (parameters.length == 1) {
                        return parameters[0];
                    } else if (parameters.length == 2) {
                        return ((BigDecimal) parameters[0]).compareTo((BigDecimal) parameters[1]) <= 0 ?
                                parameters[0] : parameters[1];
                    }
                    BigDecimal minOne = (BigDecimal) parameters[0];
                    for (int i = 1, parametersLength = parameters.length; i < parametersLength; i++) {
                        BigDecimal parameter = (BigDecimal) parameters[i];
                        if (minOne.compareTo(parameter) > 0) {
                            minOne = parameter;
                        }
                    }
                    return minOne;
                });
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("avg", MethodType.methodType(BigDecimal.class, BigDecimal[].class),
                (context, parameters) -> {
                    if (parameters.length == 1) {
                        return parameters[0];
                    } else if (parameters.length == 2) {
                        return ((BigDecimal) parameters[0]).add((BigDecimal) parameters[1]).divide(valueOf(2), context.mathContext());
                    }
                    BigDecimal sum = BigDecimal.ZERO;
                    for (Object parameter : parameters) {
                        sum = sum.add((BigDecimal) parameter);
                    }
                    return sum.divide(BigDecimal.valueOf(parameters.length), context.mathContext());
                });
        extensions.put(callSite.getKeyName(), callSite);

        //TODO implementar função para o [valor médio - median]

        callSite = new LambdaCallSite("rule3d", MethodType.methodType(
                BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> {
                    BigDecimal p1 = (BigDecimal) parameters[0];
                    BigDecimal p2 = (BigDecimal) parameters[1];
                    BigDecimal px = (BigDecimal) parameters[2];
                    return px.multiply(p2, context.mathContext()).divide(p1, context.mathContext());
                });
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("rule3i", MethodType.methodType(
                BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> {
                    BigDecimal p1 = (BigDecimal) parameters[0];
                    BigDecimal p2 = (BigDecimal) parameters[1];
                    BigDecimal px = (BigDecimal) parameters[2];
                    return p1.multiply(p2, context.mathContext()).divide(px, context.mathContext());
                });
        extensions.put(callSite.getKeyName(), callSite);

        return extensions;
    }


}
