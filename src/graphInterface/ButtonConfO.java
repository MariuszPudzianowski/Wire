package graphInterface;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class ButtonConfO extends Button {

	public ButtonConfO( int x, int y ) {
		super( x, y, "Open conf." );
	}
	
	public void open () {
		File config = new File( "config/board.txt" );

		try {
		    Desktop.getDesktop().edit( config );
		} catch( IOException e ) {
			new WindowError( "File cannot be opened." );
		}
	}
	
}
