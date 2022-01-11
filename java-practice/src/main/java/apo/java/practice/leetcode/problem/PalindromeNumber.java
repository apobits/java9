package apo.java.practice.leetcode.problem;

import static org.junit.Assert.assertTrue;

public class PalindromeNumber {
    public static void main(String[] args) {
	assertTrue(isPalindrome(121));
    }

    public static boolean isPalindrome(int number) {
	if (number < 0) {
	    return false;
	}
	int temp = number;
	int backwards = 0;
	while (temp > 0) {
	    backwards = backwards * 10 + temp % 10;
	    temp /= 10;
	}
	return number == backwards;
    }
}
