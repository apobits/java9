package apo.java.practice.hackerrank.java.challenges;

import org.junit.Assert;

public class SherlockAndSquares {
    public static void main(String[] args) {
        Assert.assertEquals(3, squares(5, 30));
    }

    public static int squares(int start, int end) {
        int index = 1, counter = 0, square;
        do {
            square = index * index;
            if (square >= start && square <= end) {
                counter++;
            }
            index++;
        } while (square <= end);
        return counter;
    }
}
