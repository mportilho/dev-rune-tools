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

package io.github.mportilho.sentencecompiler.syntaxtree.ext;

import io.github.mportilho.sentencecompiler.syntaxtree.function.OperationLambdaCaller;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.HashMap;
import java.util.Map;

import static io.github.mportilho.sentencecompiler.syntaxtree.function.FunctionMetadataFactory.keyName;

public class DateTimeFunctionExtension {

    private static final Map<String, OperationLambdaCaller> INSTANCE = internalDateTimeFunctionsFactory();

    public static Map<String, OperationLambdaCaller> dateTimeFunctionsFactory() {
        return INSTANCE;
    }

    private static Map<String, OperationLambdaCaller> internalDateTimeFunctionsFactory() {
        Map<String, OperationLambdaCaller> extensions = new HashMap<>();

        extensions.put(keyName("secondsBetween", 2), (context, params) ->
                ChronoUnit.SECONDS.between((Temporal) params[0], (Temporal) params[1]));

        extensions.put(keyName("minutesBetween", 2), (context, params) ->
                ChronoUnit.MINUTES.between((Temporal) params[0], (Temporal) params[1]));

        extensions.put(keyName("hoursBetween", 2), (context, params) ->
                ChronoUnit.HOURS.between((Temporal) params[0], (Temporal) params[1]));

        extensions.put(keyName("daysBetween", 2), (context, params) ->
                ChronoUnit.DAYS.between((Temporal) params[0], (Temporal) params[1]));

        extensions.put(keyName("monthsBetween", 2), (context, params) ->
                ChronoUnit.MONTHS.between((Temporal) params[0], (Temporal) params[1]));

        extensions.put(keyName("yearsBetween", 2), (context, params) ->
                ChronoUnit.YEARS.between((Temporal) params[0], (Temporal) params[1]));

        return extensions;
    }

}
