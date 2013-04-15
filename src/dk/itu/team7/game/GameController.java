package dk.itu.team7.game;

public class GameController {
	// this is the main class of the game.

	// private static Board board;
	private static View view;

	public GameController() throws InterruptedException {
		// this constructor(GameController) calls on the method startGame and runGame.

		startGame();

		runGame();

	}

	public void startGame() {
    // this method makes a new object of the class View, and runs the method in it - setupView
		
		view = new View();

		view.setupView();

	}

	public void runGame() throws InterruptedException {
// This method calls on view and and uses the function repaint on it. The Tread.sleep is the refresh-time 
		
		while (true) {

			view.repaint();

			Thread.sleep(10);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// this is the main method. it makes a new object of the Gamecontroller, since u cant initialize a method with out first initializing its class?

		@SuppressWarnings("unused")
		GameController controller = new GameController();

	}
}