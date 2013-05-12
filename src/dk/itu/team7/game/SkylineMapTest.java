package dk.itu.team7.game;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Shape;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SkylineMapTest {

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
	public void testCreateSkyline() {
		SkylineMap skyline = new SkylineMap();
		int[][] testArray = skyline.createSkyline();
		
		int numberOfHouses = skyline.numberOfHouses;
		boolean numberCondition1 = numberOfHouses >= 8 && numberOfHouses <= 12;
		assertTrue(numberCondition1);
		
		int houseWidth = skyline.houseWidth;
		boolean widthCondition = houseWidth >= (1366/12) && houseWidth <= (1366/8);
		assertTrue(widthCondition);

		boolean arrayCondition1 = testArray.length == numberOfHouses;
		assertTrue(arrayCondition1);
		boolean arrayCondition2 = testArray[0].length == 2;
		assertTrue(arrayCondition2);
//		fail("Not yet implemented");
	}

	@Test
	public void testGetShape() {
		SkylineMap skyline = new SkylineMap();
		skyline.createSkyline();
		Shape expectedS = skyline.getShape();
		assertNotNull(expectedS);
//		fail("Not yet implemented");
	}

	@Test
	public void testGetColor() {
		SkylineMap skyline = new SkylineMap();
		Color expectedC = Color.BLACK;
		Color actualC = skyline.getColor();
		assertEquals(expectedC, actualC);
//		fail("Not yet implemented");
	}
}