package graphInterface;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class Panel extends JPanel implements ActionListener {
	
	PanelBoard board;
	Button start, stop, genNext, genPrev, fileS, fileL, confO, confL;
	int k;
	
	public Panel( Container pane, PanelBoard board ) {
		this.board = board;
 
        start = new ButtonStart( 20, 500 );
        start.setEnabled( false );
        
        stop = new ButtonStop( 20, 570 );
        stop.setEnabled( false );
        
        genNext = new ButtonGenNext( 140, 500 );
        genNext.setEnabled( false );
        
        genPrev = new ButtonGenPrev( 140, 570 );
        genPrev.setEnabled( false );
       
        fileS = new ButtonFileS( 260, 500 );
        fileS.setEnabled( false );
        
        fileL = new ButtonFileL( 260, 570 );
        confO = new ButtonConfO( 380, 500 );
        confL = new ButtonConfL( 380, 570 );
        
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
			if( board.b != null ) {
				start.setEnabled( true );
				genNext.setEnabled( true );
				fileS.setEnabled( true );
				k = 0;
			}
		} else if( source instanceof ButtonFileL ) {
			( (ButtonFileL) source ).load( this );
			if( board.b != null ) {
				start.setEnabled( true );
				genNext.setEnabled( true );
				fileS.setEnabled( true );
				k = 0;
			}
		} else if( source instanceof ButtonFileS ) {
			( (ButtonFileS) source ).save( board.b );
		} else if( source instanceof ButtonGenNext ) {
			( (ButtonGenNext) source ).next( board );
			k++;
		} else if( source instanceof ButtonGenPrev ) {
			( (ButtonGenPrev) source ).prev( board, k );
			k--;
		}
		
		if( board.b != null) {
			if( k == board.b.gen )
				genNext.setEnabled( false );
			else
				genNext.setEnabled( true );
			
			if( k > 0 )
				genPrev.setEnabled( true );
			else
				genPrev.setEnabled( false );
		}
	}

}