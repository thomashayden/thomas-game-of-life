/**
 * A data type that represents the location of a cell given
 * it's x and y coordinates. Based on the grid, not pixel locations
 * @author Thomas
 */
public class Location {
	
	private int x;
	private int y;
	
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
}
