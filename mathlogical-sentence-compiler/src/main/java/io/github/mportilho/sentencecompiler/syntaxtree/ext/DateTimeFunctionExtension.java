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

import io.github.mportilho.sentencecompiler.syntaxtree.function.LambdaCallSite;

import java.lang.invoke.MethodType;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.HashMap;
import java.util.Map;

public class DateTimeFunctionExtension {

    private static final Map<String, LambdaCallSite> INSTANCE = internalDateTimeFunctionsFactory();

    public static Map<String, LambdaCallSite> dateTimeFunctionsFactory() {
        return INSTANCE;
    }

    private static Map<String, LambdaCallSite> internalDateTimeFunctionsFactory() {
        LambdaCallSite callSite;
        Map<String, LambdaCallSite> extensions = new HashMap<>();

        callSite = new LambdaCallSite("secondsBetween", MethodType.methodType(Long.class, Temporal.class, Temporal.class),
                (context, parameters) -> ChronoUnit.SECONDS.between((Temporal) parameters[0], (Temporal) parameters[1]));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("minutesBetween", MethodType.methodType(Long.class, Temporal.class, Temporal.class),
                (context, parameters) -> ChronoUnit.MINUTES.between((Temporal) parameters[0], (Temporal) parameters[1]));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("hoursBetween", MethodType.methodType(Long.class, Temporal.class, Temporal.class),
                (context, parameters) -> ChronoUnit.HOURS.between((Temporal) parameters[0], (Temporal) parameters[1]));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("daysBetween", MethodType.methodType(Long.class, Temporal.class, Temporal.class),
                (context, parameters) -> ChronoUnit.DAYS.between((Temporal) parameters[0], (Temporal) parameters[1]));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("monthsBetween", MethodType.methodType(Long.class, Temporal.class, Temporal.class),
                (context, parameters) -> ChronoUnit.MONTHS.between((Temporal) parameters[0], (Temporal) parameters[1]));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("yearsBetween", MethodType.methodType(Long.class, Temporal.class, Temporal.class),
                (context, parameters) -> ChronoUnit.YEARS.between((Temporal) parameters[0], (Temporal) parameters[1]));
        extensions.put(callSite.getKeyName(), callSite);

        return extensions;
    }

}
