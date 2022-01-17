package io.github.mportilho.sentencecompiler.syntaxtree.function;

public class LambdaFunctionInterfacesWrapper {

    public interface FunctionX {
    }

    public interface Function1 extends FunctionX {
        Object apply(Object p1);
    }

    public interface Function2 extends FunctionX {
        Object apply(Object p1, Object p2);
    }

    public interface Function3 extends FunctionX {
        Object apply(Object p1, Object p2, Object p3);
    }

    public interface Function4 extends FunctionX {
        Object apply(Object p1, Object p2, Object p3, Object p4);
    }

    public interface Function5 extends FunctionX {
        Object apply(Object p1, Object p2, Object p3, Object p4, Object p5);
    }

    public interface Function6 extends FunctionX {
        Object apply(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6);
    }

    public interface Function7 extends FunctionX {
        Object apply(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7);
    }

    public interface Function8 extends FunctionX {
        Object apply(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8);
    }

}
