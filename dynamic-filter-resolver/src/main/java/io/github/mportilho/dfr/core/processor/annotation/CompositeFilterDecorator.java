package io.github.mportilho.dfr.core.processor.annotation;

import io.github.mportilho.commons.converters.FormattedConversionService;
import io.github.mportilho.dfr.core.processor.ConditionalStatement;
import org.apache.commons.lang3.Validate;

import java.util.Collection;

public class CompositeFilterDecorator<T> implements FilterDecorator<T> {

    private final Collection<FilterDecorator<T>> decorators;

    public CompositeFilterDecorator(Collection<FilterDecorator<T>> decorators) {
        this.decorators = Validate.notEmpty(decorators, "Decorator collection cannot be null");
    }

    @Override
    public T decorate(T filter, ConditionalStatement conditionalStatement, FormattedConversionService formattedConversionService) {
        T decorated = filter;
        for (FilterDecorator<T> decorator : decorators) {
            decorated = decorator.decorate(decorated, conditionalStatement, formattedConversionService);
        }
        return decorated;
    }
}
