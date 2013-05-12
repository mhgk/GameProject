package dk.itu.team7.game;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RandomizerTest {

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
	public void testRandomizer() {
		int[][] testArray = Randomizer.randomizer();
		int numberOfHouses = testArray[0][0];
		boolean condition1 = testArray.length == numberOfHouses;
		boolean condition2 = testArray[0].length == 2;
		assertTrue(condition1);
		assertTrue(condition2);
//		fail("Not yet implemented");
	}

	@Test
	public void testRandomNumberOfHouses() {
		int numberOfHouses = Randomizer.randomNumberOfHouses();
		boolean condition = numberOfHouses >= 8 && numberOfHouses <= 12;
		assertTrue(condition);
//		fail("Not yet implemented");
	}

	@Test
	public void testRandomHouseY() {
		int houseY = Randomizer.randomHouseY();
		boolean condition = houseY >= 350 && houseY <= 700;
		assertTrue(condition);
//		fail("Not yet implemented");
	}

	@Test
	public void testWindFactor() {
		double wF = Randomizer.windFactor();
		boolean condition = wF >= -10 && wF <= 10;
		assertTrue(condition);
//		fail("Not yet implemented");
	}
}