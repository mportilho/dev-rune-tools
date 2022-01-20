package io.github.mportilho.commons.converters;

import java.util.Objects;

public class NoFormattedConverterFoundException extends RuntimeException {

    private final Class<?> sourceType;
    private final Class<?> targetType;

    public NoFormattedConverterFoundException(Class<?> sourceType, Class<?> targetType) {
        super(String.format("No converter found for source type [%s] and target type [%s]",
                sourceType.getCanonicalName(), targetType.getCanonicalName()));
        this.sourceType = Objects.requireNonNull(sourceType);
        this.targetType = Objects.requireNonNull(targetType);
    }

    public NoFormattedConverterFoundException(String message, Class<?> sourceType, Class<?> targetType) {
        super(message);
        this.sourceType = Objects.requireNonNull(sourceType);
        this.targetType = Objects.requireNonNull(targetType);
    }

    public NoFormattedConverterFoundException(
            String message, Throwable cause, Class<?> sourceType, Class<?> targetType) {
        super(message, cause);
        this.sourceType = Objects.requireNonNull(sourceType);
        this.targetType = Objects.requireNonNull(targetType);
    }

    public Class<?> getSourceType() {
        return sourceType;
    }

    public Class<?> getTargetType() {
        return targetType;
    }
}
