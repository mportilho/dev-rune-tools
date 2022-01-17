package io.github.mportilho.sentencecompiler.syntaxtree.function.teste2;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.function.Function;

public class MyAccessor {

    private final Function getterFunction;

    public MyAccessor() throws Throwable{
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        CallSite site = LambdaMetafactory.metafactory(lookup,
                "apply",
                MethodType.methodType(Function.class),
                MethodType.methodType(Object.class, Object.class),
                lookup.findVirtual(Person.class, "getName", MethodType.methodType(String.class, int.class)),
                MethodType.methodType(String.class, Person.class));
        getterFunction = (Function) site.getTarget().invokeExact();
    }

    public Object executeGetter(Object bean) {
        return getterFunction.apply(bean);
    }

    public static void main(String[] args) throws Throwable {
        System.out.println(new MyAccessor().getterFunction.apply(new Person("teste person")));
    }

}
