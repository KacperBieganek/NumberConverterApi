package com.github.kacperbieganek.number_conversion;

class RomanNumberConverter implements NumberConverter {
    @Override
    public String convertNumber(long number) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < number; i++) {
            builder.append("I");
        }
        return builder.toString();
    }
}
