package apo.java.practice.leetcode;

public class FirstUniqueCharacter {
    public static void main(String[] args) {
	System.out.println(firstUniqChar("leetcode"));
    }

    public static int firstUniqChar(String s) {
	if (s == null || s.isEmpty()) {
	    return -1;
	}
	var character = 96;
	var index = Integer.MAX_VALUE;
	while (++character < 123) {
	    var firstIndex = s.indexOf(character);
	    var lastIndex = firstIndex != -1 ? s.lastIndexOf(character) : -1;
	    if (firstIndex != -1 && firstIndex == lastIndex) {
		index = Math.min(index, firstIndex);
	    }
	}
	return index == Integer.MAX_VALUE ? -1 : index;
    }
}
