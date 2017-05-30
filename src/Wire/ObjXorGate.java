package Wire;

import graphInterface.WindowError;

public class ObjXorGate implements BoardObject {

	private String direction;
	private int h, w, step;
	
	
	public ObjXorGate( int h, int w, String direction ) {
		this.direction = direction;
		this.h = h;
		this.w = w;
		step = ( direction.equalsIgnoreCase("right") || direction.equalsIgnoreCase("down") ) ? 1 : -1;
	}
	
	@Override
	public void addToBoard( Board b, int ifBack ) {
		
		try {
			if( direction.equalsIgnoreCase("right") || direction.equalsIgnoreCase("left") ) {
				b.getCell( h, w ).setValue( 1 );
				b.getCell( h+1, w ).setValue( 1 );
				b.getCell( h-1, w ).setValue( 1 );
				b.getCell( h+3, w ).setValue( 1 );
				b.getCell( h-3, w ).setValue( 1 );
				
				b.getCell( h+1, w+step ).setValue( 1 );
				b.getCell( h-1, w+step ).setValue( 1 );
				b.getCell( h+2, w+step ).setValue( 1 );
				b.getCell( h-2, w+step ).setValue( 1 );
				
				b.getCell( h+1, w+2*step ).setValue( 1 );
				b.getCell( h-1, w+2*step ).setValue( 1 );				
				
				b.getCell( h, w+3*step ).setValue( 1 );
				b.getCell( h+1, w+3*step ).setValue( 1 );
				b.getCell( h-1, w+3*step ).setValue( 1 );
				
				b.getCell( h, w+4*step ).setValue( 1 );
				
			} else {
				b.getCell( h, w ).setValue( 1 );
				b.getCell( h, w+1 ).setValue( 1 );
				b.getCell( h, w-1 ).setValue( 1 );
				b.getCell( h, w+3 ).setValue( 1 );
				b.getCell( h, w-3 ).setValue( 1 );
				
				b.getCell( h+step, w+1 ).setValue( 1 );
				b.getCell( h+step, w-1 ).setValue( 1 );
				b.getCell( h+step, w+2 ).setValue( 1 );
				b.getCell( h+step, w-2 ).setValue( 1 );
				
				b.getCell( h+2*step, w+1 ).setValue( 1 );
				b.getCell( h+2*step, w-1 ).setValue( 1 );				
				
				b.getCell( h+3*step, w ).setValue( 1 );
				b.getCell( h+3*step, w+1 ).setValue( 1 );
				b.getCell( h+3*step, w-1 ).setValue( 1 );
				
				b.getCell( h+4*step, w ).setValue( 1 );
			}
		} catch( ArrayIndexOutOfBoundsException e ) {
			if( ifBack == 0 )
				new WindowError( "<html>Object is out of bounds.<br>" + getClass().getName() + ", " + h + ", " + w + "</html>" );
		}
	}
}
