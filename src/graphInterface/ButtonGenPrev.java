package graphInterface;

import Wire.InOut;

public class ButtonGenPrev extends Button {

	public ButtonGenPrev( int x, int y ) {
		super( x, y, "Gen -1" );
	}
	
	public void prev ( PanelBoard p, int k ) {
		Wire.Board newBoard = new Wire.Board( p.b.getSize(), Wire.InOut.readParameters( p.b.source, 1 ), p.b.source );
		InOut.readObjects( p.b.source, newBoard, 1 );
		//System.out.println(newBoard.gen);
		//System.out.println( k );
		p.b = newBoard;
		//p.repaint();
		
		for( int i=0; i<k-1; i++) {
			p.b.nextGen();
			
		}
		p.repaint();
	}
	
}
