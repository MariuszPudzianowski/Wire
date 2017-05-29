package graphInterface;

public class ButtonGenNext extends Button {

	public ButtonGenNext( int x, int y ) {
		super( x, y, "Gen +1" );
	}
	
	public void next ( PanelBoard p ) {
		p.b.nextGen();
		p.repaint();
	}
	
}
