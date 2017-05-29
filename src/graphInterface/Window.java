package graphInterface;

import javax.swing.JFrame;

import Wire.InOut;

public class Window extends JFrame {
	
	private final int height = 670;
	private final int width = 500;
	//public Wire.Board gameBoard = new Wire.Board( Wire.InOut.readSize() );
	
	public Window() {
		super( "WireWorld" );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		setSize( width, height );
		setResizable( false );
		setLocationRelativeTo( null );

		PanelBoard board = new PanelBoard();
		Panel buttons = new Panel( this, board );
		
		add( buttons );
		add( board );
		
		setVisible( true );
		
	}
}