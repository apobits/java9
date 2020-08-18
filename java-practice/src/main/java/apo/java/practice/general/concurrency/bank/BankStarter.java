package apo.java.practice.general.concurrency.bank;

public class BankStarter {
    public static void main(String[] args) {
	var bank = new Bank();
	double delay = 10000;
	double maxAmount = 1000;

	Runnable runnable1 = () -> {
	    for (int i = 0; i < 5; i++) {
		bank.transferMoney(0, 1, (int) (maxAmount * Math.random()));
		try {
		    Thread.sleep((long) (delay * Math.random()));
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	};

	Runnable runnable2 = () -> {
	    for (int i = 0; i < 5; i++) {
		bank.transferMoney(1, 0, (int) (maxAmount * Math.random()));
		try {
		    Thread.sleep((long) (delay * Math.random()));
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	};

	new Thread(runnable1).start();
	new Thread(runnable2).start();
    }
}
