package Wire;

import graphInterface.WindowError;

/**
 * Klasa reprezentuje obiekt - ogon elektronu.
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class ObjElectrTail implements BoardObject {
	
	private int h, w;
	
	/**
	 * Konstruktor ustala parametry ogona elektronu.
	 * 
	 * @param h wspó³rzêdna y
	 * @param w wspó³rzêdna x
	 */
	public ObjElectrTail( int h, int w ) {
		this.h = h;
		this.w = w;
	}

	/**
	 * Metoda umieszcza ogon elektronu na planszy.
	 * Je¿eli obiekt wychodzi poza planszê, wyœwietlany jest komunikat o b³êdzie.
	 */
	@Override
	public void addToBoard( Board b, int ifBack ) {
		try {
			b.getCell( h, w ).setValue( 3 );
		} catch( ArrayIndexOutOfBoundsException e ) {
			if( ifBack == 0 )
				new WindowError( "<html>Object is out of bounds.<br>" + getClass().getName() + ", " + h + ", " + w + "</html>" );
		}
	}
}
