package apo.java.practice.leetcode.problem;

import org.junit.Assert;

public final class ZigZagConversion {
    public static void main(String[] args) {
        Assert.assertEquals("A", convert("A", 1));
        Assert.assertEquals("AB", convert("AB", 2));
    }

    public static String convert(String phrase, int rows) {
        if (phrase.length() <= 1 || rows == 1) {
            return phrase;
        }

        int phraseIndex = 0, index = 0;
        var array = new String[rows][phrase.length()];
        for (int c = 0; c < phrase.length(); c++) {
            for (int r = 0; r < rows; r++) {
                if ((index == 0 || r == (rows - 1 - index)) && (phraseIndex < phrase.length())) {
                    array[r][c] = phrase.substring(phraseIndex, ++phraseIndex);
                }
            }
            if (++index == rows - 1) {
                index = 0;
            }
        }

        var organizedPhrase = new StringBuilder();
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < phrase.length(); c++) {
                var value = array[r][c];
                if (value != null) {
                    organizedPhrase.append(array[r][c]);
                }
            }
        return organizedPhrase.toString();
    }
}
