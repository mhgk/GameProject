package dk.itu.team7.game;

import java.awt.Color;
import java.awt.Container;
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
	CollisionControl collisionControl;
	AddInputVariabels addInputV;
	View view;
	public static int counterP1;
	public static int counterP2;
	boolean isBanana1 = false;
	boolean isBanana2 = false;
	boolean playerHit = true;
	private int collisionResult = -1;
    
	public Board() {
	}


	public void setupBoard() {
		addKeyListener(this);
		addInputV = new AddInputVariabels();
		add(addInputV);
		
		skyline = new SkylineMap();

		collisionControl = new CollisionControl();

        	
		skyline.createSkyline();

		player1 = new Player(skyline.houseWidth / 2,
				skyline.blockNew[0][1] - 40, 20, 40, Color.blue);
		player2 = new Player(1366 - skyline.houseWidth / 2 - 20,
				skyline.blockNew[skyline.numberOfhouses - 1][1] - 40, 20, 40,
				Color.red);
		banana1 = new Banana(50, -400, 15, 15, Color.YELLOW);

		collisionControl.getParameters(skyline.blockNew, skyline.houseWidth,
				skyline.houseHight, player1.getX(), player1.getY(),
				player2.getX(), player2.getY());

	//	addInputV.inputAngleField();

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
		player1.draw(g);
		player2.draw(g);

		skyline.display(g);

		if (isBanana1) {

			banana1.visible = true;
			banana1.updateBanana(player1.getX(), player1.getY()-16);
			Trajectory.calculateDegree();
			isBanana1 = false;

		}
		
		
		if (isBanana2) {

			banana1.visible = true;
			banana1.updateBanana(player2.getX(), player2.getY()-16);
			Trajectory.calculateDegree();
			isBanana2 = false;

		}

		banana1.draw(g);

		banana1.runme();

		collisionResult = collisionControl.collisionControl(banana1.getX(),
				banana1.getY());

		if (collisionResult == 3) {
			
			// banana1.updateBanana(player1.getX(), player1.getY());
			banana1.visible = false;
		}

		if (collisionResult == 2 ) {

			setupBoard();
			banana1.visible = false;
			playerHit = true;
		}

	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_SPACE) {

			isBanana1 = true;
		}
		
		if (keyCode == KeyEvent.VK_CONTROL) {

			isBanana1 = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
