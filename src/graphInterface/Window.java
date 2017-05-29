package graphInterface;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.OverlayLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;

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
		
		//setLayout(new OverLay());
		//setLayout(new GridLayout(5, 20));

		//PanelBoard board = new PanelBoard();
		Panel buttons = new Panel( this, new PanelBoard() );
		
		
		add( buttons );
		add( buttons.board );
		
		setVisible( true );
		
	}
}