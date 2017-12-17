import java.util.ArrayList;

/**
 * A data type to hold the information for the locations of living cells
 * @author Thomas
 */
public class CellList {
	
	private ArrayList<Location> list = new ArrayList<Location>();
	
	/**
	 * Adds a cell to the list of living cells
	 * @param l
	 */
	public void addCell(Location l) {
		if(!list.contains(l)) {
			list.add(l);
		}
	}
	
	/**
	 * Returns if the given cell is living
	 * @param l the location of the cell in question
	 * @return if the given cell is living
	 */
	public boolean isLiving(Location l) {
		return list.contains(l);
	}
	
}
