public class Coins {
	// TODO: add fields here
	private int p, n, d, q;
	
	// TODOL add constructors
	public Coins(int p, int n, int d, int q) {
		this.p = p;
		this.n = n;
		this.d = d;
		this.q = q;
	}
	
	// TODO: add getters
	public int getPennies() {
		return p;
	}
	
	public int getNickels() {
		return n;
	}
	
	public int getDimes() {
		return d;
	}
	
	public int getQuarters() {
		return q;
	}
	
	// TODO: add methods
	public int findCentsValue() {
		int total = p + 5*n + 10*d + 25*q;
		return total;
	}
	
	public int findDollars() {
		return findCentsValue()/100;
	}
	
	public int findChange() {
		return findCentsValue()%100;
	}
}

