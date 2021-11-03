public class Coins {
	// TODO: add class components with corresponding comment labels

	// fields
	private int pennies;
	private int nickels;
	private int dimes;
	private int quarters;

	// constructor
	public Coins(int pennies, int nickels, int dimes, int quarters) {
		this.pennies = pennies;
		this.nickels = nickels;
		this.dimes = dimes;
		this.quarters = quarters;
	}

	// getter methods
	public int getPennies() {
		return pennies;
	}

	public int getNickels() {
		return nickels;
	}

	public int getDimes() {
		return dimes;
	}

	public int getQuarters() {
		return quarters;
	}

	// instance methods
	public int findCentsValue() {
		return (getPennies() + (getNickels() * 5) + (getDimes() * 10) + (getQuarters() * 25));
	}

	public int findDollars() {
		return findCentsValue() / 100;
	}

	public int findChange() {
		return findCentsValue() % 100;
	}
}
