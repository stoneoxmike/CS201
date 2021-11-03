import java.util.ArrayList;
import java.util.List;

/**
 * A Selection object represents one or more cards that
 * the user wants to move.  A {@link Location} indicates the
 * source of the moved cards (e.g., the main deck or a
 * tableau pile).  An ArrayList of {@link Card}s stores
 * references to the cards that the user wants to move.
 */
public class Selection {
	// TODO: add fields
	private Location origin;
	private ArrayList<Card> selected;
	/**
	 * Constructor.
	 * 
	 * @param origin   a {@link Location} describing the origin (source) of the moved cards
	 * @param selected an ArrayList containing the {@link Card}s the user wants to move
	 */
	public Selection(Location origin, ArrayList<Card> selected) {
		this.origin = origin;
		this.selected = selected;
	}

	/**
	 * @return the origin (source) {@link Location} which describes where the cards
	 *         are being moved from
	 */
	public Location getOrigin() {
		return origin;
	}

	/**
	 * @return the ArrayList of {@link Card}s the user wants to move
	 */
	public ArrayList<Card> getCards() {
		return selected;
	}

	/**
	 * @return the number of cards the user wants to move
	 */
	public int getNumCards() {
		return selected.size();
	}
}
