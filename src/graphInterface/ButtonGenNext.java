package graphInterface;

/**
 * Klasa opisuje zachowanie i funkcj� przycisku Gen +1.
 * Przycisk po naci�ni�ciu wy�wietla nast�pn� generacj�.
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class ButtonGenNext extends Button {

	/**
	 * Konstruktor tworzy przycisk Gen +1 w po�o�eniu okre�lonym wsp�rz�dnymi x i y.
	 * 
	 * @param x wsp�rz�dna x lewego g�rnego rogu przycisku
	 * @param y wsp�rz�dna y lewego g�rnego rogu przycisku
	 */
	public ButtonGenNext( int x, int y ) {
		super( x, y, "Gen +1" );
	}
	
	/**
	 * Metoda realizuje funkcjonalno�� przycisku Gen +1 (wy�wietla nast�pn� generacj�).
	 * 
	 * @param p zape�niany obszar planszy
	 */
	public void next ( PanelBoard p ) {
		p.b.nextGen();
		p.repaint();
	}
	
}
