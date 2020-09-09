package apo.java.practice.general.concurrency.thread;

import java.util.concurrent.Executors;

public class UnsafeSequence {
    private int sequence;

    public int getSequence() {
	return ++sequence;
    }

    public static void main(String[] args) throws InterruptedException {
	var sequence = new UnsafeSequence();
	Runnable runnable = () -> {
	    for (int i = 0; i < 10; i++) {
		System.out.printf("\nThread %s got sequence %d", Thread.currentThread().getName(),
				sequence.getSequence());
		try {
		    Thread.sleep(500);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	};

	var executor = Executors.newFixedThreadPool(20);
	for (int i = 0; i < 20; i++) {
	    executor.execute(runnable);
	}
	Thread.sleep(60000);
	executor.shutdown();
    }
}
