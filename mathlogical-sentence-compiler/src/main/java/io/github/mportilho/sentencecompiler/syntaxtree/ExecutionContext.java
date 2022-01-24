package io.github.mportilho.sentencecompiler.syntaxtree;

import io.github.mportilho.sentencecompiler.syntaxtree.function.OperationLambdaCaller;

import java.util.HashMap;
import java.util.Map;

public class ExecutionContext {

    private final Map<String, Object> dictionary;
    private final Map<String, OperationLambdaCaller> functions;

    public ExecutionContext() {
        this.dictionary = new HashMap<>();
        this.functions = new HashMap<>();
    }

    public ExecutionContext(
            Map<String, Object> dictionary,
            Map<String, OperationLambdaCaller> functions) {
        this.dictionary = dictionary;
        this.functions = functions;
    }

    public Map<String, Object> getDictionary() {
        return dictionary;
    }

    public Map<String, OperationLambdaCaller> getFunctions() {
        return functions;
    }

}
