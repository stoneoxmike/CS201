import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayListApp {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// Create ArrayList of Strings rather than generic Objects
		ArrayList<String> names = new ArrayList<String>();
		
		System.out.println("Type some names:");
		while(true) {
    		String name = reader.readLine();
    		if (name.equals("")) {
        		break;
    		}
    		names.add(name);
		}
		// INVALID! Card is not a String
		// names.add(new Card(Suit.DIAMONDS, Rank.QUEEN));
		
		
		int count = countStringsContaining(names, 'J') +
    				countStringsContaining(names, 'j');

		System.out.println("You entered "+ count + " names containing J");
		
		// Can create an ArrayList of Cards and add Card objects
		ArrayList<Card> deck = new ArrayList<Card>();
		deck.add(new Card(Suit.DIAMONDS, Rank.QUEEN));
		deck.add(new Card(Suit.SPADES, Rank.TWO));

		// INVALID! countStringsContaining only takes ArrayList of Strings
		// Card is not a String
		//int count2 = countStringsContaining(deck, 'J'); // (!)
	}

	// Method only accepts ArrayList of Strings
	public static int countStringsContaining(ArrayList<String> strings, char ch) {
    	int count = 0;

    	for (int i = 0; i < strings.size(); i++) {
    		// No need for instanceof check or typecast
    		// since objects in ArrayList are guaranteed to be
    		// String
    		String s = strings.get(i);
    		if (s.indexOf(ch) >= 0) {
    			count++;
    		}
    	}

    	return count;
	}
}