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
        int numberToConvert = 1;
        //when
        String result = converter.convert(numberToConvert);
        //then
        assertThat(result).isEqualTo("1");
    }

    @Test
    public void shouldConvertZero() {
        //given
        int numberToConvert = 0;
        //when
        String result = converter.convert(numberToConvert);
        //then
        assertThat(result).isEqualTo("0");
    }

    @Test
    public void shouldConvertNegativeNumber() {
        //given
        int numberToConvert = -1;
        //when
        String result = converter.convert(numberToConvert);
        //then
        assertThat(result).isEqualToIgnoringCase("FFFFFFFF");
    }
}