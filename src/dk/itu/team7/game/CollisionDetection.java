package dk.itu.team7.game;

import java.awt.Shape;

/**
 * This class detects when collision occur and returns an integer describing the
 * collision type.
 * 
 * @author Team 7: Mads Gade & Rene A. Nielsen
 * @version 1.0
 */

public class CollisionDetection {

	int[][] houseArray;
	int houseWidth;
	int houseHeight;
	int player1x;
	int player1y;
	int player2x;
	int player2y;

	int bananaX;
	int bananaY;
	Shape bananaShape;

	/**
	 * This method sets the parameters
	 * 
	 * @param houseArray
	 *            specified house array, containing number of houses and
	 *            starting Y position for each house
	 * @param houseWidth
	 *            specified house width
	 * @param houseHeight
	 *            specified house height
	 * @param player1x
	 *            specified X position of player 1
	 * @param player1y
	 *            specified Y position of player 1
	 * @param player2x
	 *            specified X position of player 2
	 * @param player2y
	 *            specified Y position of player 2
	 */

	public void setParams(int[][] houseArray, int houseWidth, int houseHeight,
			int player1x, int player1y, int player2x, int player2y) {

		this.houseArray = houseArray;
		this.houseWidth = houseWidth;
		this.houseHeight = houseHeight;
		this.player1x = player1x;
		this.player1y = player1y;
		this.player2x = player2x;
		this.player2y = player2y;
	}

	/**
	 * This method detects which type of collision that occurs. There are three
	 * types of collisions: Player hit, house hit & 'Out of bounds'.
	 * 
	 * @param x
	 *            specified X position of banana
	 * @param y
	 *            specified Y position of banana
	 * @param shape
	 *            specified shape of banana
	 * @return an int describing the collision type.
	 */

	// public int collisionControl(int x, int y) {

	public int collisionCalc(int x, int y, Shape shape) {

		bananaX = x;
		bananaY = y;
		bananaShape = shape;

		for (int i = 0; i < houseArray.length; i++) {

			int houseStartX = houseWidth * i;
			int houseY = houseArray[i][1];
			// int houseEndX = houseWidth * (i + 1);
			// int houseY = houseArray[i][1] - 15;

			if (bananaShape.intersects(houseStartX, houseY, houseWidth,
					houseHeight)) {
				return 3;
			}
			// if (bananaX > houseStartX && bananaX < houseEndX) {
			// if (bananaY > houseY) {
			// return 3;
			// }
			// }
		}

		if (bananaX < -20 || bananaX > 1386) {
			return 4;
		}

		// if (bananaX >= player1x && bananaX <= player1x + 20) {
		//
		// if (bananaY > player1y) {
		// Board.counterP2++;
		// return 2;
		// }
		// }
		// if (bananaX >= player2x && bananaX <= player2x + 20) {
		//
		// if (bananaY > player2y) {
		// Board.counterP1++;
		// return 2;
		// }
		// }

		if (bananaShape.intersects(player1x, player1y, 20, 40) == true) {
			Board.counterP2++;
			return 2;
		}
		if (bananaShape.intersects(player2x, player2y, 20, 40) == true) {
			Board.counterP1++;
			return 2;
		}

		return 0;
	}
}