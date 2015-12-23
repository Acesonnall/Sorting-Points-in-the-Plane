package edu.iastate.cs228.hw2;

/**
 * 
 * @author Omar Taylor
 *
 */

public class Point implements Comparable<Point> {
	private int x;
	private int y;

	/**
	 * Constructs and initializes a point at the origin (0, 0) of the coordinate
	 * space.
	 */
	public Point() // default constructor
	{
		// x and y get default value 0
		x = 0;
		y = 0;
	}

	/**
	 * Constructs and initializes a point at the specified (x,y) location in the
	 * coordinate space.
	 * 
	 * @param x
	 *            The X coordinate of this Point.
	 * @param y
	 *            The Y coordinate of this Point.
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * 
	 * @return the X coordinate of this Point2D in double precision.
	 */
	public int getX() {
		return x;
	}

	/**
	 * 
	 * @return Returns the Y coordinate of this Point2D in double precision.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Determines whether or not two points are equal.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}

	/**
	 * Compare this point with a second point q in the left-to-right order.
	 * 
	 * @param q
	 * @return -1 if this.x < q.x || (this.x == q.x && this.y < q.y) 0 if this.x
	 *         == q.x && this.y < q.y 1 otherwise
	 */
	@Override
	public int compareTo(Point q) {
		if ((this.x < q.x) || ((this.x == q.x) && (this.y < q.y))) {
			return -1;
		} else if ((this.x == q.x) && (this.y == q.y)) {
			return 0;
		} else {
			return 1;
		}
	}

	/**
	 * Output a point in the standard form (x, y).
	 */
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
