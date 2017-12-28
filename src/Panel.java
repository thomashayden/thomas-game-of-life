import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel extends JPanel implements MouseListener {
	
	int CELL_SIZE = 10;
	
	private Board bd;
	
	public Panel() {
    	bd = new Board(new CellList(new ArrayList<Location>()));
		
    	addMouseListener(this);
    	
		setLayout(null);
		JButton step = new JButton("Step");
		step.addActionListener(bd);
		step.setLocation(50, Information.GRID_HEIGHT);
		step.setSize(100,50);
		this.add(step);
		
		JButton run = new JButton("Run");
		run.addActionListener(bd);
		run.setLocation(200, Information.GRID_HEIGHT);
		run.setSize(100, 50);
		run.setEnabled(false); // Currently not supported
		this.add(run);
		
		JButton stop = new JButton("Stop");
		stop.addActionListener(bd);
		stop.setLocation(350, Information.GRID_HEIGHT);
		stop.setSize(100, 50);
		stop.setEnabled(false); // Currently not supported
		this.add(stop);
		
		JButton clear = new JButton("Clear");
		clear.addActionListener(bd);
		clear.setLocation(500, Information.GRID_HEIGHT);
		clear.setSize(100, 50);
		this.add(clear);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		drawGrid(g);
		drawCells(g);
		drawControls(g);
	}
	
	public void drawControls(Graphics g) {
		
	}
	
	public void drawCells(Graphics g) {
		// Draw the cells
		for(Dimension d : bd.getCellListPixelLocations()) {
			drawRect(g, d.getWidth(), d.getHeight(), Information.GRID_SIZE, Information.GRID_SIZE, true);
		}
	}
	
	/**
	 * Draws the grid of the board, without any cells
	 * @param g the Graphics object to draw with
	 */
	public void drawGrid(Graphics g) {
		double gridWidth = Information.GRID_WIDTH;
		double gridHeight = Information.GRID_HEIGHT;
		double startX = 0 % Information.GRID_SIZE;
		double startY = 0 % Information.GRID_SIZE;
		
		// Iterate over the vertical lines
		for(double i = startX; i < gridWidth; i += Information.GRID_SIZE) {
			drawLine(g, i, 0, i, gridHeight);
		}
		// Iterate over the horizontal lines
		for(double i = startY; i < gridHeight; i += Information.GRID_SIZE) {
			drawLine(g, 0, i, gridWidth, i);
		}
	}
	
	public void drawRect(Graphics g, double x, double y, double width, double height, boolean fill) {
		if(fill) {
			g.fillRect((int) x, (int) y, (int) width, (int) height);
		} else {
			g.drawRect((int) x, (int) y, (int) width, (int) height);
		}
	}
	
	public void drawLine(Graphics g, double x1, double y1, double x2, double y2) {
		g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
	}
	
	private void drawText(Graphics g, String text, int x, int y) {
		g.drawString(text, x, y);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		this.bd.onClick(arg0);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) { }

	@Override
	public void mouseExited(MouseEvent arg0) { }

	@Override
	public void mousePressed(MouseEvent arg0) { }

	@Override
	public void mouseReleased(MouseEvent arg0) { }
}
