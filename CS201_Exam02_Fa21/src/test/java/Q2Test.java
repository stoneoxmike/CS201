import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Q2Test {
	private Integer[] intsDecreasing;
	private Integer[] intsNotDecreasing;	
	private Integer[] intsNotDecreasing2;
	private String[] strsDecreasing;
	private String[] strsNotDecreasing;
	private Card[] cardsDecreasing;
	private Card[] cardsNotDecreasing;
	
	@Before
	public void setUp() {
		intsDecreasing = new Integer[5];
		intsNotDecreasing = new Integer[5];
		intsNotDecreasing2 = new Integer[5];
		intsDecreasing[0] = 13;
		intsDecreasing[1] = 8;
		intsDecreasing[2] = 6;
		intsDecreasing[3] = 3;
		intsDecreasing[4] = 1;
		
		intsNotDecreasing[0] = 1;
		intsNotDecreasing[1] = 5;
		intsNotDecreasing[2] = 3;
		intsNotDecreasing[3] = 4;
		intsNotDecreasing[4] = 6;

		intsNotDecreasing2[0] = 6;
		intsNotDecreasing2[1] = 5;
		intsNotDecreasing2[2] = 5;
		intsNotDecreasing2[3] = 4;
		intsNotDecreasing2[4] = 3;
		
		strsDecreasing = new String[4];
		strsNotDecreasing = new String[4];
		
		strsDecreasing[0] = "Not";
		strsDecreasing[1] = "Me";
		strsDecreasing[2] = "Is to";
		strsDecreasing[3] = "I am";
		
		strsNotDecreasing[0] = "this";
		strsNotDecreasing[1] = "Is";
		strsNotDecreasing[2] = "too";
		strsNotDecreasing[3] = "Easy";
		
		cardsDecreasing = new Card[3];
		cardsNotDecreasing = new Card[5];
		cardsDecreasing[0] = new Card(Rank.JACK, Suit.SPADES);
		cardsDecreasing[1] = new Card(Rank.JACK, Suit.HEARTS);
		cardsDecreasing[2] = new Card(Rank.TWO, Suit.SPADES);
		cardsNotDecreasing[0] = new Card(Rank.JACK, Suit.SPADES);
		cardsNotDecreasing[1] = new Card(Rank.JACK, Suit.SPADES);
		cardsNotDecreasing[2] = new Card(Rank.TWO, Suit.CLUBS);
		cardsNotDecreasing[3] = new Card(Rank.SIX, Suit.DIAMONDS);
		cardsNotDecreasing[4] = new Card(Rank.QUEEN, Suit.HEARTS);
		
	}
	
	@Test
	public void testIntsDecreasing() throws Exception {
		assertTrue(Q2.isDecreasing(intsDecreasing));
	}

	@Test	
	public void testIntsNotDecreasing() throws Exception {
		assertFalse(Q2.isDecreasing(intsNotDecreasing));
		assertFalse(Q2.isDecreasing(intsNotDecreasing2));
	}

	@Test
	public void testStrsDecreasing() throws Exception {
		assertTrue(Q2.isDecreasing(strsDecreasing));
	}

	@Test	
	public void testStrsNotDecreasing() throws Exception {
		assertFalse(Q2.isDecreasing(strsNotDecreasing));
	}
	
	@Test
	public void testCardsDecreasing() throws Exception {
		assertTrue(Q2.isDecreasing(cardsDecreasing));
	}

}
