package b_Money;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * JUnit test class for testing the Account class.
 */
public class AccountTest {
	// Currency and banks for testing
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;

	// Test account
	Account testAccount;

	/**
	 * Set up currency, banks, and account before each test.
	 * @throws Exception If an exception occurs during setup.
	 */
	@Before
	public void setUp() throws Exception {
		// Create currency and banks
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Alice");

		// Create a test account and deposit money
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));

		// Deposit money into Alice's account in SweBank
		SweBank.deposit("Alice", new Money(1000000, SEK));
	}

	/**
	 * Test the addTimedPayment and removeTimedPayment methods of the Account class.
	 */
	@Test
	public void testAddRemoveTimedPayment() {
		// Test case: Add a timed payment and then remove it
		testAccount.addTimedPayment("1", 3, 1, new Money(500, SEK), SweBank, "Alice");
		assertTrue(testAccount.getTimedPayments().containsKey("1"));
		testAccount.removeTimedPayment("1");
		assertFalse(testAccount.getTimedPayments().containsKey("1"));
	}

	/**
	 * Test the timedPaymentExists method of the Account class.
	 */
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		// Test case: Check if a timed payment exists
		testAccount.addTimedPayment("1", 3, 1, new Money(500, SEK), SweBank, "Alice");
		assertTrue(testAccount.timedPaymentExists("1"));
	}

	/**
	 * Test the withdraw method of the Account class.
	 */
	@Test
	public void testAddWithdraw() {
		// Test case: Withdraw all money from the account
		testAccount.withdraw(new Money(10000000, SEK));
		assertEquals(0, testAccount.getBalance().getAmount(), 0.0001);
	}

	/**
	 * Test the getBalance method of the Account class.
	 */
	@Test
	public void testGetBalance() {
		// Test case: Check the balance of the account
		assertEquals(10000000, testAccount.getBalance().getAmount(), 0.0001);
	}
}

