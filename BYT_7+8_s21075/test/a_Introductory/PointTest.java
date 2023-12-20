package a_Introductory;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * JUnit test class for testing the Point class.
 */
public class PointTest {
	// Points for testing
	Point p1, p2, p3;

	/**
	 * Set up points before each test.
	 * @throws Exception If an exception occurs during setup.
	 */
	@Before
	public void setUp() throws Exception {
		// Define points for testing
		p1 = new Point(7, 9);
		p2 = new Point(-3, -30);
		p3 = new Point(-10, 3);
	}

	/**
	 * Test the add method of the Point class.
	 */
	@Test
	public void testAdd() {
		// Test case 1: Add p2 to p1
		Point res1 = p1.add(p2);
		assertEquals(new Integer(4), res1.x);
		assertEquals(new Integer(-21), res1.y);

		// Test case 2: Add p3 to p1
		Point res2 = p1.add(p3);
		assertEquals(new Integer(-3), res2.x);
		assertEquals(new Integer(12), res2.y);
	}

	/**
	 * Test the sub method of the Point class.
	 */
	@Test
	public void testSub() {
		// Test case 1: Subtract p2 from p1
		Point res1 = p1.sub(p2);
		assertEquals(new Integer(10), res1.x);
		assertEquals(new Integer(39), res1.y);

		// Test case 2: Subtract p3 from p1
		Point res2 = p1.sub(p3);
		assertEquals(new Integer(17), res2.x);
		assertEquals(new Integer(6), res2.y);
	}
}
