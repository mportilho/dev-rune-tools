/*******************************************************************************
 * MIT License
 *
 * Copyright (c) 2021-2022. Marcelo Silva Portilho
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

import io.github.mportilho.commons.converters.FormattedConversionService;
import io.github.mportilho.sentencecompiler.data.DataStore;
import io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaCallSite;

import java.math.MathContext;
import java.time.ZoneId;
import java.time.temporal.Temporal;
import java.util.function.Supplier;

import static io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaCallSite.keyName;

public record OperationContext(

        MathContext mathContext,
        Integer scale,
        boolean allowingNull,
        boolean cachingVariableProvider,
        Supplier<Temporal> currentDateTime,
        FormattedConversionService formattedConversionService,
        DataStore dataStore,
        DataStore userDataStore,
        boolean preciseNumbers,
        ZoneId zoneId
) {

    public LambdaCallSite getFunction(String name, int parameterCount) {
        String functionKey = keyName(name, parameterCount);
        LambdaCallSite func = userDataStore.findFunction(functionKey);
        if (func == null) {
            func = dataStore.findFunction(functionKey);
        }
        if (func == null && parameterCount > 1) {
            func = getFunction(name, 1);
        } else if (func == null && parameterCount == 1) {
            return null;
        }
        return func;
    }

}
