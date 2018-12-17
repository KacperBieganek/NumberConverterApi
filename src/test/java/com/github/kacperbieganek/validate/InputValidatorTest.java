package com.github.kacperbieganek.validate;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

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
        ValidateResult result = validator.validateInput(Collections.emptySet());
        //then
        assertThat(result.isValid()).isFalse().as("Shouldn't be valid when parameters are missing");
        assertThat(result.getErrorMessage()).isEqualToIgnoringCase("Missing parameter");
    }
}