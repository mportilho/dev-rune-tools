package io.github.mportilho.sentencecompiler.syntaxtree.ext;

import io.github.mportilho.sentencecompiler.syntaxtree.function.OperationLambdaCaller;

import java.util.Map;

public class DateTimeFunctionExtension {

    private static final Map<String, OperationLambdaCaller> INSTANCE = internalDateTimeFunctionsFactory();

    public static Map<String, OperationLambdaCaller> dateTimeFunctionsFactory() {
        return INSTANCE;
    }

    private static Map<String, OperationLambdaCaller> internalDateTimeFunctionsFactory() {
        // daysBetween
        return null;
    }

}
