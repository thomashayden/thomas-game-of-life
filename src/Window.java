import java.awt.EventQueue;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	static private Window ex;
	private Panel p = new Panel();
	
	public Window() {
		add(p);
		
		setTitle("Thomas's Game of Life");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public void updateCellList(CellList cl) {
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ex = new Window();
				ex.setResizable(false);
				ex.setVisible(true);
				(new Thread(new GameLoop(ex))).start();
			}
		});
	}
	
}
