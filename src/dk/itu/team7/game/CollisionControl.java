package dk.itu.team7.game;

import java.awt.Shape;

public class CollisionControl {

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

//	public int collisionControl(int x, int y) {
	
	public int collisionControl(int x, int y, Shape shape) {

		bananaX = x;
		bananaY = y;
		bananaShape = shape;

		for (int i = 0; i < houseArray.length; i++) {

			int houseStartX = houseWidth * i;
//			int houseEndX = houseWidth * (i + 1);
//			int houseY = houseArray[i][1] - 15;
			int houseY = houseArray[i][1];

			if (bananaShape.intersects(houseStartX, houseY, houseWidth, houseHeight)) {
				return 3;
			}
//			if (bananaX > houseStartX && bananaX < houseEndX) {
//
//				if (bananaY > houseY) {
//					return 3;
//				}
//			}
		}

		if (bananaX < -20 || bananaX > 1386) {
			return 4;
		}

//		if (bananaX >= player1x && bananaX <= player1x + 20) {
//
//			if (bananaY > player1y) {
//				Board.counterP2++;
//				return 2;
//			}
//		}
//		if (bananaX >= player2x && bananaX <= player2x + 20) {
//
//			if (bananaY > player2y) {
//				Board.counterP1++;
//				return 2;
//			}
//		}
		
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