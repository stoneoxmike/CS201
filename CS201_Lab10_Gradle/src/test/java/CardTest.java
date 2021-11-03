import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CardTest {
	// TODO - define test fixture objects
	Card card1;
	Card card2;
	Card card3;
	Card card4;
	Card card5;
	Card[] cards = new Card[5];

	@Before
	public void setUp() throws Exception {
		// TODO - create test fixture objects
		card1 = new Card(Suit.DIAMONDS, Rank.QUEEN);
		card2 = new Card(Suit.CLUBS, Rank.ACE);
		card3 = new Card(Suit.HEARTS, Rank.TWO);
		card4 = new Card(Suit.SPADES, Rank.THREE);
		card5 = new Card(Suit.DIAMONDS, Rank.KING);
		cards[0] = card1;
		cards[1] = card2;
		cards[2] = card3;
		cards[3] = card4;
		cards[4] = card5;
	}


	// TODO - add test methods
	@Test
	public void testGetSuit() {
		// TODO: test calling getSuit() on your Card objects
		assertEquals(Suit.DIAMONDS, card1.getSuit());
		assertEquals(Suit.CLUBS, card2.getSuit());
		assertEquals(Suit.HEARTS, card3.getSuit());
		assertEquals(Suit.SPADES, card4.getSuit());
		assertEquals(Suit.DIAMONDS, card5.getSuit());
	}

	@Test
	public void testGetRank() {
		// TODO: test calling getRank() on your Card objects
		assertEquals(Rank.QUEEN, card1.getRank());
		assertEquals(Rank.ACE, card2.getRank());
		assertEquals(Rank.TWO, card3.getRank());
		assertEquals(Rank.THREE, card4.getRank());
		assertEquals(Rank.KING, card5.getRank());
	}

	@Test
	public void testCompareTo() {
		assertEquals(card1.compareTo(card2), Suit.DIAMONDS.compareTo(Suit.CLUBS));
		assertEquals(card4.compareTo(card5), Suit.SPADES.compareTo(Suit.DIAMONDS));
		assertEquals(card1.compareTo(card5), Rank.QUEEN.compareTo(Rank.KING));
	}

	@Test
	public void testSort() {
		Arrays.sort(cards);
		assertEquals(card2, cards[0]);
		assertEquals(card4, cards[4]);
	}
}
