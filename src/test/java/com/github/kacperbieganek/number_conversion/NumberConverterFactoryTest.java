package com.github.kacperbieganek.number_conversion;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

public class NumberConverterFactoryTest {

    @Test
    public void shouldReturnHexNumberConvertedWhenAskedForHexStrategy() {
        //given
        String desiredStrategy = "HEX";
        //when
        Optional<NumberConverter> strategy = NumberConverterFactory.getConversionStrategy(desiredStrategy);
        //then
        assertThat(strategy.isPresent()).isTrue();
        assertThat(strategy.get()).isInstanceOf(HexNumberConverter.class);
    }

    @Test
    public void shouldReturnHexNumberConvertedWhenAskedForRomanStrategy() {
        //given
        String desiredStrategy = "ROMAN";
        //when
        Optional<NumberConverter> strategy = NumberConverterFactory.getConversionStrategy(desiredStrategy);
        //then
        assertThat(strategy.isPresent()).isTrue();
        assertThat(strategy.get()).isInstanceOf(RomanNumberConverter.class);
    }

    @Test
    public void shouldReturnHexNumberConvertedWhenAskedForNotSupportedStrategy() {
        //given
        String desiredStrategy = "FOO";
        //when
        Optional<NumberConverter> strategy = NumberConverterFactory.getConversionStrategy(desiredStrategy);
        //then
        assertThat(strategy.isPresent()).isFalse();
    }
}