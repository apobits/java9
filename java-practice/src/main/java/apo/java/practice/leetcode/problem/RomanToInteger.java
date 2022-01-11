package apo.java.practice.leetcode.problem;

import org.junit.Assert;

public final class RomanToInteger {
    public static void main(String[] args) {
        Assert.assertEquals(3, romanToInt("III"));
        Assert.assertEquals(4, romanToInt("IV"));
        Assert.assertEquals(58, romanToInt("LVIII"));
        Assert.assertEquals(1994, romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String roman) {
        int index = -1;
        int value = 0;
        while (++index < roman.length()) {
            char c = roman.charAt(index);
            if (index + 1 < roman.length()) {
                char nextChar = roman.charAt(index + 1);
                if (c == 73 && nextChar == 86) {
                    value += 4;
                    index++;
                } else if (c == 73 && nextChar == 88) {
                    value += 9;
                    index++;
                } else if (c == 88 && nextChar == 76) {
                    value += 40;
                    index++;
                } else if (c == 88 && nextChar == 67) {
                    value += 90;
                    index++;
                } else if (c == 67 && nextChar == 68) {
                    value += 400;
                    index++;
                } else if (c == 67 && nextChar == 77) {
                    value += 900;
                    index++;
                } else {
                    value += convertRomanToInteger(c);
                }
            } else {
                value += convertRomanToInteger(c);
            }
        }
        return value;
    }

    private static int convertRomanToInteger(char character) {
        return switch (character) {
            case 73 -> 1;
            case 86 -> 5;
            case 88 -> 10;
            case 76 -> 50;
            case 67 -> 100;
            case 68 -> 500;
            case 77 -> 1000;
            default -> 0;
        };
    }
}