package com.github.kacperbieganek.validate;

import com.github.kacperbieganek.number_conversion.NumberConverterFactory;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class InputValidator {

    public static final String MISSING_PARAMETERS_MESSAGE = "Missing type/number parameter(s)";
    public static final String INVALID_NUMBER_ERROR_MESSAGE = "Number parameter is invalid, must be decimal digit or positive decimal digit for Roman conversion";
    public static final String INVALID_CONVERSION_TYPE_ERROR_MESSAGE = "Type parameter is invalid expected HEX or ROMAN but was %s";

    public ValidateResult validateInput(Map<String, String[]> requestParams) {
        ValidateResult result = new ValidateResult();
        if (!areParametersPresent(requestParams.keySet())) {
            prepareValidationResult(result, MISSING_PARAMETERS_MESSAGE);
            return result;
        }
        if (!isNumberValid(requestParams)) {
            prepareValidationResult(result, INVALID_NUMBER_ERROR_MESSAGE);
            return result;
        }
        if (!isConversionTypeValid(requestParams.get("type")[0])) {
            result.setValid(false);
            result.setErrorMessage(String.format(INVALID_CONVERSION_TYPE_ERROR_MESSAGE, requestParams.get("type")[0]));
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

    private boolean isNumberValid(Map<String, String[]> requestParams) {
        String number = requestParams.get("number")[0];
        return NumberUtils.isParsable(number) && (isValidHexConversion(requestParams) || isValidForRomanConversion(number, requestParams.get("type")[0]));
    }

    private boolean isValidForRomanConversion(String number, String type) {
        return NumberUtils.isDigits(number) && type.equals("ROMAN");
    }

    private boolean isValidHexConversion(Map<String, String[]> requestParams) {
        return requestParams.get("type")[0].equals("HEX");
    }

    private boolean areParametersPresent(Set<String> queryParams) {
        return queryParams.containsAll(Arrays.asList("type", "number"));
    }
}
