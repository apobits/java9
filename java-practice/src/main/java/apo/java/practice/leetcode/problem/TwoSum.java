package apo.java.practice.leetcode.problem;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
	System.out.println(Arrays.toString(twoSum(new int[] { 3, 2, 4 }, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
	int indexOne = -1;
	while (++indexOne < nums.length) {
	    int indexTwo = indexOne;
	    while (++indexTwo < nums.length) {
		if ((nums[indexOne] + nums[indexTwo]) == target) {
		    return new int[] { indexOne, indexTwo };
		}
	    }
	}
	return null;
    }
}
