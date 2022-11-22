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

package io.github.mportilho.dfr.modules.springjpa.webautoconfigure.openapi3utils;

import io.github.mportilho.dfr.core.processor.annotation.Filter;
import io.swagger.v3.oas.models.media.Schema;
import org.springframework.core.annotation.AnnotationUtils;

import jakarta.validation.constraints.*;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.math.BigDecimal;

public class SchemaValidationUtils {

    /**
     * Applies Bean Validation's requirements on the request parameter based on the
     * annotated attribute located on the {@link Filter#path()}
     */
    public static void applyValidations(Schema<?> schema, AnnotatedElement annotatedElement) {
        if (isNumberType(schema)) {
            if (AnnotationUtils.findAnnotation(annotatedElement, PositiveOrZero.class) != null) {
                schema.setMaximum(BigDecimal.valueOf(Long.MAX_VALUE));
                schema.setMinimum(BigDecimal.ZERO);
            }

            Min min = AnnotationUtils.findAnnotation(annotatedElement, Min.class);
            if (min != null) {
                schema.setMinimum(new BigDecimal(min.value()));
            }

            Max max = AnnotationUtils.findAnnotation(annotatedElement, Max.class);
            if (max != null) {
                schema.setMaximum(new BigDecimal(max.value()));
            }

            DecimalMin decimalMin = AnnotationUtils.findAnnotation(annotatedElement, DecimalMin.class);
            if (decimalMin != null) {
                schema.setMinimum(new BigDecimal(decimalMin.value()));
                schema.setExclusiveMinimum(!decimalMin.inclusive());
            }

            DecimalMax decimalMax = AnnotationUtils.findAnnotation(annotatedElement, DecimalMax.class);
            if (decimalMax != null) {
                schema.setMaximum(new BigDecimal(decimalMax.value()));
                schema.setExclusiveMaximum(!decimalMax.inclusive());
            }
        }

        if (isStringType(schema)) {
            Size size = AnnotationUtils.findAnnotation(annotatedElement, Size.class);
            if (size != null) {
                schema.minLength(size.min());
                schema.maxLength(size.max());
            }

            Pattern pattern = AnnotationUtils.findAnnotation(annotatedElement, Pattern.class);
            if (pattern != null) {
                schema.setPattern(pattern.regexp());
            }
        }

        if (isArrayType(schema)) {
            Size size = AnnotationUtils.findAnnotation(annotatedElement, Size.class);
            if (size != null) {
                schema.setMinItems(size.min());
                schema.setMaxItems(size.max());
            }
        }
    }

    private static boolean isNumberType(Schema<?> schema) {
        return "integer".equals(schema.getType()) || "number".equals(schema.getType());
    }

    private static boolean isStringType(Schema<?> schema) {
        return "string".equals(schema.getType());
    }

    private static boolean isArrayType(Schema<?> schema) {
        return "array".equals(schema.getType());
    }

    public static boolean isFieldRequired(Field field) {
        return AnnotationUtils.findAnnotation(field, NotNull.class) != null
                || AnnotationUtils.findAnnotation(field, NotBlank.class) != null
                || AnnotationUtils.findAnnotation(field, NotEmpty.class) != null;
    }

}
