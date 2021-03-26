package apo.java.practice.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class CheckArrayFormationThroughConcatenation {
    public static void main(String[] args) {
	var array = new int[] { 2, 82, 79, 95, 28 };
	var pieces = new int[][] { { 2 }, { 82 }, { 28 }, { 79, 95 } };
	System.out.println(canFormArray(array, pieces));
    }

    public static boolean canFormArray(int array[], int[][] pieces) {
	int i = -1;
	while (++i < pieces.length) {
	    int index = findIndex(array, pieces[i][0]);
	    if (index == -1) {
		return false;
	    }
	    int j = -1;
	    while (++j < pieces[i].length) {
		if (index >= array.length || array[index++] != pieces[i][j]) {
		    return false;
		}
	    }

	}
	return true;
    }

    private static int findIndex(int[] array, int number) {
	int i = -1;
	while (++i < array.length) {
	    if (array[i] == number) {
		return i;
	    }
	}
	return -1;
    }

    public static boolean canFormArrayOld(int array[], int[][] pieces) {
	var arrayString = getNumbers(array);
	var piecesStringList = Arrays.stream(pieces).map(CheckArrayFormationThroughConcatenation::getNumbers)
			.sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
	for (String s : piecesStringList) {
	    arrayString = arrayString.replaceFirst(s, "");
	}
	return arrayString.replace(",", "").trim().isEmpty();
    }

    private static String getNumbers(int[] array) {
	var temp = Arrays.toString(array);
	return temp.substring(1, temp.length() - 1);
    }
}
