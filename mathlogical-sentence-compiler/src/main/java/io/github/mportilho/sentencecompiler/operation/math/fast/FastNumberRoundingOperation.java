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

package io.github.mportilho.sentencecompiler.operation.math.fast;

import io.github.mportilho.sentencecompiler.operation.AbstractBinaryOperation;
import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.CloningContext;
import io.github.mportilho.sentencecompiler.OperationContext;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FastNumberRoundingOperation extends AbstractBinaryOperation {

    private final RoundingEnum roundingEnum;

    public FastNumberRoundingOperation(
            AbstractOperation leftOperand, AbstractOperation rightOperand, RoundingEnum roundingEnum) {
        super(leftOperand, rightOperand);
        this.roundingEnum = roundingEnum;
    }

    @Override
    protected Object resolve(OperationContext context) {
        Double number = getLeftOperand().evaluate(context);
        Double roundingFactor = getRightOperand().evaluate(context);
        return switch (roundingEnum) {
            case CEILING -> BigDecimal.valueOf(number).setScale(roundingFactor.intValue(), RoundingMode.CEILING).doubleValue();
            case DOWN -> BigDecimal.valueOf(number).setScale(roundingFactor.intValue(), RoundingMode.DOWN).doubleValue();
            case FLOOR -> BigDecimal.valueOf(number).setScale(roundingFactor.intValue(), RoundingMode.FLOOR).doubleValue();
            case HALF_DOWN -> BigDecimal.valueOf(number).setScale(roundingFactor.intValue(), RoundingMode.HALF_DOWN).doubleValue();
            case HALF_EVEN -> BigDecimal.valueOf(number).setScale(roundingFactor.intValue(), RoundingMode.HALF_EVEN).doubleValue();
            case HALF_UP -> BigDecimal.valueOf(number).setScale(roundingFactor.intValue(), RoundingMode.HALF_UP).doubleValue();
            case UP -> BigDecimal.valueOf(number).setScale(roundingFactor.intValue(), RoundingMode.UP).doubleValue();
            case UNNECESSARY -> BigDecimal.valueOf(number).setScale(roundingFactor.intValue(), RoundingMode.UNNECESSARY).doubleValue();
		};
    }

    @Override
    protected AbstractOperation createClone(CloningContext context) {
        return new FastNumberRoundingOperation(getLeftOperand().copy(context), getRightOperand().copy(context), roundingEnum);
    }

    @Override
    public void formatRepresentation(StringBuilder builder) {
        builder.append(getOperationToken()).append('(');
        getLeftOperand().toString(builder);
        builder.append(", ");
        getRightOperand().toString(builder);
        builder.append(')');
    }

    @Override
    protected String getOperationToken() {
        return roundingEnum.toString();
    }

    public RoundingEnum getRoundingEnum() {
        return roundingEnum;
    }

    public enum RoundingEnum {
        UP("up"), DOWN("down"), CEILING("ceiling"), FLOOR("floor"), HALF_UP("halfUp"), HALF_DOWN("halfDown"), HALF_EVEN("halfEven"),
        UNNECESSARY("Unnecessary");

        private final String mnemonic;

        RoundingEnum(String mnemonic) {
            this.mnemonic = mnemonic;
        }

        @Override
        public String toString() {
            return mnemonic;
        }
    }
}
