package dk.itu.team7.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Board extends JPanel implements KeyListener {
	/**
	 * This class calls on the player class and assign values to the player
	 * parameters. it also initialize the keyListener which takes input from the
	 * keyboard
	 */

	private static final long serialVersionUID = 1L;
	Player player1;
	Player player2;
	Banana banana1;
	SkylineMap skyline;
	DrawObjects drawobject;
//	Trajectory trajectory;
	CollisionControl c;
	boolean isBanana = false;
	boolean playerHit = true;
	private int collisionResult = -1;
	public Board() {}
		// makes 2 new player objects, and assign values to the player
		// parameters
		
		public void setupBoard() {
		skyline = new SkylineMap();

		c = new CollisionControl();
		
		
	    skyline.createSkyline();

		player1 = new Player(skyline.houseWidth / 2,
				skyline.blockNew[0][1] - 40, 20, 40, Color.blue); 
		player2 = new Player(1366 - skyline.houseWidth / 2 - 20,
				skyline.blockNew[skyline.numberOfhouses - 1][1] - 40, 20, 40,
				Color.red);
		banana1 = new Banana(50, -400, 15, 15, Color.YELLOW);
		
		 c.getParameters(skyline.blockNew, skyline.houseWidth, skyline.houseHight,player1.getX(), player1.getY(),player2.getX(), player2.getY());
		
		

		addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// this method calls on the method moveDown(in class player) to get the
		// movement-range

		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_SPACE) {

			// trajectory.updateBanana(x, y);
			isBanana = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	/**
	 * Set's focus on the panel so key events are catch.
	 */

	public boolean isFocusTraversable() {
		return true;
		// what does this do?

	}

	public void paint(Graphics g) {
		// This method lets us paint the new objects of the players. it calls on
		// the method Graphics g in players.
		// return nothing
		player1.display(g);
		player2.display(g);

		skyline.display(g);

		if (isBanana) {

			banana1.visible = true;
			banana1.updateBanana(player1.getX(), player1.getY());
			isBanana = false;

		}
      
		banana1.display(g);

		banana1.runme();
		
		
		
		 collisionResult =  c.collisionControl(banana1.getX(), banana1.getY());
				
		 if (collisionResult == 1) {
			 // change player
			 
		 }
		 
		 if (collisionResult == 2){
			
			setupBoard();
			banana1.visible = false;
			playerHit = true;
		}
       
		
	} 
	
}
