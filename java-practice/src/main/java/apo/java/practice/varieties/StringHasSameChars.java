package apo.java.practice.varieties;

import java.util.HashMap;

public class StringHasSameChars {

    // Big O(a + b)
    public static boolean hasSameCharacters(String a, String b) {
	var map = new HashMap<Character, Integer>();
	var aArray = a.toCharArray();
	for (int i = 0; i < aArray.length; i++) {
	    map.put(aArray[i], i);
	}
	var lastIndex = -1;
	for (char c : b.toCharArray()) {
	    if (!map.containsKey(c) || map.get(c) <= lastIndex) {
		return false;
	    }
	    lastIndex = map.get(c);
	}
	return true;
    }
}
