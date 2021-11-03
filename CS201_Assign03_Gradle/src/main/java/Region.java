public class Region {
	private final LocationType locationType;
	private final Pile pile;
	private final int pileIndex;
	private final int x;
	private final int y;
	private final int width;
	private final int height;
	private final boolean stacked;
	private final int gap;
	private final int cardHeight;
	
	// Constructor for non-stacked regions
	public Region(LocationType locationType, Pile pile, int pileIndex, int x, int y, int width, int height) {
		this(locationType, pile, pileIndex, x, y, width, height, false, 0, 0);
	}

	// Constructor for stacked regions (i.e., tableau piles)
	public Region(LocationType locationType, Pile pile, int pileIndex, int x, int y, int width, int height, int gap, int cardHeight) {
		this(locationType, pile, pileIndex, x, y, width, height, true, gap, cardHeight);
	}
	
	private Region(LocationType locationType, Pile pile, int pileIndex, int x, int y, int width, int height, boolean stacked, int gap, int cardHeight) {
		this.locationType = locationType;
		this.pile = pile;
		this.pileIndex = pileIndex;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.stacked = stacked;
		this.gap = gap;
		this.cardHeight = cardHeight;
	}
	
	public Location computeLocation(int x, int y) {
//		if (pile.isEmpty()) {
//			// No cards on pile
//			return null;
//		}
		if (x < this.x || x >= this.x+this.width || y < this.y || y >= this.y+this.height){
			// Click is not in this region
			return null;
		}
		if (!stacked || pile.isEmpty()) {
			// This is either:
			// - a non-stacked pile (such as the main deck or foundation pile), or
			// - a stacked pile (i.e., tableau pile) that is empty
			return new Location(locationType, pileIndex, pile.getIndexOfTopCard());
		} else {
			//System.out.println("Yarrgh...");
			int yoff = y - this.y;
			for (int i = 0; i < pile.getNumCards(); i++) {
				boolean hit = false;
				if (i != pile.getNumCards()-1) {
					// Card that is only partially shown (i.e., there's a card stacked on top of it)
					if (yoff >= i*gap && yoff < (i+1)*gap) {
						hit = true;
					}
				} else {
					// Top card on stack, which is shown completely
					if (yoff >= i*gap && yoff < i*gap+cardHeight) {
						hit = true;
					}
				}
				if (hit) {
					return new Location(locationType, pileIndex, i);
				}
			}
			return null;
		}
	}
}
