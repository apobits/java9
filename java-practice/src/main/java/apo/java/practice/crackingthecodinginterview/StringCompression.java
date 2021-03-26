package apo.java.practice.crackingthecodinginterview;

import org.junit.Assert;

public class StringCompression {
    public static void main(String[] args) {
	Assert.assertEquals("3a2b2c2d2e2f2g2h2i1j", compress("aaabbccddeeffgghhiij"));
    }

    public static String compress(String s) {
	var stringBuilder = new StringBuilder(s.length());
	int index = -1;
	int counter = 1;
	while (++index < s.length()) {
	    if (index + 1 == s.length() || s.charAt(index) != s.charAt(index + 1)) {
		stringBuilder.append(counter).append(s.charAt(index));
		counter = 1;
	    } else {
		counter++;
	    }
	}
	return stringBuilder.length() < s.length() ? stringBuilder.toString() : s;
    }
}
