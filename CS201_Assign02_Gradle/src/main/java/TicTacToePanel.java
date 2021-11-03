import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class TicTacToePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;
	private static final Font FONT = new Font("Dialog", Font.BOLD, 24);
	
	// TODO: Add fields for model, controller, and end game flags
	TicTacToeModel model;
	TicTacToeController controller;
	private boolean gameOver;
	
	// constructor
	public TicTacToePanel() {
		// TODO: Initialize fields
		model = new TicTacToeModel();
		controller = new TicTacToeController();
		gameOver = false;

		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.BLACK);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { handleMouseClick(e); }
		});
		
		// Register event handlers (DO NOT CHANGE)
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) { handleKeyTyped(e); }

			@Override
			public void keyReleased(KeyEvent e) {}
			
		});
	}
	
	private void handleMouseClick(MouseEvent e) {
		// TODO: Player attempting to place marker on the board
		int x = 0;
		int y = 0;
		if (!gameOver) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				// assign row and column based on range of x and y coordinates of mouse
				x = e.getX() / 100;
				y = e.getY() / 100;
				// checks if move can be made, and if it can checks for draw and win after making move
				if (!controller.makeMove(model, TicTacToeModel.PLAYER_X, x, y)) {
					System.out.println("Invalid Move");
				} else {
					if (controller.checkDraw(model) || controller.checkWin(model)) {
						gameOver = true;
					} else {
						controller.changePlayer(model);
					}
				}
			} else if (e.getButton() == MouseEvent.BUTTON3) {
				// assign row and column based on range of x and y coordinates of mouse
				x = e.getX() / 100;
				y = e.getY() / 100;
				// checks if move can be made, and if it can checks for draw and win after making move
				if (!controller.makeMove(model, TicTacToeModel.PLAYER_O, x, y)) {
					System.out.println("Invalid Move");
				} else {
					if (controller.checkDraw(model) || controller.checkWin(model)) {
						gameOver = true;
					} else {
						controller.changePlayer(model);
					}
				}
			}
		}
		repaint();
	}
	
	private void handleKeyTyped(KeyEvent e) {
		// TODO: Save for 's' and load for 'l'
		if (e.getKeyChar() == 'l') {
			// sets the model reference to a new BLANK model object, then updates the new object with the load file
			// this may not be the most efficient since there is the leftover old model object every time this runs, but it was the best solution I could find for the moment
			model = new TicTacToeModel();
			controller.readBoard(model);
		} else if (e.getKeyChar() == 's') {
			controller.writeBoard(model);
		}
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g); // paint background

		// Draw the tic-tac-toe board (DO NOT MODIFY)
		g.setColor(Color.WHITE);
		for (int i = 1; i < 4; i++) {
			// Vertical line
			g.drawLine(i*(WIDTH/3), 0, i*(WIDTH/3), HEIGHT-1);
			// Horizontal line
			g.drawLine(0, i*(HEIGHT/3), WIDTH-1, i*(HEIGHT/3));
		}
		
		// TODO: Draw markers
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (model.getCell(i, j) == TicTacToeModel.PLAYER_X) {
					int rectX = (i * 100) + 5;
					int rectY = (j * 100) + 5;
					int length = 90;
					g.setColor(Color.green);
					g.fillRect(rectX, rectY, length, length);
				} else if (model.getCell(i, j) == TicTacToeModel.PLAYER_O) {
					int ovalX = (i * 100) + 5;
					int ovalY = (j * 100) + 5;
					int radius = 45;
					g.setColor(Color.blue);
					g.fillOval(ovalX, ovalY, 2*radius, 2*radius);
				}
			}
		}

		// TODO: Draw end game messages if necessary		
		if (gameOver) {
			g.setFont(FONT);
			g.setColor(Color.YELLOW);
			if (controller.checkDraw(model)) {
				g.drawString("GAME OVER!", 5, 150);
				g.drawString("It's a draw", 5, 170);
			} else if (controller.checkWin(model)) {
				if (model.getTurn() == TicTacToeModel.PLAYER_X) {
					g.drawString("GAME OVER!", 5, 150);
					g.drawString("Player X Wins", 5, 170);
				} else if (model.getTurn() == TicTacToeModel.PLAYER_O) {
					g.drawString("GAME OVER!", 5, 150);
					g.drawString("Player O Wins", 5, 170);
				}
			}
		}
	}
}
