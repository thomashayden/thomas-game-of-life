import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.JPanel;

public class Panel extends JPanel {
	
	int CELL_SIZE = 10;
	
	CellList cl;
	
	public Panel() {
		cl = new CellList();
	}
	
	/**
	 * Updates this class's cl to the given cl
	 * @param cl the new CellList
	 */
	public void updateCellList(CellList cl) {
		this.cl = cl;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
		
		// Draw the grid
		
		// Draw the cells
	}
	
	public void drawRect(Graphics g, double x, double y, double width, double height, boolean fill) {
		if(fill) {
			g.fillRect((int) x, (int) y, (int) width, (int) height);
		} else {
			g.drawRect((int) x, (int) y, (int) width, (int) height);
		}
	}
	
	private void drawText(Graphics g, String text, int x, int y) {
		g.drawString(text, x, y);
	}
}
