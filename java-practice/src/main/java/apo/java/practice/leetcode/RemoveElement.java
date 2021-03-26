package apo.java.practice.leetcode;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
	var numbers = new int[] { 1, 0, 2, 3, 4, 2, 5, 6, 7 };
	System.out.println(removeElement(numbers, 2));
	System.out.println(Arrays.toString(numbers));
    }

    public static int removeElement(int[] nums, int value) {
	var index = 0;
	for (int i = 0; i < nums.length; i++) {
	    if (nums[i] != value) {
		nums[index++] = nums[i];
	    }
	}
	return index;
    }

}
