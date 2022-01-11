package apo.java.practice.leetcode.problem;

import org.junit.Assert;

public class ImplementStrStr {
    public static void main(String[] args) {
//        Assert.assertEquals(2, strStr2("hello", "ll"));
//        Assert.assertEquals(0, strStr2("a", "a"));
//        Assert.assertEquals(4, strStr2("mississippi", "issip"));
//        Assert.assertEquals(9, strStr2("mississippi", "pi"));
//        Assert.assertEquals(6, strStr2("mississippi", "sipp"));
        Assert.assertEquals(6, strStr2("aabaaabaaac", "aabaaac"));
    }

    public static int strStr(String hayStack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int index = -1;
        int result = index;

        while (++index < hayStack.length()) {
            if (hayStack.charAt(index) == needle.charAt(0)) {
                if ((index + needle.length() <= hayStack.length()) && (hayStack.startsWith(needle, index))) {
                    result = index;
                    break;
                }
            }
        }

        return result;
    }

    public static int strStr2(String hayStack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int index = -1;
        int result = index;

        byte[] hayStackBytes = hayStack.getBytes();
        byte[] needleBytes = needle.getBytes();
        while (++index < hayStackBytes.length) {
            if (hayStack.charAt(index) == needle.charAt(0)) {
                int size = index + needle.length();
                if ((size <= hayStackBytes.length)) {
                    int tempIndex = index - 1;
                    int needleIndex = -1;
                    boolean flag = true;
                    while (++tempIndex < size) {
                        if (hayStackBytes[tempIndex] != needleBytes[++needleIndex]) {
                            index = (tempIndex - index) > 2 ? (tempIndex - 2) : (index);
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        result = index;
                        break;
                    }
                }
            }
        }
        return result;
    }

}
