package b_Money;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;

	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Alice");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));

		SweBank.deposit("Alice", new Money(1000000, SEK));
	}

	@Test
	public void testAddRemoveTimedPayment() {
		testAccount.addTimedPayment("1", 3, 1, new Money(500, SEK), SweBank, "Alice");
		assertTrue(testAccount.getTimedPayments().containsKey("1"));
		testAccount.removeTimedPayment("1");
		assertFalse(testAccount.getTimedPayments().containsKey("1"));
	}

	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		testAccount.addTimedPayment("1", 3, 1, new Money(500, SEK), SweBank, "Alice");
		assertTrue(testAccount.timedPaymentExists("1"));
	}

	@Test
	public void testAddWithdraw() {
		testAccount.withdraw(new Money(10000000, SEK));
		assertEquals(0, testAccount.getBalance().getAmount(), 0.0001);
	}

	@Test
	public void testGetBalance() {
		assertEquals(10000000, testAccount.getBalance().getAmount(), 0.0001);
	}
}
