package com.github.kacperbieganek.number_conversion;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

public class RomanNumberConverterTest {

    private NumberConverter converter;

    @Before
    public void setUp() {
        converter = new RomanNumberConverter();
    }

    @Test
    public void shouldConvertFortyOneToRoman() {
        //given
        long number = 41;
        //when
        String result = converter.convertNumber(number);
        //then
        assertThat(result).isEqualTo("XLI");
    }

    @Test
    public void shouldConvertFiftyFourToRoman() {
        //given
        long number = 54;
        //when
        String result = converter.convertNumber(number);
        //then
        assertThat(result).isEqualTo("LIV");
    }

    @Test
    public void shouldConvertNinetyNineToRoman() {
        //given
        long number = 99;
        //when
        String result = converter.convertNumber(number);
        //then
        assertThat(result).isEqualTo("XCIX");
    }

    @Test
    public void shouldConvertHundredAndTenToRoman() {
        //given
        long number = 110;
        //when
        String result = converter.convertNumber(number);
        //then
        assertThat(result).isEqualTo("CX");
    }

    @Test
    public void shouldParseMillionOneHundredElevenThousandOneHundredElevenToRoman() {
        //given
        long number = 1111111;
        //when
        String result = converter.convertNumber(number);
        //then
        assertThat(result).isEqualTo("(M)(C)(X)MCXI");
    }
}