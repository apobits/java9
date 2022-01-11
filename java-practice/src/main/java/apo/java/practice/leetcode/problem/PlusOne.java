package apo.java.practice.leetcode.problem;

import org.junit.Assert;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        Assert.assertArrayEquals(new int[]{1, 0, 0}, plusOne(new int[]{9, 9}));
        Assert.assertArrayEquals(new int[]{9, 0, 0}, plusOne(new int[]{8, 9, 9}));

    }

    public static int[] plusOne(int[] digits) {
        int lastDigitIndex = digits.length - 1;
        while (lastDigitIndex >= 0 && digits[lastDigitIndex] == 9) {
            lastDigitIndex--;
        }
        if (lastDigitIndex < 0 ) {
            lastDigitIndex = 0;
            digits = Arrays.copyOf(digits, digits.length + 1);
            digits[lastDigitIndex] = 1;
        } else {
            digits[lastDigitIndex] += 1;
        }
        while (++lastDigitIndex < digits.length) {
            digits[lastDigitIndex] = 0;
        }
        return digits;
    }
}
