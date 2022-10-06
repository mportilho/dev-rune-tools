/*******************************************************************************
 * MIT License
 *
 * Copyright (c) 2021-2022. Marcelo Silva Portilho
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/

package io.github.mportilho.dfr.modules.springjpa.operation;

import io.github.mportilho.commons.converters.FormattedConversionService;
import io.github.mportilho.dfr.core.operation.DataFilter;
import io.github.mportilho.dfr.core.operation.type.StartsWith;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;

/**
 * Implementation of {@link StartsWith} for the Spring Data JPA's
 * {@link Specification} interface
 *
 * @param <T>
 * @author Marcelo Portilho
 */
class SpecStartsWith<T> implements StartsWith<Specification<T>> {

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public Specification<T> createFilter(DataFilter dataFilter, FormattedConversionService formattedConversionService) {
        return (root, query, criteriaBuilder) -> {
            Path<String> path = JpaPredicateUtils.computeAttributePath(dataFilter, root);
            String value = formattedConversionService.convert(dataFilter.findOneValue(), path.getJavaType(), dataFilter.format());

            Expression<String> expression;
            if (dataFilter.ignoreCase()) {
                expression = criteriaBuilder.upper(path);
                value = value != null ? value.toUpperCase() + "%" : null;
            } else {
                expression = path;
                value = value != null ? value + "%" : null;
            }
            return criteriaBuilder.like(expression, value);
        };
    }

}
