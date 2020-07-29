package apo.java.practice.codewars;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

public class SumOfPositive {
    public static void main(String[] args) {
 	assertEquals(15, sum(new int[] { -2, 5, 0, 10 }));
    }

    public static int sum(int[] arr) {
	return Arrays.stream(arr).filter(t -> t > 0).sum();
    }
}
