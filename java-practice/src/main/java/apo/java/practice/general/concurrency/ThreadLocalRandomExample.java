package apo.java.practice.general.concurrency;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomExample {

    public static void main(String[] args) {
	System.out.println(ThreadLocalRandom.current().nextInt(1,11));
    }
}
