package graphInterface;

import javax.swing.*;

/**
 * Klasa jest implementacj¹ okna z komunikatem o b³êdzie.
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class WindowError extends JFrame {
	
	private final int height = 100;
	private final int width = 400;
	
	/**
	 * Konstruktor tworzy nowe okno z okreœlonym komunikatem o b³êdzie.
	 * Pos³uguje siê w tym celu metodami klasy JFrame.
	 * 
	 * @param text treœæ komunikatu
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
