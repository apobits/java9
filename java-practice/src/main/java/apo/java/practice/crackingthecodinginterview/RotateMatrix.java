package apo.java.practice.crackingthecodinginterview;

import java.util.Arrays;

public class RotateMatrix {

    public static void main(String[] args) {
	System.out.println(Arrays.deepToString(rotateMatrix90Degree(
			new char[][] { { 'a', 'b', 'c', 'd' }, { 'e', 'f', 'g', 'h' }, { 'i', 'j', 'k', 'l' }, { 'm', 'n', 'o', 'p' } })));
    }

    public static char[][] rotateMatrix90Degree(char[][] matrix) {
	var rotatedMatrix = new char[matrix.length][matrix.length];
	int r = matrix.length, c = -1;
	int rm = -1, cm = -1;
	while (--r >= 0) {
	    cm++;
	    while (++c < matrix[r].length) {
		rotatedMatrix[++rm][cm] = matrix[r][c];
	    }
	    c = -1;
	    rm = -1;
	}
	return rotatedMatrix;
    }
}
