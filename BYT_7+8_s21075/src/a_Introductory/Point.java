package a_Introductory;

public class Point {
	// Instance variables representing the x and y coordinates of the point
	public Integer x, y;

	// Constructor to initialize the Point with x and y coordinates
	Point(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	// Method to add another Point to the current Point and return the result as a new Point
	public Point add(Point p) {
		return new Point(x + p.x, y + p.y);
	}

	// Method to subtract another Point from the current Point and return the result as a new Point
	public Point sub(Point p) {
		return new Point(x - p.x, y - p.y);
	}
}

