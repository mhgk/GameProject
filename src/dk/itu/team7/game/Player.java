package dk.itu.team7.game;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;

/**
 * This class creates a player with specified parameters and returns a shape
 * when asked for.
 * 
 * @author Team 7: Mads Gade & René A. Nielsen
 * @version 1.0
 */

public class Player {
	// this class defines what parameters we want to have on the players. Also
	// we define what movement they can make.

	public int x;
	public int y;
	public int w;
	public int h;
	public Color c;

	/**
	 * This constructs a Player with the following specified parameters.
	 * 
	 * @param x
	 *            - specified X position
	 * @param y
	 *            - specified Y position
	 * @param w
	 *            - specified width
	 * @param h
	 *            - specified height
	 * @param color
	 *            - specified color
	 */

	public Player(int x, int y, int w, int h, Color c) {
		this.y = y;
		this.x = x;
		this.w = w;
		this.h = h;
		this.c = c;
	}

	/**
	 * This returns the shape.
	 * 
	 * @return shape of player.
	 */

	public Shape getShape() {
		return new Rectangle(x, y, w, h);
	}

	/**
	 * This returns the color.
	 * 
	 * @return color of player.
	 */

	public Color getColor() {
		return c;
	}

	/**
	 * This returns the Y position.
	 * 
	 * @return Y position of player.
	 */

	public int getY() {
		return y;
	}

	/**
	 * This returns the X position.
	 * 
	 * @return X position of player.
	 */

	public int getX() {
		return x;
	}
}