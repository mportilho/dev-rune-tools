package io.github.mportilho.sentencecompiler.syntaxtree;

import io.github.mportilho.sentencecompiler.syntaxtree.function.OperationLambdaCaller;

import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.emptyMap;

public class OperationSupportData {

    public static final OperationSupportData EMPTY_DATA = new OperationSupportData(emptyMap(), emptyMap());

    private final Map<String, Object> dictionary;
    private final Map<String, OperationLambdaCaller> functions;

    public OperationSupportData() {
        this.dictionary = new HashMap<>();
        this.functions = new HashMap<>();
    }

    public OperationSupportData(
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

    public OperationSupportData putDictionary(String key, Object value) {
        dictionary.put(key, value);
        return this;
    }

    public OperationSupportData putFunction(String key, OperationLambdaCaller function) {
        functions.put(key, function);
        return this;
    }

}
