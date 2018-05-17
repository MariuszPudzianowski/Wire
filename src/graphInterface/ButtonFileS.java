package graphInterface;

import Wire.Board;
import java.io.*;
import java.util.Calendar;

/**
 * Klasa opisuje zachowanie i funkcjê przycisku Save gen.
 * Przycisk po naciœniêciu pozwala wybraæ lokalizacjê, a po jej wybraniu zapisaæ w niej plik konfiguracyjny,
 * który bêdzie zawiera³ bie¿¹c¹ generacjê.
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class ButtonFileS extends Button {

	/**
	 * Konstruktor tworzy przycisk Save gen. w po³o¿eniu okreœlonym wspó³rzêdnymi x i y.
	 * 
	 * @param x wspó³rzêdna x lewego górnego rogu przycisku
	 * @param y wspó³rzêdna y lewego górnego rogu przycisku
	 */
	public ButtonFileS( int x, int y ) {
		super( x, y, "Save gen." );
	}
	
	/**
	 * Metoda tworzy nazwê, pod jak¹ zostanie zapisany plik z generacj¹.
	 * Nazwa opiera siê na aktualnej dacie i bie¿¹cym czasie.
	 * 
	 * @return nazwa pliku z konfiguracj¹
	 */
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
	
	/**
	 * Metoda generuje plik konfiguracyjny i zapisuje go w wybranej lokalizacji.
	 * 
	 * @param b tablica komórek
	 */
	public void save ( Board b ) {
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
