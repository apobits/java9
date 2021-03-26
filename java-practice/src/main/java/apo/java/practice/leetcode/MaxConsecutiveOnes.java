package apo.java.practice.leetcode;

import junit.framework.Assert;

public class MaxConsecutiveOnes {
    //{1,1,0,1,1,1}
    public static int findMaxConsecutiveOnes(int[] binaryArray) {
	var counter = 0;
	var max = 0;
	for (int i = 0; i < binaryArray.length; i++) {
	    if (binaryArray[i] == 0) {
		max = Math.max(max, counter);
		counter = 0;
	    } else {
		counter++;
	    }
	}
	System.gc();
	return Math.max(max, counter);
    }

    public static void main(String[] args) {
	Assert.assertEquals(3, findMaxConsecutiveOnes(new int[] { 1, 0, 1, 1, 1 }));
    }
}
