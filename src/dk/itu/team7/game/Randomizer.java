package dk.itu.team7.game;

import java.util.Random;

public class Randomizer {

	public static int[][] randomizer() {

		int numberOfhouses = randomNumberOfHouses();

		int[][] houseArray = new int[numberOfhouses][2];

		for (int i = 0; i < numberOfhouses; i++) {

			int houseHeight = randomHouseY();
			houseArray[i][0] = numberOfhouses;
			houseArray[i][1] = houseHeight;

		}

		return houseArray;

	}

	public static int randomNumberOfHouses() {

		Random random = new Random();

		// numberOfHouses varies from 8 to 12
		int numberOfhouses = 12 - random.nextInt(5);

		return numberOfhouses;

	}

	public static int randomHouseY() {

		Random random = new Random();

		int y = 350 + random.nextInt(350);

		return y;
	}

	public static double windFactor() {

		Random random = new Random();

		// set windfactor between -10 and 10
		double wF = random.nextInt(21) - 10;
		return wF;
	}

}
