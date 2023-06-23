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

package io.github.mportilho.sentencecompiler;

import io.github.mportilho.commons.converters.FormattedConversionService;
import io.github.mportilho.commons.converters.impl.DefaultFormattedConversionService;
import io.github.mportilho.sentencecompiler.data.DataStore;

import java.math.MathContext;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class MathSentenceOptions {

    private final MathContext mathContext;
    private final Integer scale;
    private final FormattedConversionService formattedConversionService;
    private final DataStore dataStore;
    private final ZoneId zoneId;
    private final boolean preciseNumbers;
    private final boolean cachingVariableProvider;

    public MathSentenceOptions() {
        this(MathContext.DECIMAL64, null, new DefaultFormattedConversionService(), null,
                ZoneOffset.UTC, true, true);
    }

    public MathSentenceOptions(
            MathContext mathContext, Integer scale,
            FormattedConversionService formattedConversionService) {
        this(mathContext, scale, formattedConversionService, null,
                ZoneOffset.UTC, true, true);
    }

    public MathSentenceOptions(DataStore dataStore) {
        this(MathContext.DECIMAL64, null, new DefaultFormattedConversionService(), dataStore,
                ZoneOffset.UTC, true, true);
    }

    public MathSentenceOptions(
            MathContext mathContext, Integer scale, FormattedConversionService formattedConversionService,
            DataStore dataStore, ZoneId zoneId, boolean preciseNumbers, boolean cachingVariableProvider) {
        this.mathContext = mathContext;
        this.scale = scale;
        this.formattedConversionService = formattedConversionService;
        this.dataStore = dataStore;
        this.zoneId = zoneId;
        this.preciseNumbers = preciseNumbers;
        this.cachingVariableProvider = cachingVariableProvider;
    }

    public MathContext getMathContext() {
        return mathContext;
    }

    public Integer getScale() {
        return scale;
    }

    public FormattedConversionService getFormattedConversionService() {
        return formattedConversionService;
    }

    public DataStore getDataStore() {
        return dataStore;
    }

    public ZoneId getZoneId() {
        return zoneId;
    }

    public boolean isPreciseNumbers() {
        return preciseNumbers;
    }

    public boolean isCachingVariableProvider() {
        return cachingVariableProvider;
    }
}
