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

package io.github.mportilho.sentencecompiler.operation;

import io.github.mportilho.commons.converters.NoFormattedConverterFoundException;
import io.github.mportilho.sentencecompiler.exceptions.SyntaxExecutionException;
import io.github.mportilho.sentencecompiler.operation.value.variable.AbstractVariableValueOperation;
import io.github.mportilho.sentencecompiler.syntaxtree.OperationContext;
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.OperationVisitor;

import java.util.Objects;

/**
 * Default behavior for all operations
 *
 * @author Marcelo Portilho
 */
public abstract class AbstractOperation {

    private Object cache;
    private AbstractOperation[] cacheBlockingSemaphores;

    private AbstractOperation[] parents = {};
    private Class<?> expectedType;
    private boolean applyingParenthesis;

    public AbstractOperation() {
        this.expectedType = Object.class;
    }

    protected abstract Object resolve(OperationContext context);

    protected abstract AbstractOperation createClone(CloningContext context);

    protected abstract String getOperationToken();

    public abstract void accept(OperationVisitor<?> visitor);

    protected abstract void formatRepresentation(StringBuilder builder);

    /**
     * @return signal for enabling caches
     */
    public boolean getCacheHint() {
        return true;
    }

    public boolean shouldResetOperation(OperationContext context) {
        return false;
    }

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
            if (isCaching()) {
                if (cache == null) {
                    result = resolve(context); // resolve method can disable cache
                    cache = isCaching() ? result : null;
                } else {
                    result = cache;
                }
            } else {
                result = resolve(context);
                cache = isCaching() ? result : null;
            }
            result = castOperationResult(result, context);
        } catch (ClassCastException e) {
            throw new SyntaxExecutionException(String.format("Wrong operands type for expression [%s]", this), e);
        } catch (ArithmeticException e) {
            throw new SyntaxExecutionException(String.format("Arithmetic error computing expression [%s]", this), e);
        } catch (NullPointerException | SyntaxExecutionException e) {
            throw e;
        } catch (Exception e) {
            throw new SyntaxExecutionException(String.format("Error computing expression [%s]", this), e);
        }

        if (result == null && !context.allowingNull()) {
            if (this instanceof AbstractVariableValueOperation) {
                throw new SyntaxExecutionException(String.format("Variable [%s] requires a value", this));
            } else {
                throw new NullPointerException(String.format("Invalid null result for expression [%s] ", this));
            }
        }
        return (T) result;
    }

    private Object castOperationResult(Object result, OperationContext operationContext) {
        if (result != null && !result.getClass().isArray() && !getExpectedType().isArray() && !getExpectedType().equals(result.getClass())) {
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
        AbstractOperation operation = null;
        if (parents.length == 1 && parents[0] instanceof BaseOperation) {
            operation = parents[0];
        } else if (this instanceof BaseOperation) {
            operation = this;
        }
        if (operation != null && Boolean.class.equals(e.getSourceType()) && Number.class.isAssignableFrom(e.getTargetType())) {
            expectedType(Boolean.class);
            operation.expectedType(Boolean.class);
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
        if (this.cacheBlockingSemaphores != null && this.cacheBlockingSemaphores.length != 0) {
            copy.cacheBlockingSemaphores = new AbstractOperation[this.cacheBlockingSemaphores.length];
            for (int i = 0, blockingSemaphoresLength = this.cacheBlockingSemaphores.length; i < blockingSemaphoresLength; i++) {
                copy.cacheBlockingSemaphores[i] = cloningContext.getClonedOperationsMap().get(this.cacheBlockingSemaphores[i]);
            }
        }
        return copy;
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
        AbstractOperation[] newArray = new AbstractOperation[parents.length + 1];
        System.arraycopy(parents, 0, newArray, 0, parents.length);
        newArray[newArray.length - 1] = operation;
        parents = newArray;
    }

    public void configureCaching(boolean enable) {
        if (enable && !isCaching()) {
            enableCaching(this, this);
        } else if (!enable) {
            disableCaching(this, this);
        }
    }

    private void enableCaching(AbstractOperation semaphore, AbstractOperation operation) {
        if (operation.cacheBlockingSemaphores != null && operation.cacheBlockingSemaphores.length > 0) {
            if (operation.cacheBlockingSemaphores.length == 1 && operation.cacheBlockingSemaphores[0] == semaphore) {
                operation.cacheBlockingSemaphores = new AbstractOperation[0];
                for (AbstractOperation parent : operation.parents) {
                    enableCaching(semaphore, parent);
                }
            } else if (operation.cacheBlockingSemaphores.length > 1) {
                int index = findSemaphoreIndex(semaphore, operation);
                if (index != -1) {
                    AbstractOperation[] temp = new AbstractOperation[operation.cacheBlockingSemaphores.length - 1];
                    System.arraycopy(operation.cacheBlockingSemaphores, 0, temp, 0, index);
                    System.arraycopy(operation.cacheBlockingSemaphores, index + 1, temp, index,
                            operation.cacheBlockingSemaphores.length - index - 1);
                    operation.cacheBlockingSemaphores = temp;
                    for (AbstractOperation parent : operation.parents) {
                        enableCaching(semaphore, parent);
                    }
                }
            }
        }
    }

    private void disableCaching(AbstractOperation semaphore, AbstractOperation operation) {
        operation.cache = null;
        if (operation.cacheBlockingSemaphores == null) {
            operation.cacheBlockingSemaphores = new AbstractOperation[1];
            operation.cacheBlockingSemaphores[0] = semaphore;
            for (AbstractOperation parent : operation.parents) {
                disableCaching(semaphore, parent);
            }
        } else {
            if (findSemaphoreIndex(semaphore, operation) == -1) {
                AbstractOperation[] temp = new AbstractOperation[operation.cacheBlockingSemaphores.length + 1];
                System.arraycopy(operation.cacheBlockingSemaphores, 0, temp, 0, operation.cacheBlockingSemaphores.length);
                temp[temp.length - 1] = semaphore;
                operation.cacheBlockingSemaphores = temp;
                for (AbstractOperation parent : operation.parents) {
                    disableCaching(semaphore, parent);
                }
            }
        }
    }

    public int findSemaphoreIndex(AbstractOperation semaphore, AbstractOperation operation) {
        for (int i = 0, cacheLength = operation.cacheBlockingSemaphores.length; i < cacheLength; i++) {
            if (operation.cacheBlockingSemaphores[i] == semaphore) {
                return i;
            }
        }
        return -1;
    }

    protected boolean isCaching() {
        return cacheBlockingSemaphores == null || cacheBlockingSemaphores.length == 0;
    }

    public void clearCache() {
        clearCache(this);
    }

    private void clearCache(AbstractOperation operation) {
        operation.cache = null;
        for (AbstractOperation parent : operation.parents) {
            clearCache(parent);
        }
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
    public boolean isNotApplyingParenthesis() {
        return !applyingParenthesis;
    }

    /**
     * Builds a String representation of the current operation
     *
     * @param builder the {@link StringBuilder} object where the representation will
     *                be placed
     */
    public final void toString(StringBuilder builder) {
        if (applyingParenthesis) {
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
