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

package io.github.mportilho.dfr.core.processor;

import io.github.mportilho.dfr.core.operation.DataFilter;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * It's the representation of a set of logic clauses and optional set of correlated sub-statements
 *
 * @author Marcelo Portilho
 */
public record ConditionalStatement(
        String id,
        LogicType logicType,
        boolean negate,
        DataFilter[] clauses,
        ConditionalStatement[] oppositeStatements,
        Map<String, DataFilter> decoratableFilters
) {

    public ConditionalStatement {
        Objects.requireNonNull(clauses, "Clause list cannot be null");
        Objects.requireNonNull(oppositeStatements, "Opposite statement list cannot be null");
    }

    public Optional<DataFilter> getDecorableFilter(String key) {
        return Optional.ofNullable(decoratableFilters.get(key));
    }

    public Optional<DataFilter> findClauseByPath(String path) {
        for (DataFilter clause : clauses) {
            if (clause != null && path.equals(clause.path())) {
                return Optional.of(clause);
            }
        }
        return Optional.empty();
    }

    /**
     * @return An indication that this statement has no clauses nor sub-statements
     */
    public boolean hasNoCondition() {
        return clauses != null && oppositeStatements != null && clauses.length == 0 && oppositeStatements.length == 0;
    }

    /**
     * @return True if this statement applies conjunction logic. False if it applies
     * disjunction logic
     */
    public boolean isConjunction() {
        return LogicType.CONJUNCTION.equals(logicType);
    }

}
