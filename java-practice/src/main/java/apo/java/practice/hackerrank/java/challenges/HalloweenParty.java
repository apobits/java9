package apo.java.practice.hackerrank.java.challenges;

import org.junit.Assert;

public class HalloweenParty {
    public static void main(String[] args) {
        Assert.assertEquals(9,halloweenParty(6));
        Assert.assertEquals(0,halloweenParty(1));
        Assert.assertEquals(1,halloweenParty(2));
        Assert.assertEquals(861534819721l
                ,halloweenParty(1856378));

    }

    public static long halloweenParty(int cuts) {
        long index = 0, result = 0;
        while (++index <= cuts) {
            result += index / 2;
        }
        return result;
    }
}
