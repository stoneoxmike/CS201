public class Card implements Comparable<Card> {
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

    public int compareTo(Card other) {
        int cmp;
        cmp = this.getSuit().compareTo(other.getSuit());
        if (cmp != 0) {
            return cmp;
        } else {
            cmp = this.getRank().compareTo(other.getRank());
            return cmp;
        }
    }

    public boolean equals(Card other) {
        if (this.getSuit().compareTo(other.getSuit()) == 0 && this.getRank().compareTo(other.getRank()) == 0) {
            return true;
        } else {
            return false;
        }
    }
}
