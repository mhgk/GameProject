package dk.itu.team7.game.world;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FirstWorldTest {

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
	public void test() {
		//fail("Not yet implemented");
    	 
    	  FirstWorld NewFirst = new FirstWorld();
    	  
    	  int expResult = 2;
    	  
    	  int result = NewFirst.getLocations().size();
    	  
    	  assertEquals(expResult, result);
    	  
    	  
    			  
    	
    			  
    		
	}

}
