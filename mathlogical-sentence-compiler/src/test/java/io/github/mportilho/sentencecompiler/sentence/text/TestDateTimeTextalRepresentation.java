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

package io.github.mportilho.sentencecompiler.sentence.text;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import io.github.mportilho.sentencecompiler.MathSentence;

public class TestDateTimeTextalRepresentation {

	@Test
	public void testDateTextualRepresentation() {
		assertThat(new MathSentence("2000-03-05 = 2000-03-05").toString()).isEqualTo("2000-03-05 = 2000-03-05");
		assertThat(new MathSentence("(2000-03-05) = 2000-03-05").toString()).isEqualTo("(2000-03-05) = 2000-03-05");
		assertThat(new MathSentence("2000-03-05 setDays 3 = 2000-03-05").toString()).isEqualTo("2000-03-05 setDays 3 = 2000-03-05");
		assertThat(new MathSentence("2000-03-05 plusDays 3 setYears 2010 = 2010-03-03").toString())
				.isEqualTo("2000-03-05 plusDays 3 setYears 2010 = 2010-03-03");
		assertThat(new MathSentence("(2000-03-05 minusDays 3 setYears 2010) = 2010-03-03").toString())
				.isEqualTo("(2000-03-05 minusDays 3 setYears 2010) = 2010-03-03");
	}

	@Test
	public void testTimeTextualRepresentation() {
		assertThat(new MathSentence("13:14:15 = 13:14:15").toString()).isEqualTo("13:14:15 = 13:14:15");
		assertThat(new MathSentence("(13:14:15) = 13:14:15").toString()).isEqualTo("(13:14:15) = 13:14:15");
		assertThat(new MathSentence("13:14:15 setHours 3 plusMinutes 1 = 13:14:15").toString())
				.isEqualTo("13:14:15 setHours 3 plusMinutes 1 = 13:14:15");
		assertThat(new MathSentence("13:14:15 minusHours 3 setSeconds 20 = 03:14:20").toString())
				.isEqualTo("13:14:15 minusHours 3 setSeconds 20 = 03:14:20");
		assertThat(new MathSentence("(13:14:15 setHours 3 setSeconds 20) = 03:14:20").toString())
				.isEqualTo("(13:14:15 setHours 3 setSeconds 20) = 03:14:20");
	}

	@Test
	public void testDateTimeTextualRepresentation() {
		assertThat(new MathSentence("2000-03-05T13:14:15 = 2000-03-05T13:14:15").toString()).isEqualTo("2000-03-05T13:14:15 = 2000-03-05T13:14:15");
		assertThat(new MathSentence("(2000-03-05T13:14:15) = 2000-03-05T13:14:15").toString())
				.isEqualTo("(2000-03-05T13:14:15) = 2000-03-05T13:14:15");
		assertThat(new MathSentence("2000-03-05T13:14:15 plusDays 3 = 2000-03-05T13:14:15").toString())
				.isEqualTo("2000-03-05T13:14:15 plusDays 3 = 2000-03-05T13:14:15");
		assertThat(new MathSentence("2000-03-05T13:14:15 setDays 3 setYears 2010 plusMinutes 4 = 2010-03-03T13:18:15").toString())
				.isEqualTo("2000-03-05T13:14:15 setDays 3 setYears 2010 plusMinutes 4 = 2010-03-03T13:18:15");
		assertThat(new MathSentence("(2000-03-05T13:14:15 minusDays 3 setYears 2010 plusMinutes 4) = 2010-03-03T13:18:15").toString())
				.isEqualTo("(2000-03-05T13:14:15 minusDays 3 setYears 2010 plusMinutes 4) = 2010-03-03T13:18:15");
	}

}
