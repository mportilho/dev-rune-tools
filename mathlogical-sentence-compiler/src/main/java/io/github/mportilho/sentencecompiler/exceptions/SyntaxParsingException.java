package io.github.mportilho.sentencecompiler.exceptions;

public class SyntaxParsingException extends RuntimeException {

    public SyntaxParsingException(String message) {
        super(message);
    }

    public SyntaxParsingException(String message, Throwable cause) {
        super(message, cause);
    }

    public SyntaxParsingException(Throwable cause) {
        super(cause);
    }

    public SyntaxParsingException(
            String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
