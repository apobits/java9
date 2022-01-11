package apo.java.practice.crackingthecodinginterview;

public class URLify {
    public static void main(String[] args) {
        System.out.println(urlify("Hello there .    ", 13));
    }

    public static String urlify(String s, int trueLength) {
        var chars = s.toCharArray();
        int arrayIndex = s.length() - 1;
        int lengthIndex = trueLength - 1;
        while (arrayIndex != lengthIndex && arrayIndex >= 0) {
            if (chars[lengthIndex] == ' ') {
                chars[arrayIndex--] = '0';
                chars[arrayIndex--] = '2';
                chars[arrayIndex--] = '%';
            } else {
                chars[arrayIndex--] = chars[lengthIndex];
            }
            lengthIndex--;
        }
        return new String(chars);
    }
}
//testing spaces.
