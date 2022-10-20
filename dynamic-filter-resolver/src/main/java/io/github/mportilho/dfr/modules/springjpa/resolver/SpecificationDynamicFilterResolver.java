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

package io.github.mportilho.dfr.modules.springjpa.resolver;

import io.github.mportilho.dfr.core.operation.FilterData;
import io.github.mportilho.dfr.core.operation.FilterOperationService;
import io.github.mportilho.dfr.core.processor.ConditionalStatement;
import io.github.mportilho.dfr.core.processor.LogicType;
import io.github.mportilho.dfr.core.resolver.AbstractDynamicFilterResolver;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * A DynamicFilterResolver that converts {@link ConditionalStatement}
 * into {@link Specification} instances
 *
 * @author Marcelo Portilho
 */
public class SpecificationDynamicFilterResolver extends AbstractDynamicFilterResolver<Specification<?>> {

    private final FilterOperationService<Specification<?>> filterOperationService;

    public SpecificationDynamicFilterResolver(FilterOperationService<Specification<?>> filterOperationService) {
        this.filterOperationService = filterOperationService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public <R extends Specification<?>> R emptyPredicate() {
        return (R) Specification.where(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public <R extends Specification<?>> R createPredicateFromStatement(ConditionalStatement conditionalStatement) {
        Specification rootSpec = null;

        for (FilterData clause : conditionalStatement.clauses()) {
            Specification<?> spec = filterOperationService.createFilter(clause);

            if (spec != null) {
                spec = clause.negate() ? Specification.not(spec) : spec;
                if (rootSpec == null) {
                    rootSpec = spec;
                } else {
                    rootSpec = conditionalStatement.isConjunction() ? rootSpec.and(spec) : rootSpec.or(spec);
                }
            }
        }
        return conditionalStatement.negate() ? (R) Specification.not(rootSpec) : (R) rootSpec;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public <R extends Specification<?>> R composePredicatesFromSubStatements(LogicType logicType, R predicate, List<R> subStatementPredicates) {
        Specification currentPredicate = predicate;
        for (Specification subPredicate : subStatementPredicates) {
            if (currentPredicate == null) {
                currentPredicate = subPredicate;
            } else { // sub-statements have opposite logic type of its wrapper statement
                currentPredicate = logicType.isConjunction() ? currentPredicate.or(subPredicate) : currentPredicate.and(subPredicate);
            }
        }
        return (R) currentPredicate;
    }

    @Override
    public FilterOperationService<Specification<?>> getFilterOperationService() {
        return filterOperationService;
    }
}
