package apo.java.practice.leetcode.problem;

public class ReverseInteger {
    public static void main(String[] args) {
	System.out.println(reverse(123));
    }

    public static int reverse(int x) {
	long result = 0;
	while (x != 0) {
	    result = result * 10 + x % 10;
	    if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
		return 0;
	    }
	    x = x / 10;
	}
	return (int) result;
    }
}
