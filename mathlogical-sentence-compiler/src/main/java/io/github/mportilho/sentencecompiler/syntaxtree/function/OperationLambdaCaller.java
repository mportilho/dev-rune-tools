package io.github.mportilho.sentencecompiler.syntaxtree.function;

@FunctionalInterface
public interface OperationLambdaCaller {

    Object call(FunctionContext functionContext, Object[] parameters);

}
