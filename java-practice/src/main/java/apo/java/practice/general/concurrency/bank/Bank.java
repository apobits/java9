package apo.java.practice.general.concurrency.bank;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final int[] accounts = { 1000, 1000, 1000, 1000, 1000 };
    private final ReentrantLock reentrantLock = new ReentrantLock();

    public void transferMoney(int from, int to, int amount) {
	reentrantLock.lock();
	try {
	    if (accounts[from] < amount) {
		System.out.printf("Account %d insufficient balance: %d , cannot transfer: %d\n", from, accounts[from],
				amount);
		return;
	    }
	    accounts[from] -= amount;
	    System.out.printf("Transferring %d from account: %d to account: %d\n", amount, from, to);
	    try {
		Thread.sleep(1000);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	    accounts[to] += amount;
	    System.out.printf("Account: %d new balance: %d\nAccount: %d new balance: %d\n", from, accounts[from], to,
			    accounts[to]);
	} finally {
	    reentrantLock.unlock();
	}
    }

    public String getTotalBalances() {
	return Arrays.toString(accounts);
    }

    public int getSumTotalBalances() {
	return Arrays.stream(accounts).sum();
    }

}
