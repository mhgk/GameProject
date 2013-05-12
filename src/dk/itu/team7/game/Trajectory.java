package dk.itu.team7.game;

public class Trajectory {

	public static double windFactor;
	public static double velocity;
	public static double inputAngle;
	private static double degreeToRadian;
	private static double x_speed;

	// x_speed = ((1 + velocity * 0.02) + (windFactor * 0.01)) *
	// Math.cos(degreeToRadian);

	private static double y_speed;
	// y_speed = -(1 + velocity * 0.02) * Math.sin(degreeToRadian);

	// private static double degreeToRadian = (inputAngle / 360) * (2 *
	// Math.PI);

	// private double y_speed = -2 * (((((45 - input)*1.11111))/100)+1);

	private static double g = 0.004;
	private	static double inner_x;
	private	static double inner_y;
	private static double x;
	private static double y;

	public static void calculateDegree(int direction) {
		degreeToRadian = (inputAngle / 360) * (2 * Math.PI);

		x_speed = (direction * (1 + velocity * 0.02) * Math.cos(degreeToRadian))
				+ (windFactor * 0.02);
		y_speed = -(1 + velocity * 0.02) * Math.sin(degreeToRadian);

	}

	public static void projectory(double x, double y) {

		inner_x = x;

		inner_y = y;

		inner_x += x_speed;

		inner_y += y_speed;

		y_speed += g;

		setX(inner_x);

		setY(inner_y);

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

	public static void setAngle(double value) {

		inputAngle = value;
	}

	public static void setVelocity(double value) {

		velocity = value;
	}

	public static void setwindFactor(double value) {

		windFactor = value;
	}

	// the following getters are only used in TrajectoryTest
	public static double getX_speed() {
		return x_speed;
	}

	public static void setX_speed(double x_speed) {
		Trajectory.x_speed = x_speed;
	}

	public static void setY_speed(double y_speed) {
		Trajectory.y_speed = y_speed;
	}

	public static double getInner_x() {
		return inner_x;
	}

	public static double getInner_y() {
		return inner_y;
	}
}