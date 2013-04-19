package dk.itu.team7.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Scanner;

public class Banana {
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;

	private int velocity;
	private int angle;
	
	Scanner scannerV = new Scanner(System.in);
	Scanner scannerA = new Scanner(System.in);

	Banana(int x, int y, int w, int h, Color c) {

		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.color = c;
	}
	
	public void updateBanana(int x, int y) {
		this.x = x;
		this.y = y;
		
	}

	public void display(Graphics g) {
		// This method lets us draw the players

		// This is player rendered graphics.
		Graphics2D graphics = (Graphics2D) g; // Graphical library to render
												// shapes.
		graphics.setColor(color);
		graphics.drawRect(x, y, width, height); // draws a rectangle circumces
		graphics.fillRect(x, y, width, height); // this fills the rectangle with
												// colour
		// graphics.
	}
	


	public void projectory() {

		//velocity = scannerV.nextInt();
	//	angle = scannerA.nextInt();
	// is this scanner suppose to be here???			
		
		x = x+1;
		        y = y+1; 
	}
}
