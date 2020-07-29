package apo.java.practice.hackerrank.java.datastructures;

import java.util.BitSet;
import java.util.Scanner;

public class JavaBitSet {
    public static void main(String[] args) {
	try (Scanner scanner = new Scanner(System.in)) {
	    int size = scanner.nextInt();
	    int operations = scanner.nextInt();
	    BitSet bitSetOne = new BitSet(size);
	    BitSet bitSetTwo = new BitSet(size);
	    while (operations-- > 0) {
		switch (scanner.next()) {
		case "AND":
		    if (scanner.nextInt() == 1) {
			bitSetOne.and(bitSetTwo);
		    } else {
			bitSetTwo.and(bitSetOne);
		    }
		    scanner.nextInt();
		    break;
		case "OR":
		    if (scanner.nextInt() == 1) {
			bitSetOne.or(bitSetTwo);
		    } else {
			bitSetTwo.or(bitSetOne);
		    }
		    scanner.nextInt();
		    break;
		case "XOR":
		    if (scanner.nextInt() == 1) {
			bitSetOne.xor(bitSetTwo);
		    } else {
			bitSetTwo.xor(bitSetOne);
		    }
		    scanner.nextInt();
		    break;
		case "FLIP":
		    int flipBitSet = scanner.nextInt();
		    int flipIndex = scanner.nextInt();
		    if (flipBitSet == 1) {
			bitSetOne.flip(flipIndex);
		    } else {
			bitSetTwo.flip(flipIndex);
		    }
		    break;
		case "SET":
		    int setBitSet = scanner.nextInt();
		    int setIndex = scanner.nextInt();
		    if (setBitSet == 1) {
			bitSetOne.set(setIndex);
		    } else {
			bitSetTwo.set(setIndex);
		    }
		    break;
		}
		System.out.printf("%d %d", bitSetOne.cardinality(), bitSetTwo.cardinality());
	    }
	}
    }
}
