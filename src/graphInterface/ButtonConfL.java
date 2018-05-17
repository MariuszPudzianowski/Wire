package graphInterface;

import Wire.*;
import java.io.File;

/**
 * Klasa opisuje zachowanie i funkcjê przycisku Load conf.
 * Przycisk po naciœniêciu wczytuje generacjê z pliku konfiguracyjnego zapisanego pod sta³¹ œcie¿k¹.
 * Plik konfiguracyjny powinien byæ zapisany w folderze "config" pod nazw¹ "board.txt"
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class ButtonConfL extends Button {

	/**
	 * Konstruktor tworzy przycisk Load conf. w po³o¿eniu okreœlonym wspó³rzêdnymi x i y.
	 * 
	 * @param x wspó³rzêdna x lewego górnego rogu przycisku
	 * @param y wspó³rzêdna y lewego górnego rogu przycisku
	 */
	public ButtonConfL( int x, int y ) {
		super( x, y, "Load conf." );
	}
	
	/**
	 * Metoda realizuje funkcjonalnoœæ przycisku Load conf. (wczytuje generacjê z pliku konfiguracyjnego).
	 * 
	 * @param p panel z przyciskami i obszarem planszy
	 */
	public void load ( Panel p ) {
		
		File config = new File( "config/board.txt" );
	
		p.panelBoard.b = new Board( InOut.readParameters( config, 0 ), InOut.readParameters( config, 1 ), config );
		
		if( p.panelBoard.b.getSize() != 0 && p.panelBoard.b.gen != 0 ) {
			InOut.readObjects( config, p.panelBoard.b, 0 );
			p.panelBoard.repaint();
		}
			
		
	}
	
}