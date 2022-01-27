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