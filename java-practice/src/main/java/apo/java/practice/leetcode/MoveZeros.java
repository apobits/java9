package apo.java.practice.leetcode;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
	var nums = new int[] { 3, 0, 0, 1, 4, 5 };
	moveZeros3(nums);
	System.out.println(Arrays.toString(nums));
    }

    public static void moveZeros(int[] nums) {
	var index = nums.length - 1;
	while (index >= 0) {
	    if (nums[index] == 0) {
		var tempIndex = index;
		while (tempIndex < nums.length - 1) {
		    var value = nums[tempIndex + 1];
		    if (value == 0) {
			nums[tempIndex] = 0;
			break;
		    }
		    nums[tempIndex++] = value;
		}
		if (tempIndex == nums.length - 1) {
		    nums[tempIndex] = 0;
		}
	    }
	    index--;
	}
    }

    public static void moveZeros2(int[] nums) {
	var index = 0;
	var zeroIndex = nums.length - 1;
	while (index < nums.length && index < zeroIndex) {
	    if (nums[index] == 0) {
		var tempIndex = index;
		while (tempIndex < nums.length - 1 && tempIndex < zeroIndex) {
		    var value = nums[tempIndex + 1];
		    nums[tempIndex++] = value;
		}
		nums[tempIndex] = 0;
		zeroIndex = tempIndex - 1;
	    }
	    if (nums[index] != 0) {
		index++;
	    }
	}
    }

    public static void moveZeros3(int[] nums) {
	var arrayIndex = -1;
	var nonZeroIndex = 0;
	while (++arrayIndex < nums.length) {
	    if (nums[arrayIndex] != 0) {
		swap(nums, nonZeroIndex++, arrayIndex);
	    }
	}
    }

    private static void swap(int[] nums, int left, int right) {
	var temp = nums[left];
	nums[left] = nums[right];
	nums[right] = temp;
    }
}
