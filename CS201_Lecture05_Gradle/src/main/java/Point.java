public class Point {
	// Fields
	private int x;
	private int y;

	// Constructor
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// Getters
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	// Setters
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	// Instance print method
	public void print() {
		System.out.println("x=" + x + ", y=" + y);
	}
}