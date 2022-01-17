package io.github.mportilho.commons.converters.impl;

import io.github.mportilho.commons.converters.FormattedConverter;

import java.util.Objects;

public class StringToLongConverter implements FormattedConverter<String, Long, String> {

    @Override
    public Long convert(String source, String format) {
        return Long.parseLong(Objects.requireNonNull(source));
    }

}
