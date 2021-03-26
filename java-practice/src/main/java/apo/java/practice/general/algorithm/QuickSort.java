package apo.java.practice.general.algorithm;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
	int[] numbers = { 2, 3, 5, 1, 4 };
	sort(numbers);
	System.out.println(Arrays.toString(numbers));
    }

    public static void sort(int[] numbers) {
	sortWithExtraSpace(numbers, 0, numbers.length - 1);
    }

    private static void sortWithExtraSpace(int[] numbers, int leftIndex, int rightIndex) {
	if (leftIndex >= rightIndex) {
	    return;
	}
	var pivotIndex = (leftIndex + rightIndex) / 2;
	var pivot = numbers[pivotIndex];
	var left = leftIndex;
	var right = rightIndex;
	numbers[pivotIndex] = numbers[right];
	numbers[right--] = pivot;
	while (left <= right) {
	    while (numbers[left] < pivot) {
		left++;
	    }
	    while (numbers[right] > pivot) {
		right--;
	    }
	    if (left < right) {
		var swapValue = numbers[right];
		numbers[right--] = numbers[left];
		numbers[left++] = swapValue;
	    }
	}
	numbers[rightIndex] = numbers[left];
	numbers[left] = pivot;
	sortWithExtraSpace(numbers, leftIndex, left - 1);
	sortWithExtraSpace(numbers, left + 1, rightIndex);
    }

    private static void sortWithSameSpace(int[] numbers, int leftIndex, int rightIndex) {
	if (leftIndex >= rightIndex) {
	    return;
	}
	var index = (leftIndex + rightIndex) / 2;
	var pivot = numbers[index];
	var left = leftIndex;
	var right = rightIndex;
	while (left <= right) {
	    while (numbers[left] < pivot) {
		left++;
	    }
	    while (numbers[right] > pivot) {
		right--;
	    }
	    if (left <= right) {
		var temp = numbers[right];
		numbers[right] = numbers[left];
		numbers[left++] = temp;
	    }
	}
	sortWithSameSpace(numbers, leftIndex, left - 1);
	sortWithSameSpace(numbers, left, rightIndex);
    }
}
