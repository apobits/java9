package apo.java.practice.crackingthecodinginterview;

import org.junit.Assert;

import java.util.HashMap;

public class StringRotation {
    public static void main(String[] args) {
	Assert.assertEquals(true,isSubstring("abcd","abc"));
    }
    public static boolean isSubstring(String string, String substring) {
	if (string.length() < substring.length()) {
	    return false;
	}
	var stringHashMap = new HashMap<Character, Integer>();
	var subStringHashMap = new HashMap<Character, Integer>();
	int index = -1;
	while (++index < substring.length()) {
	    subStringHashMap.merge(substring.charAt(index), 1, Integer::sum);
	}
	index = -1;
	while (++index < string.length()) {
	    stringHashMap.merge(string.charAt(index), 1, Integer::sum);
	}
	for (var entry : subStringHashMap.entrySet()) {
	    if (stringHashMap.getOrDefault(entry.getKey(), -1) < entry.getValue()) {
		return false;
	    }
	}
	return true;
    }
}
//abcd
//abc
