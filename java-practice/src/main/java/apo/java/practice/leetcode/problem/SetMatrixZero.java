package apo.java.practice.leetcode.problem;

import java.util.Arrays;
import java.util.HashSet;

public class SetMatrixZero {
    public static void main(String[] args) {
        setZeroesV2(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});
    }

    public static void setZeroes(int matrix[][]) {
        var rowSet = new HashSet<Integer>();
        var columnSet = new HashSet<Integer>();
        var copy = new int[matrix.length][];
        for (int row = 0; row < matrix.length; row++) {
            copy[row] = new int[matrix[row].length];
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == 0) {
                    rowSet.add(row);
                    columnSet.add(column);
                }
                copy[row][column] = matrix[row][column];
                matrix[row][column] = 0;
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (!rowSet.contains(row) && !columnSet.contains(column)) {
                    matrix[row][column] = copy[row][column];
                }
            }
        }
    }

    public static void setZeroesV2(int matrix[][]) {
        var rowSet = new HashSet<Integer>();
        var columnSet = new HashSet<Integer>();
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == 0) {
                    rowSet.add(row);
                    columnSet.add(column);
                }
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            if (rowSet.contains(row)) {
                matrix[row] = new int[matrix[row].length];
            } else {
                for (int column = 0; column < matrix[row].length; column++) {
                    if (columnSet.contains(column)) {
                        matrix[row][column] = 0;
                    }
                }
            }
        }
    }
}
