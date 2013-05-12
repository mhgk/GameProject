package dk.itu.team7.game;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BoardTest {

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
	public void testGetCounterP1() {
		Board.counterP1 = 4;
		int expCountP1 = 4;
		int actCountP1 = Board.getCounterP1();
		assertEquals(expCountP1, actCountP1);
		// fail("Not yet implemented");
	}

	@Test
	public void testGetCounterP2() {
		Board.counterP2 = 5;
		int expCountP2 = 5;
		int actCountP2 = Board.getCounterP2();
		assertEquals(expCountP2, actCountP2);
		// fail("Not yet implemented");
	}

	@Test
	public void testSetBanana1() {
		Board board = new Board();
		board.setBanana1(true);
		boolean expBool = true;
		boolean actBool = board.isBanana1;
		assertEquals(expBool, actBool);
		// fail("Not yet implemented");
	}

	@Test
	public void testSetBanana2() {
		Board board = new Board();
		board.setBanana2(true);
		boolean expBool = true;
		boolean actBool = board.isBanana2;
		assertEquals(expBool, actBool);
		// fail("Not yet implemented");
	}

}
