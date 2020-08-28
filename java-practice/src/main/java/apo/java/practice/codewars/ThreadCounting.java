package apo.java.practice.codewars;

public class ThreadCounting {

    public static void main(String[] args) throws InterruptedException {
	var threadCounting = new ThreadCounting();
	threadCounting.tryWait();
    }

    public synchronized void tryWait() throws InterruptedException {
	this.wait();
    }

    static class Else {
	public static synchronized void oneAtATime() {
	    System.out.printf("Thread: ", Thread.currentThread().getName());
	    Else.class.notifyAll();
	}
    }

}
