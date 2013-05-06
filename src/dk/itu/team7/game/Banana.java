package dk.itu.team7.game;

import java.awt.Color;

public class Banana extends DrawObjects {

	private double doubleX;
	private double doubleY;
	public boolean visible = false;

	Banana(int x, int y, int w, int h, Color c) {

		super(x, y, w, h, c);

	}

	public void runme() {

		if (visible) {
			Trajectory.projectory(doubleX, doubleY);

			doubleX = Trajectory.getX();
			doubleY = Trajectory.getY();

			y = (int) Math.round(doubleY);
			x = (int) Math.round(doubleX);
		}
	}

	public void updateBanana(int x, int y) {

		
		  System.out.println("virker det" + y + x);
		  this.doubleX = x;
		  this.doubleY = y;
		 
	}
	
	public  int getY() {

		return y;
	}
	
	public int getX() {

		return x;
	}
	
	public void setX(int value) {
		x = value;
		} 

	public void setY(int value) {
	   y = value;
	} 
}
