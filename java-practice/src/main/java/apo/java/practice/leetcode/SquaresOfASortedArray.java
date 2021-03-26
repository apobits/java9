package apo.java.practice.leetcode;

import java.util.Arrays;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
	System.out.println(Arrays.toString(sortedSquares(new int[] { -3, -3, -2, 1 })));
    }

    public static int[] sortedSquares(int[] nums) {
	var leftIndex = 0;
	var rightIndex = nums.length - 1;
	while (leftIndex < rightIndex) {
	    var left = nums[leftIndex] * nums[leftIndex];
	    var right = nums[rightIndex] * nums[rightIndex];
	    if (left > right) {
		swap(nums, 0, rightIndex);
		nums[rightIndex] = left;
	    } else {
		nums[rightIndex] = right;
	    }
	    rightIndex--;
	}
	return nums;
    }

    private static void swap(int[] nums, int leftIndex, int rightIndex) {
	var temp = nums[leftIndex];
	nums[leftIndex] = nums[rightIndex];
	nums[rightIndex] = temp;
    }
}
