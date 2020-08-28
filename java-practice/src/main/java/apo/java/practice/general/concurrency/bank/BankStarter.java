package apo.java.practice.general.concurrency.bank;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class BankStarter {

    public static void main(String[] args) throws InterruptedException {
	var bank = new Bank();
	double delay = 10000;
	double maxAmount = 1000;
	int maxAccounts = 5;
	ThreadGroup threadGroup = new ThreadGroup("My group");
	Runnable runnable = () -> {
	    bank.transferMoney((int) (maxAccounts * Math.random()), (int) (maxAccounts * Math.random()),
			    (int) (maxAmount * Math.random()));
	};

	for (int i = 0; i < 100; i++) {
	    new Thread(threadGroup,runnable).start();
	}

	var threadArray =  new Thread[100];
	threadGroup.enumerate(threadArray);
	Arrays.stream(threadArray).forEach(t-> {
	    try {
		t.join();
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	});
	System.out.println(bank.getTotalBalances());
	System.out.println(bank.getSumTotalBalances());
    }
}
