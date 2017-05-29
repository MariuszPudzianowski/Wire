package Wire;

import graphInterface.WindowError;

public class ObjWire implements BoardObject {
	int hStart;
	int wStart;
	int hEnd;
	int wEnd;
	
	public ObjWire( int hStart, int wStart, int hEnd, int wEnd ) {
		this.hStart = hStart;
		this.wStart = wStart;
		this.hEnd = hEnd;
		this.wEnd = wEnd;
	}
	
	@Override
	public void addToBoard( Board b, int ifBack ) {
		
		if( hEnd-hStart != 0 && wEnd-wStart != 0 && Math.abs(hEnd-hStart) != Math.abs(wEnd-wStart) ) {
			if( ifBack == 0 )
				new WindowError( "<html>Wire is neither horizontal, vertical nor 45 degr.<br>" + getClass().getName() + ", " + hStart + ", " + wStart + ", " + hEnd + ", " + wEnd + "</html>" );
			return;
		}
			
		int hStep = hEnd>hStart ? 1 : ( hEnd==hStart ? 0 : -1 ) ;
		int wStep = wEnd>wStart ? 1 : ( wEnd==wStart ? 0 : -1 ) ;
		
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
