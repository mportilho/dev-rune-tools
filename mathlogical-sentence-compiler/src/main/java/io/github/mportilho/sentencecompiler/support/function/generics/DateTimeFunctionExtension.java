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

package io.github.mportilho.sentencecompiler.support.function.generics;

import io.github.mportilho.sentencecompiler.exceptions.SentenceConfigurationException;
import io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaCallSite;
import io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaCallSiteFactory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Map;

public class DateTimeFunctionExtension {

    private static final Map<String, LambdaCallSite> INSTANCE = internalDateTimeFunctionsFactory();

    public static Map<String, LambdaCallSite> dateTimeFunctionsFactory() {
        return INSTANCE;
    }

    public static Long secondsBetween(Temporal t1, Temporal t2) {
        return ChronoUnit.SECONDS.between(t1, t2);
    }

    public static Long minutesBetween(Temporal t1, Temporal t2) {
        return ChronoUnit.MINUTES.between(t1, t2);
    }

    public static Long hoursBetween(Temporal t1, Temporal t2) {
        return ChronoUnit.HOURS.between(t1, t2);
    }

    public static Long daysBetween(Temporal t1, Temporal t2) {
        return ChronoUnit.DAYS.between(t1, t2);
    }

    public static Long monthsBetween(Temporal t1, Temporal t2) {
        return ChronoUnit.MONTHS.between(t1, t2);
    }

    public static Long yearsBetween(Temporal t1, Temporal t2) {
        return ChronoUnit.YEARS.between(t1, t2);
    }

    public static LocalDate maxDate(LocalDate[] p) {
        if (p.length == 1) {
            return p[0];
        } else if (p.length == 2) {
            return p[0].compareTo(p[1]) >= 0 ? p[0] : p[1];
        }
        LocalDate maxOne = p[0];
        for (int i = 1, parametersLength = p.length; i < parametersLength; i++) {
            LocalDate parameter = p[i];
            if (maxOne.compareTo(parameter) < 0) {
                maxOne = parameter;
            }
        }
        return maxOne;
    }

    public static LocalDate minDate(LocalDate[] p) {
        if (p.length == 1) {
            return p[0];
        } else if (p.length == 2) {
            return p[0].compareTo(p[1]) >= 0 ? p[1] : p[0];
        }
        LocalDate minOne = p[0];
        for (int i = 1, parametersLength = p.length; i < parametersLength; i++) {
            LocalDate parameter = p[i];
            if (minOne.compareTo(parameter) > 0) {
                minOne = parameter;
            }
        }
        return minOne;
    }

    public static LocalTime maxTime(LocalTime[] p) {
        if (p.length == 1) {
            return p[0];
        } else if (p.length == 2) {
            return p[0].compareTo(p[1]) >= 0 ? p[0] : p[1];
        }
        LocalTime maxOne = p[0];
        for (int i = 1, parametersLength = p.length; i < parametersLength; i++) {
            LocalTime parameter = p[i];
            if (maxOne.compareTo(parameter) < 0) {
                maxOne = parameter;
            }
        }
        return maxOne;
    }

    public static LocalTime minTime(LocalTime[] p) {
        if (p.length == 1) {
            return p[0];
        } else if (p.length == 2) {
            return p[0].compareTo(p[1]) >= 0 ? p[1] : p[0];
        }
        LocalTime minOne = p[0];
        for (int i = 1, parametersLength = p.length; i < parametersLength; i++) {
            LocalTime parameter = p[i];
            if (minOne.compareTo(parameter) > 0) {
                minOne = parameter;
            }
        }
        return minOne;
    }

    public static ZonedDateTime maxDateTime(ZonedDateTime[] p) {
        if (p.length == 1) {
            return p[0];
        } else if (p.length == 2) {
            return p[0].compareTo(p[1]) >= 0 ? p[0] : p[1];
        }
        ZonedDateTime maxOne = p[0];
        for (int i = 1, parametersLength = p.length; i < parametersLength; i++) {
            ZonedDateTime parameter = p[i];
            if (maxOne.compareTo(parameter) < 0) {
                maxOne = parameter;
            }
        }
        return maxOne;
    }

    public static ZonedDateTime minDateTime(ZonedDateTime[] p) {
        if (p.length == 1) {
            return p[0];
        } else if (p.length == 2) {
            return p[0].compareTo(p[1]) >= 0 ? p[1] : p[0];
        }
        ZonedDateTime minOne = p[0];
        for (int i = 1, parametersLength = p.length; i < parametersLength; i++) {
            ZonedDateTime parameter = p[i];
            if (minOne.compareTo(parameter) > 0) {
                minOne = parameter;
            }
        }
        return minOne;
    }


    private static Map<String, LambdaCallSite> internalDateTimeFunctionsFactory() {
        try {
            return LambdaCallSiteFactory.createLambdaCallSites(DateTimeFunctionExtension.class);
        } catch (Throwable e) {
            throw new SentenceConfigurationException("Error while loading temporal functions", e);
        }
    }

}
