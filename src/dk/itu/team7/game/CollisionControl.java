package dk.itu.team7.game;

public class CollisionControl {

	int[][] map;
	int houseWidth;
	int houseHight;
	int player1x;
	int player1y;
	int player2x;
	int player2y;

	public void getParameters(int[][] map, int houseWidth, int houseHight,
			int player1x, int player1y, int player2x, int player2y) {

		this.map = map;
		this.houseWidth = houseWidth;
		this.houseHight = houseHight;
		this.player1x = player1x;
		this.player1y = player1y;
		this.player2x = player2x;
		this.player2y = player2y;
	}

	public int collisionControl(int x, int y) {

		int bananaY = y;

		int bananaX = x;

		for (int i = 0; i < map.length; i++) {

			int houseStartX = houseWidth * i;
			int houseEndX = houseWidth * (i + 1);
			int houseY = map[i][1] - 15;

			if (bananaX > houseStartX && bananaX < houseEndX) {

				if (bananaY > houseY) {

					return 3;

				}

			}

		}
		if (x < 0 || x > 1400) {

			return 3;
		}

		if (bananaX > player1x && bananaX < player1x + 20 || bananaX > player2x
				&& bananaX < player2x + 20) {

			if (bananaY > player1y) {
				Board.counterP1++;
				return 2;
			}

			if (bananaY > player2y) {
				Board.counterP2++;
				return 2;

			}
		}
		return 0;
	}

}
