package apo.java.practice.hackerrank.java.bignumber;

import java.math.BigInteger;
import java.util.Scanner;

public class JavaPrimalityTest {
    public static void main(String[] args) {
	try(Scanner scanner = new Scanner(System.in)){
	    BigInteger number = scanner.nextBigInteger();
	    System.out.println(number.isProbablePrime(1)?"prime":"not prime");
	}
    }
}
