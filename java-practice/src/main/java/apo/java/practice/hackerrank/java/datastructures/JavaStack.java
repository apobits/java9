package apo.java.practice.hackerrank.java.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class JavaStack {
    public static void main(String[] args) {
	try (Scanner scanner = new Scanner(System.in)) {
	    while (scanner.hasNext()) {
		System.out.println(isBalanced(scanner.next()));
	    }
	}
    }

    private static boolean isBalanced(String data) {
	if (data == null || data.isEmpty()) {
	    return true;
	}

	Deque<String> deque = new ArrayDeque<>();
	for (String letter : data.split("")) {
	    if (letter.equals("(") || letter.equals("{") || letter.equals("[")) {
		deque.push(letter);
	    } else if (deque.peek() == null) {
		return false;
	    } else if ((letter.equals(")") && deque.peek().equals("(")) || (letter.equals("}") && deque.peek()
			    .equals("{")) || (letter.equals("]") && deque.peek().equals("["))) {
		deque.pop();
	    }
	}
	if (deque.isEmpty()) {
	    return true;
	}

	return false;
    }
}
