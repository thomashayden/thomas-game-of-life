import java.util.ArrayList;

/**
 * A data type to hold the information for the locations of living cells
 * @author Thomas
 */
public class CellList {
	
	private ArrayList<Location> list = new ArrayList<Location>();
	
	public CellList(ArrayList<Location> list) {
		this.list = list;
	}
	
	/**
	 * Adds a cell to the list of living cells
	 * @param l
	 */
	public void addCell(Location l) {
		if(!list.contains(l)) {
			list.add(l);
		}
	}
	
	public void removeCell(Location l) {
		for(Location m : list) {
			if(m.getX() == l.getX() && m.getY() == l.getY()) {
				list.remove(m);
			}
		}
	}
	
	/**
	 * Returns if the given cell is living
	 * @param l the location of the cell in question
	 * @return if the given cell is living
	 */
	public boolean isLiving(Location l) {
		for(Location m : list) {
			if(m.getX() == l.getX() && m.getY() == l.getY()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns the full list of the locations of living cells
	 * @return the full list of the locations of living cells
	 */
	public ArrayList<Location> getList() {
		return list;
	}
	
	public boolean isLivingNextStep(Location l) {
		int livingNeighbors = 0;
		for(Location m : l.getNeighborLocations()) {
			livingNeighbors += isLiving(m) ? 1 : 0;
		}
		
		if(livingNeighbors == 3) {
			return true;
		} else if(livingNeighbors == 2 && isLiving(l)) {
			return true;
		}
		return false;
	}
	
}
