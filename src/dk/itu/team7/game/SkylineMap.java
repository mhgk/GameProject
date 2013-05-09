package dk.itu.team7.game;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.Rectangle;

public class SkylineMap  {
	public int[][] houseArray;
	public int numberOfhouses;
	public int houseWidth;
	int houseHeight = 768;
	int screenWidth = 1366;
	Color c = Color.black;
    
	public int[][] createSkyline() {
		
		// set wind factor for the new skyline
		Randomizer.windFactor();

		houseArray = Randomizer.randomizer();

		numberOfhouses = houseArray[0][0];

		houseWidth = screenWidth / numberOfhouses;

		return houseArray;
	}
	
	public Shape getShape() {
		Area area = null;
		  for (int i = 0; i < numberOfhouses; i++) {
			  Shape house = new Rectangle(i * houseWidth, houseArray[i][1], houseWidth, houseHeight);
			  if (area == null) {
				  area = new Area(house);
			  } else {
				  area.add(new Area(house));
			  }
		  }
		return area;
	}
	
	public Color getColor() {
		return c;
	}
}