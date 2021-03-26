package apo.java.practice.leetcode;

import java.util.Arrays;

public class DuplicateZeros {
    public static void main(String[] args) {
	var numbers = new int[] { 1, 5, 2, 0, 6, 8, 0, 6, 0 };
	duplicateZerosV2(numbers);
	System.out.println(Arrays.toString(numbers));
    }

    public static void duplicateZerosV1(int[] numbers) {
	var temp = Arrays.copyOf(numbers, numbers.length);
	var index = 0;
	for (int i = 0; i < temp.length && index < numbers.length; i++, index++) {
	    numbers[index] = temp[i];
	    if (temp[i] == 0 && (index + 1) < numbers.length) {
		numbers[++index] = 0;
	    }
	}
    }

    public static void duplicateZerosV2(int[] numbers) {
	var temp1 = numbers[0];
	var temp2 = numbers[1];

	for (int i = 0; i < numbers.length; i++) {
	    var temp3 = temp1;
	    temp1 = temp2;
	    if ((i + 2) < numbers.length) {
		temp2 = numbers[i + 2];
	    }
	    if (temp3 == 0) {
		i++;
	    }
	    numbers[i] = temp3;

	}
    }
}
