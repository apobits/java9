package apo.java.practice.crackingthecodinginterview;

public class URLify {
    public static void main(String[] args) {
	System.out.println(urlify("hello there ."));
    }
    public static String urlify(String s) {
	var chars = s.toCharArray();
	int spaces = 0;
	int stringIndex = -1;
	while (++stringIndex < chars.length) {
	    if (chars[stringIndex] == ' ') {
		spaces++;
	    }
	}
	int newCharsIndex = s.length() + (spaces * 2);
	var newChars = new char[newCharsIndex];
	stringIndex = s.length();
	while (--stringIndex >= 0) {
	    if (chars[stringIndex] == ' ') {
		newChars[--newCharsIndex] = '0';
		newChars[--newCharsIndex] = '2';
		newChars[--newCharsIndex] = '%';
	    } else {
		newChars[--newCharsIndex] = chars[stringIndex];
	    }
	}
	return new String(newChars);
    }
}
//testing spaces.
