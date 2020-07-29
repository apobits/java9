package apo.java.practice.hackerrank.java.datastructures;

import java.util.Scanner;
import java.util.TreeSet;

public class Java2DArray {
    public static void main(String[] args) {
	int[][] matrix2D = new int[6][6];
	try (Scanner scanner = new Scanner(System.in)) {
	    for (int i = 0; i < 6; i++) {
		for (int j = 0; j < 6; j++) {
		    matrix2D[i][j] = scanner.nextInt();
		}
	    }

	    TreeSet<Integer> sums = new TreeSet<>();
	    for (int i = 0; i < 6; i++) {
		for (int j = 0; j < 6; j++) {
		    sums.add(sumHourGlass(matrix2D, i, j));
		}
	    }
	    System.out.println(sums.last());
	}

    }

    private static int sumHourGlass(int[][] matrix, int rowIndex, int columnIndex) {
	boolean upperLeftCorner = rowIndex - 1 >= 0 && columnIndex - 1 >= 0;
	boolean upperRightCorner = rowIndex - 1 >= 0 && columnIndex + 1 < matrix[rowIndex - 1].length;
	boolean lowerLeftCorner = rowIndex + 1 < matrix.length && columnIndex - 1 >= 0;
	boolean lowerRightCorner = rowIndex + 1 < matrix.length && columnIndex + 1 < matrix[rowIndex + 1].length;
	if (upperLeftCorner && upperRightCorner && lowerLeftCorner && lowerRightCorner) {
	    return matrix[rowIndex - 1][columnIndex - 1] + matrix[rowIndex - 1][columnIndex + 1] + matrix[rowIndex + 1][
			    columnIndex - 1] + matrix[rowIndex + 1][columnIndex + 1] + matrix[rowIndex][columnIndex]
			    + matrix[rowIndex - 1][columnIndex] + matrix[rowIndex + 1][columnIndex];
	}
	return Integer.MIN_VALUE;
    }
}
