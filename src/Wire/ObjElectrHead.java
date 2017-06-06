package Wire;

import graphInterface.WindowError;

/**
 * Klasa reprezentuje obiekt - g³owê elektronu.
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class ObjElectrHead implements BoardObject {
	
	private int h, w;
	
	/**
	 * Konstruktor ustala parametry g³owy elektronu.
	 * 
	 * @param h wspó³rzêdna y
	 * @param w wspó³rzêdna x
	 */
	public ObjElectrHead( int h, int w ) {
		this.h = h;
		this.w = w;
	}

	/**
	 * Metoda umieszcza g³owê elektronu na planszy.
	 * Je¿eli obiekt wychodzi poza planszê, wyœwietlany jest komunikat o b³êdzie.
	 */
	@Override
	public void addToBoard( Board b, int ifBack ) {
		try {
			b.getCell( h, w ).setValue( 2 );
		} catch( ArrayIndexOutOfBoundsException e ) {
			if( ifBack == 0 )
				new WindowError( "<html>Object is out of bounds.<br>" + getClass().getName() + ", " + h + ", " + w + "</html>" );
		}
	}
}
