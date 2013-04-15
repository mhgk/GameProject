package dk.itu.team7.game;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CanasaisLocationTest {

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
		System.out.println("Test finished");
	}

	@Test
	public void TestCanasaisLocation() {
		
		CanasaisLocation NewCanasais = new CanasaisLocation();
		String expResult = "I am happy because I am skiing";
		
		String result = NewCanasais.getDescription(); 
		
		assertEquals(expResult, result); 
		
		
	}

}
