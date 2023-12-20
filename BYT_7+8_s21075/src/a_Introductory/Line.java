package a_Introductory;

public class Line {
	// Instance variables representing the two endpoints of the line
	private Point p1, p2;

	// Constructor to initialize the Line with two Points
	Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	// Method to calculate and return the Vector2D representing the line
	public Vector2D getVector() {
		return new Vector2D(p1, p2);
	}

	// Method to calculate and return the length of the line using the distance formula
	public Double getLength() {
		return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
	}

	// Method to check if the current line has the same length as another line
	public Boolean isSameLengthAs(Line l) {
		// Compare the lengths with a tolerance to account for floating-point precision
		return (Math.abs(getLength() - l.getLength()) < 0.00001);
	}
}

