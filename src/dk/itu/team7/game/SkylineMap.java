package dk.itu.team7.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class SkylineMap  {
	public int numberOfhouses;
	public int houseWidth;
	int houseHight = 800;
	public int[][] blockNew;
	Color c = Color.black;
	int w;
	int h;
	int[][] temp = new int[10][10];
    
	
	
/*	public SkylineMap(int x, int y, int w, int h, Color c) {

		super(x, y, w, h, c);

	} */

	public int[][] createSkyline() {

		blockNew = Randomizer.randomizer();

		numberOfhouses = blockNew[0][0];

		System.out.println(numberOfhouses + "hallo");

		houseWidth = 1366 / numberOfhouses;

		return blockNew;
	}


	
	  public void display(Graphics g) {
	  
	  for (int i = 0; i < numberOfhouses; i++) {
	  
	  Graphics2D graphics = (Graphics2D) g; // Graphical library to render //
	  graphics.setColor(c);
	  
	  graphics.drawRect(i * houseWidth, blockNew[i][1], houseWidth, 800); //
	  
	  graphics.fillRect(i * houseWidth, blockNew[i][1], houseWidth, 800); //
	  
	  } }
	 

}
