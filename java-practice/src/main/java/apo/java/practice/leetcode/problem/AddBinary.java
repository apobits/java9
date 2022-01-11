package apo.java.practice.leetcode.problem;

import org.junit.Assert;

public class AddBinary {
    public static void main(String[] args) {
        Assert.assertEquals("10101", addBinaryV2("1010", "1011"));
        Assert.assertEquals("100", addBinaryV2("11", "1"));

    }

    public static String addBinary(String x, String y) {
        int index = 0;
        var result = new StringBuilder();
        boolean carryOver = false;
        while (index < x.length() || index < y.length()) {
            var xValue = index < x.length() ? (x.charAt(x.length() - index - 1) == 49 ? 1 : 0) : 0;
            var yValue = index < y.length() ? (y.charAt(y.length() - index - 1) == 49 ? 1 : 0) : 0;
            var r = xValue == yValue ? 0 : 1;
            if (carryOver) {
                r = r == 1 ? 0 : 1;
                carryOver = r == 0;
            }
            result.append(r);
            if (xValue == 1 && xValue == yValue) {
                carryOver = true;
            }
            index++;
        }
        if (carryOver) {
            result.append(1);
        }
        return result.reverse().toString();
    }

    public static String addBinaryV2(String x, String y) {
        int size = Math.max(x.length(), y.length());
        var result = new char[size];
        boolean carryOver = false;
        int xIndex = x.length() - 1;
        int yIndex = y.length() - 1;
        while (size > 0) {
            var xValue = xIndex >= 0 && xIndex < x.length() ? x.charAt(xIndex) : 48;
            var yValue = yIndex >= 0 && yIndex < y.length() ? y.charAt(yIndex) : 48;
            int r = xValue + yValue == 97 ? 49 : 48;
            if (carryOver) {
                r = r == 49 ? 48 : 49;
                carryOver = r == 48;
            }
            result[size - 1] = (char) r;
            if (xValue == 49 && xValue == yValue) {
                carryOver = true;
            }
            size--;
            xIndex--;
            yIndex--;
        }
        if (carryOver) {
            return 1 + new String(result);
        }
        return new String(result);
    }

}
