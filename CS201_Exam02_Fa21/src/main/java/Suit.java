public enum Suit {
	/** Clubs */
	CLUBS("♣"),
	/** Diamonds */
	DIAMONDS("♦"),
	/** Hearts */
	HEARTS("♥"),
	/** Spades */
	SPADES("♠");
	
	private final String symbol;
	
	private Suit(String symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public String toString() {
		return symbol;
	}
	
	/**
	 * @return the enumeration member name as a string
	 */
	public String getMemberName() {
		return super.toString();
	}
}
