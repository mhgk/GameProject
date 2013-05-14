package dk.itu.team7.game;

import java.util.Random;

/**
 * This class creates random numbers used when creating the skyline and setting
 * the wind factor.
 * 
 * @author Team 7: Mads Gade & Rene A. Nielsen
 * @version 1.0
 */

public class Randomizer {

	/**
	 * This method creates an array containing a random number of houses and
	 * starting position of each house to be drawn.
	 * 
	 * @return an array containing the number of houses and Y positions of each
	 *         house.
	 */

	public static int[][] randomizer() {

		int numberOfhouses = randomNumberOfHouses();

		int[][] houseArray = new int[numberOfhouses][2];

		for (int i = 0; i < numberOfhouses; i++) {

			int topOfHouse = randomHouseY();
			houseArray[i][0] = numberOfhouses;
			houseArray[i][1] = topOfHouse;

		}

		return houseArray;

	}
	
	/**
	 * This creates a random integer between 8 and 12, used for defining the number of houses in the skyline. 
	 * 
	 * @return an int between 8 and 12. 
	 */

	public static int randomNumberOfHouses() {

		Random random = new Random();

		// numberOfHouses varies from 8 to 12
		int numberOfhouses = 12 - random.nextInt(5);

		return numberOfhouses;

	}

	/**
	 * This creates a random integer between 350 and 699, used when finding the top Y position of each house.
	 * 
	 * @return an int between 350 and 699.
	 */
	
	public static int randomHouseY() {

		Random random = new Random();

		int y = 350 + random.nextInt(350);

		return y;
	}
	
	/**
	 * This creates a random integer between 10 and -10, used when setting the wind factor.
	 * 
	 * @return an int between 10 and -10.
	 */

	public static double windFactor() {

		Random random = new Random();

		// set windfactor between -10 and 10
		double wF = random.nextInt(21) - 10;
		return wF;
	}

}
