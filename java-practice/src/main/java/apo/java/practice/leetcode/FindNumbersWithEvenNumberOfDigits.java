package apo.java.practice.leetcode;

import junit.framework.Assert;

import java.util.Arrays;

public class FindNumbersWithEvenNumberOfDigits {
    public static void main(String[] args) {
	Assert.assertEquals(1, findNumbersV2(new int[] { 1, 2, 33 }));
    }

    public static int findNumbersV2(int[] numbers) {
	var count = 0;
	for (int n : numbers) {
	    if ((n >= 10 && n <= 99) || (n >= 1000 && n <= 9999) || (n >= 100000 && n <= 999999)) {
		count++;
	    }
	}
	return count;
    }

    public static int findNumbers(int[] numbers) {
	return Arrays.stream(numbers).map(FindNumbersWithEvenNumberOfDigits::compute).sum();
    }

    private static int compute(int n) {
	var counter = 0;
	var temp = n;
	if (n > 0) {
	    do {
		temp /= 10;
		counter++;
	    } while (temp > 0);
	}
	return counter % 2 == 0 ? 1 : 0;
    }
}
