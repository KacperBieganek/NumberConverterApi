package com.github.kacperbieganek.number_conversion;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class NumberConverterFactory {
    private final static Map<String, NumberConverter> conversionStrategies = new HashMap<>();

    static {
        conversionStrategies.put("HEX", new HexNumberConverter());
        conversionStrategies.put("ROMAN", new RomanNumberConverter());
    }

    public static Optional<NumberConverter> getConversionStrategy(String desiredStrategy) {
        return Optional.ofNullable(conversionStrategies.get(desiredStrategy));
    }
}
