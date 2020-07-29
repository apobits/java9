package apo.java.practice.hackerrank.java.datastructures;

import java.util.HashSet;
import java.util.Scanner;

public class JavaHashSet {
    public static void main(String[] args) {
	try (Scanner scanner = new Scanner(System.in)) {
	    int pairNumber = scanner.nextInt();
	    scanner.nextLine();
	    HashSet<String> hashSet = new HashSet<>();
	    while (pairNumber > 0) {
		hashSet.add(scanner.nextLine());
		System.out.println(hashSet.size());
	    }
	}
    }
}
