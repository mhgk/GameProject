package dk.itu.team7.game;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;

/**
 * This class creates a banana with specified parameters, keeps track of it's
 * position and returns a shape when asked for.
 * 
 * @author Team 7: Mads Gade & Rene A. Nielsen
 * @version 1.0
 */

public class Banana {

	int x;
	int y;
	int w;
	int h;
	Color c;
	double doubleX;
	double doubleY;
	public boolean isBananaThrown = false;

	/**
	 * This constructs a Banana with the following specified parameters.
	 * 
	 * @param x
	 *            specified X position
	 * @param y
	 *            specified Y position
	 * @param w
	 *            specified width
	 * @param h
	 *            specified height
	 * @param c
	 *            specified color
	 */

	public Banana(int x, int y, int w, int h, Color c) {
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
		this.c = c;
	}

	/**
	 * This method sends banana coordinates to Trajectory, gets the new
	 * coordinates from Trajectory and saves the integers x and y used for
	 * painting.
	 */

	public void positionCalc() {

		if (isBananaThrown) {

			Trajectory.projectory(doubleX, doubleY);

			doubleX = Trajectory.getX();
			doubleY = Trajectory.getY();

			y = (int) Math.round(doubleY);
			x = (int) Math.round(doubleX);
		}
	}

	/**
	 * This method updates the X and Y position.
	 * 
	 * @param x
	 *            specified X position
	 * @param y
	 *            specified Y position
	 */

	public void updateBanana(int x, int y) {

		this.x = x;
		this.y = y;
		this.doubleX = x;
		this.doubleY = y;

	}

	/**
	 * This returns the Y position.
	 * 
	 * @return Y position of banana.
	 */

	public int getY() {

		return y;
	}

	/**
	 * This returns the X position.
	 * 
	 * @return X position of banana.
	 */

	public int getX() {

		return x;
	}

	/**
	 * This returns the shape.
	 * 
	 * @return shape of banana.
	 */

	public Shape getShape() {
		return new Rectangle(x, y, w, h);
	}

	/**
	 * This returns the color.
	 * 
	 * @return color of banana.
	 */

	public Color getColor() {
		return c;
	}

	/**
	 * This method sets the boolean isBananaThrown
	 * 
	 * @param isBananaThrown
	 */

	public void setBananaThrown(boolean isBananaThrown) {
		this.isBananaThrown = isBananaThrown;
	}
}