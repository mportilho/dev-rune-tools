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

package io.github.mportilho.dfr.core.resolver;


import io.github.mportilho.commons.converters.FormattedConversionService;
import io.github.mportilho.dfr.core.operation.FilterOperationService;
import io.github.mportilho.dfr.core.processor.ConditionalStatement;
import io.github.mportilho.dfr.core.processor.annotation.FilterDecorator;

import java.util.Collections;
import java.util.Map;

/**
 * Represents the operation for converting a {@link ConditionalStatement}, with
 * the provided parameters for filtering data, to an input for a specific query
 * framework, like Spring Data JPA's Specification object.
 *
 * @param <T> Return type of the target query object for this dynamic filter
 * @author Marcelo Portilho
 */
public interface DynamicFilterResolver<T> {

    FilterOperationService<T> getFilterOperationService();

    /**
     * Converts the conditional statement to a target framework's query structure
     * object
     *
     * @param <R>                  Return type of the target query object for this
     *                             dynamic filter
     * @param conditionalStatement Conditional statement representation for
     *                             conversion
     * @return The query object created from this dynamic filter resolver
     */
    default <R extends T> R convertTo(ConditionalStatement conditionalStatement) {
        return convertTo(conditionalStatement, null, Collections.emptyMap());
    }

    /**
     * Converts the conditional statement to a target framework's query structure
     * object
     *
     * @param <R>                  Return type of the target query object for this
     *                             dynamic filter
     * @param conditionalStatement Conditional statement representation for
     *                             conversion.
     * @param decorator            Decorator to be used for the resulting filtering object
     * @param parametersMap        User provided parameters
     * @return The query object created from this dynamic filter resolver
     */
    <R extends T> R convertTo(ConditionalStatement conditionalStatement, FilterDecorator<T> decorator,
                              Map<String, Object[]> parametersMap);

    /**
     * A method that can be overridden to decorate the resulting converted object
     *
     * @param <R>             Return type of the target query object for this dynamic
     *                        filter
     * @param filter          The resulting query object created from this dynamic filter
     * @param filterDecorator decarates the resulting filter
     * @param parametersMap   User provided parameters
     * @return The decorated query object
     */
    @SuppressWarnings({"unchecked"})
    default <R extends T> R decorateFilters(
            R filter, FilterDecorator<T> filterDecorator, ConditionalStatement conditionalStatement,
            Map<String, Object[]> parametersMap, FormattedConversionService formattedConversionService) {
        if (filterDecorator == null) {
            return filter;
        }
        return (R) filterDecorator.decorate(filter, conditionalStatement, parametersMap, formattedConversionService);
    }

}
