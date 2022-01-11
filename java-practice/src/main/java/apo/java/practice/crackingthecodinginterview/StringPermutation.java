package apo.java.practice.crackingthecodinginterview;

import java.util.Arrays;

public class StringPermutation {
    public static boolean isPermutation(String one, String two) {
        var oneArray = one.toCharArray();
        var twoArray = two.toCharArray();
        Arrays.sort(oneArray);
        Arrays.sort(twoArray);
        return Arrays.equals(oneArray, twoArray);
    }
}
