package apo.java.practice.leetcode.problem;

import org.junit.Assert;

public class SQRTX {
    public static void main(String[] args) {
        Assert.assertEquals(2, mySqrt(8));
        Assert.assertEquals(46339, mySqrt(2147395599));
    }

    public static int mySqrt(int n) {
        if (n < 2) {
            return n;
        }
        int d = Integer.MAX_VALUE >> 1;
        while (d > n) {
            d >>= 2;
        }
        int c = 0;
        while (d != 0) {
            if (n >= (c + d)) {
                n -= c + d;
                c = (c >> 1) + d;
            } else {
                c >>= 1;
            }
            d >>= 2;
        }
        return c;
    }
}
