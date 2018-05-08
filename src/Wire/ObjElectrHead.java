package Wire;

import graphInterface.WindowError;

/**
 * Klasa reprezentuje obiekt - g�ow� elektronu.
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class ObjElectrHead implements BoardObject {
	
	private int h, w;
	
	/**
	 * Konstruktor ustala parametry g�owy elektronu.
	 * 
	 * @param h wsp�rz�dna y
	 * @param w wsp�rz�dna x
	 */
	public ObjElectrHead( int h, int w ) {
		this.h = h;
		this.w = w;
	}

	/**
	 * Metoda umieszcza g�ow� elektronu na planszy.
	 * Je�eli obiekt wychodzi poza plansz�, wy�wietlany jest komunikat o b��dzie.
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
