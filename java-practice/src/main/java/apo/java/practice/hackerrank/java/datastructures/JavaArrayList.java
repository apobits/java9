package apo.java.practice.hackerrank.java.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaArrayList {
    public static void main(String[] args) {
	try (Scanner scanner = new Scanner(System.in)) {
	    int numOfArrays = scanner.nextInt();
	    List<List<Integer>> arrayLists = new ArrayList<>();
	    for (int i = 0; i < numOfArrays; i++) {
		int arrayLength = scanner.nextInt();
		arrayLists.add(new ArrayList<>(arrayLength));
		for (int j = 0; j < arrayLength; j++) {
		    arrayLists.get(i).add(scanner.nextInt());
		}
	    }
	    int numOfQueries = scanner.nextInt();
	    for (int i = 0; i < numOfQueries; i++) {
		int arrayIndex = scanner.nextInt();
		int elementIndex = scanner.nextInt();
		if (arrayIndex < 0 || arrayIndex > arrayLists.size() || (arrayLists.get(arrayIndex - 1).isEmpty()
				&& elementIndex > 0) || (elementIndex > arrayLists.get(arrayIndex - 1).size())) {
		    System.out.println("ERROR !");
		} else {
		    System.out.println(arrayLists.get(arrayIndex - 1).get(elementIndex - 1));
		}
	    }
	}
    }
}
