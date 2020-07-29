package apo.java.practice.hackerrank.java.datastructures;

import java.util.Scanner;

public class JavaSubArray {

    public static void main(String[] args) {
	try (Scanner scanner = new Scanner(System.in)) {
	    int arrayLength = scanner.nextInt();
	    int array[] = new int[arrayLength];
	    for (int i = 0; i < arrayLength; i++) {
		array[i] = scanner.nextInt();
	    }
	    System.out.println(numOfNegativeSubArraysByIndex0(array));
	}
    }

    private static int numOfNegativeSubArraysByIndex0(int[] array) {
	//[1,-1,2,-2]
	int counter = 0;
	for (int i = 0; i < array.length; i++) {
	    if (array[i] < 0) {
		counter++;
	    }
	    int sum = array[i];
	    for (int j = i + 1; j < array.length; j++) {
		sum += array[j];
		if (sum < 0) {
		    counter++;
		}
	    }
	}
	return counter;
    }
}
