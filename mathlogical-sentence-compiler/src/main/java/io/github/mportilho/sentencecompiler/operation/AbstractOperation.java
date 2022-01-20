/*MIT License

Copyright (c) 2021 Marcelo Portilho

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.*/

package io.github.mportilho.sentencecompiler.operation;

import io.github.mportilho.commons.converters.NoFormattedConverterFoundException;
import io.github.mportilho.sentencecompiler.exceptions.SyntaxExecutionException;
import io.github.mportilho.sentencecompiler.operation.value.variable.AbstractVariableValueOperation;
import io.github.mportilho.sentencecompiler.syntaxtree.OperationContext;
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.OperationVisitor;

import java.util.*;

/**
 * Default behavior for all operations
 *
 * @author Marcelo Portilho
 */
public abstract class AbstractOperation {

    private Object cache;
    private Set<AbstractOperation> cacheBlockingSemaphores;

    private List<AbstractOperation> parents;
    private Class<?> expectedType;
    private boolean applyingParenthesis;

    public AbstractOperation() {
        this.expectedType = Object.class;
    }

    protected abstract Object resolve(OperationContext context);

    protected abstract AbstractOperation createClone(CloningContext context);

    protected abstract String getOperationToken();

    public abstract <T> T accept(OperationVisitor<T> visitor);

    protected abstract void formatRepresentation(StringBuilder builder);

    /**
     * Evaluates the current operation for it's resulting value. If the current
     * operation was previously evaluated, returns it's cached value.
     *
     * @param <T>     Dynamic return type
     * @param context a holder of the evaluation proccess properties
     * @return the operation's evaluation result
     */
    @SuppressWarnings("unchecked")
    public final <T> T evaluate(OperationContext context) {
        Object result;
        try {
            result = readValue(context);
            result = castOperationResult(result, context);
        } catch (ClassCastException e) {
            throw new IllegalStateException(String.format("Wrong operands type for expression %s", this), e);
        } catch (ArithmeticException e) {
            ArithmeticException newException = new ArithmeticException(
                    String.format("Arithmetic error for expression '%s': %s", this, e.getMessage()));
            newException.setStackTrace(e.getStackTrace());
            throw newException;
        } catch (SyntaxExecutionException e) {
            throw new IllegalStateException(e.getMessage(), e.getCause());
        } catch (IllegalArgumentException | IllegalStateException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalStateException(String.format("Error during calculation of expression '%s'", this), e);
        }
        if (result == null && !context.allowingNull()) {
            if (this instanceof AbstractVariableValueOperation) {
                throw new IllegalArgumentException(String.format("The variable '%s' does not have any provided value", this));
            } else {
                throw new NullPointerException(String.format("Not expecting null for expression value '%s' ", this));
            }
        }
        return (T) result;
    }

    private Object readValue(OperationContext context) {
        Object result;
        if (isCaching()) {
            if (cache == null) {
                result = resolve(context); // resolve method can disable cache
                cache = isCaching() ? result : null;
            } else {
                result = cache;
            }
        } else {
            result = resolve(context);
        }
        return result;
    }

    private Object castOperationResult(Object result, OperationContext operationContext) {
        if (result != null && !getExpectedType().equals(result.getClass())) {
            try {
                return operationContext.formattedConversionService().convert(result, getExpectedType(), null);
            } catch (NoFormattedConverterFoundException e) {
                return castOperationFromDetectedAmbiguity(result, e);
            }
        }
        return result;
    }

    /**
     * Possible ambiguity located on root expression. Ex.: "f.someFunction()" doesn't have a predictable return type
     */
    private Object castOperationFromDetectedAmbiguity(Object result, NoFormattedConverterFoundException e) {
        if (parents != null && parents.size() == 1
                && parents.get(0) instanceof BaseOperation baseOperation
                && Boolean.class.equals(e.getSourceType()) && Number.class.isAssignableFrom(e.getTargetType())) {
            expectedType(Boolean.class);
            baseOperation.expectedType(Boolean.class);
            return result;
        } else {
            throw new SyntaxExecutionException(
                    String.format("Wrong expected value type on expression [%s]. Expected [%s], got [%s]",
                            this, e.getTargetType(), e.getSourceType()), e);
        }
    }

    /**
     * Makes a copy of the current operation, with its properties and cache value
     *
     * @param cloningContext a holder of the cloning operation temporary properties
     * @return a new copy of this object
     */
    public final AbstractOperation copy(CloningContext cloningContext) {
        AbstractOperation copy;
        if (cloningContext.getClonedOperationsMap().containsKey(this)) {
            copy = cloningContext.getClonedOperationsMap().get(this);
        } else {
            copy = createClone(cloningContext).copyAtributes(this);
            cloningContext.getClonedOperationsMap().put(this, copy);
        }
        if (this.cacheBlockingSemaphores != null && !this.cacheBlockingSemaphores.isEmpty()) {
            copy.cacheBlockingSemaphores = new HashSet<>(this.cacheBlockingSemaphores.size());
            for (AbstractOperation cacheBlocker : this.cacheBlockingSemaphores) {
                copy.cacheBlockingSemaphores.add(cloningContext.getClonedOperationsMap().get(cacheBlocker));
            }
        }
        return copy;
    }

    public boolean shouldResetOperation(OperationContext context) {
        return false;
    }

    @SuppressWarnings({"unchecked"})
    public final <T extends AbstractOperation> T expectedType(Class<?> expectedType) {
        this.expectedType = Objects.requireNonNull(expectedType);
        return (T) this;
    }

    private AbstractOperation copyAtributes(AbstractOperation sourceOperation) {
        this.cache = sourceOperation.cache;
        this.applyingParenthesis = sourceOperation.applyingParenthesis;
        this.expectedType = sourceOperation.expectedType;
        return this;
    }

    /**
     * Indicates the string representation must be wrapped by parenthesis
     */
    public void applyingParenthesis() {
        this.applyingParenthesis = true;
    }

    /**
     * Adds a parent operation node
     *
     * @param operation the parent of this operation
     */
    public void addParent(AbstractOperation operation) {
        if (operation == null) {
            return;
        }
        if (parents == null) {
            parents = new ArrayList<>();
        }
        parents.add(operation);
    }

    public void setCachingOptions(boolean enable) {
        if (enable) {
            enableCaching(this);
        } else {
            disableCaching(this);
        }
    }

    private void enableCaching(AbstractOperation semaphore) {
        if (this.cacheBlockingSemaphores == null) {
            return;
        }
        if (this.cacheBlockingSemaphores.remove(semaphore)) {
            for (AbstractOperation parent : getParents()) {
                parent.enableCaching(semaphore);
            }
        }
    }

    private void disableCaching(AbstractOperation semaphore) {
        if (this.cacheBlockingSemaphores == null) {
            this.cacheBlockingSemaphores = new HashSet<>(3);
        }
        this.cache = null;
        if (this.cacheBlockingSemaphores.add(semaphore)) {
            for (AbstractOperation parent : getParents()) {
                parent.disableCaching(semaphore);
            }
        }
    }

    public boolean isDisablingCache() {
        return this.cacheBlockingSemaphores != null && this.cacheBlockingSemaphores.contains(this);
    }

    protected boolean isCaching() {
        return this.cacheBlockingSemaphores == null || this.cacheBlockingSemaphores.isEmpty();
    }

    public void clearCache() {
        clearCache(null);
    }

    protected final void clearCache(Set<Class<? extends AbstractOperation>> limitingOperationTypesMap) {
        this.cache = null;
        for (AbstractOperation currParent : getParents()) {
            if (limitingOperationTypesMap == null || !limitingOperationTypesMap.contains(getClass())) {
                currParent.clearCache(limitingOperationTypesMap);
            }
        }
    }

    protected List<AbstractOperation> getParents() {
        return parents != null ? parents : Collections.emptyList();
    }

    /**
     * Retrieves the current cached value for this operation
     *
     * @return The current cache for this operation. Returns <code>null</code> if
     * the operation was not evaluated or cache is disabled
     */
    public Object getCache() {
        return cache;
    }

    public Class<?> getExpectedType() {
        return expectedType;
    }

    /**
     *
     */
    public boolean isApplyingParenthesis() {
        return applyingParenthesis;
    }

    /**
     * Builds a String representation of the current operation
     *
     * @param builder the {@link StringBuilder} object where the representation will
     *                be placed
     */
    public final void toString(StringBuilder builder) {
        if (this.applyingParenthesis) {
            builder.append('(');
            formatRepresentation(builder);
            builder.append(')');
        } else {
            formatRepresentation(builder);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        toString(builder);
        return builder.toString();
    }

}
