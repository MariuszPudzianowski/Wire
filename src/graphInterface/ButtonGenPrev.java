package graphInterface;

import Wire.*;

/**
 * Klasa opisuje zachowanie i funkcjê przycisku Gen -1.
 * Przycisk po naciœniêciu wyœwietla poprzedni¹ generacjê.
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class ButtonGenPrev extends Button {

	/**
	 * Konstruktor tworzy przycisk Gen -1 w po³o¿eniu okreœlonym wspó³rzêdnymi x i y.
	 * 
	 * @param x wspó³rzêdna x lewego górnego rogu przycisku
	 * @param y wspó³rzêdna y lewego górnego rogu przycisku
	 */
	public ButtonGenPrev( int x, int y ) {
		super( x, y, "Gen -1" );
	}
	
	/**
	 * Metoda realizuje funkcjonalnoœæ przycisku Gen -1 (wyœwietla poprzedni¹ generacjê).
	 * 
	 * @param p zape³niany obszar planszy
	 * @param g bie¿¹ca generacja
	 */
	public void prev ( PanelBoard p, int g ) {
		Board newBoard = new Board( p.b.getSize(), InOut.readParameters( p.b.source, 1 ), p.b.source );
		InOut.readObjects( p.b.source, newBoard, 1 );

		p.b = newBoard;
		
		for( int i=1; i<g-1; i++) {
			p.b.nextGen();
		}
		p.repaint();
	}
	
}
