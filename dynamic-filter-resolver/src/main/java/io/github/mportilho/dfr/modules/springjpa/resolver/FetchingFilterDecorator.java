package io.github.mportilho.dfr.modules.springjpa.resolver;

import io.github.mportilho.commons.converters.FormattedConversionService;
import io.github.mportilho.dfr.core.processor.ConditionalStatement;
import io.github.mportilho.dfr.core.processor.annotation.FilterDecorator;
import io.github.mportilho.dfr.modules.springjpa.annotations.Fetching;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.mapping.PropertyPath;

import javax.persistence.criteria.From;
import java.util.Collection;
import java.util.Map;

public class FetchingFilterDecorator implements FilterDecorator<Specification<?>> {

    private final Collection<Fetching> fetches;

    public FetchingFilterDecorator(Collection<Fetching> fetches) {
        this.fetches = fetches;
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public Specification<?> decorate(Specification<?> filter, ConditionalStatement conditionalStatement,
                                     Map<String, Object[]> parametersMap, FormattedConversionService formattedConversionService) {
        if (fetches == null || fetches.isEmpty()) {
            return filter;
        }
        Specification<?> decoratedSpec = (root, query, criteriaBuilder) -> {
            query.distinct(true);
            for (Fetching fetching : fetches) {
                for (String attributePath : fetching.value()) {
                    From<?, ?> from = root;
                    PropertyPath propertyPath = PropertyPath.from(attributePath, root.getJavaType());
                    while (propertyPath != null && propertyPath.hasNext()) {
                        from = (From<?, ?>) root.fetch(propertyPath.getSegment(), fetching.joinType());
                        propertyPath = propertyPath.next();
                    }
                    if (propertyPath != null) {
                        from.fetch(propertyPath.getSegment(), fetching.joinType());
                    } else {
                        throw new IllegalStateException(
                                String.format("Expected parsing to yield a PropertyPath from %s but got null!", attributePath));
                    }
                }
            }
            return null;
        };
        return ((Specification) decoratedSpec).and(filter);
    }

}
