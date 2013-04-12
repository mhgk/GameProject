package dk.itu.team7.game.world;

	import java.util.List;

	public interface Location {
		
		public enum Direction {east, north, south, west, up, down };
		
		List<Location> getExits(Direction direction);
		
		String getDescription();

}
