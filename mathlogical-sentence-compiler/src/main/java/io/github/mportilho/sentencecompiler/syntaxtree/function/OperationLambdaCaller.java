package io.github.mportilho.sentencecompiler.syntaxtree.function;

@FunctionalInterface
public interface OperationLambdaCaller {

    Object apply(FunctionContext functionContext, Object[] parameters);

}
