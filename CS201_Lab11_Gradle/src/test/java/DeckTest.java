import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DeckTest {
    // TODO - define test fixture objects
    Deck deck;
    Card card;
    Deck shuffle;

    @Before
    public void setUp() throws Exception {
        // TODO - create test fixture objects
        deck = new Deck();
        card = new Card(Suit.SPADES, Rank.ACE);
        shuffle = new Deck();
        shuffle.shuffle();
    }


    // TODO - add test methods
    @Test
    public void testGetNumCards() {
        assertEquals(52, deck.getNumCards());
    }

    @Test
    public void testDrawCard() {
        assertTrue(card.equals(deck.drawCard()));
    }

    @Test
    public void testShuffle() {
        assertNotEquals(deck, shuffle);
    }
}
