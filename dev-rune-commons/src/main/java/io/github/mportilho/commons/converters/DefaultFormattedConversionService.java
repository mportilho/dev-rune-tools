package io.github.mportilho.commons.converters;


import io.github.mportilho.commons.converters.impl.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DefaultFormattedConversionService implements FormattedConversionService {

    private Map<ConvertMappingKey, FormattedConverter<?, ?, ?>> formattedConverters;

    public DefaultFormattedConversionService() {
        this.formattedConverters = loadFormattedValueConverters();
    }

    @Override
    public boolean canConvert(Class<?> sourceType, Class<?> targetType) {
        return formattedConverters.containsKey(new ConvertMappingKey(sourceType, targetType));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <S, T, F> T convert(S source, Class<T> targetType, F format) {
        Objects.requireNonNull(targetType, "Target Type must be provided");
        if (source == null) {
            return null;
        }
        FormattedConverter<S, T, F> converter = (FormattedConverter<S, T, F>) formattedConverters.get(new ConvertMappingKey(source.getClass(), targetType));
        if (converter == null) {
            if (targetType.isInstance(source)) {
                return (T) source;
            }
            throw new NoFormattedConverterFoundException(
                    String.format("No converter found for source type [%s] and target type [%s]",
                            source.getClass().getCanonicalName(), targetType.getCanonicalName()));
        }
        return converter.convert(source, format);
    }

    /**
     * Adds the default {@link FormattedConverter}s into the new instance of this
     * type
     */
    private Map<ConvertMappingKey, FormattedConverter<?, ?, ?>> loadFormattedValueConverters() {
        formattedConverters = new HashMap<>();
        formattedConverters.put(new ConvertMappingKey(String.class, Instant.class), new StringToInstantConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, LocalDate.class), new StringToLocalDateConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, LocalDateTime.class), new StringToLocalDateTimeConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, LocalTime.class), new StringToLocalTimeConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, YearMonth.class), new StringToYearMonthConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, OffsetDateTime.class), new StringToOffsetDateTimeConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, OffsetTime.class), new StringToOffsetTimeConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, Year.class), new StringToYearConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, ZonedDateTime.class), new StringToZonedDateTimeConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, Date.class), new StringToJavaUtilDateConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, java.sql.Date.class), new StringToJavaSqlDateConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, Timestamp.class), new StringToTimestampConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, Boolean.class), new StringToBooleanConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, BigDecimal.class), new StringToBigDecimalConverter());

        formattedConverters.put(new ConvertMappingKey(BigDecimal.class, String.class), new BigDecimalToStringConverter());

        return formattedConverters;
    }

}
