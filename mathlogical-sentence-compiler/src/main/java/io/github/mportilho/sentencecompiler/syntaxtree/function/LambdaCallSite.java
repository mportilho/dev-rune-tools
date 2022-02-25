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

package io.github.mportilho.sentencecompiler.syntaxtree.function;

import io.github.mportilho.commons.converters.FormattedConversionService;
import io.github.mportilho.commons.converters.impl.DefaultFormattedConversionService;

import java.lang.invoke.MethodType;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

import static io.github.mportilho.sentencecompiler.syntaxtree.function.MethodMetadataFactory.VARARGS;

public class LambdaCallSite {

    private final String methodName;
    private final MethodType methodType;
    private final OperationSupplier operationSupplier;
    private final FormattedConversionService service;
    private boolean cacheHint = false;

    public LambdaCallSite(
            String methodName, MethodType methodType,
            OperationSupplier operationSupplier) {
        this(methodName, methodType, operationSupplier, new DefaultFormattedConversionService());
    }

    public LambdaCallSite(
            String methodName, MethodType methodType,
            OperationSupplier operationSupplier, FormattedConversionService service) {
        this.methodName = methodName;
        this.methodType = methodType;
        this.operationSupplier = operationSupplier;
        this.service = service;
    }

    @SuppressWarnings({"unchecked"})
    public <T> T call(FunctionContext context, Object[] parameters) {
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
                Object[] paramArray = (Object[]) parameter;
                T[] convertedArray = (T[]) Array.newInstance(parameterType.getComponentType(), paramArray.length);
                for (int j = 0, paramArrayLength = paramArray.length; j < paramArrayLength; j++) {
                    convertedArray[j] = (T) service.convert(paramArray[j], parameterType.getComponentType());
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
        value = operationSupplier.call(context, convertedParams);

        if (methodType.returnType().equals(value.getClass())) {
            return (T) value;
        }
        return (T) service.convert(value, methodType.returnType());
    }

    public String getKeyName() {
        if (this.methodType.lastParameterType().getComponentType() == null) {
            return keyName(this.methodName, this.methodType.parameterCount());
        }
        return keyName(this.methodName, VARARGS);
    }

    public static String keyName(Method method) {
        return keyName(method.getName(), method.getParameterCount());
    }

    public static String keyName(String methodName, int parameterCount) {
        return methodName + "_" + parameterCount;
    }

    public LambdaCallSite hintCache() {
        this.cacheHint = true;
        return this;
    }

    public boolean isCacheHint() {
        return cacheHint;
    }

    public String getMethodName() {
        return methodName;
    }

    public MethodType getMethodType() {
        return methodType;
    }
}
