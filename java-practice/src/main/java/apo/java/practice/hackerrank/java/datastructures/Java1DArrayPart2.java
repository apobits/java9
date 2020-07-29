package apo.java.practice.hackerrank.java.datastructures;

import java.util.*;

public class Java1DArrayPart2 {
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
	Map<Integer, Integer> indexes = new HashMap<>();
	Set<Integer> notForwardMoves = new HashSet<>();
	int index = 0;
	do {
	    index = move(numbers, leap, index, notForwardMoves);
	    indexes.compute(index, (t, u) -> u == null ? 1 : ++u);
	} while ((!indexes.containsKey(index) || indexes.get(index) < 10) && index < numbers.length);
	return index >= numbers.length;
    }

    private static int move(int[] numbers, int leap, int index, Set<Integer> notForwardMoves) {
	int tempIndex = moveForward(numbers, leap, index, notForwardMoves);
	if (index != tempIndex) {
	    return tempIndex;
	} else {
	    return moveBackward(numbers, leap, index);
	}
    }

    private static int moveForward(int[] numbers, int leap, int index, Set<Integer> notForwardMoves) {
	int temp = index;
	if (index + leap >= numbers.length) {
	    return index + leap;
	}
	if (index + 1 >= numbers.length) {
	    return index++;
	}
	if (!notForwardMoves.contains(index + leap) && numbers[index + leap] == 0) {
	    index = index + leap;
	    int indexHelper = index;
	    while (indexHelper > temp && numbers[indexHelper - 1] == 0) {
		indexHelper--;
	    }
	    if (indexHelper > temp) {
		index = indexHelper;
	    }
	} else if (!notForwardMoves.contains(index + 1) && numbers[index + 1] == 0) {
	    index++;
	}
	if (temp != index) {
	    notForwardMoves.add(index);
	}
	return index;
    }

    private static int moveBackward(int[] numbers, int leap, int index) {
	if (index - 1 >= 0 && numbers[index - 1] == 0) {
	    index--;
	} else if ((index - leap >= 0) && numbers[index - leap] == 0) {
	    index = index - leap;
	}
	return index;
    }
}
