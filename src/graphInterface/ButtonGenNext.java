package graphInterface;

/**
 * Klasa opisuje zachowanie i funkcjê przycisku Gen +1.
 * Przycisk po naciœniêciu wyœwietla nastêpn¹ generacjê.
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class ButtonGenNext extends Button {

	/**
	 * Konstruktor tworzy przycisk Gen +1 w po³o¿eniu okreœlonym wspó³rzêdnymi x i y.
	 * 
	 * @param x wspó³rzêdna x lewego górnego rogu przycisku
	 * @param y wspó³rzêdna y lewego górnego rogu przycisku
	 */
	public ButtonGenNext( int x, int y ) {
		super( x, y, "Gen +1" );
	}
	
	/**
	 * Metoda realizuje funkcjonalnoœæ przycisku Gen +1 (wyœwietla nastêpn¹ generacjê).
	 * 
	 * @param p zape³niany obszar planszy
	 */
	public void next ( PanelBoard p ) {
		p.b.nextGen();
		p.repaint();
	}
	
}
