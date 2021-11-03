import java.io.*;

/**
 * An instance of the TicTacToeController class represents
 * a controller to update the state of a tic-tac-toe game
 */
public class TicTacToeController {
	public static final String PATH = "CS201_Assign02_Gradle/";
	public static final String saveGame = "saveGame.txt";
	/**
	 * Check if the current attempted move is legal and
	 * if so, place the current player's piece.
	 * A move is legal if the row and column are both in the
	 * range 0-2, the board is currently empty at that cell,
	 * and it is the player's turn.
	 *
	 * @param model the current game model
	 * @param player the player attempting to place a marker
	 * @param row the row index where the marker is being placed
	 * @param col the column index where the marker is being placed
	 * @return true if the move is legal, false if it is not
	 */
	public boolean makeMove(TicTacToeModel model, int player, int row, int col) {
		if (0 <= row && row <= 2 && 0 <= col && col <= 2) {
			if (model.getCell(row, col) == TicTacToeModel.EMPTY && model.getTurn() == player) {
				model.placeMarker(row, col);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * Check if the current move results in a winning
	 * configuration. A winning configuration has three
	 * consecutive markers for the current player
	 * either in a row, column, or diagonal on the board
	 *
	 * @param model the current game model
	 * @return true if the current player wins, false if not
	 */
	public boolean checkWin(TicTacToeModel model) {
		for (int i = 0; i < 3; i++) {
			// check each row for 3 in a row
			if (model.getCell(i, 0) == model.getTurn() && model.getCell(i, 1) == model.getTurn() && model.getCell(i, 2) == model.getTurn()) {
				return true;
			// check each column for 3 in a row
			} else if (model.getCell(0, i) == model.getTurn() && model.getCell(1, i) == model.getTurn() && model.getCell(2, i) == model.getTurn()) {
				return true;
			}
		}
		// check left to right diagonal for 3 in a row
		if (model.getCell(0,0) == model.getTurn() && model.getCell(1,1) == model.getTurn() && model.getCell(2,2) == model.getTurn()) {
			return true;
		// check right to left diagonal for 3 in a row
		} else if (model.getCell(0,2) == model.getTurn() && model.getCell(1,1) == model.getTurn() && model.getCell(2,0) == model.getTurn()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Check if the current move results in a draw
	 * configuration. A game is a draw if all the
	 * cells are non-empty.
	 * It is assumed that this method will only be
	 * called after the win condition is checked.
	 *
	 * @param model the current game model
	 * @return true if there is a draw, false if not
	 */
	public boolean checkDraw(TicTacToeModel model) {
		// check all cells, if none are empty and there is no winner, it is a draw
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (model.getCell(i, j) == TicTacToeModel.EMPTY) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Switch the current player's turn.
	 *
	 * @param model the current game model
	 */
	public void changePlayer(TicTacToeModel model) {
		model.updateTurn();
	}

	/**
	 * Read a game state from the saveGame file storing it
	 * in the board.
	 *
	 * @return true if loading is successful, false if not
	 */
	// Is there a reason this couldn't be void? The boolean is not needed because this method catches its own errors
	public boolean readBoard(TicTacToeModel model) {
		try {
			FileReader fileReader = new FileReader(PATH + saveGame);
			BufferedReader reader = new BufferedReader(fileReader);
			try {
				for (int i = 0; i < 3; i++) {
					String line1 = reader.readLine();
					for (int j = 0; j < 3; j++) {
						if (line1.charAt(j) == 'X') {
							if (model.getTurn() == TicTacToeModel.PLAYER_X) {
								model.placeMarker(j, i);
							} else {
								model.updateTurn();
								model.placeMarker(j, i);
							}
						} else if (line1.charAt(j) == 'O') {
							if (model.getTurn() == TicTacToeModel.PLAYER_O) {
								model.placeMarker(j, i);
							} else {
								model.updateTurn();
								model.placeMarker(j, i);
							}
						}
					}
				}
				String line4 = reader.readLine();
				if (line4 == "X") {
					if (model.getTurn() == TicTacToeModel.PLAYER_O) {
						model.updateTurn();
					}
				} else {
					if (model.getTurn() == TicTacToeModel.PLAYER_X) {
						model.updateTurn();
					}
				}
				return true;
			} finally {
				reader.close();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Write the game state to the saveGame file.
	 *
	 * @return true if loading is successful, false if not
	 */
	// Is there a reason this couldn't be void? The boolean is not needed because this method catches its own errors
	public boolean writeBoard(TicTacToeModel model) {
		try {
			FileWriter writer = new FileWriter(PATH + saveGame);
			try {
				for (int i = 0; i < 3; i++) {
					String line = "";
					String cell;
					for (int j = 0; j < 3; j++) {
						if (model.getCell(j, i) == TicTacToeModel.EMPTY) {
							cell = " ";
							line += cell;
						} else if (model.getCell(j, i) == TicTacToeModel.PLAYER_X) {
							cell = "X";
							line += cell;
						} else {
							cell = "O";
							line += cell;
						}
					}
					line += "\n";
					writer.write(line);
				}
				if (model.getTurn() == TicTacToeModel.PLAYER_X) {
					writer.write("X");
				} else {
					writer.write("O");
				}
				return true;
			} finally {
				writer.close();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			return false;
		}
	}
}
