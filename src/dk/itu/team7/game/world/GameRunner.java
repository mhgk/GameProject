package dk.itu.team7.game.world;

import java.util.List;

import dk.itu.team7.game.world.Location.Direction;

public class GameRunner {
	
	
	public static void main(String[] args) {
		
		FirstWorld FW = new FirstWorld();
				List<Location> myLocations = FW.getLocations();
				
				for (Location giveMeALocationOneAtATime : myLocations) {
					System.out.println("Fancy for loop " + giveMeALocationOneAtATime.getDescription());
				}
				
				for (Direction theNextDirection : Direction.values()) {
					System.out.println(theNextDirection);
				}
		
		
	}

}
