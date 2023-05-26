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

import io.github.mportilho.sentencecompiler.operation.value.variable.AssignedVariableOperation;
import io.github.mportilho.sentencecompiler.operation.value.constant.precise.PreciseNumberConstantValueOperation;
import io.github.mportilho.sentencecompiler.OperationContext;
import io.github.mportilho.sentencecompiler.testutils.MathSentenceCompilerMockupFactory;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

class TestBaseOperation {

    private final OperationContext context = MathSentenceCompilerMockupFactory.getPreciseOperationContext();

    @Test
    void testBaseOperation() {
        BaseOperation operation = new BaseOperation(null, null);
        assertThat(operation.<Boolean>evaluate(context)).isFalse();
    }

    @Test
    void testBaseOperationWithOperationMap() {
        Map<String, AssignedVariableOperation> map = new HashMap<>();
        map.put("one", new AssignedVariableOperation("one", new PreciseNumberConstantValueOperation("1")));
        map.put("two", new AssignedVariableOperation("two", new PreciseNumberConstantValueOperation("2")));

        BaseOperation operation = new BaseOperation(null, map);
        assertThat(operation.<Boolean>evaluate(context)).isFalse();
    }

    @Test
    void testCopingBaseOperation() throws Throwable {
        BaseOperation operation = new BaseOperation(null, null);
        BaseOperation copyOperation = (BaseOperation) operation.copy(new CloningContext());

        assertThat(operation).isNotEqualTo(copyOperation);
        assertThat(operation.<Boolean>evaluate(context)).isFalse();
        assertThat(copyOperation.<Boolean>evaluate(context)).isFalse();
    }

    @Test
    void testCopingBaseOperationWithOperationMap() throws Throwable {
        Map<String, AssignedVariableOperation> map = new HashMap<>();
        map.put("one", new AssignedVariableOperation("one", new PreciseNumberConstantValueOperation("1")));
        map.put("two", new AssignedVariableOperation("two", new PreciseNumberConstantValueOperation("2")));

        BaseOperation operation = new BaseOperation(null, map);
        BaseOperation copyOperation = (BaseOperation) operation.copy(new CloningContext());

        assertThat(operation).isNotEqualTo(copyOperation);
        assertThat(operation.<Boolean>evaluate(context)).isFalse();
        assertThat(copyOperation.<Boolean>evaluate(context)).isFalse();

        for (String key : operation.getAssignedVariables().keySet()) {
            assertThat(operation.getAssignedVariables().get(key)).isNotEqualTo(copyOperation.getAssignedVariables().get(key));
        }
    }

}
