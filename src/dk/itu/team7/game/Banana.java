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
	private double inner_x;
	private double inner_y;

	

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
		inner_x = x;
		inner_y = y;
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

	private double inputAngle = 65;
	private double degreeToRadian = (inputAngle/360)*(2 * Math.PI);
//	private double x_speed = 2 * (((((input - 45)*1.11111))/100)+1);
//    private double y_speed = -2 * (((((45 - input)*1.11111))/100)+1);		
	private double x_speed = 1 * Math.cos(degreeToRadian);
	private double y_speed =  -1 *  Math.sin(degreeToRadian);
    private double g = 0.004;
	
    public void projectory() {
		

 
		inner_x += x_speed;
		
		inner_y += y_speed;
		
		y_speed += g;

	//	System.out.println(x + " , " + y); 
		
		x = (int) Math.round(inner_x);
		y = (int) Math.round(inner_y);
		
		
		
		if (x < 0 || x > 1400 && y > 800) {
			
			
			this.visible = false;
			
			
		}
	
        
	}
    
    public int getY() {
   	 
   	 return y;
    }

    public int getX() {
   	
   	 return x;
   	
   	}
}
