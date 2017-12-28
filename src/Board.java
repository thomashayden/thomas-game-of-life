import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Board implements ActionListener {
	
	private CellList cl;
	private Dimension offset;
	
	public Board(CellList cl) {
		this.cl = cl;
		this.offset = new Dimension(0,0);
	}
	
	/**
	 * Returns the board's CellList
	 * @return the board's CellList
	 */
	public CellList getCellList() {
		return cl;
	}
	
	/**
	 * Sets the board's CellList to the given CellList
	 * @param cl the new CellList
	 */
	public void setCellList(CellList cl) {
		this.cl = cl;
	}
	
	public ArrayList<Dimension> getCellListPixelLocations() {
		ArrayList<Dimension> locations = new ArrayList<Dimension>();
		for(Location l : cl.getList()) {
			locations.add(new Dimension((int) (l.getCellLocation().getWidth() + offset.getWidth()),
										(int) (l.getCellLocation().getHeight() + offset.getHeight())));
		}
		return locations;
	}
	
	private boolean containsLocation(ArrayList<Location> arrList, Location l) {
		for(Location m : arrList) {
			if(m.getX() == l.getX() && m.getY() == l.getY()) {
				return true;
			}
		}
		return false;
	}
	
	public void step() {
		System.out.println("Running a Step");
		ArrayList<Location> newCellList = new ArrayList<Location>();
		ArrayList<Location> locationsToCheck = new ArrayList<Location>();
		for(Location l : cl.getList()) {
			if(!locationsToCheck.contains(l)) {
				locationsToCheck.add(l);
			}
			for(Location m : l.getNeighborLocations()) {
				if(!locationsToCheck.contains(m)) {
					locationsToCheck.add(m);
				}
			}
		}
		System.err.println(cl.getList().size());
		System.err.println(locationsToCheck.size());
		for(Location l : locationsToCheck) {
			if(cl.isLivingNextStep(l)) {
				if(!containsLocation(newCellList, l)) {
					newCellList.add(l);
				}
			}
		}
		setCellList(new CellList(newCellList));
		System.out.println("Step Run");
	}

	public void run() {
		System.out.println("Doing whatever is running");
	}
	
	public void stop() {
		System.out.println("Doing whatever is stopping");
	}
	
	public void clear() {
		setCellList(new CellList(new ArrayList<Location>()));
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		String command = evt.getActionCommand();
		System.out.println(command);
		if(command.equals("Step")) {
			step();
		} else if(command.equals("Run")) {
			run();
		} else if(command.equals("Stop")) {
			stop();
		} else if(command.equals("Clear")) {
			clear();
		} else {
			System.err.println("ActionCommand not found!");
		}
	}
	
	public void onClick(MouseEvent me) {
		System.out.println("Click detected");
		int x = me.getX();
		int y = me.getY();
		if(me.getButton() == MouseEvent.BUTTON1) {
			if(x > 0 && x < Information.GRID_WIDTH && y > 0 && y < Information.GRID_HEIGHT) {
				cl.addCell(new Location(x / Information.GRID_SIZE, y / Information.GRID_SIZE));
			}
		} else if(me.getButton() == MouseEvent.BUTTON3) {
			if(x > 0 && x < Information.GRID_WIDTH && y > 0 && y < Information.GRID_HEIGHT) {
				cl.removeCell(new Location(x / Information.GRID_SIZE, y / Information.GRID_SIZE));
			}
		}
	}
}
