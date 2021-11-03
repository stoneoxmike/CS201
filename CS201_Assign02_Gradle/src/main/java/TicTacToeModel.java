/**
 * An instance of the TicTacToeModel class represents the
 * state of a tic-tac-toe game.
 */
public class TicTacToeModel {
	public static final int PLAYER_O = 0;
	public static final int PLAYER_X = 1;
	public static final int EMPTY = 2;
	
	// TODO: Field for current player
	private int currentPlayer;
	// TODO: Field for the board array	
	private int[][] board;
	
	/**
	 * Constructor.
	 * Initialize the board array to EMPTY
	 * and start with PLAYER_X.
	 * 
	 */
	public TicTacToeModel() {
		currentPlayer = PLAYER_X;
		board = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = EMPTY;
			}
		}
	}
	
	/**
	 * @return the model's current player's turn
	 */
	public int getTurn() {
		return currentPlayer;
	}

	/**
	 * @return the model's current board
	 */
	public int[][] getBoard() {
		return board;
	}

	/**
	 * Return the current board location
	 * @param row the row index
	 * @param col the column index
	 * @return the contents of the board at the given location
	 */
	public int getCell(int row, int col) {
		return board[row][col];
	}

	/**
	 * Place the marker for the current player on the board and
	 * update the turn.
	 * It is assumed that this method will only be called for
	 * legal moves.
	 *
	 * @param row the row index where the marker is being placed
	 * @param col the column index where the marker is being placed
	 */
	public void placeMarker(int row, int col) {
		board[row][col] = currentPlayer;
	}

	/**
	 * Switch the current player
	 *
	 */
	public void updateTurn() {
		if (currentPlayer == PLAYER_O) {
			currentPlayer = PLAYER_X;
		} else if (currentPlayer == PLAYER_X) {
			currentPlayer = PLAYER_O;
		}
	}




















	/**
	 * Constructor FOR TESTING ONLY.
	 * DO NOT USE THIS CONSTRUCTOR
	 * 
	 */

	public TicTacToeModel(int[][] board, int turn) {
		this.board = board;
		this.currentPlayer = turn;
	}


}
