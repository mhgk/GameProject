package dk.itu.team7.game;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;

public class Banana {

	private double doubleX;
	private double doubleY;
	public boolean visible = false;

	private int x;
	private int y;
	private int w;
	private int h;
	private Color color;

	public Banana(int x, int y, int w, int h, Color color) {
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
		this.color = color;
	}

	public void positionCalc() {

		if (visible) {

			Trajectory.projectory(doubleX, doubleY);

			doubleX = Trajectory.getX();
			doubleY = Trajectory.getY();

			y = (int) Math.round(doubleY);
			x = (int) Math.round(doubleX);
		}
	}

	public void updateBanana(int x, int y) {

		this.x = x;
		this.y = y;
		this.doubleX = x;
		this.doubleY = y;

	}

	public int getY() {

		return y;
	}

	public int getX() {

		return x;
	}

	public Shape getShape() {
		return new Rectangle(x, y, w, h);
	}

	public Color getColor() {
		return color;
	}

}
