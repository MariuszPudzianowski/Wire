package graphInterface;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 * Klasa opisuje zachowanie i funkcję przycisku Open conf.
 * Przycisk po naciśnięciu otwiera plik konfiguracyjny zapisany pod stałą ścieżką.
 * Plik konfiguracyjny powinien być zapisany w folderze "config" pod nazwą "board.txt"
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class ButtonConfO extends Button {

	/**
	 * Konstruktor tworzy przycisk Open conf. w położeniu określonym współrzędnymi x i y.
	 *
	 * @param x współrzędna x lewego górnego rogu przycisku
	 * @param y współrzędna y lewego górnego rogu przycisku
	 */
	public ButtonConfO( int x, int y ) {
		super( x, y, "Open conf." );
	}
	
	/**
	 * Metoda realizuje funkcjonalność przycisku Open conf. (otwiera plik konfiguracyjny).
	 */
	public void open () {
		File config = new File( "config/board.txt" );

		try {
		    Desktop.getDesktop().edit( config );
		} catch( IOException e ) {
			new WindowError( "File cannot be opened." );
		}
	}
	
}
