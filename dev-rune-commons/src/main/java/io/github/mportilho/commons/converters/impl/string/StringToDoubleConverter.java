package io.github.mportilho.commons.converters.impl.string;

import io.github.mportilho.commons.converters.FormattedConverter;

import java.util.Objects;

public class StringToDoubleConverter implements FormattedConverter<String, Double, String> {

    @Override
    public Double convert(String source, String format) {
        return Double.valueOf(Objects.requireNonNull(source));
    }

}
