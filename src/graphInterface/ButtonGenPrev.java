package graphInterface;

import Wire.*;

/**
 * Klasa opisuje zachowanie i funkcj� przycisku Gen -1.
 * Przycisk po naci�ni�ciu wy�wietla poprzedni� generacj�.
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class ButtonGenPrev extends Button {

	/**
	 * Konstruktor tworzy przycisk Gen -1 w po�o�eniu okre�lonym wsp�rz�dnymi x i y.
	 * 
	 * @param x wsp�rz�dna x lewego g�rnego rogu przycisku
	 * @param y wsp�rz�dna y lewego g�rnego rogu przycisku
	 */
	public ButtonGenPrev( int x, int y ) {
		super( x, y, "Gen -1" );
	}
	
	/**
	 * Metoda realizuje funkcjonalno�� przycisku Gen -1 (wy�wietla poprzedni� generacj�).
	 * 
	 * @param p zape�niany obszar planszy
	 * @param g bie��ca generacja
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
