package apo.java.practice.leetcode.problem;

import org.junit.Assert;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Assert.assertEquals("fl", longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        Assert.assertEquals("", longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        Assert.assertEquals("a", longestCommonPrefix(new String[]{"ab", "a"}));

    }

    public static String longestCommonPrefix(String[] letters) {
        var base = letters[0];
        var result = new StringBuilder();
        out:
        for (int j = 0; j < base.length(); j++) {
            for (int i = 1; i < letters.length; i++) {
                if (j >= letters[i].length() || letters[i].charAt(j) != base.charAt(j)) {
                    break out;
                }
            }
            result.append(base.charAt(j));
        }
        return result.toString();
    }
}
