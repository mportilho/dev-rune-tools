package io.github.mportilho.sentencecompiler.syntaxtree.function;

import io.github.mportilho.commons.converters.DefaultFormattedConversionService;
import io.github.mportilho.commons.converters.FormattedConversionService;
import io.github.mportilho.sentencecompiler.syntaxtree.function.teste2.Person;

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

    public static void main(String[] args) throws Throwable {
        Map<String, DynamicFunctionCaller> callerMap =
                FunctionMetadataFactory.createCallSite(new Person("teste person"), new DefaultFormattedConversionService());
        System.out.println(callerMap);
    }

    public static Map<String, DynamicFunctionCaller> createCallSite(
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

            boolean isStaticMethod = isStatic(method.getModifiers());
            if (isStaticMethod) {
                String key = method.getName() + "_" + method.getParameterCount();
                dynamicCallerPool.put(key, createStaticDynamicCaller(lookup, method, clazz, conversionService));
            } else if (!isClassObject) {
                String key = method.getName() + "_" + method.getParameterCount();
                dynamicCallerPool.put(key, createDynamicCaller(lookup, method, clazz, functionProvider, conversionService));
            }
        }
        return dynamicCallerPool;
    }

    private static DynamicFunctionCaller createStaticDynamicCaller(
            MethodHandles.Lookup lookup, Method method, Class<?> clazz,
            FormattedConversionService conversionService) throws Throwable {
        return null;
    }

    private static DynamicFunctionCaller createDynamicCaller(
            MethodHandles.Lookup lookup, Method method, Class<?> clazz, Object instance,
            FormattedConversionService conversionService) throws Throwable {
        Class<?> factoryInterface = findFactoryInterface(method.getParameterCount() + 1);

        MethodType functionMethodType;
        if (method.getParameterCount() == 0) {
            functionMethodType = MethodType.methodType(method.getReturnType());
        } else {
            functionMethodType = MethodType.methodType(method.getReturnType(), method.getParameterTypes());
        }
        MethodHandle implementationMethodHandle = lookup.findVirtual(clazz, method.getName(), functionMethodType);

        CallSite callSite = LambdaMetafactory.metafactory(
                lookup,
                "apply",
                MethodType.methodType(factoryInterface), // factoryMethodType
                MethodType.genericMethodType(method.getParameterCount() + 1),
                implementationMethodHandle,
                functionMethodType.insertParameterTypes(0, clazz));

        return new DynamicFunctionCaller(method.getParameterTypes(), callSite.getTarget().invoke(), instance, conversionService);
    }

    private static Class<?> findFactoryInterface(int parameterNumber) {
        return switch (parameterNumber) {
            case 1 -> LambdaFunctionInterfacesWrapper.Function1.class;
            case 2 -> LambdaFunctionInterfacesWrapper.Function2.class;
            case 3 -> LambdaFunctionInterfacesWrapper.Function3.class;
            case 4 -> LambdaFunctionInterfacesWrapper.Function4.class;
            case 5 -> LambdaFunctionInterfacesWrapper.Function5.class;
            case 6 -> LambdaFunctionInterfacesWrapper.Function6.class;
            default -> null;
        };
    }


}
