package apo.java.practice.leetcode.problem;

import org.junit.Assert;

import java.util.LinkedList;

public class ValidParentheses {
    public static void main(String[] args) {
        Assert.assertEquals(true, isValid2("}"));

//        Assert.assertEquals(true, isValid("{[]}"));
    }

    public static boolean isValid(String s) {
        var open = new LinkedList<Character>();
        int index = -1;
        while (++index < s.length()) {
            var character = s.charAt(index);
            if (isOpen(character)) {
                open.push(character);
            } else {
                var openChar = open.poll();
                if (openChar == null || (character == '}' && openChar != '{') || (character == ')' && openChar != '(') || (character == ']' && openChar != '[')) {
                    return false;
                }
            }
        }
        return open.size() <= 0;

    }

    public static boolean isValid2(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        var open = new char[s.length()];
        var openIndex = 0;
        int index = -1;
        while (++index < s.length()) {
            var character = s.charAt(index);
            if (isOpen(character)) {
                open[openIndex++] = character;
            } else {
                if (openIndex == 0) {
                    return false;
                }
                var openChar = open[--openIndex];
                if ((character == '}' && openChar != '{') || (character == ')' && openChar != '(') || (character == ']' && openChar != '[')) {
                    return false;
                }
            }
        }
        return openIndex <= 0;

    }

    private static boolean isOpen(char character) {
        if (character == '{' || character == '[' || character == '(') {
            return true;
        }
        return false;
    }
}
