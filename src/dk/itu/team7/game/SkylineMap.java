package dk.itu.team7.game;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.Rectangle;

/**
 * This class is used to create the skyline, every time a map is created.
 * 
 * @author Team 7: Mads Gade & Rene A. Nielsen
 * @version 1.0
 */

public class SkylineMap {
	public int[][] houseArray;
	public int numberOfHouses;
	public int houseWidth;
	int houseHeight = 768;
	int screenWidth = 1366;
	Color c = Color.black;

	/**
	 * This method used the Randomizer class to create a random combination of
	 * houses in the skyline. It gets an array from Randomizer, saves number of
	 * houses and creates a house width, before returning the array to where it was
	 * called from.
	 * 
	 * @return an array it gets from Randomizer.
	 */

	public int[][] createSkyline() {

		houseArray = Randomizer.randomizer();

		numberOfHouses = houseArray[0][0];

		houseWidth = screenWidth / numberOfHouses;

		return houseArray;
	}
	
	/**
	 * This returns an Area which is created by adding all the houses to one Area.
	 * 
	 * @return an area consisting of a shapes created for each house in the array. 
	 */

	public Shape getShape() {
		Area area = null;
		for (int i = 0; i < numberOfHouses; i++) {
			Shape house = new Rectangle(i * houseWidth, houseArray[i][1],
					houseWidth, houseHeight);
			if (area == null) {
				area = new Area(house);
			} else {
				area.add(new Area(house));
			}
		}
		return area;
	}

	/**
	 * This returns the color of skyline.
	 * 
	 * @return color - used when painting the skyline.
	 */
	
	public Color getColor() {
		return c;
	}
}