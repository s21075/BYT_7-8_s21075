package a_Introductory;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test class for testing the Line class.
 */
public class LineTest {
	// Points and Lines for testing
	Point p1, p2;
	Point p3, p4;
	Line l1;
	Line l2;

	/**
	 * Set up points and lines before each test.
	 * @throws Exception If an exception occurs during setup.
	 */
	@Before
	public void setUp() throws Exception {
		// Define points and lines for test case 1
		p1 = new Point(2, -3);
		p2 = new Point(3, 7);
		l1 = new Line(p1, p2);

		// Define points and lines for test case 2
		p3 = new Point(7, 2);
		p4 = new Point(8, 12);
		l2 = new Line(p3, p4);
	}

	/**
	 * Test the length and isSameLengthAs methods of the Line class.
	 */
	@Test
	public void testLength() {
		// Test case 1: Check the length of line l1
		assertEquals(10.0498756, l1.getLength(), 0.0001);

		// Test case 2: Check the length of line l2
		assertEquals(10.0498756, l2.getLength(), 0.0001);

		// Test case 3: Check if l1 has the same length as l2
		assertTrue("l1 should have the same length as l2", l1.isSameLengthAs(l2));
	}
}
