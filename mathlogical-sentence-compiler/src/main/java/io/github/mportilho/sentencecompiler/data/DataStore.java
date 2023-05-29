/*******************************************************************************
 * MIT License
 *
 * Copyright (c) 2022. Marcelo Silva Portilho
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/

package io.github.mportilho.sentencecompiler.data;

import io.github.mportilho.commons.utils.AssertUtils;
import io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaCallSite;
import io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaCallSiteFactory;

import java.lang.invoke.MethodType;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

import static java.util.Collections.emptyMap;

public class DataStore {

    public static final DataStore EMPTY_DATA = new DataStore(null, emptyMap(), emptyMap());

    private VariableStore variableStore;
    private final Map<String, Object> dictionary;
    private final Map<String, LambdaCallSite> functions;

    public DataStore() {
        this.variableStore = null;
        this.dictionary = new HashMap<>();
        this.functions = new HashMap<>();
    }

    public DataStore(VariableStore variableStore, Map<String, Object> dictionary, Map<String, LambdaCallSite> functions) {
        this.variableStore = variableStore;
        this.dictionary = dictionary;
        this.functions = functions;
    }

    public Object findValue(String name) {
        Object value;
        if (variableStore != null && (value = variableStore.getValue(name)) != null) {
            return value;
        }
        return dictionary.get(name);
    }

    public LambdaCallSite findFunction(String key) {
        return functions.getOrDefault(key, LambdaCallSiteFactory.DEFAULT_FUNCTIONS.get(key));
    }

    public VariableStore getVariableStore() {
        return variableStore;
    }

    public void setVariableStore(VariableStore variableStore) {
        this.variableStore = variableStore;
    }

    public void putDictionary(String key, Object value) {
        AssertUtils.notNullOrBlank(key, "Dictionary entry name required");
        Objects.requireNonNull(value, "Dictionary entry value required");
        dictionary.put(key, value);
    }

    public void putAllDictionary(Map<String, Object> dictionary) {
        Objects.requireNonNull(dictionary, "Cannot add a null dictionary to execution context");
        this.dictionary.putAll(dictionary);
    }

    public void putFunction(LambdaCallSite function) {
        Objects.requireNonNull(function, "Function implementation is required");
        functions.put(function.getKeyName(), function);
    }

    public void putFunction(String functionName, MethodType methodType, Function<Object[], Object> function) {
        Objects.requireNonNull(functionName, "Function name must be provided");
        Objects.requireNonNull(methodType, "Function method type must be provided");
        Objects.requireNonNull(function, "Function must be provided");
        LambdaCallSite lambdaCallSite = new LambdaCallSite(functionName, methodType, function);
        functions.put(lambdaCallSite.getKeyName(), lambdaCallSite);
    }

}
