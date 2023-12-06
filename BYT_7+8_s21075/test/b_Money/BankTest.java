package b_Money;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;

	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {
		assertEquals("SweBank", SweBank.getName());
	}

	@Test
	public void testGetCurrency() {
		assertEquals(SEK, SweBank.getCurrency());
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		SweBank.openAccount("Alah");
		assertTrue(SweBank.getAccountList().containsKey("Alah"));
	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		SweBank.deposit("Ulrika", new Money(500, SEK));
		assertEquals(500, SweBank.getAccountList().get("Ulrika").getBalance().getAmount(), 0.001);
	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		SweBank.deposit("Ulrika", new Money(5000, SEK));
		SweBank.withdraw("Ulrika", new Money(2500, SEK));
		assertEquals(2500, SweBank.getAccountList().get("Ulrika").getBalance().getAmount(), 0.001);
	}

	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		SweBank.deposit("Ulrika", new Money(5000, SEK));
		assertEquals(5000, SweBank.getBalance("Ulrika").intValue());
	}

	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		SweBank.deposit("Ulrika", new Money(5000, SEK));
		SweBank.transfer("Ulrika", "Bob", new Money(2500, SEK));
		assertEquals(2500, SweBank.getBalance("Ulrika").intValue());
		assertEquals(2500, SweBank.getBalance("Bob").intValue());
	}

	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		SweBank.addTimedPayment("Ulrika", "1", 3, 1, new Money(5000, SEK), SweBank, "Bob");
		assertFalse(SweBank.getAccountList().get("Ulrika").getTimedPayments().isEmpty());
	}
}
