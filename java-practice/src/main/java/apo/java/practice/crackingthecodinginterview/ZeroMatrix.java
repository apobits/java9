package apo.java.practice.crackingthecodinginterview;

import java.util.Arrays;

public class ZeroMatrix {
    public static void main(String[] args) {
	var matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 1, 0, 3 }, { 4, 5, 6, 7 } };
	zeroMatrix(matrix);
	System.out.println(Arrays.deepToString(matrix));
    }

    public static void zeroMatrix(int[][] matrix) {
	int index = -1;
	var matrixCopy = new int[matrix.length][];
	while (++index < matrix.length) {
	    matrixCopy[index] = Arrays.copyOf(matrix[index], matrix[index].length);
	}

	int i = -1, j = -1;
	while (++i < matrixCopy.length) {
	    while (++j < matrixCopy[i].length) {
		if (matrixCopy[i][j] == 0) {
		    setToZeros(matrix, i, j);
		}
	    }
	    j = -1;
	}
    }

    private static void setToZeros(int[][] matrix, int i, int j) {
	int index = -1;
	while (++index < matrix.length) {
	    matrix[index][j] = 0;
	}
	index = -1;
	while (++index < matrix[i].length) {
	    matrix[i][index] = 0;
	}
    }
}
