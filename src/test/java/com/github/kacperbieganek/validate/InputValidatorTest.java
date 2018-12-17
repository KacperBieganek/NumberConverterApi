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
        assertThat(result.getErrorMessage()).isEqualToIgnoringCase(InputValidator.MISSING_PARAMETERS_MESSAGE);
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
        assertThat(result.getErrorMessage()).isEqualToIgnoringCase(InputValidator.INVALID_NUMBER_ERROR_MESSAGE);
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
        assertThat(result.getErrorMessage()).isEqualToIgnoringCase(String.format(InputValidator.INVALID_CONVERSION_TYPE_ERROR_MESSAGE, paramsMap.get("type")[0]));
    }
}