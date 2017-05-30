package graphInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

public class ButtonFileS extends Button {

	public ButtonFileS( int x, int y ) {
		super( x, y, "Save gen." );
	}
	
	private String fileName () {
		String year = Integer.toString( Calendar.getInstance().get(Calendar.YEAR) );
		String month = Integer.toString(Calendar.getInstance().get(Calendar.MONTH)+1 );
		String day = Integer.toString(Calendar.getInstance().get(Calendar.DAY_OF_MONTH) );
		String hour = Integer.toString(Calendar.getInstance().get(Calendar.HOUR_OF_DAY) );
		String minute = Integer.toString(Calendar.getInstance().get(Calendar.MINUTE) );
		String sec = Integer.toString(Calendar.getInstance().get(Calendar.SECOND) );
		String ms = Integer.toString(Calendar.getInstance().get(Calendar.MILLISECOND) );
		return( year + "_" + month + "_" + day + "_" + hour + "_" + minute + "_" + sec + "_" + ms );
	}
	
	public void save ( Wire.Board b ) {
		try {
			BufferedReader readBoard = new BufferedReader( new FileReader( b.source ) );
			
			File toSave = new File( "saves/s" + fileName() + ".txt" );
			PrintWriter saver = new PrintWriter( toSave );
			
			try {
				String line;
				String [] param;
				
				while( ( line = readBoard.readLine() ) != null ) {
					if( !line.toLowerCase().startsWith( "electrhead" ) && !line.toLowerCase().startsWith( "electrtail" ) ) {
						saver.println( line );
					}
					else {
						param = line.split( ",\\s+" );
						saver.println( "wire, " + param[1] + ", " + param[2] + ", " + param[1] + ", " + param[2] );
					}
				}
					
	
				for( int i=0; i<b.getSize(); i++ )
					for( int j=0; j<b.getSize(); j++ ) {
						if( b.getCell(i, j).getValue() == 2 )
							saver.println( "electrhead, " + Integer.toString(i) + ", " + Integer.toString(j) );
						else if( b.getCell(i, j).getValue() == 3 )
							saver.println( "electrtail, " + Integer.toString(i) + ", " + Integer.toString(j) );
					}
				
				saver.close();
			} catch( IOException e ) {
				new WindowError( "IOException." );
			}
			
			
		} catch( FileNotFoundException | NullPointerException e ) {
			new WindowError( "No file loaded." );
		}
	}
	
}
