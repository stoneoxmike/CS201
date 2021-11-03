import java.util.Collection;

public class Q6 {

	public static boolean isFlush(Collection<Card> hand) {
		if (hand.isEmpty()) {
			return false;
		} else {
			for (Card c : hand) {
				if (!c.getSuit().equals(hand.iterator().next().getSuit())) {
					return false;
				}
			}
		} return true;
	}
	
	
	// EXTRA CREDIT
	public static boolean isStraightFlush(Collection<Card> hand) {
		if (hand.isEmpty()) {
			return false;
		} else {
			for (Card c : hand) {
				if (!c.getSuit().equals(hand.iterator().next().getSuit())) {
					return false;
				}
			}
		}
		for (Card c : hand) {
			if (hand.contains(c.getRank()[c.getRank().ordinal() + 1)] || hand.contains(hand.iterator().next().getRank().ordinal() - 1)) {
				return false;
			}
		} return true;
	}

}
