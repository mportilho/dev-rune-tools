package io.github.mportilho.sentencecompiler.syntaxtree.function;

import io.github.mportilho.commons.converters.FormattedConversionService;

import java.util.function.BiFunction;

public interface LambdaCallerInterface extends BiFunction<FormattedConversionService, Object[], Object> {
}
