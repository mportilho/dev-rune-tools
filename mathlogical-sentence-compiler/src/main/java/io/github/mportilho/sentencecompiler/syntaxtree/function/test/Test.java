package io.github.mportilho.sentencecompiler.syntaxtree.function.test;

import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.function.Function;

public class Test {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Throwable{
        Class<?> homeHandlerClass = HomeHandler.class;

        Method method = homeHandlerClass.getDeclaredMethod("handle", RoutingContext.class);
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.unreflect(method);

        MethodType factoryMethodType = MethodType.methodType(Function.class, HomeHandler.class);
        MethodType functionMethodType = MethodType.methodType(Boolean.class, Object.class);
        MethodHandle implementationMethodHandle = mh;

        Function lambda =
                (Function) LambdaMetafactory.metafactory(
                                lookup,
                                "apply",
                                factoryMethodType,
                                functionMethodType.generic(),
                                implementationMethodHandle,
                                implementationMethodHandle.type().dropParameterTypes(0, 1))
                        .getTarget()
                        .invokeExact(new HomeHandler()); // capturing instance
        lambda.apply(new RoutingContext());
    }
}
