public class Horse extends Vehicle implements Animal {
	public Horse(double maxSpeed) {
		super(maxSpeed);
	}

	// Implemented Vehicle inherited methods
	public boolean startTrip(Terrain t) {
		return canMove(t);
	}

	public boolean move(Terrain t) {
		return canMove(t);
	}

	public boolean endTrip(Terrain t) {
		return canMove(t);
	}

	public double getSpeed(Terrain t) {
		if (t == Terrain.FIELD) {
			// half speed
			return 0.5 * getMaxSpeed();
		} else if (t == Terrain.MOUNTAIN) {
			// quarter speed
			return 0.25 * getMaxSpeed();
		} else {
		return getMaxSpeed();
		}
	}
  
	private boolean canMove(Terrain t) {
		// horses can go anywhere except water
		return t != Terrain.WATER;
	}

	// Implemented Animal interface methods
	public int numberOfLegs() {
		return 4;
	}

	public void makeSound() {
		System.out.println("Neigh");
	}
}