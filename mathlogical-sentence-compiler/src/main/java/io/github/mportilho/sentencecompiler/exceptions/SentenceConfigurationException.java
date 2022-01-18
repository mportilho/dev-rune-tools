package io.github.mportilho.sentencecompiler.exceptions;

public class SentenceConfigurationException extends RuntimeException {

    public SentenceConfigurationException(String message) {
        super(message);
    }

    public SentenceConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public SentenceConfigurationException(Throwable cause) {
        super(cause);
    }

    public SentenceConfigurationException(
            String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
