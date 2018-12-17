package com.github.kacperbieganek.validate;

import org.junit.Before;
import org.junit.Test;
import spark.Request;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest {

    private InputValidator validator;

    @Before
    public void setUp() {
        validator = new InputValidator();
    }

    @Test
    public void shouldRejectWhenNoParamsArePassed() {
        //when
        ValidateResult result = validator.validateInput(Collections.emptyMap());
        //then
        assertThat(result.isValid()).isFalse().as("Shouldn't be valid when parameters are missing");
        assertThat(result.getErrorMessage()).isEqualToIgnoringCase("Missing type/number parameter(s)");
    }

    @Test
    public void shouldRejectWhenNumberIsInvalid() {
        //given
        Map<String, String[]> paramsMap = new HashMap<>();
        paramsMap.put("type", new String[]{"foo"});
        paramsMap.put("number", new String[]{"foo"});
        //when
        ValidateResult result = validator.validateInput(paramsMap);
        //then
        assertThat(result.isValid()).isFalse().as("Shouldn't be valid when number input is invalid");
        assertThat(result.getErrorMessage()).isEqualToIgnoringCase("Number parameter is invalid");
    }

    @Test
    public void shouldRejectWhenConversionStrategyIsInvalid() {
        //given
        Map<String, String[]> paramsMap = new HashMap<>();
        paramsMap.put("type", new String[]{"foo"});
        paramsMap.put("number", new String[]{"123"});
        //when
        ValidateResult result = validator.validateInput(paramsMap);
        //then
        assertThat(result.isValid()).isFalse().as("Shouldn't be valid when conversion type is invalid");
        assertThat(result.getErrorMessage()).isEqualToIgnoringCase("Type parameter is invalid expected HEX or ROMAN but was foo");
    }
}