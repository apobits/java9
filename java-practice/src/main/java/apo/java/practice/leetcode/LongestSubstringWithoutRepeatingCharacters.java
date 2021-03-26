package apo.java.practice.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
	//	Assert.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
	Arrays.stream("abcdeabcde".split("a")).forEach(System.out::println);
    }

    public static int lengthOfLongestSubstring(String s) {
	if (s.isEmpty()) {
	    return 0;
	}
	var set = new HashSet<Character>();
	int subIndex = -1;
	var longest = 0;
	while (++subIndex < s.length()) {
	    var c = s.charAt(subIndex);
	    if (!set.add(c)) {
		longest = Math.max(longest, set.size());
		subIndex = s.indexOf(c, subIndex - set.size());
		set.clear();
	    }
	}
	return Math.max(set.size(), longest);
    }

    public static int lengthOfLongestSubstringV2(String s) {
	var subStringHashSet = new HashSet<String>();
	for (int c = 32; c < 127; c++) {
	    var segments = s.split(String.valueOf(c));
	}
	return 0;
    }

}
