package dk.itu.team7.game;

import javax.swing.JOptionPane;

/**
 * This class is the main class of the game. It creates instances of View and
 * Board, and runs the game as long as it is not terminated by the user.
 * 
 * @author Team 7: Mads Gade & Rene A. Nielsen
 * @version 1.0
 */

public class GameController {
	// this is the main class of the game.

	private static View view;
	private static Board board;
	String winner;

	/**
	 * This is the main method. It makes sure an instance of GameController is
	 * created, when the game is started.
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

	/**
	 * This constructor runs startGame() and runGame(), when an instance of
	 * GameController is created.
	 * 
	 * @throws InterruptedException
	 */

	public GameController() throws InterruptedException {
		// this constructor(GameController) calls the methods startGame and
		// runGame.

		startGame();

		runGame();

	}

	/**
	 * This method creates a new instance of Board, runs setupBoard and creates
	 * View with the newly created Board as parameter.
	 */

	public void startGame() {

		board = new Board();
		board.setupBoard();
		view = new View(board);

	}

	/**
	 * This method runs the game, as long as no winner is found. When a winner
	 * is found, the score is updated one last time and the user is asked to
	 * restart or quit the game.
	 * 
	 * @throws InterruptedException
	 */

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
	
	/**
	 * This returns true if a player counter reaches 5. When true is returned, the game is stopped.    
	 * 
	 * @return a boolean which describes whether there is a winner or not.
	 */

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