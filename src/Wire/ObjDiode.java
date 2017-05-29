package Wire;

import graphInterface.WindowError;

public class ObjDiode implements BoardObject {

	String direction;
	int h, w;
	
	public ObjDiode( int h, int w, String direction ) {
		this.direction = direction;
		this.h = h;
		this.w = w;
	}
	
	
	@Override
	public void addToBoard( Board b, int ifBack ) {
	
		int step = ( direction.equalsIgnoreCase("right") || direction.equalsIgnoreCase("down") ) ? 1 : -1;
		
		try {
			if( direction.equalsIgnoreCase("right") || direction.equalsIgnoreCase("left") ) {
				
				
				b.getCell( h, w ).setValue( 1 );
				
				b.getCell( h-1, w+step ).setValue( 1 );
				b.getCell( h, w+step ).setValue( 1 );
				b.getCell( h+1, w+step ).setValue( 1 );
				
				b.getCell( h-1, w+2*step ).setValue( 1 );
				b.getCell( h+1, w+2*step ).setValue( 1 );
				
				b.getCell( h, w+3*step ).setValue( 1 );
			} else {
				b.getCell( h, w ).setValue( 1 );
				
				b.getCell( h+step, w-1 ).setValue( 1 );
				b.getCell( h+step, w ).setValue( 1 );
				b.getCell( h+step, w+1 ).setValue( 1 );
				
				b.getCell( h+2*step, w-1 ).setValue( 1 );
				b.getCell( h+2*step, w+1 ).setValue( 1 );
	
				b.getCell( h+3*step, w ).setValue( 1 );
			}
		} catch( ArrayIndexOutOfBoundsException e ) {
			if( ifBack == 0 )
				new WindowError( "<html>Object is out of bounds.<br>" + getClass().getName() + ", " + h + ", " + w + "</html>" );
		}
	}
}
