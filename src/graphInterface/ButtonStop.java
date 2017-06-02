package graphInterface;

public class ButtonStop extends Button {
	Panel p;

	public ButtonStop( int x, int y ) {
		super( x, y, "STOP" );
	}
	
	public void stop (Panel p) {
		this.p = p;
		p.isPaused = true;
	}
	
}
