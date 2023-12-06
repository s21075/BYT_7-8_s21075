package b_Money;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	@Test
	public void testGetName() {
		assertEquals("SEK", SEK.getName(), "SEK");
	}
	
	@Test
	public void testGetRate() {
		assertEquals(SEK.getRate(), 0.15, 0.0001);
	}
	
	@Test
	public void testSetRate() {
		SEK.setRate(0.2);
		assertEquals(SEK.getRate(), 0.2, 0.0001);
	}
	
	@Test
	public void testGlobalValue() {
		assertEquals(15, EUR.universalValue(10), 0);
	}
	
	@Test
	public void testValueInThisCurrency() {
		assertEquals(75, EUR.valueInThisCurrency(10, DKK), 0);
	}

}
