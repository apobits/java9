package apo.java.practice.leetcode;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
	var nums = new int[] { 0, 0, 1, 2, 3, 4, 4, 5, 6, 7 };
	removeDuplicates(nums);
	System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
	var length = nums.length;
	var index = 0;
	for (int i = 0; i < nums.length; i++) {
	    while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
		i++;
		length--;
	    }
	    nums[index++] = nums[i];
	}
	return length;
    }
}
