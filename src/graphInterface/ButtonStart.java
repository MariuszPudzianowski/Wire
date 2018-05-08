package graphInterface;

/**
 * Klasa opisuje zachowanie i funkcjê przycisku START.
 * Przycisk po naciœniêciu tworzy kolejne generacje a¿ do ostatniej generacji lub do naciœniêcia
 * przycisku STOP.
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class ButtonStart extends Button implements Runnable {
	
	Panel p;
	
	/**
	 * Konstruktor tworzy przycisk START w po³o¿eniu okreœlonym wspó³rzêdnymi x i y.
	 * 
	 * @param x wspó³rzêdna x lewego górnego rogu przycisku
	 * @param y wspó³rzêdna y lewego górnego rogu przycisku
	 */
	public ButtonStart( int x, int y ) {
		super( x, y, "START" );
	}
	
	/**
	 * Metoda tworzy i rozpoczyna lub wznawia w¹tek odpowiedzialny za ci¹g³¹ produkcjê generacji.
	 * 
	 * @param p panel z przyciskami i obszarem planszy
	 */
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
	
	/**
	 * Metoda realizuje tworzenie nowych generacji.
	 */
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
			try {
				Thread.sleep(500);
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
