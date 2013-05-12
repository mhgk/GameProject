package dk.itu.team7.game;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


//
// change access modifiers in Trajectory class when testing...
//

public class TrajectoryTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Test begin.");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test end.");
	}

	@Test
	public void testCalculateDegree() {
		
		// angle 0, velocity 0, wind 0
		Trajectory.setAngle(0);
		Trajectory.setVelocity(0);
		Trajectory.setwindFactor(0);
		Trajectory.calculateDegree(1);
		double expectedSpeed0 = 1;
		double actualSpeed0 = Trajectory.getX_speed();
		assertEquals(expectedSpeed0, actualSpeed0, 0.00001);
		
		// angle 90, velocity 0, wind 0
		Trajectory.setAngle(90);
		Trajectory.setVelocity(0);
		Trajectory.setwindFactor(0);
		Trajectory.calculateDegree(1);
		double expectedSpeed90 = 0;
		double actualSpeed90 = Trajectory.getX_speed();
		assertEquals(expectedSpeed90, actualSpeed90, 0.00001);

		// angle 90, velocity 0, wind 10
		Trajectory.setAngle(90);
		Trajectory.setVelocity(0);
		Trajectory.setwindFactor(10);
		Trajectory.calculateDegree(1);
		double expectedSpeed90Wind = 0.2;
		double actualSpeed90Wind = Trajectory.getX_speed();
		assertEquals(expectedSpeed90Wind, actualSpeed90Wind, 0.00001);
		
		// angle 45, velocity 0, wind 0
		Trajectory.setAngle(45);
		Trajectory.setVelocity(0);
		Trajectory.setwindFactor(0);
		Trajectory.calculateDegree(1);
		double expectedSpeed45 = 0.7071;
		double actualSpeed45 = Trajectory.getX_speed();
		assertEquals(expectedSpeed45, actualSpeed45, 0.00001);
		// fail("Not yet implemented");
	}

	@Test
	public void testProjectory() {
		Trajectory.setX_speed(1);
		Trajectory.setY_speed(-1);
		Trajectory.projectory(100, 100);
		
		double expX = 101;
		double actX = Trajectory.getInner_x();
		assertEquals(expX, actX, 0.00001);
		
		double expY = 99;
		double actY = Trajectory.getInner_y();
		assertEquals(expY, actY, 0.00001);
		// fail("Not yet implemented");
	}

	@Test
	public void testGetY() {
		Trajectory.setY(200.7);
		double expectedY = 200.7;
		double actualY = Trajectory.getY();
		assertEquals(Double.doubleToLongBits(expectedY),
				Double.doubleToLongBits(actualY));
		// fail("Not yet implemented");
	}

	@Test
	public void testSetY() {
		Trajectory.setY(300.4);
		double expectedY = 300.4;
		double actualY = Trajectory.getY();
		assertEquals(Double.doubleToLongBits(expectedY),
				Double.doubleToLongBits(actualY));
		// fail("Not yet implemented");
	}

	@Test
	public void testGetX() {
		Trajectory.setX(101.6);
		double expectedX = 101.6;
		double actualX = Trajectory.getX();
		assertEquals(Double.doubleToLongBits(expectedX),
				Double.doubleToLongBits(actualX));
		// fail("Not yet implemented");
	}

	@Test
	public void testSetX() {
		Trajectory.setX(100.5);
		double expectedX = 100.5;
		double actualX = Trajectory.getX();
		assertEquals(Double.doubleToLongBits(expectedX),
				Double.doubleToLongBits(actualX));
		// fail("Not yet implemented");
	}

	@Test
	public void testSetAngle() {
		Trajectory.setAngle(45);
		double expectedAng = 45;
		double actualAng = Trajectory.inputAngle;
		assertEquals(Double.doubleToLongBits(expectedAng),
				Double.doubleToLongBits(actualAng));
		// fail("Not yet implemented");
	}

	@Test
	public void testSetVelocity() {
		Trajectory.setVelocity(50);
		double expectedVel = 50;
		double actualVel = Trajectory.velocity;
		assertEquals(Double.doubleToLongBits(expectedVel),
				Double.doubleToLongBits(actualVel));
		// fail("Not yet implemented");
	}

	@Test
	public void testSetwindFactor() {
		Trajectory.setwindFactor(10);
		double expectedWF = 10;
		double actualWF = Trajectory.windFactor;
		assertEquals(Double.doubleToLongBits(expectedWF),
				Double.doubleToLongBits(actualWF));
		// fail("Not yet implemented");
	}
}