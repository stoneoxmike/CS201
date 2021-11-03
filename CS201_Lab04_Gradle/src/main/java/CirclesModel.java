public class CirclesModel {
	public static final int START_R = 10;
	
	// TODO: add field to store placed Circle
	private Circle circle;
	
	// TODO: add field for counter
	private int counter;
	
	// constructor
	public CirclesModel() {
		// TODO: initialize fields
		circle = new Circle();
		counter = 0;
	}
	
	// TODO: getter and setter methods
	public Circle getCircle() {
		return circle;
	}
	
	public int getCount() {
		return counter;
	}
	
	public void updateCount() {
		counter++;
	}
	
	// TODO: create new Circle from outline values
	public void addCircle(int x, int y, int r) {
		circle = new Circle(x, y, r);
	}

}
