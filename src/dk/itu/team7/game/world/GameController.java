package Gorilla;

public class GameController implements Runnable {
	
	private static Board map;
	private static View view;
		
	public static void main(String[] args) {
		GameController controller = new GameController();		
	}
	
	public GameController() {
		GameController.view = new View();
		Player playerOne = new Player(100, 2);
		Player playerTwo = new Player(500, 2);
		// GameController.map = new Map(playerOne, playerTwo);
		
	}
}
