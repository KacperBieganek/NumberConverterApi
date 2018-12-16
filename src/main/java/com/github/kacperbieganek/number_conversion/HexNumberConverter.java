package com.github.kacperbieganek.number_conversion;

class HexNumberConverter implements NumberConverter {
    @Override
    public String convert(int number) {
        return Integer.toHexString(number);
    }
}
