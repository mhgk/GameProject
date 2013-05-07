package dk.itu.team7.game;

public class GameController {
	// this is the main class of the game.

	// private static Board board;
	private static View view;

	String winner;

	public GameController() throws InterruptedException {
		// this constructor(GameController) calls on the method startGame and
		// runGame.

		startGame();

		runGame();

	}

	public void startGame() {
		// this method makes a new object of the class View, and runs the method
		// in it - setupView

		Board board = new Board();
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
		// message dialog - print winner
System.out.println("Congrats!");
view.showScore();
	}

	public static void main(String[] args) throws InterruptedException {
		// this is the main method. it makes a new object of the Gamecontroller,
		// since u cant initialize a method with out first initializing its
		// class?

		@SuppressWarnings("unused")
		GameController controller = new GameController();

	}

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