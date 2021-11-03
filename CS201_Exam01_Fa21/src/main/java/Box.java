// CS201 Fall 2021 Exam 1

public class Box {
	// TODO: add fields
	private int height;
	private int width;
	// TODO: add constructor
	public Box(int l1, int l2) {
		if (l1 > l2) {
			height = l2;
			width = l1;
		} else {
			height = l1;
			width = l2;
		}
	}
	// TODO: add getter methods

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	// TODO: complete method
	public boolean fitsInside(Box other) {
		//throw new UnsupportedOperationException("TODO - implement");
		if (other.height > height && other.width > width) {
			return true;
		} else {
			return false;
		}
	}
}
