package apo.java.practice.leetcode;

import java.util.HashSet;

public class CheckIfNAndItsDoubleExists {
    public static void main(String[] args) {
	checkIfExist(new int[] { 3, 1, 7, 11 });
    }

    public static boolean checkIfExist(int[] nums) {
	var hashSet = new HashSet<Integer>();
	for (int n : nums) {
	    if (hashSet.contains(n * 2) || (n % 2 == 0 && hashSet.contains(n / 2))) {
		return true;
	    }
	    hashSet.add(n);
	}
	return false;
    }
}
