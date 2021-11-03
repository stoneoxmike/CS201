import java.util.Scanner;

/**
 * Console application for tic-tac-toe
 */

public class TicTacToeConsole {	
	public static void main(String[] args) {
		// Create model and controller
		TicTacToeModel model = new TicTacToeModel();
		TicTacToeController controller = new TicTacToeController();
		
		Scanner keyboard = new Scanner(System.in);
		
		boolean done = false;
		while (!done) {
			// Print current board configuration
			System.out.println();
			printBoard(model.getBoard());
			
			// Get current players selected location (Controller)
			System.out.printf("\nPlayer %c's turn:\n", (model.getTurn() == TicTacToeModel.PLAYER_X) ? 'X' : 'O');
			System.out.print("Enter a row and column (0-2): ");	
			int row = keyboard.nextInt();
			int col = keyboard.nextInt();
			
			// Check for valid move
			if (!controller.makeMove(model, model.getTurn(), row, col)) {
				System.out.println("Invalid move, try again");
			} else {
				// Move is legal so check for win/draw
				if (controller.checkWin(model)) {
					// Current player wins
					System.out.printf("Player %c wins!\n", model.getTurn() == TicTacToeModel.PLAYER_X ? 'X' : 'O');
					done = true;
				} else if (controller.checkDraw(model)) {
					// Game is a draw
					System.out.println("It's a draw!");
					done = true;
				} else {
					// Switch player
					controller.changePlayer(model);
				}
			}
		}
		keyboard.close();
		printBoard(model.getBoard());		
		System.out.println("\nThanks for playing!");
	}

	/**
	 * Print the current state of the model's board
	 * using X and O (View)
	 * 
	 */
	public static void printBoard(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == TicTacToeModel.EMPTY) {
					System.out.print("   ");
				} else {
					System.out.printf(" %c ", (board[i][j] == TicTacToeModel.PLAYER_X) ? 'X' : 'O');
				}
				if (j < board[i].length-1) {
					System.out.print("|");
				}
			}
			if (i < board.length-1) {
				System.out.print("\n---|---|---\n");
			}
		}
	}
}
