package apo.java.practice.varieties;

public class ForVsWhilePerformance {
    public static void main(String[] args) {
        var array = new int[10000000];
        var start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            process(array, i);
        }
        System.out.println("Time taken with for loop: " + (System.currentTimeMillis() - start) + " milliseconds");
        int index = -1;
        start = System.currentTimeMillis();
        while (++index < array.length) {
            process(array, index);
        }
        System.out.println("Time taken with while loop: " + (System.currentTimeMillis() - start) + " milliseconds");

    }

    public static void process(int[] array, int index) {
        array[index] += 2;
    }
}
