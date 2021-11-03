import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class KlondikeView extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/** Width of the window */
	private static final int WIDTH = 800;
	
	/** Height of window */
	private static final int HEIGHT = 600;
	
	/** Width of card images */
	private static final int CARD_WIDTH = 80;
	
	/** Height of card images */
	private static final int CARD_HEIGHT = 116;
	
	/** Offset of piles from left edge */
	private static final int LEFT_OFFSET = 30;
	
	/** Offset of top-row piles from top edge */
	private static final int TOP_OFFSET = 20;

	/** Offset of tableau piles from left edge */
	private static final int FOUNDATION_LEFT_OFFSET = 360;

	/** Offset of tableau piles from top edge */
	private static final int TABLEAU_TOP_OFFSET = 160;

	/** Spacing of piles horizontally */
	private static final int HORIZONTAL_PILE_SPACING = 110;

	/** Vertical spacing of cards in tableau piles */
	public static final int VERTICAL_CARD_SPACING = 24;

	private KlondikeModel model;
	private KlondikeController controller;
	
	private CardImageCollection cardImageCollection;
	// TODO: add other fields
	private int selectionX;
	private int selectionY;
	private Selection selection;

	public KlondikeView() {
		setBackground(new Color(0, 100, 0));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		cardImageCollection = new CardImageCollection();
		
		MouseAdapter listener = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				handleMousePressed(e);
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				handleMouseDragged(e);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				handleMouseReleased(e);
			}
		};
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}
	
	public void setModel(KlondikeModel model) {
		this.model = model;
	}
	
	public void setController(KlondikeController controller) {
		this.controller = controller;
	}
	
	protected void handleMousePressed(MouseEvent e) {
		// TODO: implement
		for (int i = 0; i < 7; i++) {
			if (e.getX() >= LEFT_OFFSET + (i * HORIZONTAL_PILE_SPACING) && e.getX() <= LEFT_OFFSET + (i * HORIZONTAL_PILE_SPACING) + CARD_WIDTH) {
				if (e.getY() >= TABLEAU_TOP_OFFSET && e.getY() <= TABLEAU_TOP_OFFSET + ((model.getTableauPile(i).getIndexOfTopCard()) * VERTICAL_CARD_SPACING) + CARD_HEIGHT) {
					int selectionIndex;
					if (e.getY() <= TABLEAU_TOP_OFFSET + ((model.getTableauPile(i).getNumCards() - 1) * VERTICAL_CARD_SPACING) + CARD_HEIGHT && e.getY() >= TABLEAU_TOP_OFFSET + ((model.getTableauPile(i).getNumCards() - 1) * VERTICAL_CARD_SPACING)) {
						selectionIndex = model.getTableauPile(i).getIndexOfTopCard();
						Location location = new Location(LocationType.TABLEAU_PILE, i, selectionIndex);
						selection = controller.select(model, location);
						selectionX = e.getX() - CARD_WIDTH / 2;
						selectionY = e.getY() - CARD_HEIGHT / 2;
					} else for (int j = model.getTableauPile(i).getIndexOfTopCard(); j >= model.getTableauPile(i).getExposeIndex(); j--) {
						if (e.getY() <= TABLEAU_TOP_OFFSET + ((model.getTableauPile(i).getNumCards() - 1) * VERTICAL_CARD_SPACING) && e.getY() >= TABLEAU_TOP_OFFSET + (j * VERTICAL_CARD_SPACING)) {
							selectionIndex = j;
							if (selectionIndex >= model.getTableauPile(i).getExposeIndex()) {
								Location location = new Location(LocationType.TABLEAU_PILE, i, selectionIndex);
								selection = controller.select(model, location);
								selectionX = e.getX() - CARD_WIDTH  / 2;
								selectionY = e.getY() - CARD_WIDTH / 2;
							}
						}
					}
				}
			}
		}
		if (e.getX() >= LEFT_OFFSET && e.getX() <= LEFT_OFFSET + CARD_WIDTH) {
			if (e.getY() >= TOP_OFFSET && e.getY() <= TOP_OFFSET + CARD_HEIGHT) {
				Location location = new Location(LocationType.MAIN_DECK, 0, model.getMainDeck().getIndexOfTopCard());
				if (!model.getMainDeck().isEmpty()) {
					selection = controller.select(model, location);
					selectionX = e.getX() - CARD_WIDTH / 2;
					selectionY = e.getY() - CARD_HEIGHT / 2;
				}
			}
		}
		if (e.getX() >= LEFT_OFFSET + HORIZONTAL_PILE_SPACING && e.getX() <= LEFT_OFFSET + CARD_WIDTH + HORIZONTAL_PILE_SPACING) {
			if (e.getY() >= TOP_OFFSET && e.getY() <= TOP_OFFSET + CARD_HEIGHT) {
				if (model.getMainDeck().isEmpty()) {
					controller.drawCardOrRecycleWaste(model);
				}
			}
		}
		repaint();
	}

	protected void handleMouseDragged(MouseEvent e) {
		// TODO: implement
		selectionX = e.getX() - CARD_WIDTH / 2;
		selectionY = e.getY() - CARD_HEIGHT / 2;
		repaint();
	}

	protected void handleMouseReleased(MouseEvent e) {
		// TODO: implement
		if (selection != null) {
			for (int i = 0; i < 7; i++) {
				if (e.getX() >= LEFT_OFFSET + (i * HORIZONTAL_PILE_SPACING) && e.getX() <= LEFT_OFFSET + (i * HORIZONTAL_PILE_SPACING) + CARD_WIDTH) {
					if (e.getY() >= TABLEAU_TOP_OFFSET && e.getY() <= TABLEAU_TOP_OFFSET + ((model.getTableauPile(i).getIndexOfTopCard()) * VERTICAL_CARD_SPACING) + CARD_HEIGHT) {
						Location location = new Location(LocationType.TABLEAU_PILE, i, model.getTableauPile(i).getIndexOfTopCard());
						if (controller.allowMove(model, selection, location)) {
							controller.moveCards(model, selection, location);
							selection = null;
						}
					}
				}
			}
			for (int i = 0; i < 4; i++) {
				if (e.getX() >= FOUNDATION_LEFT_OFFSET + (i * HORIZONTAL_PILE_SPACING) && e.getX() <= FOUNDATION_LEFT_OFFSET + (i * HORIZONTAL_PILE_SPACING) + CARD_WIDTH) {
					if (e.getY() >= TOP_OFFSET && e.getY() <= TOP_OFFSET + CARD_HEIGHT) {
						Location location = new Location(LocationType.FOUNDATION_PILE, i, 0);
						if (controller.allowMove(model, selection, location)) {
							controller.moveCards(model, selection, location);
							selection = null;
						}
					}
				}
			}
		}
		if (selection != null) {
			if (e.getX() >= LEFT_OFFSET + HORIZONTAL_PILE_SPACING && e.getX() <= LEFT_OFFSET + CARD_WIDTH + HORIZONTAL_PILE_SPACING) {
				if (e.getY() >= TOP_OFFSET && e.getY() <= TOP_OFFSET + CARD_HEIGHT) {
					if (selection.getOrigin().getLocationType().equals(LocationType.MAIN_DECK)) {
						controller.unselect(model, selection);
						controller.drawCardOrRecycleWaste(model);
						selection = null;
					}
				}
			}
		}
		if (selection != null) {
			controller.unselect(model, selection);
			selection = null;
		}
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// Paint background
		super.paintComponent(g);
		
		// Paint main deck (showing top card)
		drawPile(g, LEFT_OFFSET, TOP_OFFSET, model.getMainDeck());
		
		// Paint waste pile
		// System.out.printf("Waste pile expose index=%d\n", model.getWastePile().getExposeIndex());
		drawPile(g, LEFT_OFFSET + HORIZONTAL_PILE_SPACING, TOP_OFFSET, model.getWastePile());
		
		// Paint foundation piles (showing top card)
		for (int i = 0; i < 4; i++) {
			drawPile(g, FOUNDATION_LEFT_OFFSET + i*HORIZONTAL_PILE_SPACING, TOP_OFFSET, model.getFoundationPile(i));
		}
		
		// Paint tableau piles
		for (int i = 0; i < 7; i++) {
			drawTableauPile(g, LEFT_OFFSET + i*HORIZONTAL_PILE_SPACING, TABLEAU_TOP_OFFSET, model.getTableauPile(i));
		}
		
		// TODO: draw selection (if there is one)
		if (selection != null) {
			drawSelection(g, selectionX, selectionY, selection);
		}

		// TODO: draw congratulatory message if player has won the game
		if (controller.isWin(model)) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Dialog", Font.BOLD, 24));
			g.drawString("CONGRATULATIONS!!", (WIDTH / 2) - 100, HEIGHT / 2);
		}
	}

	private void drawPile(Graphics g, int x, int y, Pile pile) {
		if (pile.isEmpty()) {
			// Draw outline
			g.setColor(Color.LIGHT_GRAY);
			g.drawRoundRect(x, y, CARD_WIDTH, CARD_HEIGHT, 12, 12);
		} else {
			// Draw image of top card (or card back image if top card is not exposed)
			Card top = pile.getTopCard();
			int indexOfTopCard = pile.getIndexOfTopCard();
			int exposeIndex = pile.getExposeIndex();
			//System.out.printf("topcard=%d,expose=%d\n", indexOfTopCard, exposeIndex);
			boolean isExposed = indexOfTopCard >= exposeIndex;
			BufferedImage img = isExposed ? cardImageCollection.getFrontImage(top) : cardImageCollection.getBackImage();
			g.drawImage(img, x, y, null);
		}
	}

	private void drawTableauPile(Graphics g, int x, int y, Pile tableauPile) {
		// Draw cards from bottom of pile towards top.
		// All cards whose indices are greater than or equal to
		// the pile's expose index are drawn face-up.
		int numCards = tableauPile.getNumCards();
		for (int i = 0; i < numCards; i++) {
			Card card = tableauPile.getCard(i);
			BufferedImage img = i >= tableauPile.getExposeIndex()
					? cardImageCollection.getFrontImage(card)
					: cardImageCollection.getBackImage();
			g.drawImage(img, x, y + i*VERTICAL_CARD_SPACING, null);
		}
	}

	private void drawSelection(Graphics g, int x, int y, Selection selection) {
		// Draw image of top card (or card back image if top card is not exposed)
		Card top = selection.getCards().get(0);
		int numCards = selection.getNumCards();
		int exposeIndex = 0;
		//System.out.printf("topcard=%d,expose=%d\n", indexOfTopCard, exposeIndex);
		for (int i = 0; i < numCards; i++) {
			Card card = selection.getCards().get(i);
			BufferedImage img = i >= exposeIndex
					? cardImageCollection.getFrontImage(card)
					: cardImageCollection.getBackImage();
			g.drawImage(img, x, y + i*VERTICAL_CARD_SPACING, null);
		}
	}
}
