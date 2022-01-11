package apo.java.practice.leetcode.problem;

import org.junit.Assert;

public class IntegerToRoman {
    public static void main(String[] args) {
        Assert.assertEquals("CM", intToRoman(900));
        Assert.assertEquals("LVIII", intToRoman(58));
        Assert.assertEquals("MCMXCIV", intToRoman(1994));
        Assert.assertEquals("XX", intToRoman(20));
        Assert.assertEquals("XXX", intToRoman(30));
        Assert.assertEquals("XXI", intToRoman(21));
        Assert.assertEquals("CCC", intToRoman(300));
        Assert.assertEquals("X", intToRoman(10));
        Assert.assertEquals("XI", intToRoman(11));
    }

    public static String intToRoman(int n) {
        int copy = n;
        final var roman = new StringBuilder();
        while (copy > 0) {
            int number;
            String numberS;
            if (copy < 10) {
                number = copy;
                copy = 0;
            } else if (copy < 100) {
                number = copy / 10 * 10;
                copy %= 10;
            } else if (copy < 1000) {
                number = copy / 100 * 100;
                copy %= 100;
            } else {
                number = copy / 1000 * 1000;
                copy %= 1000;
            }
            numberS = switch (number) {
                case 1 -> "I";
                case 2 -> "II";
                case 3 -> "III";
                case 4 -> "IV";
                case 5 -> "V";
                case 6 -> "VI";
                case 7 -> "VII";
                case 8 -> "VIII";
                case 9 -> "IX";
                case 10 -> "X";
                case 20 -> "XX";
                case 30 -> "XXX";
                case 40 -> "XL";
                case 50 -> "L";
                case 60 -> "LX";
                case 70 -> "LXX";
                case 80 -> "LXXX";
                case 90 -> "XC";
                case 100 -> "C";
                case 200 -> "CC";
                case 300 -> "CCC";
                case 400 -> "CD";
                case 500 -> "D";
                case 600 -> "DC";
                case 700 -> "DCC";
                case 800 -> "DCCC";
                case 900 -> "CM";
                case 1000 -> "M";
                case 2000 -> "MM";
                case 3000 -> "MMM";
                default -> "";
            };
            roman.append(numberS);
        }
        return roman.toString();
    }
}
