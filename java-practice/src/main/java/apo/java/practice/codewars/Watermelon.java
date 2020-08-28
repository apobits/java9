package apo.java.practice.codewars;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class Watermelon {
    public static void main(String[] args) {
	assertTrue(divide(4));
	assertFalse(divide(2));
	assertFalse(divide(5));
	assertTrue(divide(88));
	assertTrue(divide(100));
	assertFalse(divide(67));
	assertTrue(divide(90));
	assertTrue(divide(10));
	assertFalse(divide(99));
	assertTrue(divide(32));
    }

    public static boolean divide(int weight) {
	// your code here
	return weight % 2 == 0 && weight / 2 > 1;
    }
}
