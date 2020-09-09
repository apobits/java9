package apo.java.practice.daily;

import java.util.*;

public class DailyPractice {
    public static void main(String[] args) {
	System.out.println(makeBits(new ArrayList<>(List.of(0, 2))));
    }

//    public static List<Integer> sortBinaryNumbers(List<List<Integer>> bitArrays) {
//	Map<Integer, Integer> map = new HashMap<>();
//	for (int i = 0; i < bitArrays.size(); i++) {
//
//	}
//
//    }

    private static String makeBits(List<Integer> list) {
	StringBuilder stringBuilder = new StringBuilder("000000000000");
	for (Integer x : list) {
	    stringBuilder.insert(stringBuilder.length() - x, 1);
	}
	return stringBuilder.toString();
    }

    public void rotateMatrix() {
	var matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
	var matrixCopy = new Integer[matrix.length][matrix[0].length];
	var linkedList = new LinkedList<Integer[]>();
	for (int i = 0; i < matrix.length; i++) {
	    var column = new Integer[matrix.length];
	    for (int j = matrix.length - 1, index = 0; j >= 0; j--, index++) {
		column[index] = matrix[j][i];
	    }
	    linkedList.offer(column);
	}
	for (int i = 0; i < matrixCopy.length; i++) {
	    matrixCopy[i] = linkedList.poll();
	}

	System.out.println("First array: " + Arrays.deepToString(matrix));
	System.out.println("Second array: " + Arrays.deepToString(matrixCopy));
    }
}


