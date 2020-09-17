package apo.java.practice.utility;

public class NumberUtil {

    public static void main(String[] args) {
	var number = 10;
	System.out.println(Integer.toBinaryString(10));
	System.out.println(base10ToBase2(number));
    }

    public static String base10ToBase2(long number) {
	StringBuilder stringBuilder = new StringBuilder();
	var numberCopy = number;
	while (numberCopy > 0) {
	    if (numberCopy % 2 == 0) {
		stringBuilder.append(0);
	    } else {
		stringBuilder.append(1);
	    }
	    numberCopy /= 2;
	}
	return stringBuilder.reverse().toString();
    }
}
