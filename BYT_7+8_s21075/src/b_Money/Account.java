package b_Money;

import java.util.Hashtable;

import java.util.Hashtable;

public class Account {
	private Money content;
	private String name;
	private Hashtable<String, TimedPayment> timedPayments = new Hashtable<>();

	// Constructor to initialize the Account with a name and currency
	Account(String name, Currency currency) {
		this.name = name;
		this.content = new Money(0, currency);
	}

	/**
	 * Add a timed payment
	 * @param id Id of timed payment
	 * @param interval Number of ticks between payments
	 * @param next Number of ticks till first payment
	 * @param amount Amount of Money to transfer each payment
	 * @param toBank Bank where receiving account resides
	 * @param toAccount Id of receiving account
	 */
	public void addTimedPayment(String id, Integer interval, Integer next, Money amount, Bank toBank, String toAccount) {
		TimedPayment tp = new TimedPayment(id, interval, next, amount, this, toBank, toAccount);
		timedPayments.put(id, tp);
	}

	/**
	 * Remove a timed payment
	 * @param id Id of timed payment to remove
	 */
	public void removeTimedPayment(String id) {
		timedPayments.remove(id);
	}

	/**
	 * Check if a timed payment exists
	 * @param id Id of timed payment to check for
	 */
	public boolean timedPaymentExists(String id) {
		return timedPayments.containsKey(id);
	}

	/**
	 * A time unit passes in the system
	 */
	public void tick() {
		for (TimedPayment tp : timedPayments.values()) {
			tp.tick();
		}
	}

	/**
	 * Deposit money to the account
	 * @param money Money to deposit.
	 */
	public void deposit(Money money) {
		content = content.add(money);
	}

	/**
	 * Withdraw money from the account
	 * @param money Money to withdraw.
	 */
	public void withdraw(Money money) {
		content = content.sub(money);
	}

	/**
	 * Get balance of account
	 * @return Amount of Money currently on account
	 */
	public Money getBalance() {
		return content;
	}

	/**
	 * Get a Hashtable containing all timed payments associated with the account
	 * @return Hashtable of timed payments
	 */
	public Hashtable<String, TimedPayment> getTimedPayments() {
		return timedPayments;
	}

	/* Everything below belongs to the private inner class, TimedPayment */
	private class TimedPayment {
		private final String id;
		private int interval, next;
		private Account fromAccount;
		private Money amount;
		private Bank toBank;
		private String toAccount;

		// Constructor to initialize a timed payment
		TimedPayment(String id, Integer interval, Integer next, Money amount, Account fromAccount, Bank toBank, String toAccount) {
			this.id = id;
			this.interval = interval;
			this.next = next;
			this.amount = amount;
			this.fromAccount = fromAccount;
			this.toBank = toBank;
			this.toAccount = toAccount;
		}

		/**
		 * Perform a timed payment when a time unit passes
		 * @return True if a transfer was initiated, false otherwise
		 */
		public Boolean tick() {
			if (next == 0) {
				next = interval;

				// Withdraw money from the source account
				fromAccount.withdraw(amount);

				try {
					// Deposit money to the specified bank account
					toBank.deposit(toAccount, amount);
				} catch (AccountDoesNotExistException e) {
					// Revert transfer if the receiving account does not exist
					fromAccount.deposit(amount);
				}
				return true;
			} else {
				next--;
				return false;
			}
		}
	}
}

