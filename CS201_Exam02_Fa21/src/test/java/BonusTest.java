import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BonusTest {
	private List<Card> notStraightButFlush;
	private List<Card> notFlushButStraight;
	private List<Card> straightFlush;
	
	@Before
	public void setUp() {
		notStraightButFlush = new ArrayList<Card>();
		notStraightButFlush.add(new Card(Rank.FOUR, Suit.HEARTS));
		notStraightButFlush.add(new Card(Rank.JACK, Suit.HEARTS));
		notStraightButFlush.add(new Card(Rank.SEVEN, Suit.HEARTS));
		notStraightButFlush.add(new Card(Rank.TWO, Suit.HEARTS));
		notStraightButFlush.add(new Card(Rank.FOUR, Suit.HEARTS));
		notStraightButFlush.add(new Card(Rank.TEN, Suit.HEARTS));
		
		notFlushButStraight = new ArrayList<Card>();
		notFlushButStraight.add(new Card(Rank.TWO, Suit.HEARTS));
		notFlushButStraight.add(new Card(Rank.FOUR, Suit.CLUBS));
		notFlushButStraight.add(new Card(Rank.SIX, Suit.DIAMONDS));
		notFlushButStraight.add(new Card(Rank.THREE, Suit.CLUBS));
		notFlushButStraight.add(new Card(Rank.FIVE, Suit.HEARTS));

	
		straightFlush = new ArrayList<Card>();
		straightFlush.add(new Card(Rank.KING, Suit.CLUBS));
		straightFlush.add(new Card(Rank.NINE, Suit.CLUBS));
		straightFlush.add(new Card(Rank.TEN, Suit.CLUBS));
		straightFlush.add(new Card(Rank.ACE, Suit.CLUBS));
		straightFlush.add(new Card(Rank.JACK, Suit.CLUBS));
		straightFlush.add(new Card(Rank.QUEEN, Suit.CLUBS));
	}
	
	@Test
	public void testNotStraightButFlush() throws Exception {
		assertFalse(Q6.isStraightFlush(notStraightButFlush));
	}
	
	@Test
	public void testNotFlushButStraight() throws Exception {
		assertFalse(Q6.isStraightFlush(notFlushButStraight));
	}
	

	@Test
	public void testStraightFlush() throws Exception {
		assertTrue(Q6.isStraightFlush(straightFlush));
	}
}
