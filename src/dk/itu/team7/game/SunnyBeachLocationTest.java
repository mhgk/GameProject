package dk.itu.team7.game;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SunnyBeachLocationTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Test begins");
	}

	@After
	public void tearDown() throws Exception {
	System.out.println("test finished");}

	@Test
	public void testSunnyBeach() {
		//fail("Not yet implemented");
		
		SunnyBeachLocation NewSunny = new SunnyBeachLocation();
	
		String expResult = "I am happy, the sun is shining";
		
		String Result = NewSunny.getDescription();
		
		assertEquals(expResult, Result);
	}

}
