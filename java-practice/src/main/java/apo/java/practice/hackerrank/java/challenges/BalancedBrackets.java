package apo.java.practice.hackerrank.java.challenges;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class BalancedBrackets {
    public static String isBalanced(String s) {

	LinkedList<String> stack = new LinkedList<>();
	for (String c : s.split("")) {
	    if (c.equals("(") || c.equals("{") || c.equals("[")) {
		stack.push(c);
	    } else {
	        if(stack.isEmpty()){
	            return "NO";
		}
		String value = stack.pop();
		if ((c.equals(")") && !value.equals("(")) || (c.equals("}") && !value.equals("{")) || (c.equals("]") && !value.equals("["))) {
		    return "NO";
		}
	    }
	}
	if(!stack.isEmpty()){
	    return "NO";
	}
	return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
	BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

	int t = scanner.nextInt();
	scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	for (int tItr = 0; tItr < t; tItr++) {
	    String s = scanner.nextLine();

	    String result = isBalanced(s);

	    bufferedWriter.write(result);
	    bufferedWriter.newLine();
	}

	bufferedWriter.close();

	scanner.close();
    }
}
