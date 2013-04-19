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

	

	public boolean visible;

	Scanner scannerV = new Scanner(System.in);
	Scanner scannerA = new Scanner(System.in);

	Banana(int x, int y, int w, int h, Color c) {

		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.color = c;
		this.visible = false;
	}

	public void updateBanana(int x, int y) {
		this.x = x;
		this.y = y;

	}

	public void display(Graphics g) {
		// This method lets us draw the players
		if (this.visible == true) {
			// This is player rendered graphics.
			Graphics2D graphics = (Graphics2D) g; // Graphical library to render
													// shapes.
			graphics.setColor(color);
			graphics.drawRect(x, y, width, height); // draws a rectangle
													// circumces
			graphics.fillRect(x, y, width, height); // this fills the rectangle
													// with
													// colour
			// graphics.

			projectory();
		}

	}

	private double x_speed =  1;
	private double y_speed = -2;
    private double velocity = 0.001;
	
    public void projectory() {
		

   
		x += x_speed;
		
		y += y_speed;
		
		y_speed += velocity;

		System.out.println(x + " , " + y);
		
		if (x < 0 || x > 1400) {
			x = 0;
			this.visible = false;
			
		}
		
		
        if (y > 800) {
            y = 0;        
        	this.visible = false;
        }
	}
}
