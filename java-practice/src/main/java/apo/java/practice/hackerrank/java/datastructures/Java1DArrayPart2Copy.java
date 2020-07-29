package apo.java.practice.hackerrank.java.datastructures;

import java.util.Scanner;

public class Java1DArrayPart2Copy {
    public static void main(String[] args) {
	try (Scanner scanner = new Scanner(System.in)) {
	    int queries = scanner.nextInt();
	    for (int i = 0; i < queries; i++) {
		int arraySize = scanner.nextInt();
		int jump = scanner.nextInt();
		int[] numbers = new int[arraySize];
		for (int j = 0; j < arraySize; j++) {
		    numbers[j] = scanner.nextInt();
		}
		System.out.println(canWin(numbers, jump) ? "YES" : "NO");
	    }
	}
    }

    private static boolean canWin(int[] numbers, int leap) {
	int index = 0, counter = 0;
	do {
	    index = move(numbers, leap, index);
	    if (index == 0) {
		counter++;
	    }
	} while (counter < numbers.length && index < numbers.length);
	return index >= numbers.length;
    }

    private static int move(int[] numbers, int leap, int index) {
	int tempIndex = moveForward(numbers, leap, index);
	if (index != tempIndex) {
	    return tempIndex;
	} else {
	    return moveBackward(numbers, leap, index);
	}
    }

    private static int moveForward(int[] numbers, int leap, int index) {
	if ((index + 1) >= numbers.length || index + leap >= numbers.length) {
	    return numbers.length;
	}
	if (numbers[index + leap] == 0) {
	    index = index + leap;
	} else if (numbers[index + 1] == 0) {
	    index++;
	}

	return index;
    }

    private static int moveBackward(int[] numbers, int leap, int index) {
	numbers[index] = -1;
	return 0;
    }
}
