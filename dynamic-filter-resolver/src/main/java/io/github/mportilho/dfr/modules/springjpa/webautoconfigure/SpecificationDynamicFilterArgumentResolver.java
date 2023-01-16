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

package io.github.mportilho.dfr.modules.springjpa.webautoconfigure;

import io.github.mportilho.dfr.core.processor.ConditionalStatement;
import io.github.mportilho.dfr.core.processor.ConditionalStatementProcessor;
import io.github.mportilho.dfr.core.processor.FilterDefinition;
import io.github.mportilho.dfr.core.processor.annotation.AnnotationProcessorParameter;
import io.github.mportilho.dfr.core.processor.annotation.CompositeFilterDecorator;
import io.github.mportilho.dfr.core.processor.annotation.FilterDecorator;
import io.github.mportilho.dfr.core.processor.annotation.FilterDecorators;
import io.github.mportilho.dfr.core.resolver.DynamicFilterResolver;
import io.github.mportilho.dfr.modules.springjpa.annotations.Fetching;
import io.github.mportilho.dfr.modules.springjpa.resolver.FetchingFilterDecorator;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.MethodParameter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.HandlerMapping;

import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Resolves interfaces assignable from {@link Specification} into valid queries.
 * These structures must be annotated with Conjunction or Disjunction types.
 *
 * @author Marcelo Portilho
 */
public class SpecificationDynamicFilterArgumentResolver implements HandlerMethodArgumentResolver {

    private final ApplicationContext applicationContext;
    private final ConditionalStatementProcessor<AnnotationProcessorParameter> conditionalStatementProcessor;
    private final DynamicFilterResolver<Specification<?>> dynamicFilterResolver;

    public SpecificationDynamicFilterArgumentResolver(ApplicationContext applicationContext, ConditionalStatementProcessor<AnnotationProcessorParameter> conditionalStatementProcessor, DynamicFilterResolver<Specification<?>> dynamicFilterResolver) {
        this.applicationContext = applicationContext;
        this.conditionalStatementProcessor = conditionalStatementProcessor;
        this.dynamicFilterResolver = dynamicFilterResolver;
    }

    /**
     * {@link Inherited}
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> parameterType = parameter.getParameterType();
        return parameterType.isInterface() && Specification.class.isAssignableFrom(parameterType);
    }

    /**
     * {@link Inherited}
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        Map<String, Object[]> userParameters = createProvidedValuesMap(webRequest);
        ConditionalStatement statement = conditionalStatementProcessor.createStatements(new AnnotationProcessorParameter(parameter.getParameterType(), parameter.getParameterAnnotations()), userParameters);
        FilterDecorator<Specification<?>> filterDecorator = createFilterDecoratorByFetchingAnnotation(parameter);
        FilterDefinition filterDefinition = new FilterDefinition(statement, filterDecorator, userParameters);
        return createProxy(dynamicFilterResolver.createFilter(filterDefinition), parameter.getParameterType());
    }

    @SuppressWarnings({"unchecked"})
    private FilterDecorator<Specification<?>> createFilterDecoratorByFetchingAnnotation(MethodParameter parameter) {
        List<FilterDecorator<Specification<?>>> decoratorList = null;

        FetchingFilterDecorator fetchingDecorator = createFetchingDecorator(parameter);
        if (fetchingDecorator != null) {
            decoratorList = new ArrayList<>();
            decoratorList.add(fetchingDecorator);
        }

        FilterDecorators annotation = parameter.getParameterAnnotation(FilterDecorators.class);
        if (annotation != null) {
            if (decoratorList == null) {
                decoratorList = new ArrayList<>();
            }
            for (Class<? extends FilterDecorator<?>> aClass : annotation.value()) {
                Map<String, ? extends FilterDecorator<?>> beansOfType = applicationContext.getBeansOfType(aClass);
                if (beansOfType.isEmpty()) {
                    try {
                        decoratorList.add((FilterDecorator<Specification<?>>) aClass.getConstructor().newInstance());
                    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                             InvocationTargetException e) {
                        throw new RuntimeException(e); //TODO create a new exception. Suggested name: FilterArgumentResolverException
                    }
                } else {
                    for (FilterDecorator<?> filterDecorator : beansOfType.values()) {
                        decoratorList.add((FilterDecorator<Specification<?>>) filterDecorator);
                    }
                }
            }
        }
        return decoratorList != null ? new CompositeFilterDecorator<>(decoratorList) : null;
    }

    private FetchingFilterDecorator createFetchingDecorator(MethodParameter parameter) {
        List<Fetching> fetches = new ArrayList<>();
        for (Annotation annotation : parameter.getParameterAnnotations()) {
            if (annotation.annotationType().equals(Fetching.class)) {
                fetches.add((Fetching) annotation);
            }
        }
        return fetches.isEmpty() ? null : new FetchingFilterDecorator(fetches);
    }

    /**
     * Creates a new value provider map from the request parameters
     */
    @SuppressWarnings("unchecked")
    private Map<String, Object[]> createProvidedValuesMap(NativeWebRequest webRequest) {
        HttpServletRequest httpServletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        Map<String, Object[]> providedParameterValuesMap = new HashMap<>(webRequest.getParameterMap());
        if (httpServletRequest == null) {
            throw new IllegalStateException("Obligatory HTTP Context not found");
        }

        Map<String, Object> pathVariables = (Map<String, Object>) httpServletRequest.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        if (pathVariables != null && !pathVariables.isEmpty()) {
            for (Map.Entry<String, Object> entry : pathVariables.entrySet()) {
                boolean isArray = entry.getValue() != null && entry.getValue().getClass().isArray();
                String[] value = isArray ? (String[]) entry.getValue() : new String[]{(String) entry.getValue()};
                if (value.length > 1 || (value.length == 1 && value[0] != null && !value[0].isBlank())) {
                    providedParameterValuesMap.put(entry.getKey(), value);
                }
            }
        }
        return providedParameterValuesMap;
    }

    /**
     * Creates a new proxy object for interfaces that extends {@link Specification}
     */
    @SuppressWarnings("unchecked")
    private <T> T createProxy(Object target, Class<T> targetInterface) {
        if (target == null) {
            return null;
        } else if (targetInterface.equals(target.getClass())) {
            return (T) target;
        }
        return (T) Proxy.newProxyInstance(getDefaultClassLoader(), new Class[]{targetInterface}, (proxy, method, args) -> method.invoke(target, args));
    }

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {
            // Cannot access thread context ClassLoader - falling back...
        }
        if (cl == null) {
            // No thread context class loader -> use class loader of this class.
            cl = ClassUtils.class.getClassLoader();
            if (cl == null) {
                // getClassLoader() returning null indicates the bootstrap ClassLoader
                try {
                    cl = ClassLoader.getSystemClassLoader();
                } catch (Throwable ex) {
                    // Cannot access system ClassLoader - oh well, maybe the caller can live with null...
                }
            }
        }
        return cl;
    }

}
