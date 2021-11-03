import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q4Test {
	private Card c1, c2, c3, c4;
	private CardRankComparator comp;
	
	@Before
	public void setUp() {
		c1 = new Card(Rank.EIGHT, Suit.HEARTS);
		c2 = new Card(Rank.EIGHT, Suit.CLUBS);
		c3 = new Card(Rank.ACE, Suit.SPADES);
		c4 = new Card(Rank.TWO, Suit.CLUBS);
		comp = new CardRankComparator();
	}
	
	@Test
	public void testCardRankComparisonLessThan() throws Exception {
		assertTrue(comp.compare(c1, c3) < 0);
		assertTrue(comp.compare(c4, c2) < 0);
	}
	
	@Test
	public void testCardRankComparisonGreaterThan() throws Exception {
		assertTrue(comp.compare(c1, c4) > 0);
		assertTrue(comp.compare(c3, c2) > 0);
	}
	
	@Test
	public void testCardRankComparisonEqual() throws Exception {
		assertTrue(comp.compare(c1, c2) == 0);
		assertFalse(comp.compare(c2, c4) == 0);
	}
}
