package apo.java.practice.general.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
	ExecutorService executorService = Executors.newSingleThreadExecutor();
	var future = executorService.submit(() -> "Hello");
	while (!future.isDone()) {
	    System.out.println("Doing some work while the task finishes");
	}
	System.out.printf("Result from future: %s", future.get());

    }
}
