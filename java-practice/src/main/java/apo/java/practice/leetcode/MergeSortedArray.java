package apo.java.practice.leetcode;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
	var nums1 = new int[] { 1, 2, 3, 4, 0, 0, 0, 0 };
	var nums2 = new int[] { 3, 4, 5, 6 };

	merge(nums1, 4, nums2, nums2.length);
	System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
	for (int i = m, j = 0; i < nums1.length && j < n; i++, j++) {
	    nums1[i] = nums2[j];
	}
	Arrays.sort(nums1);
    }
}
