package graphInterface;

/**
 * Klasa opisuje zachowanie i funkcjê przycisku STOP.a
 * Przycisk po naciœniêciu zatrzymuje tworzenie kolejnych generacji na skutek uprzedniego naciœniêcia przycisku START.
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class ButtonStop extends Button {
	
	/**
	 * Konstruktor tworzy przycisk STOP w po³o¿eniu okreœlonym wspó³rzêdnymi x i y.
	 * 
	 * @param x wspó³rzêdna x lewego górnego rogu przycisku
	 * @param y wspó³rzêdna y lewego górnego rogu przycisku
	 */
	public ButtonStop( int x, int y ) {
		super( x, y, "STOP" );
	}
	
	/**
	 * Metoda realizuje funkcjonalnoœæ przycisku STOP (zatrzymuje tworzenie kolejnych generacji).
	 * 
	 * @param p panel z przyciskami i obszarem planszy
	 */
	public void stop (Panel p) {
		p.isPaused = true;
	}
	
}
