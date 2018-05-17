package graphInterface;

import Wire.InOut;
import javax.swing.JFileChooser;
import java.io.File;

/**
 * Klasa opisuje zachowanie i funkcjê przycisku Load gen.
 * Przycisk po naciœniêciu pozwala wybraæ lokalizacjê pliku, po czym wczytuje z niego generacjê traktuj¹c go jak plik konfiguracyjny.
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
		    	p.panelBoard.b = new Wire.Board( InOut.readParameters( selectedFile, 0 ), InOut.readParameters( selectedFile, 1 ), selectedFile );
		
				if( p.panelBoard.b.getSize() != 0 && p.panelBoard.b.gen != 0 ) {
					InOut.readObjects( selectedFile, p.panelBoard.b, 0 );
					p.panelBoard.repaint();
				}
		    }
			else
				new WindowError( "The file is not a '.txt' file." );
		}
	}
	
}
