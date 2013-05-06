package dk.itu.team7.game;

public class Trajectory {

	private static double windFactor = -30;
	private static double velocity = 50;
	private static double inputAngle = 65;
	private static double degreeToRadian = (inputAngle / 360) * (2 * Math.PI);
	// private double y_speed = -2 * (((((45 - input)*1.11111))/100)+1);
	private static double x_speed = ((1 + velocity * 0.02) + (windFactor * 0.01))
			* Math.cos(degreeToRadian);
	private static double y_speed = -(1 + velocity * 0.02)
			* Math.sin(degreeToRadian);
	private static double g = 0.004;
	private static double inner_x;
	private static double inner_y;
	private static double x;
	private static double y;

	// public boolean visible = false;

	public static void projectory(double x, double y) {

		inner_x = x;

		inner_y = y;

		inner_x += x_speed;

		inner_y += y_speed;

		y_speed += g;

		setX(inner_x);

		setY(inner_y);

		// CollisionControl.collisionControl(double x, double y);

		if (x < 0 || x > 1400 || y < -800) {

			y_speed = -(1 + velocity * 0.02) * Math.sin(degreeToRadian);

			// this.visible = false;
		}
	}

	public static double getY() {

		return y;
	}

	public static void setY(double value) {

		y = value;
	}

	public static double getX() {

		return x;
	}

	public static void setX(double value) {

		x = value;
	}

}
