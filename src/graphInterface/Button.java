package graphInterface;

import javax.swing.JButton;

public class Button extends JButton {

	private final int width = 100;
	private final int height = 50;
	
	public Button( int x, int y, String name ) {
		this.setBounds( x, y, width, height );
		this.setText( name );
	}
}
