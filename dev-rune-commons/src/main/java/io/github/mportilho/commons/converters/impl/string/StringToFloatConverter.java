package io.github.mportilho.commons.converters.impl.string;

import io.github.mportilho.commons.converters.FormattedConverter;

import java.util.Objects;

public class StringToFloatConverter implements FormattedConverter<String, Float, String> {

    @Override
    public Float convert(String source, String format) {
        return Float.valueOf(Objects.requireNonNull(source));
    }
}
