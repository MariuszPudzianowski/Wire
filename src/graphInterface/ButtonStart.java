package graphInterface;

public class ButtonStart extends Button implements Runnable {
	Panel p;

	public ButtonStart( int x, int y ) {
		super( x, y, "START" );
	}
	
	public synchronized void start (Panel p) {
		this.p = p;
		if (p.isRunning == false) {
			p.isRunning = true;
			p.isPaused = false;
			Thread t = new Thread(this);
			t.start();
		} else if (p.isPaused == true){
			p.isPaused = false;
			notify();
		}
	}
	
	@Override
	public void run() {
		while (p.g < p.board.b.gen) {
			while (p.isPaused == true) {
				synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
					// DO NOTHING
				}
				}
			}
			p.board.b.nextGen();
			p.board.repaint();
			p.g++;
			System.out.println("start " + p.g);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// DO NOTHING
			}
		}
		
		p.stop.setEnabled( false );
		p.genNext.setEnabled( false );
		p.genPrev.setEnabled( true );
		p.fileL.setEnabled( true );
		p.fileS.setEnabled( true );
		p.confO.setEnabled( true );
		p.confL.setEnabled( true );
		p.isRunning = false;
		p.isPaused = true;
	}

}
