package io.github.mportilho.commons.converters;

public class NoFormattedConverterFoundException extends RuntimeException {

    public NoFormattedConverterFoundException() {
    }

    public NoFormattedConverterFoundException(String message) {
        super(message);
    }

    public NoFormattedConverterFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoFormattedConverterFoundException(Throwable cause) {
        super(cause);
    }

    public NoFormattedConverterFoundException(
            String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
