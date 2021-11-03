import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<Card>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                Card card = new Card(Suit.values()[i], Rank.values()[j]);
                deck.add(card);
            }
        }
    }

    public int getNumCards() {
        return deck.size();
    }

    public Card getCard(int i) {
        return deck.get(i - 1);
    }

    public Card drawCard() {
        return deck.remove(51);
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }
}
