
public class GameLoop implements Runnable {

	int FRAMES_PER_SECOND = 30;
    int SKIP_TICKS = 1000 / FRAMES_PER_SECOND;
    long nextGameTick = System.currentTimeMillis();
    int sleepTime = 0;
	
	long lastTime = System.currentTimeMillis();
    int frameCount;
    int actualFPS = FRAMES_PER_SECOND;
	
    Window window;
    CellList cl;
    
    public GameLoop(Window ex) {
    	window = ex;
    	init();
    }
    
    public void init() {
    	cl = new CellList();
    }
    
	@Override
	public void run() {
		while(true) {
			if(System.currentTimeMillis() - lastTime >= 1000) {
				window.setTitle("Application | FPS: " + frameCount);
				lastTime = System.currentTimeMillis();
				frameCount = 0;
			}
			frameCount++;
			
			update();
			draw();
			
			nextGameTick += SKIP_TICKS;
	        sleepTime = (int) (nextGameTick - System.currentTimeMillis());
	        if( sleepTime >= 0 ) {
	            try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	        }
	        else {
	            System.err.println("Game running behind!");
	        }
		}
	}
	
	public void update() {
		
		// Update the cell list as the last step before drawing
		window.updateCellList(cl);
	}
	
	public void draw() {
		window.repaint();
	}

}
