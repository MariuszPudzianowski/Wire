package Wire;

import graphInterface.WindowError;

/**
 * Klasa reprezentuje obiekt - przewód.
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class ObjWire implements BoardObject {
	
	private int hStart, wStart, hEnd, wEnd;
	private int hStep, wStep;
	
	/**
	 * Konstruktor ustala parametry przewodu.
	 * 
	 * @param hStart wspó³rzêdna y pocz¹tku przewodu
	 * @param wStart wspó³rzêdna x pocz¹tku przewodu
	 * @param hEnd wspó³rzêdna y koñca przewodu
	 * @param wEnd wspó³rzêdna x koñca przewodu
	 */
	public ObjWire( int hStart, int wStart, int hEnd, int wEnd ) {
		this.hStart = hStart;
		this.wStart = wStart;
		this.hEnd = hEnd;
		this.wEnd = wEnd;
		hStep = hEnd>hStart ? 1 : ( hEnd==hStart ? 0 : -1 ) ;
		wStep = wEnd>wStart ? 1 : ( wEnd==wStart ? 0 : -1 ) ;
	}
	
	/**
	 * Metoda umieszcza przewód na planszy.
	 * Je¿eli obiekt wychodzi poza planszê, wyœwietlany jest komunikat o b³êdzie.
	 */
	@Override
	public void addToBoard( Board b, int ifBack ) {
		
		if( hEnd-hStart != 0 && wEnd-wStart != 0 && Math.abs(hEnd-hStart) != Math.abs(wEnd-wStart) ) {
			if( ifBack == 0 )
				new WindowError( "<html>Wire is neither horizontal, vertical nor 45 degr.<br>" + getClass().getName() + ", " + hStart + ", " + wStart + ", " + hEnd + ", " + wEnd + "</html>" );
			return;
		}
			
		try {
			int i = hStart, j = wStart;
			
			do {
				b.getCell( i, j ).setValue( 1 );
				
				i += hStep;
				j += wStep;
			} while( i != hEnd+hStep || j != wEnd+wStep );
						
		} catch( ArrayIndexOutOfBoundsException e ) {
			if( ifBack == 0 )
				new WindowError( "<html>Object is out of bounds.<br>" + getClass().getName() + ", " + hStart + ", " + wStart + ", " + hEnd + ", " + wEnd + "</html>" );
		}
	}
}
