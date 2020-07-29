package apo.java.practice.hackerrank.java.bignumber;

import java.math.BigInteger;
import java.util.Scanner;

public class JavaBigInteger {
    public static void main(String[] args) {
	try (Scanner scanner = new Scanner(System.in)) {
	    BigInteger bigIntegerOne = scanner.nextBigInteger();
	    BigInteger bigIntegerTwo = scanner.nextBigInteger();
	    System.out.println(bigIntegerOne.add(bigIntegerTwo));
	    System.out.println(bigIntegerOne.multiply(bigIntegerTwo));
	}
    }
}
