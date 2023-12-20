package b_Money;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for testing the Currency class.
 */
public class CurrencyTest {
	// Currency instances for testing
	Currency SEK, DKK, NOK, EUR;

	/**
	 * Set up currencies with exchange rates before each test.
	 * @throws Exception If an exception occurs during setup.
	 */
	@Before
	public void setUp() throws Exception {
		// Set up currencies with exchange rates
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	/**
	 * Test the getName method of the Currency class.
	 */
	@Test
	public void testGetName() {
		// Test case: Check the name of the currency
		assertEquals("SEK", SEK.getName(), "SEK");
	}

	/**
	 * Test the getRate method of the Currency class.
	 */
	@Test
	public void testGetRate() {
		// Test case: Check the exchange rate of the currency
		assertEquals(SEK.getRate(), 0.15, 0.0001);
	}

	/**
	 * Test the setRate method of the Currency class.
	 */
	@Test
	public void testSetRate() {
		// Test case: Set a new exchange rate for the currency and check it
		SEK.setRate(0.2);
		assertEquals(SEK.getRate(), 0.2, 0.0001);
	}

	/**
	 * Test the universalValue method of the Currency class.
	 */
	@Test
	public void testGlobalValue() {
		// Test case: Convert an amount to the universal value and check it
		assertEquals(15, EUR.universalValue(10), 0);
	}

	/**
	 * Test the valueInThisCurrency method of the Currency class.
	 */
	@Test
	public void testValueInThisCurrency() {
		// Test case: Convert an amount from another currency to the currency and check it
		assertEquals(75, EUR.valueInThisCurrency(10, DKK), 0);
	}
}
