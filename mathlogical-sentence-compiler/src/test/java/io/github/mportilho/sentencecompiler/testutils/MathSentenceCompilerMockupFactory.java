package io.github.mportilho.sentencecompiler.testutils;

import io.github.mportilho.commons.converters.impl.DefaultFormattedConversionService;
import io.github.mportilho.sentencecompiler.syntaxtree.ExecutionContext;
import io.github.mportilho.sentencecompiler.syntaxtree.OperationContext;

import java.math.MathContext;
import java.time.LocalDateTime;

public class MathSentenceCompilerMockupFactory {

    public static OperationContext getOperationContext() {
        return new OperationContext(MathContext.DECIMAL64, 8, false, LocalDateTime.now(),
                new DefaultFormattedConversionService(), new ExecutionContext(), new ExecutionContext());
    }

    public static OperationContext getOperationContext(boolean allowingNull) {
        return new OperationContext(MathContext.DECIMAL64, 8, allowingNull, LocalDateTime.now(),
                new DefaultFormattedConversionService(), new ExecutionContext(), new ExecutionContext());
    }

}
