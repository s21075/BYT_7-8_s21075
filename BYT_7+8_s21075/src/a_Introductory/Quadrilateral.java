package a_Introductory;

public class Quadrilateral {
	// Instance variables representing the four points and four lines of the quadrilateral
	private Point p1, p2, p3, p4;
	private Line l1, l2, l3, l4;

	// Constructor to initialize the Quadrilateral with four Points
	Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;

		// Create lines connecting the consecutive points to form the quadrilateral
		this.l1 = new Line(p1, p2);
		this.l2 = new Line(p2, p3);
		this.l3 = new Line(p3, p4);
		this.l4 = new Line(p4, p1);
	}

	// Method to check if the quadrilateral is a rectangle
	public Boolean isRectangle() {
		// Get vectors representing the sides of the quadrilateral
		Vector2D v1 = l1.getVector();
		Vector2D v2 = l2.getVector();
		Vector2D v3 = l3.getVector();
		Vector2D v4 = l4.getVector();

		// Check if the consecutive sides are orthogonal to each other
		return (v1.isOrthogonalTo(v2) &&
				v2.isOrthogonalTo(v3) &&
				v3.isOrthogonalTo(v4) &&
				v4.isOrthogonalTo(v1));
	}

	// Method to check if the quadrilateral is a square
	public Boolean isSquare() {
		// Check if the quadrilateral is a rectangle and if opposite sides have equal lengths
		return (isRectangle() &&
				l1.isSameLengthAs(l2));
	}
}

