package Wire;

import graphInterface.WindowError;

public class ObjElectrHead implements BoardObject {
	
	int h;
	int w;
	
	public ObjElectrHead( int h, int w ) {
		this.h = h;
		this.w = w;
	}

	@Override
	public void addToBoard( Board b ) {
		try {
			b.getCell( h, w ).setValue( 2 );
		} catch( ArrayIndexOutOfBoundsException e ) {
			new WindowError( "<html>Object is out of bounds.<br>" + getClass().getName() + ", " + h + ", " + w + "</html>" );
		}
	}
}
