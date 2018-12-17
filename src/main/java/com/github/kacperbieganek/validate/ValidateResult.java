package com.github.kacperbieganek.validate;

public class ValidateResult {
    private boolean isValid;
    private String errorMessage;

    ValidateResult() {
        isValid = true;
        errorMessage = "";
    }

    public boolean isValid() {
        return isValid;
    }

    public void setPartialyValid(boolean partialValidation) {
        isValid &= partialValidation;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
