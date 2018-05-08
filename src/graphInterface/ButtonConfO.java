package graphInterface;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 * Klasa opisuje zachowanie i funkcjê przycisku Open conf.
 * Przycisk po naciœniêciu otwiera plik konfiguracyjny zapisany pod sta³¹ œcie¿k¹.
 * Plik konfiguracyjny powinien byæ zapisany w folderze "config" pod nazw¹ "board.txt"
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class ButtonConfO extends Button {

	/**
	 * Konstruktor tworzy przycisk Open conf. w po³o¿eniu okreœlonym wspó³rzêdnymi x i y.
	 * 
	 * @param x wspó³rzêdna x lewego górnego rogu przycisku
	 * @param y wspó³rzêdna y lewego górnego rogu przycisku
	 */
	public ButtonConfO( int x, int y ) {
		super( x, y, "Open conf." );
	}
	
	/**
	 * Metoda realizuje funkcjonalnoœæ przycisku Open conf. (otwiera plik konfiguracyjny).
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
