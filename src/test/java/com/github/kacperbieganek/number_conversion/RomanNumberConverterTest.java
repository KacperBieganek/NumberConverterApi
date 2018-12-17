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
    public void shouldConvertOneToRoman() {
        //given
        long number = 1;
        //when
        String result = converter.convertNumber(number);
        //then
        assertThat(result).isEqualTo("I");
    }

    @Test
    public void shouldConvertFourToRoman() {
        //given
        long number = 4;
        //when
        String result = converter.convertNumber(number);
        //then
        assertThat(result).isEqualTo("IV");
    }

    @Test
    public void shouldConvertNineToRoman() {
        //given
        long number = 9;
        //when
        String result = converter.convertNumber(number);
        //then
        assertThat(result).isEqualTo("IX");
    }

    @Test
    public void shouldConvertTenToRoman() {
        //given
        long number = 10;
        //when
        String result = converter.convertNumber(number);
        //then
        assertThat(result).isEqualTo("X");
    }

    @Test
    public void shouldConvertFortyToRoman() {
        //given
        long number = 40;
        //when
        String result = converter.convertNumber(number);
        //then
        assertThat(result).isEqualTo("XL");
    }

}