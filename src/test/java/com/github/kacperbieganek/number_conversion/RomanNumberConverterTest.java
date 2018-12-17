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
    public void shouldConvertTwoToRoman() {
        //given
        long number = 2;
        //when
        String result = converter.convertNumber(number);
        //then
        assertThat(result).isEqualTo("II");
    }
}