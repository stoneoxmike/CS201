import java.util.ArrayList;
import java.util.Collections;

/**
 * The controller class implements all of the logic required to
 * play a game of Klondike.  All of the data is represented
 * in a {@link KlondikeModel} object, and each controller method
 * takes a reference to the model object as a parameter. 
 */
public class KlondikeController {
	/**
	 * Initialize the model object.
	 * 1. Should populate and shuffle the main deck
	 * 2. deal cards from the main deck onto the seven tableau piles
	 * 3. It should set the expose index of each tableau pile
	 *    so that only the top card is exposed.
	 * 4. It should set the expose index of the main deck so that
	 *    only the top card is exposed.
	 * 5. It should set the expose index of the waste pile so that
	 *    no cards can ever be exposed (i.e., set it to a high value,
	 *    such that even if it contains all 52 cards, none of them
	 *    would be exposed).
	 * 6. It should set the expose index of each foundation pile to 0.
	 * 
	 * @param model the {@link KlondikeModel} object to initialize
	 */
	public void initModel(KlondikeModel model) {
		// 1.
		model.getMainDeck().populate();
		model.getMainDeck().shuffle();
		// 2.
		for (int j = 0; j < 7; j++) {
			for (int i = 0; i <= j; i++) {
				model.getTableauPile(j).addCard(model.getMainDeck().drawCard());
			}
		}
		// 3.
		for (int i = 0; i < 7; i++) {
			model.getTableauPile(i).setExposeIndex(model.getTableauPile(i).getIndexOfTopCard());
		}
		// 4.
		model.getMainDeck().setExposeIndex(model.getMainDeck().getIndexOfTopCard());
		// 5.
		model.getWastePile().setExposeIndex(100);
		// 6.
		for (int i = 0; i < 4; i++) {
			model.getFoundationPile(i).setExposeIndex(0);
		}
	}

	/**
	 * <p>Attempt to create a {@link Selection} that represents one
	 * or more {@link Card}s to be moved from a pile
	 * indicated by a {@link Location}.  The {@link Location} specifies
	 * which pile to move cards from, and which card or cards
	 * within the pile should be moved. If the move is legal, 
	 * the indicated cards should be removed from the source pile
	 * (as indicated by the {@link Location}),
	 * and transfered into the {@link Selection} object returned from
	 * the method.</p>
	 *
	 * <p>Legal moves include: </p>
	 * <ol>
	 *   <li>If the {@link Location} has {@link LocationType#MAIN_DECK} as
	 *       its location type, 
	 *          Then if the main deck is non-empty AND
	 *          the selected card is the top card on the main deck,
	 *          remove the top card from the main deck (1 card) for the selection.
	 *   </li>
	 * 
	 *   <li>If the {@link Location} has {@link LocationType#TABLEAU_PILE}
	 *       as its location type,
	 *          Then if the {@link Location}'s card index refers to a valid card
	 *          (less than or equal to the tableau's top card index) AND
	 *          the card index is greater than or equal to the tableau pile's expose index,
	 *          remove the cards from the card index to the top of the tableau for the selection.
	 *   </li>
	 * 
	 *   <li>If the {@link Location}'s location type is {@link LocationType#WASTE_PILE} OR
	 *       {@link LocationType#FOUNDATION_PILE},
	 *          Then the move is invalid so the selection should be set to <code>null</code>.
	 *    </li>
	 * </ol>
	 * <p>If the move is not legal, return <code>null</code></p>
	 * 
	 * @param model   the {@link KlondikeModel}
	 * @param location the {@link Location} specifying which card or cards to move
	 * @return a {@link Selection} containing the cards to move and the
	 *         {@link Location}, or null if the {@link Location} does not
	 *         indicate a legal location from which cards can be moved
	 */
	public Selection select(KlondikeModel model, Location location) {
		if (location.getLocationType().equals(LocationType.MAIN_DECK)) {
			if (!model.getMainDeck().isEmpty() && location.getCardIndex() == model.getMainDeck().getIndexOfTopCard()) {
				return new Selection(location, model.getMainDeck().removeCards(1));
			}
		} else if (location.getLocationType().equals(LocationType.TABLEAU_PILE)) {
			if (location.getCardIndex() <= model.getTableauPile(location.getPileIndex()).getIndexOfTopCard() && location.getCardIndex() >= model.getTableauPile(location.getPileIndex()).getExposeIndex()) {
				return new Selection(location, model.getTableauPile(location.getPileIndex()).removeCards(model.getTableauPile(location.getPileIndex()).getNumCards() - location.getCardIndex()));
			}
		} else if (location.getLocationType().equals(LocationType.FOUNDATION_PILE) || location.getLocationType().equals(LocationType.WASTE_PILE)) {
			return null;
		}
		return null;
	}

	/**
	 * "Undo" a selection by moving cards from a {@link Selection} object
	 * back to the pile they were taken from, as indicated by the
	 * selection's origin {@link Location}.  For example, if the location
	 * indicates that the selection's cards were taken from a tableau
	 * pile, then they should be moved back to that tableau pile.
	 * 
	 * @param model      the {@link KlondikeModel}
	 * @param selection  the {@link Selection} to undo
	 */
	public void unselect(KlondikeModel model, Selection selection) {
		if (selection.getOrigin().getLocationType().equals(LocationType.TABLEAU_PILE)) {
			model.getTableauPile(selection.getOrigin().getPileIndex()).addCards(selection.getCards());
		} else if (selection.getOrigin().getLocationType().equals(LocationType.MAIN_DECK)) {
			model.getMainDeck().addCards(selection.getCards());
		} else if (selection.getOrigin().getLocationType().equals(LocationType.WASTE_PILE)) {
			model.getWastePile().addCards(selection.getCards());
		} else if (selection.getOrigin().getLocationType().equals(LocationType.FOUNDATION_PILE)) {
			model.getFoundationPile(selection.getOrigin().getPileIndex()).addCards(selection.getCards());
		}
	}

	/**
	 * <p>Determine whether it is legal to move the current {@link Selection} to a
	 * destination pile indicated by a {@link Location}. Illegal moves include:</p>
	 * <ol>
	 *   <li>If the destination {@link Location} has {@link LocationType#FOUNDATION_PILE}
	 *       as its {@link LocationType}, 
	 *       <ol type="a">
	 *         <li>If the {@link Selection} does not contain a single card.</li>
	 *         <li>If the foundation pile is empty AND the selected card is not an {@link Rank#ACE}.</li>
	 *         <li>If the foundation pile is not empty, AND the selected card has a different suit
	 *             as the top card on the foundation pile OR the ordinal value of its {@link Rank} is not
	 *             one greater than the top card on the foundation pile.</li>
	 *       </ol>
	 *   </li>
	 *   <li>If the destination {@link Location} has {@link LocationType#TABLEAU_PILE}
	 *       as its {@link LocationType}:
	 *       <ol type="a">
	 *         <li>If the destination tableau pile is empty AND the bottom card of the {@link Selection}
	 *             is not {@link Rank#KING} </li>
	 *         <li>If the destination tableau pile is not empty, AND the bottom card of the {@link Selection}
	 *             has a {@link Suit} that is the same {@link Color} as the top card of the
	 *             tableau pile OR the bottom card of the {@link Selection} has a
	 *             {@link Rank} whose ordinal value is not one less than the ordinal value of the
	 *             top card of the tableau pile.</li>
	 *      </ol>
	 *    </li>
	 *    <li>If the destination {@link Location} has {@link LocationType#MAIN_DECK} or
	 *        {@link LocationType#WASTE_PILE} as its {@link LocationType}
	 *        <ol type="a">
	 *          <li> The move is illegal.</li>
	 *     </li>
	 * </ol>
	 * 
	 * <p>
	 * Note that this method just checks to see whether or not a move would
	 * be legal: it does not move any cards.
	 * </p>
	 * 
	 * @param model      the {@link KlondikeModel}
	 * @param selection  the {@link Selection}
	 * @param dest       the destination {@link Location}
	 * @return true if the move is legal, false if the move is illegal
	 */
	public boolean allowMove(KlondikeModel model, Selection selection, Location dest) {
		 if (dest.getLocationType().equals(LocationType.FOUNDATION_PILE)) {
			 if (selection.getNumCards() != 1) {
				 return false;
			 } else if (model.getFoundationPile(dest.getPileIndex()).isEmpty() && !selection.getCards().get(0).getRank().equals(Rank.ACE)) {
				 return false;
			 } else if (!model.getFoundationPile(dest.getPileIndex()).isEmpty()) {
				 if (model.getFoundationPile(dest.getPileIndex()).getTopCard().getSuit() != selection.getCards().get(0).getSuit() || selection.getCards().get(0).getRank().ordinal() != model.getFoundationPile(dest.getPileIndex()).getTopCard().getRank().ordinal() + 1) {
					 return false;
				 } else {
					 return true;
				 }
			 } else {
				 return true;
			 }
		 } else if (dest.getLocationType().equals(LocationType.TABLEAU_PILE)) {
			if (model.getTableauPile(dest.getPileIndex()).isEmpty() && !selection.getCards().get(0).getRank().equals(Rank.KING)) {
				return false;
			} else if (!model.getTableauPile(dest.getPileIndex()).isEmpty()) {
				if (selection.getCards().get(0).getSuit().getColor().equals(model.getTableauPile(dest.getPileIndex()).getTopCard().getSuit().getColor()) || selection.getCards().get(0).getRank().ordinal() != model.getTableauPile(dest.getPileIndex()).getTopCard().getRank().ordinal() - 1) {
					return false;
				} else {
					return true;
				}
			} else {
				return true;
			}
		 } else if (dest.getLocationType().equals(LocationType.MAIN_DECK) || dest.getLocationType().equals(LocationType.WASTE_PILE)) {
			return false;
		 } else {
			 return true;
		 }
	}

	/**
	 * <p>Move the cards in a {@link Selection} onto a pile as indicated
	 * by the destination {@link Location}.</p>
	 * 
	 * <p>The method does <em>not</em> need to check whether or not the move is legal:
	 * it can assume that the {@link #allowMove(KlondikeModel, Selection, Location)}
	 * method has already determined that the move is legal.</p>
	 * 
	 * <p>
	 * <strong>Important</strong>: If the pile that the selected cards
	 * were taken from is non-empty, and if its top card is not exposed,
	 * then its top card should be exposed.
	 * </p>
	 * 
	 * <p>
	 * Note that the expose index of the destination pile should not change.
	 * </p>
	 * 
	 * @param model      the {@link KlondikeModel} 
	 * @param selection  the {@link Selection} containing the selected cards
	 * @param dest       the destination {@link Location}
	 */
	public void moveCards(KlondikeModel model, Selection selection, Location dest) {
		if (dest.getLocationType().equals(LocationType.FOUNDATION_PILE)) {
			model.getFoundationPile(dest.getPileIndex()).addCards(selection.getCards());
		} else if (dest.getLocationType().equals(LocationType.TABLEAU_PILE)) {
			model.getTableauPile(dest.getPileIndex()).addCards(selection.getCards());
		}
		if (selection.getOrigin().getLocationType().equals(LocationType.TABLEAU_PILE)) {
			if (model.getTableauPile(selection.getOrigin().getPileIndex()).getExposeIndex() - 1 == model.getTableauPile(selection.getOrigin().getPileIndex()).getIndexOfTopCard()) {
				model.getTableauPile(selection.getOrigin().getPileIndex()).setExposeIndex(model.getTableauPile(selection.getOrigin().getPileIndex()).getExposeIndex() - 1);
			}
		} else if (selection.getOrigin().getLocationType().equals(LocationType.MAIN_DECK)) {
			model.getMainDeck().setExposeIndex(model.getMainDeck().getExposeIndex() - 1);
		}
	}

	/**
	 * <p>If the main deck is not empty, then remove the top card from the main deck
	 * and add it to the waste pile.  If the main deck is empty, then all cards
	 * should be moved from the waste pile back to the main deck.</p>
	 *
	 * <p>Note: when the waste pile is recycled, it should move cards
	 * back to the main deck such that they are in the same order in which
	 * they originally occurred.  In other words, drawing all of the cards
	 * from the main deck and then moving them back to the main deck
	 * should result in the main deck being in its original order.</p>
	 *
	 * <p>Before this method returns, it should check whether the
	 * main deck is non-empty, and if it is non-empty, it should ensure
	 * that the top card on the main deck is exposed.</p>
	 *
	 * @param model the {@link KlondikeModel}
	 */
	public void drawCardOrRecycleWaste(KlondikeModel model) {
		if (!model.getMainDeck().isEmpty()) {
			model.getWastePile().addCard(model.getMainDeck().drawCard());
		} else {
			int startingSize = model.getWastePile().getNumCards();
			for (int i = 0; i < startingSize; i++) {
				model.getMainDeck().addCard(model.getWastePile().drawCard());
			}
		}
		if (!model.getMainDeck().isEmpty()) {
			model.getMainDeck().setExposeIndex(model.getMainDeck().getIndexOfTopCard());
		}
	}

	/**
	 * Determine if the player has won the game.
	 *
	 * @param model the {@link KlondikeModel}
	 * @return true if each foundation pile has 13 cards, false otherwise
	 */
	public boolean isWin(KlondikeModel model) {
		boolean win1 = false;
		boolean win2 = false;
		boolean win3 = false;
		boolean win4 = false;
		if (model.getFoundationPile(0).getNumCards() == 13) {
			win1 = true;
		}
		if (model.getFoundationPile(1).getNumCards() == 13) {
			win2 = true;
		}
		if (model.getFoundationPile(2).getNumCards() == 13) {
			win3 = true;
		}
		if (model.getFoundationPile(3).getNumCards() == 13) {
			win4 = true;
		}
		return win1 && win2 && win3 && win4;
	}
}
