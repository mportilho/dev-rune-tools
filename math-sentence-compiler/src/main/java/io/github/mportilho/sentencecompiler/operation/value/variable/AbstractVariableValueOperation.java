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

package io.github.mportilho.sentencecompiler.operation.value.variable;

import io.github.mportilho.sentencecompiler.exceptions.SentenceConfigurationException;
import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.OperationVisitor;

import java.util.Arrays;
import java.util.function.Supplier;

public abstract class AbstractVariableValueOperation extends AbstractOperation {

    private final String variableName;
    private Object value;
    private boolean locked = false;

    public AbstractVariableValueOperation(String variableName) {
        this.variableName = variableName;
    }

    @Override
    protected String getOperationToken() {
        return "";
    }

    /**
     * Sets a new value for this variable overriding the current value without any checks or validations
     *
     * @param value the new value
     */
    protected void overrideValue(Object value) {
        this.value = value;
    }

    /**
     * Sets a new value
     *
     * @param newValue the new value
     * @throws SentenceConfigurationException if the variable is locked or the new value is null
     */
    public void setValue(Object newValue) {
        if (locked) {
            throw new SentenceConfigurationException(String.format("Variable [%s] was set as a constant", variableName));
        }
        if (newValue == null) {
            throw new SentenceConfigurationException(String.format("Variable [%s] received a null value", variableName));
        }
        this.value = newValue;
    }

    /**
     * Sets a new value and locks the variable for modifications
     *
     * @param newValue the new value
     */
    public void setValueAndLock(Object newValue) {
        setValue(newValue);
        this.locked = true;
        this.configureCaching(true);
    }

    /**
     * Copies the internal state of this operation to another one, except for its value
     *
     * @param operation the operation to copy the state to
     */
    protected void copyVariableStateTo(AbstractVariableValueOperation operation) {
        operation.locked = this.locked;
    }

    @Override
    protected void formatRepresentation(StringBuilder builder) {
        if (getCache() != null) {
            builder.append(getCache().getClass().isArray() ? Arrays.toString((Object[]) getCache()) : getCache());
        } else {
            if (getValue() == null || getValue() instanceof VariableProvider || getValue() instanceof Supplier<?>) {
                builder.append(getVariableName());
            } else {
                builder.append(getValue());
            }
        }
    }

    @Override
    public void accept(OperationVisitor<?> visitor) {
        if (value instanceof AbstractOperation operation) {
            operation.accept(visitor);
        }
        visitor.visit(this);
    }

    public String getVariableName() {
        return variableName;
    }

    public Object getValue() {
        return value;
    }

}
