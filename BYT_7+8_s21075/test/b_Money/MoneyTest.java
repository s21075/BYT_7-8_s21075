package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * JUnit test class for testing the Money class.
 */
public class MoneyTest {
	// Currency instances for testing
	Currency SEK, DKK, NOK, EUR;

	// Money instances for testing
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;

	/**
	 * Set up currencies and Money instances for testing before each test.
	 * @throws Exception If an exception occurs during setup.
	 */
	@Before
	public void setUp() throws Exception {
		// Set up currencies with exchange rates
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);

		// Set up Money instances with different amounts and currencies
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	/**
	 * Test the getAmount method of the Money class.
	 */
	@Test
	public void testGetAmount() {
		// Test case: Check the amount of Money
		assertEquals(10000, SEK100.getAmount(), 0.0001);
	}

	/**
	 * Test the getCurrency method of the Money class.
	 */
	@Test
	public void testGetCurrency() {
		// Test case: Check the currency of Money
		assertEquals(SEK, SEK100.getCurrency());
	}

	/**
	 * Test the toString method of the Money class.
	 */
	@Test
	public void testToString() {
		// Test case: Check the string representation of Money
		assertEquals("100.00 SEK", SEK100.toString());
	}

	/**
	 * Test the universalValue method of the Money class.
	 */
	@Test
	public void testGlobalValue() {
		// Test case: Check the universal value of Money
		assertEquals(300000, EUR20.universalValue(), 0.001);
	}

	/**
	 * Test the equals method of the Money class.
	 */
	@Test
	public void testEqualsMoney() {
		// Test case: Check if two Money instances are equal
		assertTrue(SEK0.equals(EUR0));
	}

	/**
	 * Test the add method of the Money class.
	 */
	@Test
	public void testAdd() {
		// Test case: Check the result of adding two Money instances
		assertEquals("300.00 SEK", (SEK100.add(SEK200)).toString());
	}

	/**
	 * Test the sub method of the Money class.
	 */
	@Test
	public void testSub() {
		// Test case: Check the result of subtracting two Money instances
		assertEquals(10000, SEK200.sub(SEK100).getAmount().intValue());
	}

	/**
	 * Test the isZero method of the Money class.
	 */
	@Test
	public void testIsZero() {
		// Test case: Check if Money is zero
		assertFalse(SEK100.isZero());
	}

	/**
	 * Test the negate method of the Money class.
	 */
	@Test
	public void testNegate() {
		// Test case: Check the negation of Money
		assertEquals(-10000, SEK100.negate().getAmount().intValue());
	}

	/**
	 * Test the compareTo method of the Money class.
	 */
	@Test
	public void testCompareTo() {
		// Test case: Check the result of comparing two Money instances
		assertEquals(1, SEK200.compareTo(SEK100));
	}
}

