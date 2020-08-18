package apo.java.practice.general.concurrency.bank;

public class Bank {
    private final int[] accounts = { 1000, 1000 };

    public void transferMoney(int from, int to, int amount) {
	if (accounts[from] < amount) {
	    System.out.printf("Account %d insufficient balance: %d , cannot transfer: %d\n", from, accounts[from],
			    amount);
	    return;
	}
	System.out.printf("Transferring %d from account: %d to account: %d\n", amount, from, to);
	accounts[from] -= amount;
	accounts[to] += amount;
	System.out.printf("Account: %d new balance: %d\nAccount: %d new balance: %d\n", from, accounts[from], to,
			accounts[to]);
    }

}
