// CS201 Fall 2021 Exam 1
import java.util.ArrayList;

public class Stack {
	private ArrayList<Box> stack;

	public ArrayList<Box> getBoxes() {
		return stack;
	}

	// TODO: implement constructor and methods
	public Stack() {
		//throw new UnsupportedOperationException("TODO - implement");
		stack = new ArrayList<Box>();
	}
	

	public int getStackSize() {
		//throw new UnsupportedOperationException("TODO - implement");
		return stack.size();
	}

	public boolean isEmpty() {
		//throw new UnsupportedOperationException("TODO - implement");
		return stack.isEmpty();
	}

	public boolean canNest(Box b) {
		//throw new UnsupportedOperationException("TODO - implement");
		if (stack.isEmpty()) {
			return true;
		} else if (stack.size() < 10) {
			if (b.fitsInside(stack.get(stack.size() - 1))) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public void addBox(Box b) {
		//throw new UnsupportedOperationException("TODO - implement");
		stack.add(b);
	}
	
	public Box removeBox() {
		//throw new UnsupportedOperationException("TODO - implement");
		if (!stack.isEmpty()) {
			return stack.remove(stack.size() - 1);
		} else {
			throw new IllegalStateException();
		}
	}
	
	public void printStack() {
		//throw new UnsupportedOperationException("TODO - implement");
		for (int i = 0; i < stack.size(); i++) {
			System.out.println("Box " + i + ":  h=" + stack.get(i).getHeight() + " w=" + stack.get(i).getWidth());
		}
	}

}
