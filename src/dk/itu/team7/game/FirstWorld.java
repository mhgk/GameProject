package dk.itu.team7.game;

import java.util.ArrayList;
import java.util.List;

public class FirstWorld implements World {

	List<Location> myLocations = new ArrayList<Location>();
	
	public FirstWorld () { 
		myLocations.add(new SunnyBeachLocation());
		myLocations.add(new CanasaisLocation());
		
	}
	
	
	@Override
	public List<Location> getLocations() {
		// TODO Auto-generated method stub
		return myLocations;
	}

}
