package io.github.mportilho.dfr.core.processor;

import io.github.mportilho.dfr.core.processor.annotation.FilterDecorator;

import java.util.Map;

public record FilterDefinition(
        ConditionalStatement statement,
        FilterDecorator<?> decorator,
        Map<String, Object[]> parameters
) {

    /**
     * @param statement  Conditional statement representation for conversion
     * @param decorator  Decorator to be used for the resulting filtering object
     * @param parameters Provided filter parameters
     */
    public FilterDefinition {
    }

    public boolean hasNoConditions() {
        return statement == null || statement.hasNoCondition();
    }
}
