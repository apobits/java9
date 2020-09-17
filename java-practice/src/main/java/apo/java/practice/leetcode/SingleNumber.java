package apo.java.practice.leetcode;

import java.util.HashSet;

public class SingleNumber {

    public static int singleNumber(int[] nums) {
	var set = new HashSet<Integer>();
	for (int i = 0; i < nums.length; i++) {
	    if (set.contains(nums[i])) {
		set.remove(nums[i]);
	    } else {
		set.add(nums[i]);
	    }
	}

	return set.iterator().next();
    }
}
