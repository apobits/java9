package apo.java.practice.leetcode;

import java.util.Arrays;

public class ReplaceElementsWithGreatestElementOnRightSide {
    public static void main(String[] args) {
	System.out.println(Arrays.toString(replaceElements(new int[] { 17, 18, 5, 4, 6, 1 })));
    }

    public static int[] replaceElements(int[] array) {
	var lastIndex = array.length - 1;
	var value = array[lastIndex];
	array[lastIndex] = -1;
	for (int i = lastIndex - 1; i >= 0; i--) {
	    if (value > array[i]) {
		array[i] = value;
	    } else {
		var temp = value;
		value = array[i];
		array[i] = temp;
	    }
	}
	return array;
    }
}
