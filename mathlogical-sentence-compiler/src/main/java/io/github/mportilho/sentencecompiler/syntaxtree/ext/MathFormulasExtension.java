package io.github.mportilho.sentencecompiler.syntaxtree.ext;

import io.github.mportilho.sentencecompiler.syntaxtree.function.OperationLambdaCaller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static io.github.mportilho.sentencecompiler.syntaxtree.function.FunctionMetadataFactory.keyName;

public class MathFormulasExtension {

    private static final Map<String, OperationLambdaCaller> INSTANCE = internalMathFunctionsFactory();

    public static Map<String, OperationLambdaCaller> mathFunctionsFactory() {
        return INSTANCE;
    }

    private static Map<String, OperationLambdaCaller> internalMathFunctionsFactory() {
        Map<String, OperationLambdaCaller> extensions = new HashMap<>();

        extensions.put(keyName("max", -1), (context, params) -> Stream.of(params)
                .filter(Objects::nonNull)
                .map(p -> context.conversionService().convert(p, BigDecimal.class)).max(BigDecimal::compareTo)
                .orElse(null));

        extensions.put(keyName("min", -1), (context, params) -> Stream.of(params)
                .filter(Objects::nonNull)
                .map(p -> context.conversionService().convert(p, BigDecimal.class)).min(BigDecimal::compareTo)
                .orElse(null));

        extensions.put(keyName("avg", -1), (context, params) -> {
            BigDecimal[] totalWithCount = Stream.of(params).filter(Objects::nonNull)
                    .map(p -> new BigDecimal[]{context.conversionService().convert(p, BigDecimal.class), BigDecimal.ONE})
                    .reduce((a, b) -> new BigDecimal[]{a[0].add(b[0], context.mathContext()), a[1].add(BigDecimal.ONE)})
                    .orElseThrow();
            return totalWithCount[0].divide(totalWithCount[1], context.mathContext());
        });

        //TODO implementar função para o [valor médio - median]

        extensions.put(keyName("rule3d", 3), (context, params) -> {
            BigDecimal p1 = context.conversionService().convert(params[0], BigDecimal.class);
            BigDecimal p2 = context.conversionService().convert(params[1], BigDecimal.class);
            BigDecimal px = context.conversionService().convert(params[2], BigDecimal.class);
            return px.multiply(p2, context.mathContext()).divide(p1, context.mathContext());
        });

        extensions.put(keyName("rule3i", 3), (context, params) -> {
            BigDecimal p1 = context.conversionService().convert(params[0], BigDecimal.class);
            BigDecimal p2 = context.conversionService().convert(params[1], BigDecimal.class);
            BigDecimal px = context.conversionService().convert(params[2], BigDecimal.class);
            return p1.multiply(p2, context.mathContext()).divide(px, context.mathContext());
        });

        return extensions;
    }


}
