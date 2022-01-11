package apo.java.practice.crackingthecodinginterview;

import org.junit.Assert;

import java.util.HashSet;

public class StringHasAllUniqueCharacters {
    public static void main(String[] args) {
        Assert.assertEquals(true, hasAllUniqueCharacters("abcdefghijklmnopqrstuvwxyz"));
        Assert.assertEquals(false, hasAllUniqueCharacters("abcdefghijklmnopqrrstuvwxyz"));

    }

    public static boolean hasAllUniqueCharacters(String s) {
        var hashSet = new HashSet<Character>();
        var index = -1;
        while (++index < s.length()) {
            if (!hashSet.add(s.charAt(index))) {
                return false;
            }
        }
        return true;
    }
}
