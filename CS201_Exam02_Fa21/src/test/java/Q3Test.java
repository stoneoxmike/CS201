import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Q3Test {
	private List<Integer> ints;
	private List<Card> cards;
	private List<Foo> empty;
	private Card c1, c2, c3, c4, c5, c6;
	
	@Before
	public void setUp() {
		ints = new ArrayList<Integer>();
		ints.add(1);
		ints.add(2);
		ints.add(3);
		ints.add(4);
		ints.add(5);
		ints.add(6);
		ints.add(7);
		cards = new ArrayList<Card>();
		c1 = new Card(Rank.FOUR, Suit.CLUBS);
		c2 = new Card(Rank.SIX, Suit.SPADES);
		c3 = new Card(Rank.EIGHT, Suit.SPADES);
		c4 = new Card(Rank.THREE, Suit.HEARTS);
		c5 = new Card(Rank.JACK, Suit.DIAMONDS);
		c6 = new Card(Rank.FIVE, Suit.CLUBS);
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
		cards.add(c6);
		
		empty = new ArrayList<Foo>();
	}
	
	@Test
	public void testChopNInt2Size() throws Exception {
		List<Integer> result = Q3.chopN(ints,2);
		assertEquals(3, result.size());
		assertEquals(4, ints.size());
	}
	
	@Test
	public void testChopNInt2Values() throws Exception {
		List<Integer> result = Q3.chopN(ints, 2);
		assertEquals((Integer) 2, result.get(0));
		assertEquals((Integer) 4, result.get(1));
		assertEquals((Integer) 6, result.get(2));
		assertEquals((Integer) 1, ints.get(0));
		assertEquals((Integer) 3, ints.get(1));
		assertEquals((Integer) 5, ints.get(2));
		assertEquals((Integer) 7, ints.get(3));
	}

	@Test
	public void testSplitCard2Size() throws Exception {
		List<Card> result = Q3.chopN(cards, 2);
		assertEquals(3, result.size());
		assertEquals(3, cards.size());
	}

	@Test
	public void testSplitCard2Values() throws Exception {
		List<Card> result = Q3.chopN(cards,2);
		assertEquals(c2, result.get(0));
		assertEquals(c4, result.get(1));
		assertEquals(c6, result.get(2));
		assertEquals(c1, cards.get(0));
		assertEquals(c3, cards.get(1));
		assertEquals(c5, cards.get(2));
	}

	@Test
	public void testSplitEmptyFoo() throws Exception {
		List<Foo> result = Q3.chopN(empty, 2);
		assertEquals(0, result.size());
		assertEquals(0, empty.size());
	}

	@Test
	public void testChopNInt3Size() throws Exception {
		List<Integer> result = Q3.chopN(ints,3);
		assertEquals(2, result.size());
		assertEquals(5, ints.size());
	}

	@Test
	public void testChopNInt3Values() throws Exception {
		List<Integer> result = Q3.chopN(ints, 3);
		assertEquals((Integer) 3, result.get(0));
		assertEquals((Integer) 6, result.get(1));
		assertEquals((Integer) 1, ints.get(0));
		assertEquals((Integer) 2, ints.get(1));
		assertEquals((Integer) 4, ints.get(2));
		assertEquals((Integer) 5, ints.get(3));
		assertEquals((Integer) 7, ints.get(4));
	}

}
