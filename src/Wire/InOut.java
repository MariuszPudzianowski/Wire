package Wire;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import graphInterface.WindowError;

public class InOut {

	//private static File config = new File( "config/board.txt" );
	
	public static int readParameters( File config, int ifGen ) {
		int retNumber = 0;
		int maxSize = 50;
		int maxGen = 50;
		
		//File config = new File( path );
		
		try {
			BufferedReader readBoard = new BufferedReader( new FileReader( config ) );
			
			try {
				if( ifGen == 1 ) 
					readBoard.readLine();
				
				String line = readBoard.readLine();
				String param[] = line.split( "\\s+" );
				
				try {
					retNumber = Integer.parseInt( param[1] );
					
					int compare = (ifGen==0) ? maxSize : maxGen;
					if( retNumber <= 0 || retNumber > compare ) {
						new WindowError( "<html>Config: Board size cannot be less than 1 and more than " + maxSize + "<br>\nNumber of gens cannot be less than 1 and more than " + maxGen + "</html>" );
						readBoard = new BufferedReader( new FileReader( "config/board.txt" ) );
						return 0;
					}
				} catch( NumberFormatException e ) {
					new WindowError( "Config: The number given is not int " );
				} catch( ArrayIndexOutOfBoundsException e ) {
					new WindowError( "Config: No data given." );
				}
			} catch( NullPointerException e ){
				if( ifGen == 0)
					new WindowError( "Config: No data in file." );
			} catch( IOException e ) {
				new WindowError( "Config: IOException" );
			}
		} catch( FileNotFoundException e ) {
			if( ifGen == 0)
				new WindowError( "Config: No file given." );
		}

		return retNumber;
	}
	
	
	public static void readObjects( File config, Board b, int ifBack ) {
		
		BoardObject obj = null;
		//File config = new File( path );
		
		try {
			BufferedReader readBoard = new BufferedReader( new FileReader( config ) );
			
			
			try {
				String line;
				String param[];
				
				readBoard.readLine();
				readBoard.readLine();
				
				
				while( ( line = readBoard.readLine() ) != null ) {
					param = line.split( ",\\s+" );
					
					
					try {
						switch( param[0].toLowerCase() ) {
							case "wire":
								obj = new ObjWire( Integer.parseInt(param[1]), Integer.parseInt(param[2]), Integer.parseInt(param[3]), Integer.parseInt(param[4]) );
								obj.addToBoard( b, ifBack );
								break;
							
							case "electrhead":
								obj = new ObjElectrHead( Integer.parseInt(param[1]), Integer.parseInt(param[2]) );
								obj.addToBoard( b, ifBack );
								break;
							
							case "electrtail":
								obj = new ObjElectrTail( Integer.parseInt(param[1]), Integer.parseInt(param[2]) );
								obj.addToBoard( b, ifBack );
								break;
								
							default:
								switch( param[0].toLowerCase() ) {
									case "diode":
										obj = new ObjDiode( Integer.parseInt(param[1]), Integer.parseInt(param[2]), param[3] );
										break;
										
									case "orgate":
										obj = new ObjOrGate( Integer.parseInt(param[1]), Integer.parseInt(param[2]), param[3] );
										break;
										
									case "xorgate":
										obj = new ObjXorGate( Integer.parseInt(param[1]), Integer.parseInt(param[2]), param[3] );
										break;
										
									default:
										if( ifBack == 0 )
											new WindowError( "<html>Config: No object in line.<br>" + line + "</html>" );
								}
								
								if( !param[3].equalsIgnoreCase("right") && !param[3].equalsIgnoreCase("left") && !param[3].equalsIgnoreCase("up") && !param[3].equalsIgnoreCase("down") ) {
									if( ifBack == 0 )
										new WindowError( "<html>Config: The direction is not up, down, left or right.<br>" + line + "</html>" );
								}
								else	
									obj.addToBoard( b, ifBack );
								
						}
						
					} catch( NumberFormatException e ) {
						if( ifBack == 0 )
							new WindowError( "<html>Config: The number given is not int.<br>" + line + "</html>" );
					} catch( ArrayIndexOutOfBoundsException e ) {
						if( ifBack == 0 )
							new WindowError( "<html>Config: No data given.<br>" + line + "</html>" );
					}	
				}
			} catch( IOException e ) {
				if( ifBack == 0 )
					new WindowError( "Config: IOException." );
			}
		
		} catch( FileNotFoundException e ) {
			new WindowError( "Config: No file given." );
		}
	}
	
}
