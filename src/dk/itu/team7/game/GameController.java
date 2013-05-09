package dk.itu.team7.game;

import javax.swing.JOptionPane;

/**
 * The GameController class is the main class.
 * 
 * @author Team 7: Mads Gade & René Nielsen
 * @version 1.0 (15.May.2013)
 * 
 * @param view
 *            New instance of View.
 * @param board
 *            New instance of Board.
 * @param winner
 *            String to include name of the winner.
 */

public class GameController {
	// this is the main class of the game.

	private static View view;
	private static Board board;
	String winner;

	/**
	 * Class constructor
	 * 
	 * @throws InterruptedException
	 */

	public static void main(String[] args) throws InterruptedException {
		// this is the main method. it makes a new object of the Gamecontroller,
		// since u cant initialize a method with out first initializing its
		// class

		// ignore 'controller is not used' warning
		@SuppressWarnings("unused")
		GameController controller = new GameController();

	}

	public GameController() throws InterruptedException {
		// this constructor(GameController) calls the methods startGame and
		// runGame.

		startGame();

		runGame();

	}

	public void startGame() {

		board = new Board();
		board.setupBoard();
		view = new View(board);

	}

	public void runGame() throws InterruptedException {
		// This method calls on view and and uses the function repaint on it.
		// The Tread.sleep is the refresh-time

		while (!isThereAWinner()) {
			view.repaint();
			Thread.sleep(10);
			view.showScore();
		}

		view.showScore();

		int answer = JOptionPane.showConfirmDialog(null, "Play again?", winner
				+ "won the game :D", JOptionPane.YES_NO_OPTION);
		System.out.println(answer);

		if (answer == 0) {
			Board.counterP1 = 0;
			Board.counterP2 = 0;
			runGame();
		}

		if (answer == 1) {
			System.exit(0);
		}
	}

	// public void newShootInput() {
	// if (Board.collisionResult == 3) {
	// view.inputAngleField();
	// }
	// }

	public boolean isThereAWinner() {
		if (Board.getCounterP1() == 5) {
			winner = "Player 1";
			return true;
		}
		if (Board.getCounterP2() == 5) {
			winner = "Player 2";
			return true;
		}
		return false;
	}
}