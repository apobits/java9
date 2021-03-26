package apo.java.practice.leetcode.problem;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
	System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
    }

    public static double findMedianSortedArrays(int[] numbers1, int[] numbers2) {
	int[] numbers = new int[numbers1.length + numbers2.length];
	int index = 0, numbers1Index1 = -1;
	while (++numbers1Index1 < numbers1.length) {
	    numbers[index++] = numbers1[numbers1Index1];
	}
	int numbers2Index = -1;
	while (++numbers2Index < numbers2.length) {
	    numbers[index++] = numbers2[numbers2Index];
	}
	Arrays.sort(numbers);
	double median;
	if (numbers.length % 2 == 0) {
	    median = ((double) numbers[(numbers.length / 2) - 1] + numbers[(numbers.length / 2)]) / 2;
	} else {
	    median = numbers[numbers.length / 2];
	}
	return median;
    }
}
