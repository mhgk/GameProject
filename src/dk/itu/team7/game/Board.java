package dk.itu.team7.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Board extends JPanel {

	/**
	 * This class creates instances of SkylineMap, CollisionControl, Player &
	 * Banana. It contains a paint method which draws the objects. It controls
	 * what happens, when a collision is detected. It also keeps track of the
	 * score count for the two players.
	 * 
	 * @author Team 7: Mads Gade & René A. Nielsen
	 * @version 1.0
	 */

	private static final long serialVersionUID = 1L;

	SkylineMap skyline;
	CollisionDetection collisionControl;
	Player player1;
	Player player2;
	Banana banana1;

	public static int counterP1;
	public static int counterP2;
	boolean isBanana1 = false;
	boolean isBanana2 = false;
	public static int collisionResult = -1;
	boolean missedTarget = false;

	public Board() {
	}

	/**
	 * This method sets up the visual part of the game, by creating the skyline,
	 * setting the wind factor, creating two players and a banana. It also sets
	 * the parameters used for collision control.
	 * 
	 */

	public void setupBoard() {

		skyline = new SkylineMap();

		collisionControl = new CollisionDetection();

		skyline.createSkyline();

		Trajectory.setwindFactor(Randomizer.windFactor());

		player1 = new Player(skyline.houseWidth / 2,
				skyline.houseArray[0][1] - 40, 20, 40, Color.blue);
		player2 = new Player(skyline.screenWidth - skyline.houseWidth / 2 - 20,
				skyline.houseArray[skyline.numberOfHouses - 1][1] - 40, 20, 40,
				Color.red);
		banana1 = new Banana(-16, -16, 15, 15, Color.YELLOW);

		collisionControl.setParams(skyline.houseArray, skyline.houseWidth,
				skyline.houseHeight, player1.getX(), player1.getY(),
				player2.getX(), player2.getY());
	}

	/**
	 * This method overrides paint() in JComponent. It is used to draw objects
	 * on the JPanel and runs every time View is repainted. Position
	 * calculations for the banana and collision control actions are placed
	 * inside the loop to make sure these are handled immediately.
	 */

	public void paint(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(player1.getColor());
		g2.fill(player1.getShape());
		g2.setColor(player2.getColor());
		g2.fill(player2.getShape());
		g2.setColor(skyline.getColor());
		g2.fill(skyline.getShape());
		g2.setColor(banana1.getColor());
		g2.fill(banana1.getShape());

		if (isBanana1) {
			banana1.isBananaThrown = true;
			banana1.updateBanana(player1.getX(), player1.getY() - 16);
			Trajectory.calculateDegree(1);
			isBanana1 = false;
		}

		if (isBanana2) {
			banana1.isBananaThrown = true;
			banana1.updateBanana(player2.getX(), player2.getY() - 16);
			Trajectory.calculateDegree(-1);
			isBanana2 = false;
		}

		banana1.positionCalc();

		collisionResult = collisionControl.collisionCalc(banana1.getX(),
				banana1.getY(), banana1.getShape());

		if (collisionResult == 4) {
			banana1.isBananaThrown = false;
			banana1.updateBanana(-16, -16);
			missedTarget = true;
		}

		if (collisionResult == 3) {
			banana1.isBananaThrown = false;
			banana1.updateBanana(-16, -16);
		}

		if (collisionResult == 2) {
			banana1.isBananaThrown = false;
			banana1.updateBanana(-16, -16);
			setupBoard();
		}
	}

	/**
	 * This returns the counter for player 1.
	 * 
	 * @return counterP1
	 */

	public static int getCounterP1() {
		return counterP1;
	}

	/**
	 * This returns the counter for player 2.
	 * 
	 * @return counterP2
	 */

	public static int getCounterP2() {
		return counterP2;
	}

	/**
	 * This method sets isBanana1 to the specified value.
	 * 
	 * @param isBanana1
	 *            - true or false.
	 */

	public void setBanana1(boolean isBanana1) {
		this.isBanana1 = isBanana1;
	}

	/**
	 * This method sets isBanana2 to the specified value.
	 * 
	 * @param isBanana2
	 *            - true or false.
	 */

	public void setBanana2(boolean isBanana2) {
		this.isBanana2 = isBanana2;
	}

	public boolean isFocusable() {
		return true;
		/*
		 * "A component must be focusable in order to gain the focus. When a
		 * component has been removed from the focus cycle with
		 * setFocusable(false), it can no longer be navigated with the
		 * keyboard."
		 */
	}
}
