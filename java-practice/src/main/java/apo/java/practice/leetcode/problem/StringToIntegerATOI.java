package apo.java.practice.leetcode.problem;

public class StringToIntegerATOI {
    public static void main(String[] args) {
	var start = System.currentTimeMillis();
	System.out.println(myAtoi("20000000000000000000"));
	System.out.println(System.currentTimeMillis() - start);
    }

    public static int myAtoi(String s) {
	int leftIndex = 0;
	//skip left side spaces
	while (leftIndex < s.length() && s.charAt(leftIndex) == ' ') {
	    leftIndex++;
	}
	if (leftIndex == s.length()) {
	    return 0;
	}
	//get sign
	int sign = 1;
	int temp = s.charAt(leftIndex);
	if (temp == 45) {
	    sign = -1;
	    leftIndex++;
	} else if (temp == 43) {
	    leftIndex++;
	}

	if (leftIndex == s.length()) {
	    return 0;
	}

	//have fun
	long result = 0;
	while (leftIndex < s.length() && (result / 10) <= Integer.MAX_VALUE && s.charAt(leftIndex) >= 48 && s.charAt(leftIndex) <= 57) {
	    result += s.charAt(leftIndex) - '0';
	    result *= 10;
	    leftIndex++;
	}
	result /= (10 * sign);
	if (result < Integer.MIN_VALUE) {
	    return Integer.MIN_VALUE;
	}
	if (result > Integer.MAX_VALUE) {
	    return Integer.MAX_VALUE;
	}
	return (int) result;
    }
}
