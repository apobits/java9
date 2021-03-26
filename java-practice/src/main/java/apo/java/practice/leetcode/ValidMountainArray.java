package apo.java.practice.leetcode;

import junit.framework.Assert;

public class ValidMountainArray {
    public static void main(String[] args) {
	Assert.assertEquals(true, validMountainArray(new int[] { 1, 3, 2 }));
    }

    public static boolean validMountainArray(int[] a) {
	if (a.length < 3) {
	    return false;
	}
	var leftIndex = 0;
	while (leftIndex < a.length - 1 && a[leftIndex] < a[leftIndex + 1]) {
	    leftIndex++;
	}
	var rightIndex = a.length - 1;
	while (rightIndex > leftIndex && a[rightIndex] < a[rightIndex - 1]) {
	    rightIndex--;
	}

	return leftIndex > 0 && rightIndex < a.length - 1 && leftIndex == rightIndex;
    }
}
