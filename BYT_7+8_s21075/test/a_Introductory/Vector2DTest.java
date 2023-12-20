package a_Introductory;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * JUnit test class for testing the Vector2D class.
 */
public class Vector2DTest {
	// Vectors for testing
	Vector2D v1, v2, v3;

	/**
	 * Set up vectors before each test.
	 * @throws Exception If an exception occurs during setup.
	 */
	@Before
	public void setUp() throws Exception {
		/* v1 and v3 are orthogonal, v1 and v2 aren't. */
		v1 = new Vector2D(-2, 4);
		v2 = new Vector2D(1, 2);
		v3 = new Vector2D(2, 1);
	}

	/**
	 * Test the dotProduct method of the Vector2D class.
	 */
	@Test
	public void testDotProduct() {
		// Test case 1: v1 and v3 are orthogonal. The dot product should be zero.
		assertEquals("v1 and v3 are orthogonal. The dot product should be zero.", 0, v1.dotProduct(v3));

		// Test case 2: The dot product of v1 and v2 should be (-2 * 1) + (4 * 2) = 6
		assertEquals("The dot product of v1 and v2 should be (-2 * 1) + (4 * 2) = 6", 6, v1.dotProduct(v2));
	}

	/**
	 * Test the isOrthogonalTo method of the Vector2D class.
	 */
	@Test
	public void testOrthogonality() {
		// Test case 1: v1 should not be orthogonal to v2
		assertFalse("v1 should not be orthogonal to v2", v1.isOrthogonalTo(v2));

		// Test case 2: v1 should be orthogonal to v3
		assertTrue("v1 should be orthogonal to v3", v1.isOrthogonalTo(v3));
	}
}

