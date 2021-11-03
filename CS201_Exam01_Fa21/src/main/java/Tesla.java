public abstract class Tesla {
	private int maxRange;
	private int numMotors;

	public Tesla() { numMotors = 1; }
	public Tesla(int m) {
		numMotors = m;
	}
	
	public int getMaxRange() {
    	return maxRange;
	}
	public int getNumMotors() {
		return numMotors;
	}
	public void setMaxRange(int maxRange) { this.maxRange = maxRange; }

	public abstract void setRange();
	public abstract double getRange(double load);
	public abstract double getAcceleration();
}