package dk.itu.team7.game;

/**
 * This class calculates the trajectory for banana.
 * 
 * @author Team 7: Mads Gade & Rene A. Nielsen
 * @version 1.0
 */

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
	private static double inner_x;
	private static double inner_y;
	private static double x;
	private static double y;

	/**
	 * This method calculates the x_speed and y_speed, with the use of following
	 * variables: inputAngle, velocity & windFactor.
	 * 
	 * @param direction
	 *            determines which direction the banana flies.
	 *            <p>
	 *            1 = from left to right.
	 *            <p>
	 *            -1 = from right to left.
	 */

	public static void calculateDegree(int direction) {
		degreeToRadian = (inputAngle / 360) * (2 * Math.PI);

		x_speed = (direction * (1 + velocity * 0.02) * Math.cos(degreeToRadian))
				+ (windFactor * 0.02);
		y_speed = -(1 + velocity * 0.02) * Math.sin(degreeToRadian);

	}

	/**
	 * This method changes the trajectory of the banana by adding x_speed to x
	 * and y_speed to y. Furthermore gravity g is also added to y_speed to give
	 * the banana a downward direction (over time).
	 * 
	 * @param x
	 *            current X position of banana
	 * @param y
	 *            current Y position of banana
	 */

	public static void projectory(double x, double y) {

		inner_x = x;

		inner_y = y;

		inner_x += x_speed;

		inner_y += y_speed;

		y_speed += g;

		setX(inner_x);

		setY(inner_y);

	}

	/**
	 * This returns the Y position.
	 * 
	 * @return a double describing the current Y position.
	 */

	public static double getY() {

		return y;
	}

	/**
	 * This sets the Y position to the specified value.
	 * 
	 * @param value
	 *            specified value used to set Y position.
	 */

	public static void setY(double value) {

		y = value;
	}

	/**
	 * This returns the X position.
	 * 
	 * @return a double describing the current X position.
	 */

	public static double getX() {

		return x;
	}

	/**
	 * This sets the X position to the specified value.
	 * 
	 * @param value
	 *            specified value used to set X position.
	 */

	public static void setX(double value) {

		x = value;
	}

	/**
	 * This sets the angle used when calculating speeds.
	 * 
	 * @param value
	 *            specified value used to set angle.
	 */

	public static void setAngle(double value) {

		inputAngle = value;
	}

	/**
	 * This sets the velocity used when calculating speeds.
	 * 
	 * @param value
	 *            specified value used to set velocity.
	 */

	public static void setVelocity(double value) {

		velocity = value;
	}

	/**
	 * This sets the wind factor used when calculating speeds.
	 * 
	 * @param value
	 *            specified value used to set wind factor.
	 */

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