package io.github.mportilho.sentencecompiler.exceptions;

public class MathSentenceLockingException extends RuntimeException {

    public MathSentenceLockingException(String message) {
        super(message);
    }

    public MathSentenceLockingException(String message, Throwable cause) {
        super(message, cause);
    }

    public MathSentenceLockingException(Throwable cause) {
        super(cause);
    }

    public MathSentenceLockingException(
            String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
