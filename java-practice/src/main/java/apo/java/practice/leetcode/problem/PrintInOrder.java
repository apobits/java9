package apo.java.practice.leetcode.problem;

public class PrintInOrder {
    private boolean t1, t2;

    public void first(Runnable printFirst) {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        synchronized (this) {
            t1 = true;
            notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (!t1) {
            wait();
        }
        printSecond.run();
        t2 = true;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (!t2) {
            wait();
        }
        printThird.run();
    }
}
