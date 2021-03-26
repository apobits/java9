package apo.java.practice.crackingthecodinginterview;

import org.junit.Assert;

import java.util.HashMap;

public class PalindromePermutation {
    public static void main(String[] args) {
	Assert.assertEquals(true, isPalindromeFromPermutation("mm"));
    }

    public static boolean isPalindromeFromPermutation(String s) {
	if (s.length() == 1) {
	    return true;
	}
	var hashMap = new HashMap<Character, Integer>();
	int index = -1;
	int length = 0;
	while (++index < s.length()) {
	    char c = s.charAt(index);
	    if (c != ' ') {
		hashMap.merge(c, 1, (t, u) -> null);
		length++;
	    }
	}
	if (length % 2 == 0) {
	    return hashMap.size() == 0;
	} else {
	    return hashMap.size() == 1;
	}
    }
}
//mom
