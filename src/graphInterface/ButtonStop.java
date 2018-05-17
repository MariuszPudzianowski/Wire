package graphInterface;

/**
 * Klasa opisuje zachowanie i funkcj� przycisku STOP.a
 * Przycisk po naci�ni�ciu zatrzymuje tworzenie kolejnych generacji na skutek uprzedniego naci�ni�cia przycisku START.
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class ButtonStop extends Button {
	
	/**
	 * Konstruktor tworzy przycisk STOP w po�o�eniu okre�lonym wsp�rz�dnymi x i y.
	 * 
	 * @param x wsp�rz�dna x lewego g�rnego rogu przycisku
	 * @param y wsp�rz�dna y lewego g�rnego rogu przycisku
	 */
	public ButtonStop( int x, int y ) {
		super( x, y, "STOP" );
	}
	
	/**
	 * Metoda realizuje funkcjonalno�� przycisku STOP (zatrzymuje tworzenie kolejnych generacji).
	 * 
	 * @param p panel z przyciskami i obszarem planszy
	 */
	public void stop (Panel p) {
		p.isPaused = true;
	}
	
}
