package com.github.kacperbieganek.number_conversion;

import java.util.TreeMap;

class RomanNumberConverter implements NumberConverter {

    private final static TreeMap<Long, String> map = new TreeMap<>();

    static {
        map.put(1000000L, "(M)");
        map.put(900000L, "(CM)");
        map.put(500000L, "(D)");
        map.put(400000L, "(CD)");
        map.put(100000L, "(C)");
        map.put(90000L, "(XC)");
        map.put(50000L, "(L)");
        map.put(40000L, "(XL)");
        map.put(10000L, "(X)");
        map.put(9000L, "(IX)");
        map.put(5000L,"(V)");
        map.put(1000L, "M");
        map.put(900L, "CM");
        map.put(500L, "D");
        map.put(400L, "CD");
        map.put(100L, "C");
        map.put(90L, "XC");
        map.put(50L, "L");
        map.put(40L, "XL");
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
