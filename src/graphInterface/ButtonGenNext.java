package graphInterface;

/**
 * Klasa opisuje zachowanie i funkcję przycisku Gen +1.a
 * Przycisk po naciśnięciu wyświetla następną generację.
 *
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class ButtonGenNext extends Button {

	/**
	 * Konstruktor tworzy przycisk Gen +1 w położeniu określonym współrzędnymi x i y.
	 * 
	 * @param x współrzędna x lewego górnego rogu przycisku
	 * @param y współrzędna y lewego górnego rogu przycisku
	 */
	public ButtonGenNext( int x, int y ) {
		super( x, y, "Gen +1" );
	}
	
	/**
	 * Metoda realizuje funkcjonalność przycisku Gen +1 (wyświetla następną generację).
	 * 
	 * @param p zapełniany obszar planszy
	 */
	public void next ( PanelBoard p ) {
		p.b.nextGen();
		p.repaint();
	}
	
}
