/*******************************************************************************
 * MIT License
 *
 * Copyright (c) 2022. Marcelo Silva Portilho
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

package io.github.mportilho.dfr.modules.springjpa.webautoconfigure;

import io.github.mportilho.dfr.modules.springjpa.webautoconfigure.obj.ObjectValidations;
import io.github.mportilho.dfr.modules.springjpa.webautoconfigure.openapi3utils.SchemaValidationUtils;
import io.swagger.v3.oas.models.media.Schema;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;

import static io.github.mportilho.dfr.modules.springjpa.webautoconfigure.openapi3utils.SchemaValidationUtils.applyValidations;


public class TestOpenApi3ValidationOnOperationCustomizer {

    @Test
    public void assert_integerValidations() throws Exception {
        Schema<?> schema;
        Field field = ObjectValidations.class.getDeclaredField("negativeValues");

        schema = new Schema<>();
        schema.setName("numeroDiasValidade");
        schema.setType("integer");
        applyValidations(schema, field);
        assertThat(schema.getMaximum()).isEqualByComparingTo("-1");
        assertThat(schema.getMinimum()).isEqualByComparingTo("-10");
        assertThat(schema.getName()).isEqualTo("numeroDiasValidade");
        assertThat(SchemaValidationUtils.isFieldRequired(field)).isTrue();
    }

    @Test
    public void assert_integer_positiveOrZero() throws Exception {
        Schema<?> schema;
        schema = new Schema<>();
        schema.setName("numeroDiasValidade");
        schema.setType("integer");
        applyValidations(schema, ObjectValidations.class.getDeclaredField("positiveOrZeroNumbers"));
        assertThat(schema.getMaximum()).isEqualByComparingTo(Long.toString(Long.MAX_VALUE));
        assertThat(schema.getMinimum()).isEqualByComparingTo("0");
        assertThat(schema.getName()).isEqualTo("numeroDiasValidade");
    }

    @Test
    public void test_customAnnotation() throws Exception {
        Field field = ObjectValidations.class.getDeclaredField("negativeValues");
        Schema<?> schema;
        schema = new Schema<>();
        schema.setName("name");
        schema.setType("string");

        applyValidations(schema, ObjectValidations.class.getDeclaredField("participantName"));
        assertThat(SchemaValidationUtils.isFieldRequired(field)).isTrue();
        assertThat(schema.getPattern()).isEqualTo("\\w*\\W*");
        assertThat(schema.getMaxLength()).isEqualTo(150);
        assertThat(schema.getMinLength()).isEqualTo(0);
        assertThat(schema.getMaximum()).isNull();
        assertThat(schema.getMinimum()).isNull();
        assertThat(schema.getMaxItems()).isNull();
        assertThat(schema.getMaxItems()).isNull();
    }

    @Test
    public void test_ListParameter() throws Exception {
        Field field = ObjectValidations.class.getDeclaredField("schedule");
        Schema<?> schema;
        schema = new Schema<>();
        schema.setName("calendar");
        schema.setType("array");

        applyValidations(schema, ObjectValidations.class.getDeclaredField("schedule"));
        assertThat(SchemaValidationUtils.isFieldRequired(field)).isTrue();
        assertThat(schema.getMaxLength()).isNull();
        assertThat(schema.getMinLength()).isNull();
        assertThat(schema.getMaximum()).isNull();
        assertThat(schema.getMinimum()).isNull();
        assertThat(schema.getMaxItems()).isEqualTo(300);
        assertThat(schema.getMinItems()).isEqualTo(1);
    }

}
