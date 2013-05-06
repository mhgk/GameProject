package dk.itu.team7.game;

import java.util.Random;

public class Randomizer {
	
	
	public static int[][] randomizer() {
	
	int numberOfhouses = randomNumberOfHouses();
	
	int[][] block = new int[numberOfhouses][2];
	
	for (int i= 0; i < numberOfhouses; i++) {
		
		int houseHeight = randomYHouse();
		block [i][0] = numberOfhouses;
		block[i][1]= houseHeight; 
		
	}
	
	
	return block;
	
	}
	
	public static int randomNumberOfHouses() {

		Random randomXHouse = new Random();

		int numberOfhouses = 12 - randomXHouse.nextInt(5);

		return numberOfhouses;

	}

	public static int randomYHouse() {

		Random randomYHouse = new Random();

		int y = 150 + randomYHouse.nextInt(400);

		return y;
	}


}
