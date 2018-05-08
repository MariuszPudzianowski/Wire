package Wire;

import graphInterface.WindowError;

/**
 * Klasa reprezentuje obiekt - bramk� OR.
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class ObjOrGate implements BoardObject {

	private String direction;
	private int h, w, step;
	
	/**
	 * Konstruktor ustala parametry bramki.
	 * 
	 * @param h wsp�rz�dna y
	 * @param w wsp�rz�dna x
	 * @param direction kierunek obiektu
	 */
	public ObjOrGate( int h, int w, String direction ) {
		this.direction = direction;
		this.h = h;
		this.w = w;
		step = ( direction.equalsIgnoreCase("right") || direction.equalsIgnoreCase("down") ) ? 1 : -1;
	}
	
	/**
	 * Metoda umieszcza bramk� na planszy.
	 * Je�eli obiekt wychodzi poza plansz�, wy�wietlany jest komunikat o b��dzie.
	 */
	@Override
	public void addToBoard( Board b, int ifBack ) {
		
		try {
			if( direction.equalsIgnoreCase("right") || direction.equalsIgnoreCase("left") ) {
				b.getCell( h, w ).setValue( 1 );
				b.getCell( h-2, w ).setValue( 1 );
				b.getCell( h+2, w ).setValue( 1 );
				
				b.getCell( h, w+step ).setValue( 1 );
				b.getCell( h-1, w+step ).setValue( 1 );
				b.getCell( h+1, w+step ).setValue( 1 );
				
				b.getCell( h, w+2*step ).setValue( 1 );
				
				b.getCell( h, w+3*step ).setValue( 1 );
				
			} else {
				b.getCell( h, w ).setValue( 1 );
				b.getCell( h, w-2 ).setValue( 1 );
				b.getCell( h, w+2 ).setValue( 1 );
				
				b.getCell( h+step, w ).setValue( 1 );
				b.getCell( h+step, w-1 ).setValue( 1 );
				b.getCell( h+step, w+1 ).setValue( 1 );
				
				b.getCell( h+2*step, w ).setValue( 1 );
				
				b.getCell( h+3*step, w ).setValue( 1 );
			}
		} catch( ArrayIndexOutOfBoundsException e ) {
			if( ifBack == 0 )
				new WindowError( "<html>Object is out of bounds.<br>" + getClass().getName() + ", " + h + ", " + w + "</html>" );
		}
	}
	
}
