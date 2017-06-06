package graphInterface;

import javax.swing.*;

/**
 * Klasa jest implementacj� okna z komunikatem o b��dzie.
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class WindowError extends JFrame {
	
	private final int height = 100;
	private final int width = 400;
	
	/**
	 * Konstruktor tworzy nowe okno z okre�lonym komunikatem o b��dzie.
	 * Pos�uguje si� w tym celu metodami klasy JFrame.
	 * 
	 * @param text tre�� komunikatu
	 */
	public WindowError ( String text ) {
		super( "Error" );
		JLabel t = new JLabel( text, SwingConstants.CENTER );
		this.add( t );
		
		setSize( width, height );
		setResizable( false );
		setLocationRelativeTo( null );
		
		setVisible( true );
	}
}
