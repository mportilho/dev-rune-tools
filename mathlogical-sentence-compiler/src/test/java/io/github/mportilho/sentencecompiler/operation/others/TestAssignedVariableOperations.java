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

package io.github.mportilho.sentencecompiler.operation.others;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import io.github.mportilho.sentencecompiler.testutils.MathSentenceCompilerMockupFactory;
import org.junit.jupiter.api.Test;

import io.github.mportilho.sentencecompiler.operation.CloningContext;
import io.github.mportilho.sentencecompiler.OperationContext;
import io.github.mportilho.sentencecompiler.operation.other.AssignedVariableOperation;
import io.github.mportilho.sentencecompiler.operation.value.constant.precise.PreciseNumberConstantValueOperation;

public class TestAssignedVariableOperations {

	private final OperationContext context = MathSentenceCompilerMockupFactory.getPreciseOperationContext();

	@Test
	public void testAssignedVariableOperation() {
		PreciseNumberConstantValueOperation valueOperation = new PreciseNumberConstantValueOperation("2");
		AssignedVariableOperation operation = new AssignedVariableOperation("AB", valueOperation);

		assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("2");
		assertThat(operation.getVariableName()).isEqualTo("AB");
	}

	@Test
	public void testCopingAssignedVariableOperation() throws Throwable {
		PreciseNumberConstantValueOperation valueOperation = new PreciseNumberConstantValueOperation("2");
		AssignedVariableOperation operation = new AssignedVariableOperation("AB", valueOperation);

		AssignedVariableOperation copyOperation = (AssignedVariableOperation) operation.copy(new CloningContext());

		assertThat(operation).isNotEqualTo(copyOperation);
		assertThat(operation.getValue()).isNotEqualTo(copyOperation.getValue());
		assertThat(operation.<BigDecimal>evaluate(context)).isEqualByComparingTo("2");
		assertThat(copyOperation.<BigDecimal>evaluate(context)).isEqualByComparingTo("2");
		assertThat(operation.getVariableName()).isEqualTo("AB");
		assertThat(copyOperation.getVariableName()).isEqualTo("AB");
	}

}
