import java.awt.Color;

public class CountModel {
	// Fields for the system state
	private int count;
	private int colorIndex;

    // as the count increases, the rectangle will cycle through these colors
    public static final Color[] colors = { Color.RED, Color.GREEN, Color.BLUE };
	
	// Model constructor
	public CountModel() {
		count = 0;
		colorIndex = 0;
	}
	
	// Model getter methods
	public int getCount() {
		return count;
	}
	
	public int getColorIndex() {
		return colorIndex;
	}
	
	// Increment count method
	public void incrementCount() {
		count++;
	}
	
	// Increment color cyclically
	public void incrementColorIndex() {
		colorIndex = (colorIndex+1)%colors.length;
	}
}
