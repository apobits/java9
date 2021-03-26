package apo.java.practice.leetcode.challenge;

public class CheckIfTwoStringArraysAreEquivalent {
    public static boolean arrayStringsAreEqual(String[] array1, String[] array2) {
	var index = -1;
	var array1SB = new StringBuilder();
	while (++index < array1.length) {
	    array1SB.append(array1[index]);
	}
	index = -1;
	var array2SB = new StringBuilder();
	while (++index < array2.length) {
	    array2SB.append(array2[index]);
	}
	return array1SB.compareTo(array2SB) == 0;
    }
}
