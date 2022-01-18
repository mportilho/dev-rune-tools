package io.github.mportilho.sentencecompiler.syntaxtree.function;

import io.github.mportilho.commons.converters.FormattedConversionService;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.lang.invoke.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.lang.reflect.Modifier.isStatic;

public class FunctionMetadataFactory {

    public static Map<String, DynamicFunctionCaller> createFunctionCaller(
            Object functionProvider,
            FormattedConversionService conversionService) throws Throwable {
        Objects.requireNonNull(functionProvider, "Parameter [functionProvider] must not be null");

        boolean isClassObject = functionProvider instanceof Class<?>;
        Class<?> clazz = isClassObject ? (Class<?>) functionProvider : functionProvider.getClass();
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Object.class);

        Map<String, DynamicFunctionCaller> dynamicCallerPool = new HashMap<>();
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        for (MethodDescriptor methodDescriptor : beanInfo.getMethodDescriptors()) {
            Method method = methodDescriptor.getMethod();
            if (void.class.equals(method.getReturnType()) || !Modifier.isPublic(method.getModifiers())) {
                continue;
            }

            if (findFactoryInterface(method.getParameterCount()) == null) {
                dynamicCallerPool.put(keyName(method),
                        createMethodHandleCaller(lookup, method, conversionService, functionProvider));
            } else if (isStatic(method.getModifiers())) {
                dynamicCallerPool.put(keyName(method),
                        createStaticCaller(lookup, method, conversionService));
            } else if (!isClassObject) {
                dynamicCallerPool.put(keyName(method),
                        createDynamicCaller(lookup, method, functionProvider, conversionService));
            }
        }
        return dynamicCallerPool;
    }

    // slower
    private static DynamicFunctionCaller createMethodHandleCaller(
            MethodHandles.Lookup lookup, Method method,
            FormattedConversionService conversionService, Object instance) throws Throwable {

        MethodHandle methodHandle = instance == null ? lookup.unreflect(method) : lookup.unreflect(method).bindTo(instance);
        MethodHandle callableMethodHandle = methodHandle.asType(methodHandle.type().generic())
                .asSpreader(Object[].class, methodHandle.type().parameterCount());

        LambdaCallerInterface caller = (s, params) -> {
            try {
                return callableMethodHandle.invokeExact(params);
            } catch (Throwable e) {
                throw new IllegalArgumentException("Error calling dynamic function", e);
            }
        };
        return new DynamicFunctionCaller(caller, method.getParameterTypes(), conversionService);
    }

    private static DynamicFunctionCaller createStaticCaller(
            MethodHandles.Lookup lookup, Method method, FormattedConversionService conversionService) throws Throwable {

        Class<?> clazz = method.getDeclaringClass();
        Class<?> factoryInterface = findFactoryInterface(method.getParameterCount());
        MethodType functionMethodType = MethodType.methodType(method.getReturnType(), method.getParameterTypes());
        MethodHandle implementationMethodHandle = lookup.findStatic(clazz, method.getName(), functionMethodType);
        CallSite callSite = LambdaMetafactory.metafactory(lookup,
                "apply",
                MethodType.methodType(factoryInterface),
                functionMethodType.generic(),
                implementationMethodHandle,
                functionMethodType);

        return new DynamicFunctionCaller(method.getParameterTypes(), callSite.getTarget().invoke(), conversionService);
    }

    private static DynamicFunctionCaller createDynamicCaller(
            MethodHandles.Lookup lookup, Method method, Object instance,
            FormattedConversionService conversionService) throws Throwable {

        Class<?> clazz = method.getDeclaringClass();
        Class<?> factoryInterface = findFactoryInterface(method.getParameterCount() + 1);
        MethodType functionMethodType = MethodType.methodType(method.getReturnType(), method.getParameterTypes());
        MethodHandle implementationMethodHandle = lookup.findVirtual(clazz, method.getName(), functionMethodType);

        CallSite callSite = LambdaMetafactory.metafactory(lookup,
                "apply",
                MethodType.methodType(factoryInterface), // factoryMethodType
                MethodType.genericMethodType(method.getParameterCount() + 1), // method params plus instance object
                implementationMethodHandle,
                functionMethodType.insertParameterTypes(0, clazz)); // method params plus instance object
        return new DynamicFunctionCaller(method.getParameterTypes(), callSite.getTarget().invoke(), instance, conversionService);
    }

    public static String keyName(Method method) {
        return keyName(method.getName(), method.getParameterCount());
    }

    public static String keyName(String methodName, int parameterCount) {
        return methodName + "_" + parameterCount;
    }

    private static Class<?> findFactoryInterface(int parameterNumber) {
        return switch (parameterNumber) {
            case 1 -> LambdaFunctionInterfacesWrapper.Function1.class;
            case 2 -> LambdaFunctionInterfacesWrapper.Function2.class;
            case 3 -> LambdaFunctionInterfacesWrapper.Function3.class;
            case 4 -> LambdaFunctionInterfacesWrapper.Function4.class;
            case 5 -> LambdaFunctionInterfacesWrapper.Function5.class;
            case 6 -> LambdaFunctionInterfacesWrapper.Function6.class;
            case 7 -> LambdaFunctionInterfacesWrapper.Function7.class;
            case 8 -> LambdaFunctionInterfacesWrapper.Function8.class;
            case 9 -> LambdaFunctionInterfacesWrapper.Function9.class;
            case 10 -> LambdaFunctionInterfacesWrapper.Function10.class;
            case 11 -> LambdaFunctionInterfacesWrapper.Function11.class;
            default -> null;
        };
    }


}
