package com.github.kacperbieganek.validate;

import java.util.Arrays;
import java.util.Collection;

public class InputValidator {
    public ValidateResult validateInput(Collection queryParams) {
        ValidateResult result = new ValidateResult();
        if (!areParametersPresent(queryParams)) {
            result.setPartialyValid(areParametersPresent(queryParams));
            result.setErrorMessage("Missing parameter");
        }
        return result;
    }

    private boolean areParametersPresent(Collection queryParams) {
        return queryParams.containsAll(Arrays.asList("type", "number"));
    }
}
