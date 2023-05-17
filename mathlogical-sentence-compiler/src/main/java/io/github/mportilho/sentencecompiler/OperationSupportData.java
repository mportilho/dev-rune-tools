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

package io.github.mportilho.sentencecompiler;

import io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaCallSite;
import io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaCallSiteFactory;

import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.emptyMap;

public class OperationSupportData {

    public static final OperationSupportData EMPTY_DATA = new OperationSupportData(emptyMap(), emptyMap());

    private final Map<String, Object> dictionary;
    private final Map<String, LambdaCallSite> functions;

    public OperationSupportData() {
        this.dictionary = new HashMap<>();
        this.functions = new HashMap<>();
    }

    public OperationSupportData(
            Map<String, Object> dictionary,
            Map<String, LambdaCallSite> functions) {
        this.dictionary = dictionary;
        this.functions = functions;
    }

    public Map<String, Object> getDictionary() {
        return dictionary;
    }

    public LambdaCallSite getFunction(String key) {
        return functions.getOrDefault(key, LambdaCallSiteFactory.DEFAULT_FUNCTIONS.get(key));
    }

    public void putDictionary(String key, Object value) {
        dictionary.put(key, value);
    }

    public void putFunction(String key, LambdaCallSite function) {
        functions.put(key, function);
    }

    public Map<String, LambdaCallSite> getFunctions() {
        return functions;
    }

}
