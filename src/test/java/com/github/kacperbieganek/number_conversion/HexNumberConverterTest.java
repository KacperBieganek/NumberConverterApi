package com.github.kacperbieganek.number_conversion;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class HexNumberConverterTest {

    private NumberConverter converter;

    @Before
    public void setUp() {
        converter = new HexNumberConverter();
    }

    @Test
    public void shouldConvertPositiveNumber() {
        //given
        long numberToConvert = 1;
        //when
        String result = converter.convertNumber(numberToConvert);
        //then
        assertThat(result).isEqualTo("1");
    }

    @Test
    public void shouldConvertZero() {
        //given
        long numberToConvert = 0;
        //when
        String result = converter.convertNumber(numberToConvert);
        //then
        assertThat(result).isEqualTo("0");
    }

    @Test
    public void shouldConvertNegativeNumber() {
        //given
        long numberToConvert = -1;
        //when
        String result = converter.convertNumber(numberToConvert);
        //then
        assertThat(result).isEqualToIgnoringCase("FFFFFFFFFFFFFFFF");
    }

    @Test
    public void shouldConvertLongMaxValue() {
        //given
        long numberToConvert = Long.MAX_VALUE;
        //when
        String result = converter.convertNumber(numberToConvert);
        //then
        assertThat(result).isEqualToIgnoringCase("7FFFFFFFFFFFFFFF");
    }

    @Test
    public void shouldConvertLongMinValue() {
        //given
        long numberToConvert = Long.MIN_VALUE;
        //when
        String result = converter.convertNumber(numberToConvert);
        //then
        assertThat(result).isEqualToIgnoringCase("8000000000000000");
    }
}