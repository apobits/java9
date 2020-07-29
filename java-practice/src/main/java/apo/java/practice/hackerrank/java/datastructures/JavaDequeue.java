package apo.java.practice.hackerrank.java.datastructures;

import java.util.*;

public class JavaDequeue {
    public static void main(String[] args) {
	try (Scanner scanner = new Scanner(System.in)) {
	    long start = System.nanoTime();
	    int size = scanner.nextInt();
	    int subArrayLength = scanner.nextInt();
	    int[] numbers = new int[size];
	    LinkedList<Integer> linkedList = new LinkedList<>();
	    Set<Integer> set = new HashSet<>();
	    TreeSet<Integer> higherNumbers = new TreeSet<>(Comparator.reverseOrder());
	    for (int i = 0; i < size; i++) {
		numbers[i] = scanner.nextInt();
		linkedList.offer(numbers[i]);
		set.add(numbers[i]);
		if (i == subArrayLength - 1) {
		    higherNumbers.add(set.size());
		}
		if (i > subArrayLength - 1) {
		    int temp = linkedList.poll();

		}
	    }

	    System.out.println(higherNumbers.first());
	    System.out.println((System.nanoTime() - start) / 1000000);
	}
    }

}


