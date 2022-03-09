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

import io.github.mportilho.sentencecompiler.support.function.generics.DateTimeFunctionExtension;
import io.github.mportilho.sentencecompiler.support.function.generics.FinancialFormulasExtension;
import io.github.mportilho.sentencecompiler.support.function.generics.MathFormulasExtension;
import io.github.mportilho.sentencecompiler.support.function.generics.StringFunctionExtension;
import io.github.mportilho.sentencecompiler.support.function.generics.TrigonometryFunctionExtension;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.lang.invoke.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.lang.reflect.Modifier.isStatic;

public class LambdaCallSiteFactory {

    public static final Map<String, LambdaCallSite> DEFAULT_FUNCTIONS;
    private static final MethodHandles.Lookup LOOKUP = MethodHandles.lookup();

    static {
        Map<String, LambdaCallSite> temp = new HashMap<>();
        temp.putAll(DateTimeFunctionExtension.dateTimeFunctionsFactory());
        temp.putAll(FinancialFormulasExtension.financialFunctionsFactory());
        temp.putAll(MathFormulasExtension.mathFunctionsFactory());
        temp.putAll(StringFunctionExtension.stringFunctionsFactory());
        temp.putAll(TrigonometryFunctionExtension.trigonometryFunctionFactory());
        DEFAULT_FUNCTIONS = Collections.unmodifiableMap(temp);
    }

    public static Map<String, LambdaCallSite> createLambdaCallSites(Object provider) throws Throwable {
        Objects.requireNonNull(provider, "Provider object for extracting methods required");
        boolean isClassObject = provider instanceof Class<?>;
        Class<?> clazz = isClassObject ? (Class<?>) provider : provider.getClass();
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Object.class);

        Map<String, LambdaCallSite> dynamicCallerPool = new HashMap<>();
        for (MethodDescriptor methodDescriptor : beanInfo.getMethodDescriptors()) {
            LambdaCallSite lambdaCallSite = createLambdaCallSite(methodDescriptor.getMethod(), isClassObject, provider);
            if (lambdaCallSite != null) {
                dynamicCallerPool.put(lambdaCallSite.getKeyName(), lambdaCallSite);
            }
        }
        return dynamicCallerPool;
    }

    private static LambdaCallSite createLambdaCallSite(
            Method method, boolean isClassObject, Object provider) throws Throwable {
        if (void.class.equals(method.getReturnType()) || !Modifier.isPublic(method.getModifiers())) {
            return null;
        }
        if (findFactoryInterface(method.getParameterCount()) == null || hasPrimitives(method)) {
            return createMethodHandleCaller(method, isClassObject ? null : provider);
        } else if (isStatic(method.getModifiers())) {
            return createStaticCaller(method);
        } else if (!isClassObject) {
            return createDynamicCaller(method, provider);
        }
        return null;
    }

    // slower
    private static LambdaCallSite createMethodHandleCaller(
            Method method, Object instance) throws Throwable {

        MethodHandle methodHandle = instance == null ? LambdaCallSiteFactory.LOOKUP.unreflect(method) : LambdaCallSiteFactory.LOOKUP.unreflect(method).bindTo(instance);
        MethodHandle callableMethodHandle = methodHandle.asType(methodHandle.type().generic())
                .asSpreader(Object[].class, methodHandle.type().parameterCount());
        LambdaSupplier supplier = (context, parameters) -> {
            try {
                return callableMethodHandle.invokeExact(parameters);
            } catch (Throwable e) {
                throw new IllegalStateException("Error calling dynamic function", e);
            }
        };
        return new LambdaCallSite(method.getName(), methodHandle.type(), supplier);
    }

    private static LambdaCallSite createStaticCaller(Method method) throws Throwable {
        Class<?> clazz = method.getDeclaringClass();
        Class<?> factoryInterface = findFactoryInterface(method.getParameterCount());
        MethodType functionMethodType = MethodType.methodType(method.getReturnType(), method.getParameterTypes());
        MethodHandle implementationMethodHandle = LambdaCallSiteFactory.LOOKUP.findStatic(clazz, method.getName(), functionMethodType);
        CallSite callSite = LambdaMetafactory.metafactory(LambdaCallSiteFactory.LOOKUP,
                "call",
                MethodType.methodType(factoryInterface),
                functionMethodType.generic(),
                implementationMethodHandle,
                functionMethodType);

        return new LambdaCallSite(method.getName(), functionMethodType, createLambdaWrapper(callSite.getTarget().invoke()));
    }

    private static LambdaCallSite createDynamicCaller(Method method, Object instance) throws Throwable {
        Class<?> clazz = method.getDeclaringClass();
        Class<?> factoryInterface = findFactoryInterface(method.getParameterCount());
        MethodType functionMethodType = MethodType.methodType(method.getReturnType(), method.getParameterTypes());
        MethodHandle implementationMethodHandle = LambdaCallSiteFactory.LOOKUP.findVirtual(clazz, method.getName(), functionMethodType);

        CallSite callSite = LambdaMetafactory.metafactory(LambdaCallSiteFactory.LOOKUP,
                "call",
                MethodType.methodType(factoryInterface, instance.getClass()), // factoryMethodType
                MethodType.genericMethodType(method.getParameterCount()), // method params plus instance object
                implementationMethodHandle,
                functionMethodType); // method params plus instance object
        return new LambdaCallSite(method.getName(), functionMethodType, createLambdaWrapper(callSite.getTarget().invoke(instance)));
    }

    private static boolean hasPrimitives(Method method) {
        if (method.getReturnType().isPrimitive()) {
            return true;
        }
        for (Class<?> parameterType : method.getParameterTypes()) {
            if (parameterType.isPrimitive()) {
                return true;
            }
        }
        return false;
    }


    private static Class<?> findFactoryInterface(int parameterNumber) {
        return switch (parameterNumber) {
            case 1 -> LambdaWrapper.Function1.class;
            case 2 -> LambdaWrapper.Function2.class;
            case 3 -> LambdaWrapper.Function3.class;
            case 4 -> LambdaWrapper.Function4.class;
            case 5 -> LambdaWrapper.Function5.class;
            case 6 -> LambdaWrapper.Function6.class;
            case 7 -> LambdaWrapper.Function7.class;
            case 8 -> LambdaWrapper.Function8.class;
            case 9 -> LambdaWrapper.Function9.class;
            case 10 -> LambdaWrapper.Function10.class;
            case 11 -> LambdaWrapper.Function11.class;
            default -> null;
        };
    }

    private static LambdaSupplier createLambdaWrapper(Object lambda) {
        if (lambda instanceof LambdaWrapper.Function1 f) {
            return (c, p) -> f.call(p[0]);
        } else if (lambda instanceof LambdaWrapper.Function2 f) {
            return (c, p) -> f.call(p[0], p[1]);
        } else if (lambda instanceof LambdaWrapper.Function3 f) {
            return (c, p) -> f.call(p[0], p[1], p[2]);
        } else if (lambda instanceof LambdaWrapper.Function4 f) {
            return (c, p) -> f.call(p[0], p[1], p[2], p[3]);
        } else if (lambda instanceof LambdaWrapper.Function5 f) {
            return (c, p) -> f.call(p[0], p[1], p[2], p[3], p[4]);
        } else if (lambda instanceof LambdaWrapper.Function6 f) {
            return (c, p) -> f.call(p[0], p[1], p[2], p[3], p[4], p[5]);
        } else if (lambda instanceof LambdaWrapper.Function7 f) {
            return (c, p) -> f.call(p[0], p[1], p[2], p[3], p[4], p[5], p[6]);
        } else if (lambda instanceof LambdaWrapper.Function8 f) {
            return (c, p) -> f.call(p[0], p[1], p[2], p[3], p[4], p[5], p[6], p[7]);
        } else if (lambda instanceof LambdaWrapper.Function9 f) {
            return (c, p) -> f.call(p[0], p[1], p[2], p[3], p[4], p[5], p[6], p[7], p[8]);
        } else if (lambda instanceof LambdaWrapper.Function10 f) {
            return (c, p) -> f.call(p[0], p[1], p[2], p[3], p[4], p[5], p[6], p[7], p[8], p[9]);
        } else if (lambda instanceof LambdaWrapper.Function11 f) {
            return (c, p) -> f.call(p[0], p[1], p[2], p[3], p[4], p[5], p[6], p[7], p[8], p[9], p[10]);
        }
        return null;
    }


}
