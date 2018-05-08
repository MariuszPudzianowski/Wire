package graphInterface;

import Wire.InOut;
import java.io.File;

/**
 * Klasa opisuje zachowanie i funkcj� przycisku Load conf.
 * Przycisk po naci�ni�ciu wczytuje generacj� z pliku konfiguracyjnego zapisanego pod sta�� �cie�k�.
 * Plik konfiguracyjny powinien by� zapisany w folderze "config" pod nazw� "board.txt"
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class ButtonConfL extends Button {

	/**
	 * Konstruktor tworzy przycisk Load conf. w po�o�eniu okre�lonym wsp�rz�dnymi x i y.
	 * 
	 * @param x wsp�rz�dna x lewego g�rnego rogu przycisku
	 * @param y wsp�rz�dna y lewego g�rnego rogu przycisku
	 */
	public ButtonConfL( int x, int y ) {
		super( x, y, "Load conf." );
	}
	
	/**
	 * Metoda realizuje funkcjonalno�� przycisku Load conf. (wczytuje generacj� z pliku konfiguracyjnego).
	 * 
	 * @param p panel z przyciskami i obszarem planszy
	 */
	public void load ( Panel p ) {
		
		File config = new File( "config/board.txt" );
	
		p.board.b = new Wire.Board( Wire.InOut.readParameters( config, 0 ), Wire.InOut.readParameters( config, 1 ), config );
		
		if( p.board.b.getSize() != 0 && p.board.b.gen != 0 ) {
			InOut.readObjects( config, p.board.b, 0 );
			p.board.repaint();
		}
			
		
	}
	
}