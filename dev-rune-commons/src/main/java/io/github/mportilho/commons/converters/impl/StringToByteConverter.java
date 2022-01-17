package io.github.mportilho.commons.converters.impl;

import io.github.mportilho.commons.converters.FormattedConverter;

import java.util.Objects;

public class StringToByteConverter implements FormattedConverter<String, Byte, String> {

    @Override
    public Byte convert(String source, String format) {
        return Byte.valueOf(Objects.requireNonNull(source));
    }
}
