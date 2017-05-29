package graphInterface;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class Panel extends JPanel implements ActionListener {
	
	PanelBoard board;
	
	public Panel( Container pane, PanelBoard board ) {
		this.board = board;
 
        Button start = new ButtonStart( 20, 500 );
        Button stop = new ButtonStop( 20, 570 );
        Button genNext = new ButtonGenNext( 140, 500 );
        Button genPrev = new ButtonGenPrev( 140, 570 );
        Button fileS = new ButtonFileS( 260, 500 );
        Button fileL = new ButtonFileL( 260, 570 );
        Button confO = new ButtonConfO( 380, 500 );
        Button confL = new ButtonConfL( 380, 570 );
        
        start.addActionListener( this );
        stop.addActionListener( this );
        genNext.addActionListener( this );
        genPrev.addActionListener( this );
        fileS.addActionListener( this );
        fileL.addActionListener( this );
        confO.addActionListener( this );
        confL.addActionListener( this );
        
        pane.add( start );
        pane.add( stop );
        pane.add( genNext );
        pane.add( genPrev );
        pane.add( fileS );
        pane.add( fileL );
        pane.add( confO );
        pane.add( confL );

    }
	
	@Override
	public void actionPerformed( ActionEvent event ) {
		Object source = event.getSource();

		if( source instanceof ButtonConfO ) {
			( (ButtonConfO) source ).open();
		} else if( source instanceof ButtonConfL ) {
			( (ButtonConfL) source ).load( this );
		} else if( source instanceof ButtonFileL ) {
			( (ButtonFileL) source ).load( this );
		} else if( source instanceof ButtonFileS ) {
			( (ButtonFileS) source ).save( board.b );
		}
	}

}