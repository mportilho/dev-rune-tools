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

package io.github.mportilho.sentencecompiler.support.lambdacallsite;

import io.github.mportilho.commons.converters.FormattedConversionService;
import io.github.mportilho.commons.converters.impl.DefaultFormattedConversionService;

import java.lang.invoke.MethodType;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

public class LambdaCallSite {

    private final String methodName;
    private final MethodType methodType;
    private final LambdaSupplier lambdaSupplier;
    private final FormattedConversionService service;

    public LambdaCallSite(
            String methodName, MethodType methodType,
            LambdaSupplier lambdaSupplier) {
        this(methodName, methodType, lambdaSupplier, new DefaultFormattedConversionService());
    }

    public LambdaCallSite(
            String methodName, MethodType methodType,
            LambdaSupplier lambdaSupplier, FormattedConversionService service) {
        this.methodName = methodName;
        this.methodType = methodType;
        this.lambdaSupplier = lambdaSupplier;
        this.service = service;
    }

    @SuppressWarnings({"unchecked"})
    public <R> R call(LambdaContext context, Object[] parameters) {
        Object[] convertedParams = new Object[parameters.length];
        Class<?>[] parameterTypes = methodType.parameterArray();
        Object value;

        for (int i = 0, parametersLength = parameters.length; i < parametersLength; i++) {
            Object parameter = parameters[i];
            Class<?> parameterType = parameterTypes[i];
            if (parameterType.isArray()) {
                if (!parameter.getClass().isArray()) {
                    throw new IllegalArgumentException(String.format("Parameter on position [%s] of virtual method [%s] should be an array", i, methodName));
                }
                int arrLength = Array.getLength(parameter);
                R[] convertedArray = (R[]) Array.newInstance(parameterType.getComponentType(), arrLength);
                for (int j = 0; j < arrLength; j++) {
                    convertedArray[j] = (R) service.convert(Array.get(parameter, j), parameterType.getComponentType());
                }
                convertedParams[i] = convertedArray;
            } else {
                if (parameterType.equals(parameter.getClass())) {
                    convertedParams[i] = parameter;
                } else {
                    convertedParams[i] = service.convert(parameter, parameterType);
                }
            }
        }
        value = lambdaSupplier.call(context, convertedParams);

        if (methodType.returnType().equals(value.getClass())) {
            return (R) value;
        }
        return (R) service.convert(value, methodType.returnType());
    }

    public String getKeyName() {
        return keyName(this.methodName, this.methodType.parameterCount());
    }

    public static String keyName(Method method) {
        return keyName(method.getName(), method.getParameterCount());
    }

    public static String keyName(String methodName, int parameterCount) {
        return methodName + "_" + parameterCount;
    }

    public String getMethodName() {
        return methodName;
    }

    public MethodType getMethodType() {
        return methodType;
    }
}
