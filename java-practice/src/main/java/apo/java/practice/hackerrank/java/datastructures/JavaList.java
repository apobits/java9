package apo.java.practice.hackerrank.java.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaList {
    public static void main(String[] args) {
	try (Scanner scanner = new Scanner(System.in)) {
	    int size = scanner.nextInt();
	    List<Integer> list = new ArrayList<>();
	    while (size-- > 0) {
		list.add(scanner.nextInt());
	    }
	    int queries = scanner.nextInt();
	    while (queries-- > 0) {
		String operation = scanner.next();
		if (operation.equals("Insert")) {
		    int index = scanner.nextInt();
		    int value = scanner.nextInt();
		    if (list.size() <= index) {
			list.add(value);
		    } else {
			list.add(index, value);
		    }
		} else if (operation.equals("Delete")) {
		    list.remove(scanner.nextInt());
		}
	    }
	    list.forEach(t -> System.out.printf("%d ", t));
	}
    }
}
