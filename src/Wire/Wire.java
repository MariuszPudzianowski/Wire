package Wire;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;


public class Wire {

	public static void main( String args[] ) {
		
		File plik = new File( "config/board.txt" );
		String path = "config/board.txt";
		try {
			Desktop.getDesktop().edit( plik );
		} catch( IOException e ) {
			
		}
		
		Board gameBoard = new Board( InOut.readParameters(plik, 0), InOut.readParameters(plik, 1), plik );
		
		InOut.readObjects( plik, gameBoard, 0 );
		
		System.out.println( gameBoard );
		
		for( int i=0; i<7; i++) {
			gameBoard.nextGen();
			System.out.println( gameBoard );
		}

	}
}
