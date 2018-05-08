package graphInterface;

import javax.swing.JFileChooser;
import Wire.InOut;
import java.io.File;

/**
 * Klasa opisuje zachowanie i funkcjê przycisku Load gen.
 * Przycisk po naciœniêciu pozwala wybraæ lokalizacjê pliku, po czym czyta z niego generacjê traktuj¹c go jak plik konfiguracyjny.
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class ButtonFileL extends Button {

	/**
	 * Konstruktor tworzy przycisk Load gen. w po³o¿eniu okreœlonym wspó³rzêdnymi x i y.
	 * 
	 * @param x wspó³rzêdna x lewego górnego rogu przycisku
	 * @param y wspó³rzêdna y lewego górnego rogu przycisku
	 */
	public ButtonFileL( int x, int y ) {
		super( x, y, "Load gen." );
	}
	
	/**
	 * Metoda realizuje funkcjonalnoœæ przycisku Load gen. (wczytuje generacjê z pliku o dowolnej œcie¿ce).
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
