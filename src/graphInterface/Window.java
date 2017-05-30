package graphInterface;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	private final int height = 670;
	private final int width = 500;
	
	public Window() {
		super( "WireWorld" );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		setSize( width, height );
		setResizable( false );
		setLocationRelativeTo( null );
		
		Panel buttons = new Panel( this, new PanelBoard() );
		
		add( buttons );
		add( buttons.board );
		
		setVisible( true );
		
	}
}