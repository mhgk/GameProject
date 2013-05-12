package dk.itu.team7.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Board extends JPanel {
	/**
	 * This class calls on the player class and assign values to the player
	 * parameters.
	 */

	private static final long serialVersionUID = 1L;

	SkylineMap skyline;
	CollisionControl collisionControl;
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

	public void setupBoard() {

		skyline = new SkylineMap();

		collisionControl = new CollisionControl();

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

	public void paint(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(player1.getColor());
		g2.fill(player1.getShape());
		g2.setColor(player2.getColor());
		g2.fill(player2.getShape());
		g2.setColor(skyline.getColor());
		g2.fill(skyline.getShape());

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
		g2.setColor(banana1.getColor());
		g2.fill(banana1.getShape());

		banana1.positionCalc();

//		collisionResult = collisionControl.collisionControl(banana1.getX(),
//				banana1.getY());
		collisionResult = collisionControl.collisionControl(banana1.getX(),
				banana1.getY(),banana1.getShape());

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

	public static int getCounterP1() {
		return counterP1;
	}

	public static int getCounterP2() {
		return counterP2;
	}

	public void setBanana1(boolean isBanana1) {
		this.isBanana1 = isBanana1;
	}

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
