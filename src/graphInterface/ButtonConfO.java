package graphInterface;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 * Klasa opisuje zachowanie i funkcj� przycisku Open conf.
 * Przycisk po naci�ni�ciu otwiera plik konfiguracyjny zapisany pod sta�� �cie�k�.
 * Plik konfiguracyjny powinien by� zapisany w folderze "config" pod nazw� "board.txt"
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class ButtonConfO extends Button {

	/**
	 * Konstruktor tworzy przycisk Open conf. w po�o�eniu okre�lonym wsp�rz�dnymi x i y.
	 * 
	 * @param x wsp�rz�dna x lewego g�rnego rogu przycisku
	 * @param y wsp�rz�dna y lewego g�rnego rogu przycisku
	 */
	public ButtonConfO( int x, int y ) {
		super( x, y, "Open conf." );
	}
	
	/**
	 * Metoda realizuje funkcjonalno�� przycisku Open conf. (otwiera plik konfiguracyjny).
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
