package apo.java.practice.algorithm.sort;

import java.util.Arrays;

public class MergeSort {

    private static long counter = 0;

    public static void main(String[] args) {
        var array = new int[]{3, 2, 1};
        mergeSort(array);
        System.out.println(counter);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] numbers) {
        mergeSort(numbers, new int[numbers.length], 0, numbers.length - 1);

    }

    public static void mergeSort(int[] numbers, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }
        int mid = (leftStart + rightEnd) / 2;
        mergeSort(numbers, temp, leftStart, mid);
        mergeSort(numbers, temp, mid + 1, rightEnd);
        mergeHaves2(numbers, temp, leftStart, rightEnd);

    }

    private static void mergeHaves(int[] numbers, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (numbers[left] <= numbers[right]) {
                temp[index] = numbers[left++];
            } else {
                temp[index] = numbers[right++];
            }
            index++;
        }

        System.arraycopy(numbers, left, temp, index, leftEnd - left + 1);
        System.arraycopy(numbers, right, temp, index, rightEnd - right + 1);

        int size = rightEnd - leftStart + 1;
        System.arraycopy(temp, leftStart, numbers, leftStart, size);
    }

    private static void mergeHaves2(int[] numbers, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (numbers[leftStart] > numbers[rightStart]) {
                counter++;
                swap(numbers, leftStart, rightStart);
                rightStart++;
            }
            leftStart++;
        }
    }

    private static void swap(int[] numbers, int index1, int index2) {
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }
}
