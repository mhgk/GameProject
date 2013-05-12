package dk.itu.team7.game;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CollisionControlTest {

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
	public void testSetParams() {
		SkylineMap skyline = new SkylineMap();

		CollisionControl collisionControl = new CollisionControl();

		skyline.createSkyline();

		Player player1 = new Player(skyline.houseWidth / 2,
				skyline.houseArray[0][1] - 40, 20, 40, Color.blue);
		Player player2 = new Player(skyline.screenWidth - skyline.houseWidth
				/ 2 - 20,
				skyline.houseArray[skyline.numberOfHouses - 1][1] - 40, 20, 40,
				Color.red);

		collisionControl.setParams(skyline.houseArray, skyline.houseWidth,
				skyline.houseHeight, player1.getX(), player1.getY(),
				player2.getX(), player2.getY());

		int[][] expArray = skyline.houseArray;
		int[][] actArray = collisionControl.houseArray;
		assertArrayEquals(expArray, actArray);

		int expHouseWidth = skyline.houseWidth;
		int actHouseWidth = collisionControl.houseWidth;
		assertEquals(expHouseWidth, actHouseWidth);

		int expHouseHeight = skyline.houseHeight;
		int actHouseHeight = collisionControl.houseHeight;
		assertEquals(expHouseHeight, actHouseHeight);

		int expPlayer1X = player1.getX();
		int actPlayer1X = collisionControl.player1x;
		assertEquals(expPlayer1X, actPlayer1X);

		int expPlayer1Y = player1.getY();
		int actPlayer1Y = collisionControl.player1y;
		assertEquals(expPlayer1Y, actPlayer1Y);

		int expPlayer2X = player2.getX();
		int actPlayer2X = collisionControl.player2x;
		assertEquals(expPlayer2X, actPlayer2X);

		int expPlayer2Y = player2.getY();
		int actPlayer2Y = collisionControl.player2y;
		assertEquals(expPlayer2Y, actPlayer2Y);
		// fail("Not yet implemented");
	}

	@Test
	public void testCollisionControl() {
		SkylineMap skyline = new SkylineMap();

		CollisionControl collisionControl = new CollisionControl();

		skyline.createSkyline();

		Trajectory.setwindFactor(Randomizer.windFactor());

		Player player1 = new Player(skyline.houseWidth / 2,
				skyline.houseArray[0][1] - 40, 20, 40, Color.blue);
		Player player2 = new Player(skyline.screenWidth - skyline.houseWidth
				/ 2 - 20,
				skyline.houseArray[skyline.numberOfHouses - 1][1] - 40, 20, 40,
				Color.red);
		Banana banana1 = new Banana(-16, -16, 15, 15, Color.YELLOW);

		collisionControl.setParams(skyline.houseArray, skyline.houseWidth,
				skyline.houseHeight, player1.getX(), player1.getY(),
				player2.getX(), player2.getY());

		// simulate player 1 hit
		banana1.updateBanana(collisionControl.player1x,
				collisionControl.player1y);
		int expectedResult2 = 2;
		int actualResult2 = collisionControl.collisionControl(banana1.getX(),
				banana1.getY(), banana1.getShape());
		assertEquals(expectedResult2, actualResult2);

		// simulate house hit (y = 750 is below top of skyline)
		banana1.updateBanana(100, 750);
		int expectedResult3 = 3;
		int actualResult3 = collisionControl.collisionControl(banana1.getX(),
				banana1.getY(), banana1.getShape());
		assertEquals(expectedResult3, actualResult3);

		// simulate out-of-bounds (-100 is outside the lower limit for x)
		banana1.updateBanana(-100, 100);
		int expectedResultLower4 = 4;
		int actualResultLower4 = collisionControl.collisionControl(
				banana1.getX(), banana1.getY(), banana1.getShape());
		assertEquals(expectedResultLower4, actualResultLower4);

		// simulate out-of-bounds (1400 is outside the upper limit for x)
		banana1.updateBanana(1400, 100);
		int expectedResultUpper4 = 4;
		int actualResultUpper4 = collisionControl.collisionControl(
				banana1.getX(), banana1.getY(), banana1.getShape());
		assertEquals(expectedResultUpper4, actualResultUpper4);
		// fail("Not yet implemented");
	}
}