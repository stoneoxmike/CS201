public class Card implements Comparable {
	// TODO - add fields an methods
	private Suit suit;
	private Rank rank;
	
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public int compareTo(Object o) {
		Card other = (Card) o;
		
		int cmp;
		
		// Compare by suit
		cmp = this.suit.compareTo(other.getSuit());
		if (cmp != 0) {
			return cmp;
		}
		
		// Compare by rank
		cmp = this.rank.compareTo(other.getRank());
		if (cmp != 0) {
			return cmp;
		}
		
		// Otherwise equal
		return 0;
		
	}
}
