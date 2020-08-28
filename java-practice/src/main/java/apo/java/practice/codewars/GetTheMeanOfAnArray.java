package apo.java.practice.codewars;

import java.util.Arrays;

public class GetTheMeanOfAnArray {

    public static int getAverage(int[] marks) {
	return (int) Arrays.stream(marks).average().orElseGet(() -> 0.0);
    }

}
