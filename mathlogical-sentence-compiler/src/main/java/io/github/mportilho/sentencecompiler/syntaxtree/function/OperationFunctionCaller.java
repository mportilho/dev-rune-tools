package io.github.mportilho.sentencecompiler.syntaxtree.function;

import io.github.mportilho.commons.converters.FormattedConversionService;

public class OperationFunctionCaller {

    private final OperationLambdaCaller caller;
    private final int parameterCount;
    private final FormattedConversionService conversionService;

    public OperationFunctionCaller(
            OperationLambdaCaller caller, Class<?>[] parameterTypes, FormattedConversionService conversionService) {
        this.caller = caller;
        this.parameterCount = parameterTypes == null ? -1 : parameterTypes.length;
        this.conversionService = conversionService;
    }

    public OperationFunctionCaller(
            Class<?>[] parameterTypes, Object lambda, FormattedConversionService conversionService) {
        this.caller = FunctionMetadataUtils.createStaticLambdaCaller(lambda, parameterTypes);
        this.parameterCount = parameterTypes.length;
        this.conversionService = conversionService;
    }

    public OperationFunctionCaller(
            Class<?>[] parameterTypes, Object lambda, Object instance, FormattedConversionService conversionService) {
        this.caller = FunctionMetadataUtils.createLambdaCaller(lambda, instance, parameterTypes);
        this.parameterCount = parameterTypes.length;
        this.conversionService = conversionService;
    }

    public Object call(Object... parameters) {
        validateCallParameters(parameters);
        return caller.apply(conversionService, parameters != null ? parameters : new Object[]{});
    }

    private void validateCallParameters(Object[] parameters) {
        if (this.parameterCount == -1) {
            return;
        }
        if (parameters == null) {
            if (parameterCount != 0) {
                throw new IllegalArgumentException(String.format("Wrong parameter count. Expected [%s] parameters, got [%s]",
                        parameterCount, 0));
            }
        } else if (parameters.length != parameterCount) {
            throw new IllegalArgumentException(String.format("Wrong parameter count. Expected [%s] parameters, got [%s]",
                    parameterCount, parameters.length));
        }
    }

}