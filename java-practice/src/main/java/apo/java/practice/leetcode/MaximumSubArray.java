package apo.java.practice.leetcode;

import junit.framework.Assert;

import java.util.TreeSet;

public class MaximumSubArray {
    public static void main(String[] args) {
	Assert.assertEquals(6, maxSubArrayV2(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }

    public static int maxSubArray(int[] nums) {
	var sums = new TreeSet<Long>();
	for (int i = 0; i < nums.length; i++) {
	    long result = 0;
	    for (int j = i; j < nums.length; j++) {
		result += nums[j];
		sums.add(result);
	    }
	}
	return sums.last().intValue();
    }

    public static int maxSubArrayV2(int[] nums) {
	var sums = new TreeSet<Integer>();
	sums.add(nums[nums.length - 1]);
	sums.add(nums[nums.length - 1] + nums[nums.length - 2]);
	int result = 0;
	for (int i = 0; i < nums.length - 2; i++) {
	    result += nums[i];
	    if ((result + nums[i + 1] < 0) || result + nums[i + 1] < nums[i + 1] + nums[i + 2]) {
		sums.add(result);
		result = 0;
	    }
	}
	return sums.last();
    }
}
