import java.awt.Dimension;
import java.util.ArrayList;

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
	
	public Dimension getCellLocation() {
		return new Dimension(getX() * Information.GRID_SIZE, getY() * Information.GRID_SIZE);
	}
	
	public ArrayList<Location> getNeighborLocations() {
		ArrayList<Location> relLoc = new ArrayList<Location>();
		relLoc.add(new Location(this.getX()-1, this.getY()-1));
		relLoc.add(new Location(this.getX()-1, this.getY()));
		relLoc.add(new Location(this.getX()-1, this.getY()+1));
		relLoc.add(new Location(this.getX(), this.getY()-1));
		relLoc.add(new Location(this.getX(), this.getY()+1));
		relLoc.add(new Location(this.getX()+1, this.getY()-1));
		relLoc.add(new Location(this.getX()+1, this.getY()));
		relLoc.add(new Location(this.getX()+1, this.getY()+1));
		return relLoc;
	}
	
	public String toString() {
		return "(" + getX() + ", " + getY() + ")";
	}
}
