package apo.java.practice.hackerrank.java.hashtable;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoStrings {

    public static void main(String[] args) throws IOException {
	Scanner scanner = new Scanner(System.in);

	int q = scanner.nextInt();
	scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	for (int qItr = 0; qItr < q; qItr++) {
	    String s1 = scanner.nextLine();

	    String s2 = scanner.nextLine();

	    String result = twoStrings(s1, s2);
	    System.out.println(result);
	}

	scanner.close();
    }

    /**
     * Java 8 or above
     *
     * @param s1
     * @param s2
     * @return
     */
    public static String twoStringsNew(String s1, String s2) {
	return new HashSet<String>(Arrays.asList(s1.split(""))).stream().anyMatch(s2::contains) ? "YES" : "NO";
    }

    public static String twoStrings(String s1, String s2) {
	Set<String> set = new HashSet<>(Arrays.asList(s1.split("")));
	for (String s : s2.split("")) {
	    if (set.contains(s)) {
		return "YES";
	    }
	}
	return "NO";
    }

}
