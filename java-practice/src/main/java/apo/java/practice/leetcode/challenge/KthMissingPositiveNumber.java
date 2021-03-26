package apo.java.practice.leetcode.challenge;

import junit.framework.Assert;

import java.util.HashMap;
import java.util.HashSet;

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
	var array = new int[] { 2, 3, 4, 7, 11 };
	var array2 = new int[] { 1, 2, 3, 4 };
	var array3 = new int[] { 1, 2 };
	Assert.assertEquals(9, findKthPositive2(array, 5));
    }

    public static int findKthPositive(int[] arr, int k) {
	int temp = 1, index = -1, mapIndex = 1;
	var map = new HashMap<Integer, Integer>();
	out:
	while (++index < arr.length) {
	    while (temp < arr[index]) {
		map.put(mapIndex++, temp++);
		if (mapIndex > k) {
		    break out;
		}
	    }
	    temp++;
	}
	if ((mapIndex - 1) < k) {
	    var top = arr[arr.length - 1];
	    var max = top + (k - mapIndex) + 1;
	    while (top++ < max) {
		map.put(mapIndex++, temp++);
	    }
	}
	return map.getOrDefault(k, -1);
    }

    public static int findKthPositive2(int[] arr, int k) {
	var set = new HashSet<Integer>();
	int index = -1, number = 1;
	var missingNumbers = new int[1000];
	while (++index < arr.length) {
	    set.add(arr[index]);
	}
	index = 0;
	while (index < k) {
	    if (!set.contains(number++)) {
		missingNumbers[index++] = number - 1;
	    }
	}
	return missingNumbers[k - 1];
    }
}
