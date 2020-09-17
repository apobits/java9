package apo.java.practice.leetcode;

import junit.framework.Assert;

import java.util.HashSet;

public class HappyNumber {
    public static void main(String[] args) {
	Assert.assertTrue(isHappy(39));
    }
    public static boolean isHappy(int n) {
	var set = new HashSet<Integer>();
	while ((n = compute(n)) != 1) {
	    if (set.contains(n)) {
		return false;
	    } else {
		set.add(n);
	    }
	}
	return true;
    }

    public static boolean isHappyV2(int n) {
	while ((n = compute(n)) != 1) {
	    if (n % 2 != 0) {
		return false;
	    }
	}
	return true;
    }

    private static int compute(int n) {
	var numbers = String.valueOf(n).split("");
	var result = 0;
	for (String s : numbers) {
	    var number = Integer.valueOf(s);
	    result += number * number;
	}
	return result;
    }
}
