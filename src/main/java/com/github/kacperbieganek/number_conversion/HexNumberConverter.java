package com.github.kacperbieganek.number_conversion;

class HexNumberConverter implements NumberConverter {
    @Override
    public String convertNumber(long number) {
        return Long.toHexString(number).toUpperCase();
    }
}
