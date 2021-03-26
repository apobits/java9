package apo.java.practice.leetcode;

import java.util.Arrays;

public class SortArrayByParity {
    public static void main(String[] args) {
	System.out.println(Arrays.toString(sortArrayByParity(new int[] { 1, 2, 3, 4 })));
    }

    public static int[] sortArrayByParity(int[] a) {
	var index = 0;
	var i = 0;
	while (i < a.length) {
	    if (a[i] % 2 == 0) {
		swap(a, index++, i);
	    }
	    i++;
	}
	return a;
    }

    private static void swap(int[] a, int left, int right) {
	var temp = a[left];
	a[left] = a[right];
	a[right] = temp;
    }
}
