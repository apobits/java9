package apo.java.practice.codewars;

import static org.junit.Assert.assertArrayEquals;

public class AlphabetSymmetry {

    public static void main(String[] args) {
	assertArrayEquals(new int[] { 4, 3, 1 }, solve(new String[] { "abode", "ABc", "xyzD" }));
	assertArrayEquals(new int[] { 4, 3, 0 }, solve(new String[] { "abide", "ABc", "xyz" }));
	assertArrayEquals(new int[] { 6, 5, 7 }, solve(new String[] { "IAMDEFANDJKL", "thedefgh", "xyzDEFghijabc" }));
	assertArrayEquals(new int[] { 1, 3, 1, 3 }, solve(new String[] { "encode", "abc", "xyzD", "ABmD" }));
    }

    public static int[] solve(String[] arr) {
	var result = new int[arr.length];
	for (int i = 0; i < arr.length; i++) {
	    result[i] = process(arr[i]);
	}

	return result;
    }

    private static int process(String string) {
	var counter = 0;
	for (int i = 0; i < string.length(); i++) {
	    var c = string.charAt(i);
	    if ((c - 65) == i || (c - 97) == i) {
		counter++;
	    }
	}
	return counter;
    }
}
