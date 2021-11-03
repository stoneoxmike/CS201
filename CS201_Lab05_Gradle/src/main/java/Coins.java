public class Coins {
	// TODO: add class components with corresponding comment labels

	// fields
	private int pennies;
	private int nickels;
	private int dimes;
	private int quarters;

	// constructor(s)
	public Coins() {
		pennies = 1;
		nickels = 0;
		dimes = 0;
		quarters = 0;
	}

	public Coins(double dollars) {
		int cents = (int) (dollars * 100);
		quarters = cents / 25;
		cents = cents - quarters * 25;
		dimes = cents / 10;
		cents = cents - dimes * 10;
		nickels = cents / 5;
		cents = cents - nickels * 5;
		pennies = cents;
	}

	public Coins(Coins coins) {
		this.pennies = coins.getPennies();
		this.nickels = coins.getNickels();
		this.dimes = coins.getDimes();
		this.quarters = coins.getQuarters();
	}

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

	public boolean equals(Coins coins) {
		if (coins.getQuarters() == quarters && coins.getDimes() == dimes && coins.getNickels() == nickels && coins.getPennies() == pennies) {
			return true;
		} else {
			return false;
		}
	}
}
