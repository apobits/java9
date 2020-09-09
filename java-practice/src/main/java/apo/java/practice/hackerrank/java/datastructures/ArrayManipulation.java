package apo.java.practice.hackerrank.java.datastructures;

import java.util.Scanner;

public class ArrayManipulation {
    public static void main(String[] args) {
	try (Scanner scanner = new Scanner(System.in)) {
	    int length = scanner.nextInt();
	    int queries = scanner.nextInt();
	    int[][] array = new int[queries][3];
	    for (int i = 0; i < queries; i++) {
		array[i][0] = scanner.nextInt();
		array[i][1] = scanner.nextInt();
		array[i][2] = scanner.nextInt();
	    }
	    System.out.println(arrayManipulation(length, array));
	}
    }

    static long arrayManipulation(int n, int[][] queries) {
	long start = System.currentTimeMillis();
	long[] array = new long[n];
	long max = Integer.MIN_VALUE;
	for (int[] query : queries) {
	    int from = query[0];
	    int to = query[1];
	    int value = query[2];
	    for (int j = from - 1; j < to; j++) {
		array[j] += value;
		if (array[j] > max) {
		    max = array[j];
		}
	    }
	}
	System.out.println(queries.length);
	System.out.println(System.currentTimeMillis() - start);
	return max;
    }
}
