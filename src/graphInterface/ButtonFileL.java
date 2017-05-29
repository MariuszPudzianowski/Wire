package graphInterface;

import javax.swing.JFileChooser;
//import java.awt.Container;

import Wire.InOut;

import java.io.File;

public class ButtonFileL extends Button {

	public ButtonFileL( int x, int y ) {
		super( x, y, "Load gen." );
	}
	
	public void load ( Panel p ) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory( new File( ("saves/") ) );
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
		    
		    if( selectedFile.getName().endsWith(".txt") ) {
		    	p.board.b = new Wire.Board( Wire.InOut.readParameters( selectedFile, 0 ), Wire.InOut.readParameters( selectedFile, 1 ), selectedFile );
		
				if( p.board.b.getSize() != 0 && p.board.b.gen != 0 ) {
					InOut.readObjects( selectedFile, p.board.b );
					p.board.repaint();
				}
		    }
			else
				new WindowError( "The file is not .txt file." );
		}
	}
	
}
