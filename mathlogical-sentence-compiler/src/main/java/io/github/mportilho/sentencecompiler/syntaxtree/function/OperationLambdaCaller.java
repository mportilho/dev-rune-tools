package io.github.mportilho.sentencecompiler.syntaxtree.function;

import io.github.mportilho.commons.converters.FormattedConversionService;

import java.util.function.BiFunction;

public interface OperationLambdaCaller extends BiFunction<FormattedConversionService, Object[], Object> {
}
