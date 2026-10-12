package apo.java.practice.interview.atlassian;

import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

public class OddCharNumber {

    public static void main(String[] args) {
        var values = Stream.of(odd(5).split("")).collect(Collectors.groupingBy(UnaryOperator.identity())).values();
        values.forEach(t -> {
            assertTrue(t.size() % 2 != 0);
        });
    }

    //Given a number return any combination of lower case letters that its length equals number, each included letter
    //must have an odd number of occurrences
    // n=3 xxx xya
    // n=4 abcde
    private static String odd(int n) {
        String answer;
        if (n % 2 == 0) {
            answer = "a".repeat(n - 1) + "b";
        } else {
            answer = "a".repeat(n);
        }
        return answer;
    }

}
