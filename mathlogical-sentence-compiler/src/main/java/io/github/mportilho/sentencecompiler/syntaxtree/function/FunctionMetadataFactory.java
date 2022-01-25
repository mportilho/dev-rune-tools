package io.github.mportilho.sentencecompiler.syntaxtree.function;

import io.github.mportilho.sentencecompiler.exceptions.SyntaxExecutionException;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.lang.invoke.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.github.mportilho.sentencecompiler.syntaxtree.function.LambdaWrapper.createLambdaCaller;
import static io.github.mportilho.sentencecompiler.syntaxtree.function.LambdaWrapper.createStaticLambdaCaller;
import static java.lang.reflect.Modifier.isStatic;

public class FunctionMetadataFactory {

    public static final int VARARGS = -1;
    public static final int UNKNOWN = -1;

    public static Map<String, OperationLambdaCaller> createFunctionCaller(Object functionProvider) throws Throwable {
        Objects.requireNonNull(functionProvider, "Parameter [functionProvider] must not be null");
        boolean isClassObject = functionProvider instanceof Class<?>;
        Class<?> clazz = isClassObject ? (Class<?>) functionProvider : functionProvider.getClass();
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Object.class);

        Map<String, OperationLambdaCaller> dynamicCallerPool = new HashMap<>();
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        for (MethodDescriptor methodDescriptor : beanInfo.getMethodDescriptors()) {
            Method method = methodDescriptor.getMethod();
            if (void.class.equals(method.getReturnType()) || !Modifier.isPublic(method.getModifiers())) {
                continue;
            }

            if (findFactoryInterface(method.getParameterCount()) == null) {
                dynamicCallerPool.put(keyName(method),
                        createMethodHandleCaller(lookup, method, functionProvider));
            } else if (isStatic(method.getModifiers())) {
                dynamicCallerPool.put(keyName(method),
                        createStaticCaller(lookup, method));
            } else if (!isClassObject) {
                dynamicCallerPool.put(keyName(method),
                        createDynamicCaller(lookup, method, functionProvider));
            }
        }
        return dynamicCallerPool;
    }

    // slower
    private static OperationLambdaCaller createMethodHandleCaller(
            MethodHandles.Lookup lookup, Method method, Object instance) throws Throwable {

        MethodHandle methodHandle = instance == null ? lookup.unreflect(method) : lookup.unreflect(method).bindTo(instance);
        MethodHandle callableMethodHandle = methodHandle.asType(methodHandle.type().generic())
                .asSpreader(Object[].class, methodHandle.type().parameterCount());

        Class<?>[] parameterArray = methodHandle.type().parameterArray();
        return (context, params) -> {
            Object[] callingParameters = new Object[params.length];
            for (int i = 0; i < parameterArray.length; i++) {
                callingParameters[i] = context.conversionService().convert(params[i], parameterArray[i], null);
            }
            try {
                return callableMethodHandle.invokeExact(callingParameters);
            } catch (Throwable e) {
                throw new SyntaxExecutionException("Error calling dynamic function", e);
            }
        };
    }

    private static OperationLambdaCaller createStaticCaller(
            MethodHandles.Lookup lookup, Method method) throws Throwable {

        Class<?> clazz = method.getDeclaringClass();
        Class<?> factoryInterface = findFactoryInterface(method.getParameterCount());
        MethodType functionMethodType = MethodType.methodType(method.getReturnType(), method.getParameterTypes());
        MethodHandle implementationMethodHandle = lookup.findStatic(clazz, method.getName(), functionMethodType);
        CallSite callSite = LambdaMetafactory.metafactory(lookup,
                "call",
                MethodType.methodType(factoryInterface),
                functionMethodType.generic(),
                implementationMethodHandle,
                functionMethodType);
        return createStaticLambdaCaller(callSite.getTarget().invoke(), method.getParameterTypes());
    }

    private static OperationLambdaCaller createDynamicCaller(
            MethodHandles.Lookup lookup, Method method, Object instance) throws Throwable {

        Class<?> clazz = method.getDeclaringClass();
        Class<?> factoryInterface = findFactoryInterface(method.getParameterCount() + 1);
        MethodType functionMethodType = MethodType.methodType(method.getReturnType(), method.getParameterTypes());
        MethodHandle implementationMethodHandle = lookup.findVirtual(clazz, method.getName(), functionMethodType);

        CallSite callSite = LambdaMetafactory.metafactory(lookup,
                "call",
                MethodType.methodType(factoryInterface), // factoryMethodType
                MethodType.genericMethodType(method.getParameterCount() + 1), // method params plus instance object
                implementationMethodHandle,
                functionMethodType.insertParameterTypes(0, clazz)); // method params plus instance object
        return createLambdaCaller(callSite.getTarget().invoke(), instance, method.getParameterTypes());
    }

    public static String keyName(Method method) {
        return keyName(method.getName(), method.getParameterCount());
    }

    public static String keyName(String methodName, int parameterCount) {
        return methodName + "_" + parameterCount;
    }

    private static String generateMethodSignature(String methodName, MethodType type) {
        StringBuilder sb = new StringBuilder();
        sb.append(type.returnType().getSimpleName());
        sb.append(' ').append(methodName).append('(');
        int count = type.parameterCount();
        Class<?>[] ptypes = type.parameterArray();
        for (int i = 0; i < count; i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(ptypes[i].getSimpleName());
        }
        sb.append(')');
        return sb.toString();
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


}
