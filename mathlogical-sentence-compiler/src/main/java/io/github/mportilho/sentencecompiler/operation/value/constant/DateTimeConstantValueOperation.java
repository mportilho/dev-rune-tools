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

package io.github.mportilho.sentencecompiler.operation.value.constant;

import io.github.mportilho.commons.utils.DateUtils;
import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.CloningContext;
import io.github.mportilho.sentencecompiler.syntaxtree.OperationContext;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class DateTimeConstantValueOperation extends AbstractConstantValueOperation {

    public DateTimeConstantValueOperation(String value) {
        super(value);
    }

    @Override
    protected AbstractOperation createClone(CloningContext context) {
        return new DateTimeConstantValueOperation(getValue());
    }

    @Override
    protected Object resolve(OperationContext context) {
        try {
            return DateUtils.DATETIME_FORMATTER.parse(getValue(), ZonedDateTime::from);
        } catch (DateTimeException e) {
            return ZonedDateTime.of(DateUtils.DATETIME_FORMATTER.parse(getValue(), LocalDateTime::from),
                    context.currentDateTime().getZone());
        }
    }

}
