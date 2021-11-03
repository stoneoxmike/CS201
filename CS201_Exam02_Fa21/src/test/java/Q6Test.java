import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Q6Test {
	private List<Card> flush;
	private List<Card> flush2;
	private List<Card> flush3;
	private List<Card> notFlush;
	private List<Card> notFlush2;
	private List<Card> notFlushEmpty;
	
	@Before
	public void setUp() {
		flush = new ArrayList<Card>();
		flush.add(new Card(Rank.FOUR, Suit.HEARTS));
		flush.add(new Card(Rank.SIX, Suit.HEARTS));
		flush.add(new Card(Rank.SEVEN, Suit.HEARTS));
		flush.add(new Card(Rank.THREE, Suit.HEARTS));
		flush.add(new Card(Rank.FIVE, Suit.HEARTS));
		
		flush2 = new ArrayList<Card>();
		flush2.add(new Card(Rank.KING, Suit.CLUBS));
		flush2.add(new Card(Rank.SIX, Suit.CLUBS));
		flush2.add(new Card(Rank.TEN, Suit.CLUBS));
		flush2.add(new Card(Rank.TWO, Suit.CLUBS));
		flush2.add(new Card(Rank.JACK, Suit.CLUBS));
		flush2.add(new Card(Rank.SEVEN, Suit.CLUBS));
		flush2.add(new Card(Rank.ACE, Suit.CLUBS));

		flush3 = new ArrayList<Card>();
		flush3.add(new Card(Rank.FOUR, Suit.DIAMONDS));
		flush3.add(new Card(Rank.SIX, Suit.DIAMONDS));
		flush3.add(new Card(Rank.SIX, Suit.DIAMONDS));
		flush3.add(new Card(Rank.SIX, Suit.DIAMONDS));
		flush3.add(new Card(Rank.FOUR, Suit.DIAMONDS));
		flush3.add(new Card(Rank.FOUR, Suit.DIAMONDS));
		
		notFlush = new ArrayList<Card>();
		notFlush.add(new Card(Rank.FOUR, Suit.HEARTS));
		notFlush.add(new Card(Rank.SIX, Suit.SPADES));
		notFlush.add(new Card(Rank.EIGHT, Suit.SPADES));
		notFlush.add(new Card(Rank.THREE, Suit.CLUBS));
		notFlush.add(new Card(Rank.JACK, Suit.DIAMONDS));

		notFlush2 = new ArrayList<Card>();
		notFlush2.add(new Card(Rank.FOUR, Suit.HEARTS));
		notFlush2.add(new Card(Rank.FOUR, Suit.HEARTS));
		notFlush2.add(new Card(Rank.FOUR, Suit.HEARTS));
		notFlush2.add(new Card(Rank.FOUR, Suit.HEARTS));
		notFlush2.add(new Card(Rank.FOUR, Suit.DIAMONDS));
		
		notFlushEmpty = new ArrayList<Card>();
	}
	
	@Test
	public void testFlush1() throws Exception {
		assertTrue(Q6.isFlush(flush));
	}
	
	@Test
	public void testFlush2() throws Exception {
		assertTrue(Q6.isFlush(flush2));
	}
	
	@Test
	public void testFlush3() throws Exception {
		assertTrue(Q6.isFlush(flush3));
	}

	@Test
	public void testNotFlush() throws Exception {
		assertFalse(Q6.isFlush(notFlush));
	}

	@Test
	public void testNotFlush2() throws Exception {
		assertFalse(Q6.isFlush(notFlush2));
	}
	
	@Test
	public void testNotFlushEmpty() throws Exception {
		assertFalse(Q6.isFlush(notFlushEmpty));
	}

}
