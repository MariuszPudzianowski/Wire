package graphInterface;

import java.awt.Container;

import Wire.InOut;
import java.io.File;

public class ButtonConfL extends Button {

	public ButtonConfL( int x, int y ) {
		super( x, y, "Load conf." );
	}
	
	public void load ( Panel p ) {
		File config = new File( "config/board.txt" );
		p.board.b = new Wire.Board( Wire.InOut.readParameters( config, 0 ), Wire.InOut.readParameters( config, 1 ), config );
		
		if( p.board.b.getSize() != 0 && p.board.b.gen != 0 ) {
			InOut.readObjects( config, p.board.b, 0 );
			//revalidate();
			p.board.repaint();
			//revalidate();
		}
	}
	
}