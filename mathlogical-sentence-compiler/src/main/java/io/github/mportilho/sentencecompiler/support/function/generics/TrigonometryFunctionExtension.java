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

package io.github.mportilho.sentencecompiler.support.function.generics;

import ch.obermuhlner.math.big.BigDecimalMath;
import io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaCallSite;

import java.lang.invoke.MethodType;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class TrigonometryFunctionExtension {

    private TrigonometryFunctionExtension() {
    }

    private static Map<String, LambdaCallSite> instance;

    public static Map<String, LambdaCallSite> trigonometryFunctionFactory() {
        if (instance == null) {
            instance = internalTrigonometryFunctionFactory();
        }
        return instance;
    }

    private static Map<String, LambdaCallSite> internalTrigonometryFunctionFactory() {
        LambdaCallSite callSite;
        Map<String, LambdaCallSite> extensions = new HashMap<>();

        callSite = new LambdaCallSite("sin", MethodType.methodType(BigDecimal.class, BigDecimal.class),
                (context, parameters) -> BigDecimalMath.sin(((BigDecimal) parameters[0]), context.mathContext()));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("cos", MethodType.methodType(BigDecimal.class, BigDecimal.class),
                (context, parameters) -> BigDecimalMath.cos(((BigDecimal) parameters[0]), context.mathContext()));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("tan", MethodType.methodType(BigDecimal.class, BigDecimal.class),
                (context, parameters) -> BigDecimalMath.tan(((BigDecimal) parameters[0]), context.mathContext()));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("asin", MethodType.methodType(BigDecimal.class, BigDecimal.class),
                (context, parameters) -> BigDecimalMath.asin(((BigDecimal) parameters[0]), context.mathContext()));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("acos", MethodType.methodType(BigDecimal.class, BigDecimal.class),
                (context, parameters) -> BigDecimalMath.acos(((BigDecimal) parameters[0]), context.mathContext()));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("atan", MethodType.methodType(BigDecimal.class, BigDecimal.class),
                (context, parameters) -> BigDecimalMath.atan(((BigDecimal) parameters[0]), context.mathContext()));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("atan2", MethodType.methodType(BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> BigDecimalMath.atan2(((BigDecimal) parameters[0]), ((BigDecimal) parameters[1]), context.mathContext()));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("sinh", MethodType.methodType(BigDecimal.class, BigDecimal.class),
                (context, parameters) -> BigDecimalMath.sinh(((BigDecimal) parameters[0]), context.mathContext()));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("cosh", MethodType.methodType(BigDecimal.class, BigDecimal.class),
                (context, parameters) -> BigDecimalMath.cosh(((BigDecimal) parameters[0]), context.mathContext()));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("tanh", MethodType.methodType(BigDecimal.class, BigDecimal.class),
                (context, parameters) -> BigDecimalMath.tanh(((BigDecimal) parameters[0]), context.mathContext()));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("asinh", MethodType.methodType(BigDecimal.class, BigDecimal.class),
                (context, parameters) -> BigDecimalMath.asinh(((BigDecimal) parameters[0]), context.mathContext()));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("acosh", MethodType.methodType(BigDecimal.class, BigDecimal.class),
                (context, parameters) -> BigDecimalMath.acosh(((BigDecimal) parameters[0]), context.mathContext()));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("atanh", MethodType.methodType(BigDecimal.class, BigDecimal.class),
                (context, parameters) -> BigDecimalMath.atanh(((BigDecimal) parameters[0]), context.mathContext()));
        extensions.put(callSite.getKeyName(), callSite);

        return extensions;
    }

}
