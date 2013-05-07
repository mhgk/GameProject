package dk.itu.team7.game;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Area;

public class SkylineMap  {
	public int numberOfhouses;
	public int houseWidth;
	int houseHight = 800;
	public int[][] blockNew;
	Color c = Color.black;
	int w;
	int h;
	int[][] temp = new int[10][10];
    
	public int[][] createSkyline() {

		blockNew = Randomizer.randomizer();

		numberOfhouses = blockNew[0][0];

		System.out.println(numberOfhouses + "hallo");

		houseWidth = 1366 / numberOfhouses;

		return blockNew;
	}
	
	public Shape getShape() {
		Area area = null;
		  for (int i = 0; i < numberOfhouses; i++) {
			  Shape house = new Rectangle(i * houseWidth, blockNew[i][1], houseWidth, 800);
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
