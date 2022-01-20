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

package io.github.mportilho.sentencecompiler.operation.datetime;

import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.CloningContext;
import io.github.mportilho.sentencecompiler.syntaxtree.OperationContext;

import java.time.LocalDateTime;

public class DateTimeSubtractionOperation extends AbstractDateTimeOperation {

    public DateTimeSubtractionOperation(
            AbstractOperation leftOperand, AbstractOperation rightOperand, DateElementEnum dateElement) {
        super(leftOperand, rightOperand, dateElement);
    }

    @Override
    protected Object resolve(OperationContext context) {
        LocalDateTime leftResult = getLeftOperand().evaluate(context);
        Number rightResult = getRightOperand().evaluate(context);
        return switch (getDateElement()) {
            case SECOND -> leftResult.minusSeconds(rightResult.longValue());
            case MINUTE -> leftResult.minusMinutes(rightResult.longValue());
            case HOUR -> leftResult.minusHours(rightResult.longValue());
            case DAY -> leftResult.minusDays(rightResult.longValue());
            case MONTH -> leftResult.minusMonths(rightResult.longValue());
            case YEAR -> leftResult.minusYears(rightResult.longValue());
        };
    }

    @Override
    protected AbstractOperation createClone(CloningContext context) {
        return new DateTimeSubtractionOperation(getLeftOperand().copy(context), getRightOperand().copy(context), getDateElement());
    }

    @Override
    protected String getOperationToken() {
        return "minus";
    }

}
