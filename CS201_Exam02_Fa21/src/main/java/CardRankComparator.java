import java.util.Comparator;

public class CardRankComparator implements Comparator<Card> {
	@Override
	public int compare(Card c1, Card c2) {
		// TODO: Compare cards by Rank
		return c1.getRank().compareTo(c2.getRank());

	}

}
