package io.github.mportilho.commons.utils;

public class AssertUtils {

    public static void notNullOrBlank(String value, String message, Object... params) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(String.format(message, params));
        }
    }

}
