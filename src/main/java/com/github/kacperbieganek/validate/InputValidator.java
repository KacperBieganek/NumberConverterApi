package com.github.kacperbieganek.validate;

import com.github.kacperbieganek.number_conversion.NumberConverterFactory;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class InputValidator {
    public ValidateResult validateInput(Map<String, String[]> requestParams) {
        ValidateResult result = new ValidateResult();
        if (!areParametersPresent(requestParams.keySet())) {
            prepareValidationResult(result, "Missing type/number parameter(s)");
            return result;
        }
        if (!isNumberValid(requestParams.get("number")[0])) {
            prepareValidationResult(result, "Number parameter is invalid");
            return result;
        }
        if (!isConversionTypeValid(requestParams.get("type")[0])) {
            result.setValid(false);
            result.setErrorMessage("Type parameter is invalid expected HEX or ROMAN but was " + requestParams.get("type")[0]);
            return result;
        }

        return result;
    }

    private void prepareValidationResult(ValidateResult result, String s) {
        result.setValid(false);
        result.setErrorMessage(s);
    }

    private boolean isConversionTypeValid(String type) {
        return NumberConverterFactory.getConversionStrategy(type).isPresent();
    }

    private boolean isNumberValid(String number) {
        return NumberUtils.isParsable(number) && NumberUtils.isDigits(number);
    }

    private boolean areParametersPresent(Set<String> queryParams) {
        return queryParams.containsAll(Arrays.asList("type", "number"));
    }
}
