public class CyberTruck extends Tesla {
	// TODO: Add constructor
	public CyberTruck(int numMotors) {
		super(numMotors);
	}
	// TODO: Add inherited methods
	@Override
	public void setRange() {
		if (getNumMotors() == 1) {
			setMaxRange(250);
		} else if (getNumMotors() == 2) {
			setMaxRange(300);
		} else if (getNumMotors() == 3) {
			setMaxRange(500);
		}
	}

	@Override
	public double getRange(double load) {
		if (load > ((getNumMotors() * 10000)/2.0)) {
			throw new IllegalArgumentException();
		} else {
			return getMaxRange()*(1-(load/(getNumMotors()*10000)));
		}
	}

	@Override
	public double getAcceleration() {
		if (getNumMotors() == 1) {
			return 6.5;
		} else if (getNumMotors() == 2) {
			return 4.5;
		} else if (getNumMotors() == 3) {
			return 2.9;
		} else {
			return 0;
		}
	}
}