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

import io.github.mportilho.commons.converters.FormattedConversionService;
import io.github.mportilho.commons.converters.impl.DefaultFormattedConversionService;
import io.github.mportilho.dfr.core.processor.ValueExpressionResolver;
import io.github.mportilho.dfr.core.processor.annotation.AnnotationConditionalStatementProcessor;
import io.github.mportilho.dfr.modules.springjpa.operation.SpecificationFilterOperationService;
import io.github.mportilho.dfr.modules.springjpa.resolver.SpecificationDynamicFilterResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.StringValueResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Applies autoconfiguration of
 * {@link SpecificationDynamicFilterArgumentResolver} for a Spring MVC context
 *
 * @author Marcelo Portilho
 */
@ConditionalOnClass({EnableJpaRepositories.class, EnableWebMvc.class})
public class MvcDynamicFilterResolverAutoConfiguration implements EmbeddedValueResolverAware {

    private StringValueResolver stringValueResolver;
    private final ConversionService conversionService;
    private final ValueExpressionResolver<String> valueExpressionResolver;

    public MvcDynamicFilterResolverAutoConfiguration(
            @Autowired(required = false) ConversionService conversionService,
            @Autowired(required = false) ValueExpressionResolver<String> valueExpressionResolver) {
        this.conversionService = conversionService;
        this.valueExpressionResolver = valueExpressionResolver;
    }

    /**
     * @return A bean of {@link WebMvcConfigurer} for adding the
     * {@link SpecificationDynamicFilterArgumentResolver} to the Spring MVC
     * configuration
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
                FormattedConversionService formattedConversionService;
                if (conversionService != null) {
                    formattedConversionService = new SpringFormattedConversionServiceAdapter(conversionService, new DefaultFormattedConversionService());
                } else {
                    formattedConversionService = new DefaultFormattedConversionService();
                }

                var dynamicFilterResolver = new SpecificationDynamicFilterResolver(
                        new SpecificationFilterOperationService(formattedConversionService));
                var processor = new AnnotationConditionalStatementProcessor(getValueExpressionResolver());
                resolvers.add(new SpecificationDynamicFilterArgumentResolver(processor, dynamicFilterResolver));
            }
        };
    }

    private ValueExpressionResolver<String> getValueExpressionResolver() {
        ValueExpressionResolver<String> resolver = stringValueResolver != null ? (stringValueResolver::resolveStringValue) : a -> null;
        return key -> {
            String response = null;
            if (valueExpressionResolver != null) {
                response = valueExpressionResolver.resolveValue(key);
            }
            return response != null ? response : resolver.resolveValue(key);
        };
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.stringValueResolver = resolver;
    }
}
