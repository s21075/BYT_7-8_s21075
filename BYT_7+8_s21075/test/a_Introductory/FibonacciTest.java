package a_Introductory;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * JUnit test class for testing the Fibonacci class.
 */
public class FibonacciTest {

	/**
	 * Test the fib method of the Fibonacci class.
	 */
	@Test
	public void testFib() {
		// Create an instance of the Fibonacci class
		Fibonacci tester = new Fibonacci();

		// Test cases for the Fibonacci sequence
		assertEquals("0", 0, tester.fib(0));
		assertEquals("1", 1, tester.fib(1));
		assertEquals("2", 1, tester.fib(2));
		assertEquals("3", 2, tester.fib(3));
		assertEquals("4", 3, tester.fib(4));
		assertEquals("5", 5, tester.fib(5));
		assertEquals("6", 8, tester.fib(6));
		assertEquals("7", 13, tester.fib(7));
	}
}
