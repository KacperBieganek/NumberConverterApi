package com.github.kacperbieganek;

import com.github.kacperbieganek.number_conversion.NumberConverterFactory;
import com.github.kacperbieganek.validate.InputValidator;
import com.github.kacperbieganek.validate.ValidateResult;

import static spark.Spark.*;

class NumberConverterApi {

    private static final InputValidator validator = new InputValidator();

    public static void main(String[] args) {
        before("/converter", (req, res) ->
        {
            final ValidateResult result = validator.validateInput(req.queryMap().toMap());
            if (!result.isValid()) {
                halt(401, result.getErrorMessage());
            }
        });

        get("/converter", "application/json", (req, res) -> NumberConverterFactory.
                getConversionStrategy(req.queryParams("type"))
                .get()
                .convertNumber(Long.parseLong(req.queryParams("number"))));
    }
}
