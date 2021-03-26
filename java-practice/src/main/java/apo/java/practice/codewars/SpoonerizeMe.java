package apo.java.practice.codewars;

import org.junit.Assert;

public class SpoonerizeMe {
    public static void main(String[] args) {
	Assert.assertEquals("Main Camp",spoonerize("Cain Mamp"));
    }
    public static String spoonerize(String words) {
	char firstChar = words.charAt(0);
	int secondWordIndex = words.indexOf(" ") + 1;
	var sb = new StringBuilder(words);
	sb.replace(0, 1, String.valueOf(words.charAt(secondWordIndex))).replace(secondWordIndex, secondWordIndex + 1, String.valueOf(firstChar));
	return sb.toString();
    }
}
