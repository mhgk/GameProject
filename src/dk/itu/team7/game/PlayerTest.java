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

public class PlayerTest {

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
	public void testPlayer() {
		Player player = new Player(15, 16, 17, 18, Color.GREEN);
		int expectedX = 15;
		int actualX = player.x;
		assertEquals(expectedX, actualX);
		
		int expectedY = 16;
		int actualY = player.y;
		assertEquals(expectedY, actualY);
		
		int expectedW = 17;
		int actualW = player.w;
		assertEquals(expectedW, actualW);
		
		int expectedH = 18;
		int actualH = player.h;
		assertEquals(expectedH, actualH);
		
		Color expectedC = Color.GREEN;
		Color actualC = player.c;
		assertEquals(expectedC, actualC);
//		fail("Not yet implemented");
	}

	@Test
	public void testGetShape() {
		Player player = new Player(15, 16, 17, 18, Color.GREEN);
		Shape expectedS = new Rectangle(15, 16, 17, 18);
		Shape actualS = player.getShape();
		assertEquals(expectedS, actualS);
//		fail("Not yet implemented");
	}

	@Test
	public void testGetColor() {
		Player player = new Player(15, 16, 17, 18, Color.GREEN);
		Color expectedC = Color.GREEN;
		Color actualC = player.getColor();
		assertEquals(expectedC, actualC);
//		fail("Not yet implemented");
	}

	@Test
	public void testGetY() {
		Player player = new Player(15, 16, 17, 18, Color.GREEN);
		int expectedY = 16;
		int actualY = player.getY();
		assertEquals(expectedY, actualY);
//		fail("Not yet implemented");
	}

	@Test
	public void testGetX() {
		Player player = new Player(15, 16, 17, 18, Color.GREEN);
		int expectedX = 15;
		int actualX = player.getX();
		assertEquals(expectedX, actualX);
//		fail("Not yet implemented");
	}
}