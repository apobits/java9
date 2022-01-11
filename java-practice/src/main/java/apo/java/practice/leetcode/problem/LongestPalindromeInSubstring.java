package apo.java.practice.leetcode.problem;

import java.util.Comparator;
import java.util.TreeSet;

public class LongestPalindromeInSubstring {

    public static void main(String[] args) {
	System.out.println(longestPalindrome(
			"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    public static String longestPalindrome(String word) {
	if (word.length() <= 1) {
	    return word;
	}
	String result = maxSubstring(word);
	var index = -1;
	while (++index < word.length() && result.length() < (word.length() - index)) {
	    var index1 = word.length();
	    var letter = word.substring(index, index + 1);
	    while (index < index1) {
		index1 = word.lastIndexOf(letter, index1 - 1);
		if (index1 != -1 && result.length() <= (index1 - index)) {
		    var subString = word.substring(index, index1 + 1);
		    if (isPalindrome(subString)) {
			if (subString.length() == word.length()) {
			    return subString;
			}
			result = result.length() > subString.length() ? result : subString;
			if (result.length() == subString.length()) {
			    break;
			}
		    }
		}
	    }
	}
	return result;
    }

    private static boolean isPalindrome(String word) {

	if (word == null) {
	    return false;
	}

	if (word.length() == 1) {
	    return true;
	}

	int left = -1;
	int right = word.length();
	while (++left < --right) {
	    if (word.charAt(left) != word.charAt(right)) {
		return false;
	    }
	}

	return true;
    }

    public static String longestPalindrome2(String word) {
	if (word.length() <= 1) {
	    return word;
	}
	var letters = word.split("");

	var result = "";

	var leftIndex = -1;
	while (++leftIndex < word.length() && result.length() < (word.length() - leftIndex)) {
	    var rightIndex = word.length() - 1;
	    while (leftIndex < rightIndex) {
		while (!letters[rightIndex].equals(letters[leftIndex])) {
		    rightIndex--;
		}
		var stringBuilder = new StringBuilder();
		for (int i = leftIndex; i <= rightIndex; i++) {
		    stringBuilder.append(letters[i]);
		}
		var word2 = stringBuilder.toString();
		if (isPalindrome(word2) && result.length() < word2.length()) {
		    result = word2;
		    break;
		} else {
		    rightIndex--;
		}
	    }
	}
	return result;
    }

    public static String maxSubstring(String s) {
	char c = ' ';
	var lastIndex = 0;
	var set = new TreeSet<>(Comparator.comparing(String::length));
	for (int i = 0; i < s.length(); i++) {
	    if (s.charAt(i) != c) {
		set.add(s.substring(lastIndex, i));
		lastIndex = i;
		c = s.charAt(i);
	    }
	}
	return set.pollLast();
    }

}
