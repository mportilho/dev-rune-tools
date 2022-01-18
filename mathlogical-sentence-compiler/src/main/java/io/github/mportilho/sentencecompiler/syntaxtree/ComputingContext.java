package io.github.mportilho.sentencecompiler.syntaxtree;

import io.github.mportilho.sentencecompiler.syntaxtree.function.DynamicFunctionCaller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ComputingContext {

    public static final ComputingContext EMPTY = new ComputingContext(Collections.emptyMap(), Collections.emptyMap());

    private final Map<String, Object> dictionary;
    private final Map<String, DynamicFunctionCaller> providedFunctions;

    public ComputingContext() {
        this.dictionary = new HashMap<>();
        this.providedFunctions = new HashMap<>();
    }

    public ComputingContext(
            Map<String, Object> dictionary,
            Map<String, DynamicFunctionCaller> providedFunctions) {
        this.dictionary = dictionary;
        this.providedFunctions = providedFunctions;
    }

    public Map<String, Object> getDictionary() {
        return dictionary;
    }

    public Map<String, DynamicFunctionCaller> getProvidedFunctions() {
        return providedFunctions;
    }

}
