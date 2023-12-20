package a_Introductory;

public class Vector2D {
	// Instance variables representing the x and y components of the vector
	public Integer x, y;

	// Constructor to initialize the Vector2D with x and y components
	Vector2D(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	// Constructor to construct Vector2D from two points
	Vector2D(Point p1, Point p2) {
		// Calculate the vector components based on the difference between the two points
		this.x = p2.x - p1.x;
		this.y = p2.y - p1.y;
	}

	// Method to calculate the dot product of the current vector and another vector
	public int dotProduct(Vector2D v) {
		return (x * v.x) + (y * v.y);
	}

	// Method to check if the current vector is orthogonal (perpendicular) to another vector
	public boolean isOrthogonalTo(Vector2D v) {
		// Two vectors are orthogonal if their dot product is zero
		return (dotProduct(v) == 0);
	}
}
