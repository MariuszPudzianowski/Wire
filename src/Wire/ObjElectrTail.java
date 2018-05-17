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
	 * @param h współrzędna y
	 * @param w współrzędna x
	 */
	public ObjElectrTail( int h, int w ) {
		this.h = h;
		this.w = w;
	}

	/**
	 * Metoda umieszcza ogon elektronu na planszy.
	 * Jeżeli obiekt wychodzi poza planszę, wyświetlany jest komunikat o błędzie.
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
