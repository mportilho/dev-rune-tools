package io.github.mportilho.sentencecompiler.syntaxtree;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ComputingContext {

    public static final ComputingContext EMPTY = new ComputingContext(Collections.emptyMap(), Collections.emptyMap());

    private final Map<String, Object> dictionary;
    private final Map<String, Function<Object[], Object>> providedFunctions;

    public ComputingContext() {
        this.dictionary = new HashMap<>();
        this.providedFunctions = new HashMap<>();
    }

    public ComputingContext(
            Map<String, Object> dictionary,
            Map<String, Function<Object[], Object>> providedFunctions) {
        this.dictionary = dictionary;
        this.providedFunctions = providedFunctions;
    }

    public Map<String, Object> getDictionary() {
        return dictionary;
    }

    public Map<String, Function<Object[], Object>> getProvidedFunctions() {
        return providedFunctions;
    }

}
