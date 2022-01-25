package io.github.mportilho.sentencecompiler.syntaxtree.ext;

import io.github.mportilho.sentencecompiler.syntaxtree.function.OperationLambdaCaller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.github.mportilho.sentencecompiler.syntaxtree.function.FunctionMetadataFactory.VARARGS;
import static io.github.mportilho.sentencecompiler.syntaxtree.function.FunctionMetadataFactory.keyName;

public class StringFunctionExtension {

    private static final Map<String, OperationLambdaCaller> INSTANCE = internalStringFunctionsFactory();

    public static Map<String, OperationLambdaCaller> stringFunctionsFactory() {
        return INSTANCE;
    }

    private static Map<String, OperationLambdaCaller> internalStringFunctionsFactory() {
        Map<String, OperationLambdaCaller> extensions = new HashMap<>();

        extensions.put(keyName("concat", VARARGS), (context, params) -> Stream.of(params)
                .filter(Objects::nonNull)
                .map(p -> context.conversionService().convert(p, String.class)).collect(Collectors.joining()));

        extensions.put(keyName("trim", 1), (context, params) ->
                context.conversionService().convert(params[0], String.class).trim());

        return extensions;
    }

}
