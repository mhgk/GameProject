package dk.itu.team7.game;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TrajectoryTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalculateDegree() {
//		fail("Not yet implemented");
	}

	@Test
	public void testProjectory() {
//		fail("Not yet implemented");
	}

	@Test
	public void testGetY() {
//		fail("Not yet implemented");
	}

	@Test
	public void testSetY() {
//		fail("Not yet implemented");
	}

	@Test
	public void testGetX() {
//		fail("Not yet implemented");
	}

	@Test
	public void testSetX() {
//		fail("Not yet implemented");
	}

	@Test
	public void testSetAngle() {
//		fail("Not yet implemented");
	}

	@Test
	public void testSetVelocity() {
//		fail("Not yet implemented");
	}

	@Test
	public void testSetwindFactor() {
		Trajectory.setwindFactor(10);
		double expectedWF = 10;
		double actualWF = Trajectory.windFactor;
		assertEquals(Double.doubleToLongBits(expectedWF), Double.doubleToLongBits(actualWF));
//		fail("Not yet implemented");
	}
}