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

package io.github.mportilho.dfr.core.processor.annotation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.stream.Stream;

import static io.github.mportilho.commons.utils.PredicateUtils.isEmpty;

public class ConditionalAnnotationUtils {

    private static final Map<AnnotationProcessorParameter, Map<Annotation, List<Annotation>>> cache = new WeakHashMap<>();

    private ConditionalAnnotationUtils() {
    }

    /**
     * Creates a list of parameter's filters from the annotation
     */
    public static List<Filter> flattenFilterAnnotations(Annotation annotation) {
        List<Filter> specsList = new ArrayList<>();
        if (annotation instanceof Conjunction conjunction) {
            specsList.addAll(Arrays.asList(conjunction.value()));
            specsList.addAll(Stream.of(conjunction.disjunctions()).flatMap(v -> Stream.of(v.value())).toList());
        } else if (annotation instanceof Disjunction disjunction) {
            specsList.addAll(Arrays.asList(disjunction.value()));
            specsList.addAll(Stream.of(disjunction.conjunctions()).flatMap(v -> Stream.of(v.value())).toList());
        } else if (annotation instanceof Statement statement) {
            specsList.addAll(Arrays.asList(statement.value()));
        }
        return specsList;
    }

    /**
     * Extract {@link Filter} annotation from the {@link MethodParameter}'s instance
     */
    public static Stream<Filter> retrieveFilterParameterAnnotations(
            Class<?> parameterType, Annotation[] parameterAnnotations) {
        return retrieveFilterParameterAnnotations(new AnnotationProcessorParameter(parameterType, parameterAnnotations));
    }

    public static Stream<Filter> retrieveFilterParameterAnnotations(AnnotationProcessorParameter annotationProcessorParameter) {
        return findStatementAnnotations(annotationProcessorParameter)
                .values().stream()
                .flatMap(Collection::stream)
                .map(ConditionalAnnotationUtils::flattenFilterAnnotations)
                .flatMap(Collection::stream)
                .filter(filter -> isEmpty(filter.constantValues()));
    }

    /**
     *
     */
    public static Map<Annotation, List<Annotation>> findStatementAnnotations(
            AnnotationProcessorParameter annotationProcessorParameter) {
        return cache.computeIfAbsent(annotationProcessorParameter, ConditionalAnnotationUtils::findStatementAnnotationsInternal);
    }

    /**
     *
     */
    private static Map<Annotation, List<Annotation>> findStatementAnnotationsInternal(
            AnnotationProcessorParameter annotationProcessorParameter) {
        Map<Annotation, List<Annotation>> statementAnnotations = new LinkedHashMap<>();
        for (Class<?> anInterface : extractProcessableInterfaces(annotationProcessorParameter.type())) {
            statementAnnotations.putAll(extractFilterAnnotations(anInterface));
        }
        statementAnnotations.putAll(ConditionalAnnotationUtils.extractFilterAnnotations(annotationProcessorParameter.annotations()));
        return statementAnnotations;
    }

    /**
     * Gets the {@link Field}'s representation on the specific type
     */
    public static Field findFilterField(Class<?> clazz, String fieldName) {
        final String[] fieldNames = fieldName.split("\\.", -1);
        // if using dot notation to navigate for classes
        if (fieldNames.length > 1) {
            final String firstProperty = fieldNames[0];
            final String otherProperties = StringUtils.join(fieldNames, '.', 1, fieldNames.length);
            final Field firstPropertyType = findFilterField(clazz, firstProperty);

            Class<?> actualClass = null;
            if (!Object.class.equals(firstPropertyType.getType())) {
                if (Collection.class.isAssignableFrom(firstPropertyType.getType())) {
                    actualClass = (Class<?>) ((ParameterizedType) firstPropertyType.getGenericType()).getActualTypeArguments()[0];
                } else {
                    actualClass = firstPropertyType.getType();
                }
            }

            if (actualClass != null) {
                return findFilterField(actualClass, otherProperties);
            }
        }

        try {
            return clazz.getDeclaredField(fieldName);
        } catch (final NoSuchFieldException e) {
            if (!clazz.getSuperclass().equals(Object.class)) {
                return findFilterField(clazz.getSuperclass(), fieldName);
            }
            throw new IllegalStateException(String.format("Field '%s' does not exist in type '%s'", fieldName, clazz.getCanonicalName()));
        }
    }

    /**
     *
     */
    protected static List<Class<?>> extractProcessableInterfaces(Class<?> clazz) {
        if (clazz == null) {
            return Collections.emptyList();
        }
        List<Class<?>> interfacesFound = new ArrayList<>();
        interfacesFound.add(clazz);
        getAllInterfaces(clazz, interfacesFound);
        return interfacesFound;
    }

    /**
     *
     */
    private static void getAllInterfaces(Class<?> clazz, List<Class<?>> interfacesFound) {
        while (clazz != null) {
            Class<?>[] interfaces = clazz.getInterfaces();
            for (Class<?> i : interfaces) {
                if (!i.getPackageName().startsWith("java.")) {
                    interfacesFound.add(i);
                    getAllInterfaces(i, interfacesFound);
                }
            }
            clazz = clazz.getSuperclass();
        }
    }

    /**
     *
     */
    protected static Map<Annotation, List<Annotation>> extractFilterAnnotations(Class<?> type) {
        if (type == null) {
            return Collections.emptyMap();
        }
        Map<Annotation, List<Annotation>> annotationsFound = new LinkedHashMap<>();
        List<Annotation> annotations = new ArrayList<>(Arrays.asList(type.getAnnotations()));
        annotations.removeIf(a -> a.annotationType().getPackageName().startsWith("java.lang.annotation"));
        if (!annotations.isEmpty()) {
            VirtualAnnotationHolder virtualAnnotationHolder = new VirtualAnnotationHolder(type, annotations);
            getAllAnnotations(virtualAnnotationHolder, annotationsFound);
        }
        return annotationsFound;
    }

    /**
     *
     */
    protected static Map<Annotation, List<Annotation>> extractFilterAnnotations(Annotation[] annotations) {
        if (annotations == null || annotations.length == 0) {
            return Collections.emptyMap();
        }
        Map<Annotation, List<Annotation>> annotationsFound = new LinkedHashMap<>();
        List<Annotation> annotationList = new ArrayList<>(Arrays.asList(annotations));
        annotationList.removeIf(a -> a.annotationType().getPackageName().startsWith("java.lang.annotation"));
        if (!annotationList.isEmpty()) {
            VirtualAnnotationHolder virtualAnnotationHolder = new VirtualAnnotationHolder(VirtualAnnotationHolder.class, annotationList);
            getAllAnnotations(virtualAnnotationHolder, annotationsFound);
        }
        return annotationsFound;
    }

    /**
     *
     */
    private static boolean getAllAnnotations(
            Annotation annotation, Map<Annotation, List<Annotation>> annotationsFound) {
        List<Annotation> annotations;
        if (annotation instanceof VirtualAnnotationHolder virtualAnnotationHolder) {
            annotations = virtualAnnotationHolder.getAnnotations();
        } else {
            annotations = new ArrayList<>(Arrays.asList(annotation.annotationType().getAnnotations()));
        }
        annotations.removeIf(a
                -> a.annotationType().getPackageName().startsWith("java.lang.annotation")
                || a.annotationType().getPackageName().startsWith("kotlin"));

        if (annotations.isEmpty()) {
            return annotation.annotationType() == Conjunction.class || annotation.annotationType() == Disjunction.class;
        }

        for (Annotation i : annotations) {
            boolean foundStatementAnnotation = getAllAnnotations(i, annotationsFound);
            if (foundStatementAnnotation) {
                annotationsFound.computeIfAbsent(annotation, k -> new ArrayList<>()).add(i);
            }
        }
        return false;
    }

}
