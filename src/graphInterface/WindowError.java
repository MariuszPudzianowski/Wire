package graphInterface;

import javax.swing.*;

public class WindowError extends JFrame {
	
	private final int height = 100;
	private final int width = 400;
	
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
