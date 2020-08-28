package apo.java.practice.codewars;

import static junit.framework.Assert.assertEquals;

public class HolyDay8DutyFree {
    public static void main(String[] args) {
	assertEquals(166,dutyFree(12,50,1000));
	assertEquals(294, dutyFree(17,10,500));
	assertEquals(357, dutyFree(24,35,3000));
	assertEquals(20, dutyFree(1400,35,10000));
	assertEquals(38, dutyFree(700,26,7000));
    }

    public static int dutyFree(int normPrice, int discount, int hol) {
	return (int) (hol / (normPrice * (discount / (double) 100)));
    }
}
