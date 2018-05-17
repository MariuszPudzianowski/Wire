package graphInterface;

/**
 * Klasa opisuje zachowanie i funkcj� przycisku START.a
 * Przycisk po naci�ni�ciu tworzy kolejne generacje a� do ostatniej generacji lub do naci�ni�cia
 * przycisku STOP.
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class ButtonStart extends Button implements Runnable {
	
	private Panel p;
	
	/**
	 * Konstruktor tworzy przycisk START w po�o�eniu okre�lonym wsp�rz�dnymi x i y.
	 * 
	 * @param x wsp�rz�dna x lewego g�rnego rogu przycisku
	 * @param y wsp�rz�dna y lewego g�rnego rogu przycisku
	 */
	public ButtonStart( int x, int y ) {
		super( x, y, "START" );
	}
	
	/**
	 * Metoda tworzy i rozpoczyna lub wznawia w�tek odpowiedzialny za ci�g�� produkcj� generacji.
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
		while (p.g < p.panelBoard.b.gen) {
			while (p.isPaused == true) {
				synchronized (this) {
					try {
						wait();
					} catch (InterruptedException e) {
						// DO NOTHING
					}
				}
			}
			p.panelBoard.b.nextGen();
			p.panelBoard.repaint();
			p.g++;
			try {
				Thread.sleep(300);
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
