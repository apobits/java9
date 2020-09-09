package apo.java.practice.general.algorithm;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
	var array = new int[] { 2, 1, 5, 3, 9, 4, 6, 8, 7 };
	sort(array);
	System.out.println(Arrays.toString(array));
    }


    public static void sort(int[] array) {
	for (int i = 0; i < array.length - 1; i++) {
	    var index = i + 1;
	    while (index > 0 && array[index] < array[index - 1]) {
		var temp = array[index - 1];
		array[index - 1] = array[index];
		array[index--] = temp;
	    }
	}

    }
}
