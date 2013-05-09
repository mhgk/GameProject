package dk.itu.team7.game;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;

public class Player {
	// this class defines what parameters we want to have on the players. Also
	// we define what movement they can make.

	public int x;
	public int y;
	public int w;
	public int h;
	public Color c;

	public Player(int x, int y, int w, int h, Color c) {
		this.y = y;
		this.x = x;
		this.w = w;
		this.h = h;
		this.c = c;
	}

	public Shape getShape() {
		return new Rectangle(x, y, w, h);
	}

	public Color getColor() {
		return c;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

}
