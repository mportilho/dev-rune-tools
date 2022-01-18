/*MIT License

Copyright (c) 2021 Marcelo Portilho

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.*/

package io.github.mportilho.sentencecompiler.syntaxtree;

import io.github.mportilho.commons.converters.FormattedConversionService;
import io.github.mportilho.sentencecompiler.syntaxtree.function.OperationFunctionCaller;

import java.math.MathContext;
import java.time.LocalDateTime;

public record OperationContext(

        MathContext mathContext,
        Integer scale,
        boolean allowingNull,
        LocalDateTime currentDateTime,
        FormattedConversionService formattedConversionService,
        ExecutionContext executionContext,
        ExecutionContext userExecutionContext
) {

    public Object readDictionary(String name) {
        Object value = userExecutionContext.getDictionary().get(name);
        if (value == null && userExecutionContext != executionContext) {
            value = executionContext.getDictionary().get(name);
        }
        return value;
    }

    public OperationFunctionCaller getFunction(String name) {
        OperationFunctionCaller func = userExecutionContext.getFunctions().get(name);
        if (func == null && userExecutionContext != executionContext) {
            func = executionContext.getFunctions().get(name);
        }
        return func;
    }

}
