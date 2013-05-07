package dk.itu.team7.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class DrawObjects {
    
	int[][] temp;
	public int x;
	public int y;
	public int w;
	public int h;
	public Color c;

	public DrawObjects(int x, int y, int w, int h, Color c) {

		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.c = c;
	}

	public void draw(Graphics g) {
		// This method lets us draw the objects
		// (this.visible == true) {
		// This is player rendered graphics.
		Graphics2D graphics = (Graphics2D) g; // Graphical library to render
												// shapes.
		graphics.setColor(c);
		graphics.drawRect(x, y, w, h); // draws a rectangle
										// circumces
		graphics.fillRect(x, y, w, h); // this fills the rectangle

		// }

	}
	
	public void displaySkyline() {
		
	//	temp = SkylineMap.blockNew[][];
		
		
		
	}
	
	
	
	
	
	
	
}