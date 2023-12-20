package b_Money;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * JUnit test class for testing the Bank class.
 */
public class BankTest {
	// Currencies and banks for testing
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;

	/**
	 * Set up currencies and banks before each test.
	 * @throws Exception If an exception occurs during setup.
	 */
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);

		// Open accounts in banks for testing
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	/**
	 * Test the getName method of the Bank class.
	 */
	@Test
	public void testGetName() {
		// Test case: Check the name of the bank
		assertEquals("SweBank", SweBank.getName());
	}

	/**
	 * Test the getCurrency method of the Bank class.
	 */
	@Test
	public void testGetCurrency() {
		// Test case: Check the currency of the bank
		assertEquals(SEK, SweBank.getCurrency());
	}

	/**
	 * Test the openAccount method of the Bank class.
	 */
	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		// Test case: Open an account in the bank
		SweBank.openAccount("Alah");
		assertTrue(SweBank.getAccountList().containsKey("Alah"));
	}

	/**
	 * Test the deposit method of the Bank class.
	 */
	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		// Test case: Deposit money into an account
		SweBank.deposit("Ulrika", new Money(500, SEK));
		assertEquals(500, SweBank.getAccountList().get("Ulrika").getBalance().getAmount(), 0.001);
	}

	/**
	 * Test the withdraw method of the Bank class.
	 */
	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		// Test case: Deposit and then withdraw money from an account
		SweBank.deposit("Ulrika", new Money(5000, SEK));
		SweBank.withdraw("Ulrika", new Money(2500, SEK));
		assertEquals(2500, SweBank.getAccountList().get("Ulrika").getBalance().getAmount(), 0.001);
	}

	/**
	 * Test the getBalance method of the Bank class.
	 */
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		// Test case: Check the balance of an account
		SweBank.deposit("Ulrika", new Money(5000, SEK));
		assertEquals(5000, SweBank.getBalance("Ulrika").intValue());
	}

	/**
	 * Test the transfer method of the Bank class.
	 */
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		// Test case: Transfer money between accounts in the bank
		SweBank.deposit("Ulrika", new Money(5000, SEK));
		SweBank.transfer("Ulrika", "Bob", new Money(2500, SEK));
		assertEquals(2500, SweBank.getBalance("Ulrika").intValue());
		assertEquals(2500, SweBank.getBalance("Bob").intValue());
	}

	/**
	 * Test the addTimedPayment method of the Bank class.
	 */
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		// Test case: Add a timed payment to an account
		SweBank.addTimedPayment("Ulrika", "1", 3, 1, new Money(5000, SEK), SweBank, "Bob");
		assertFalse(SweBank.getAccountList().get("Ulrika").getTimedPayments().isEmpty());
	}
}

