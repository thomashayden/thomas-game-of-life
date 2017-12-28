import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	static private Window ex;
	private Panel p = new Panel();
	
	public Window() {
		p.setPreferredSize(new Dimension(Information.DEFAULT_WINDOW_WIDTH, Information.DEFAULT_WINDOW_HEIGHT));
		add(p);
		pack();
		
		setTitle("Thomas's Game of Life");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
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
