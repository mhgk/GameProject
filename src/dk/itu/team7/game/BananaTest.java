package dk.itu.team7.game;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BananaTest {

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
	public void testBanana() {
		Banana banana = new Banana(15, 16, 17, 18, Color.GREEN);
		int expectedX = 15;
		int actualX = banana.x;
		assertEquals(expectedX, actualX);

		int expectedY = 16;
		int actualY = banana.y;
		assertEquals(expectedY, actualY);

		int expectedW = 17;
		int actualW = banana.w;
		assertEquals(expectedW, actualW);

		int expectedH = 18;
		int actualH = banana.h;
		assertEquals(expectedH, actualH);

		Color expectedC = Color.GREEN;
		Color actualC = banana.c;
		assertEquals(expectedC, actualC);
		// fail("Not yet implemented");
	}

	@Test
	public void testPositionCalc() {
		Banana banana = new Banana(15, 16, 17, 18, Color.GREEN);
		banana.isBananaThrown = true;
		banana.updateBanana(100, 100);

		for (int i = 0; i < 1000; i++) {
			banana.positionCalc();
		}
		// fail("Not yet implemented");
	}

	@Test
	public void testUpdateBanana() {
		Banana banana = new Banana(15, 16, 17, 18, Color.GREEN);
		banana.updateBanana(10, 20);

		int expectedX = 10;
		int actualX = banana.x;
		assertEquals(expectedX, actualX);

		int expectedY = 20;
		int actualY = banana.y;
		assertEquals(expectedY, actualY);

		double expectedDoubleX = 10.0;
		double actualDoubleX = banana.doubleX;
		assertEquals(Double.doubleToLongBits(expectedDoubleX),
				Double.doubleToLongBits(actualDoubleX));

		double expectedDoubleY = 20.0;
		double actualDoubleY = banana.doubleY;
		assertEquals(Double.doubleToLongBits(expectedDoubleY),
				Double.doubleToLongBits(actualDoubleY));

		// fail("Not yet implemented");
	}

	@Test
	public void testGetY() {
		Banana banana = new Banana(15, 16, 17, 18, Color.GREEN);
		int expectedY = 16;
		int actualY = banana.getY();
		assertEquals(expectedY, actualY);
		// fail("Not yet implemented");
	}

	@Test
	public void testGetX() {
		Banana banana = new Banana(15, 16, 17, 18, Color.GREEN);
		int expectedX = 15;
		int actualX = banana.getX();
		assertEquals(expectedX, actualX);
		// fail("Not yet implemented");
	}

	@Test
	public void testGetShape() {
		Banana banana = new Banana(15, 16, 17, 18, Color.GREEN);
		Shape expectedS = new Rectangle(15, 16, 17, 18);
		Shape actualS = banana.getShape();
		assertEquals(expectedS, actualS);
		// fail("Not yet implemented");
	}

	@Test
	public void testGetColor() {
		Banana banana = new Banana(15, 16, 17, 18, Color.GREEN);
		Color expectedC = Color.GREEN;
		Color actualC = banana.getColor();
		assertEquals(expectedC, actualC);
		// fail("Not yet implemented");
	}

	@Test
	public void testSetBananaThrown() {
		Banana banana = new Banana(15, 16, 17, 18, Color.GREEN);
		banana.setBananaThrown(true);
		boolean expectedB = true;
		boolean actualB = banana.isBananaThrown;
		assertEquals(expectedB, actualB);
		// fail("Not yet implemented");
	}
}