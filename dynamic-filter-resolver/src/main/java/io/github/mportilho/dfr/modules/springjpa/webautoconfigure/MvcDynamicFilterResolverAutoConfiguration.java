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
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringValueResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Applies autoconfiguration of
 * {@link SpecificationDynamicFilterArgumentResolver} for a Spring MVC context
 *
 * @author Marcelo Portilho
 */
public class MvcDynamicFilterResolverAutoConfiguration implements EmbeddedValueResolverAware {

    private StringValueResolver stringValueResolver;

    @Bean
    @ConditionalOnMissingBean
    public FormattedConversionService formattedConversionService() {
        return new DefaultFormattedConversionService();
    }

    /**
     * @return A bean of {@link WebMvcConfigurer} for adding the
     * {@link SpecificationDynamicFilterArgumentResolver} to the Spring MVC
     * configuration
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(
            @Autowired(required = false) final FormattedConversionService formattedConversionService,
            @Autowired(required = false) final ValueExpressionResolver<String> valueExpressionResolver) {
        return new WebMvcConfigurer() {

            @Override
            public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
                var specificationFilterOperationService = new SpecificationFilterOperationService(formattedConversionService);
                var dynamicFilterResolver = new SpecificationDynamicFilterResolver(specificationFilterOperationService);
                var processor = new AnnotationConditionalStatementProcessor(getValueExpressionResolver(valueExpressionResolver));
                resolvers.add(new SpecificationDynamicFilterArgumentResolver(processor, dynamicFilterResolver));
            }
        };
    }

    private ValueExpressionResolver<String> getValueExpressionResolver(ValueExpressionResolver<String> valueExpressionResolver) {
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
