package com.github.kacperbieganek.number_conversion;

import java.util.TreeMap;

class RomanNumberConverter implements NumberConverter {

    private final static TreeMap<Long, String> map = new TreeMap<>();

    static {
        map.put(40L,"XL");
        map.put(10L, "X");
        map.put(9L, "IX");
        map.put(4L, "IV");
        map.put(1L, "I");
    }

    @Override
    public String convertNumber(long number) {
        long l = map.floorKey(number);
        if (number == l) {
            return map.get(number);
        }
        return map.get(l) + convertNumber(number - l);
    }
}
