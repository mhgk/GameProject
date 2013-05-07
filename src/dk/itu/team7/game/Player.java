package dk.itu.team7.game;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;

public class Player {
	// this class defines what parameters we want to have on the players. Also
	// we define what movement they can make.

	public int x;
	public int y;
	public int width;
	public int height;
	public Color color;

	public Player(int x, int y, int w, int h, Color c) {
		this.y = y;
		this.x = x;
		this.width = w;
		this.height = h;
		this.color = c;
	}

	public Shape getShape() {
		return new Rectangle(x, y, width, height);
	}

	public Color getColor() {
		return color;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

}
