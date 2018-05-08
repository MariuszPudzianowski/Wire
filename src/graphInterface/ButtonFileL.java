package graphInterface;

import javax.swing.JFileChooser;
import Wire.InOut;
import java.io.File;

/**
 * Klasa opisuje zachowanie i funkcj� przycisku Load gen.
 * Przycisk po naci�ni�ciu pozwala wybra� lokalizacj� pliku, po czym czyta z niego generacj� traktuj�c go jak plik konfiguracyjny.
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class ButtonFileL extends Button {

	/**
	 * Konstruktor tworzy przycisk Load gen. w po�o�eniu okre�lonym wsp�rz�dnymi x i y.
	 * 
	 * @param x wsp�rz�dna x lewego g�rnego rogu przycisku
	 * @param y wsp�rz�dna y lewego g�rnego rogu przycisku
	 */
	public ButtonFileL( int x, int y ) {
		super( x, y, "Load gen." );
	}
	
	/**
	 * Metoda realizuje funkcjonalno�� przycisku Load gen. (wczytuje generacj� z pliku o dowolnej �cie�ce).
	 * 
	 * @param p panel z przyciskami i obszarem planszy
	 */
	public void load ( Panel p ) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory( new File( ("saves/") ) );
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
		    
		    if( selectedFile.getName().endsWith(".txt") ) {
		    	p.board.b = new Wire.Board( Wire.InOut.readParameters( selectedFile, 0 ), Wire.InOut.readParameters( selectedFile, 1 ), selectedFile );
		
				if( p.board.b.getSize() != 0 && p.board.b.gen != 0 ) {
					InOut.readObjects( selectedFile, p.board.b, 0 );
					p.board.repaint();
				}
		    }
			else
				new WindowError( "The file is not .txt file." );
		}
	}
	
}
