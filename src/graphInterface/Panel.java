package graphInterface;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 * Klasa reprezentuje interaktywny obszar okna sk³adaj¹cy siê z obszaru wyœwietlanej generacji oraz przycisków do jego obs³ugi.
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class Panel extends JPanel implements ActionListener {
	
	PanelBoard panelBoard;
	Button start, stop, genNext, genPrev, fileS, fileL, confO, confL;
	int g;
	boolean isRunning = false;
	boolean isPaused;
	
	/**
	 * Konstruktor tworzy now¹ zawartoœæ okna (panel) o ustalonym stanie.
	 * Funkcje, wygl¹d i rozmieszczenie przycisków s¹ okreœlone tak samo, jak pocz¹tkowy stan obszaru planszy,
	 * który zawsze po uruchomieniu jest pusty.
	 * 
	 * @param pane kontener przechowuj¹cy przyciski
	 * @param board zape³niany obszar planszy
	 */
	public Panel( Container pane, PanelBoard panelBoard ) {
		this.panelBoard = panelBoard;
 
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
	
	/**
	 * Metoda okreœla akcjê nastêpuj¹c¹ po klikniêciu danego przycisku.
	 */
	@Override
	public void actionPerformed( ActionEvent event ) {
		Object source = event.getSource();
		if ( source instanceof ButtonConfO ) {
			( (ButtonConfO) source ).open();
		} else if ( source instanceof ButtonConfL ) {
			( (ButtonConfL) source ).load( this );
			if ( panelBoard.b != null ) {
				g = 1;
				isPaused = true;
				start.setEnabled( true );
				genNext.setEnabled( true );
				genPrev.setEnabled( false );
				fileS.setEnabled( true );
			}
		} else if ( source instanceof ButtonFileL ) {
			( (ButtonFileL) source ).load( this );
			if ( panelBoard.b != null ) {
				g = 1;
				isPaused = true;
				start.setEnabled( true );
				genNext.setEnabled( true );
				genPrev.setEnabled( false );
				fileS.setEnabled( true );
			}
		} else if ( source instanceof ButtonFileS ) {
			( (ButtonFileS) source ).save( panelBoard.b );
		} else if ( source instanceof ButtonGenNext ) {
			( (ButtonGenNext) source ).next( panelBoard );
			g++;
			genPrev.setEnabled( true );
			if (g == panelBoard.b.gen) {
				genNext.setEnabled( false );
				start.setEnabled( false );
			}
		} else if ( source instanceof ButtonGenPrev ) {
			( (ButtonGenPrev) source ).prev( panelBoard, g );
			g--;
			genNext.setEnabled( true );
			start.setEnabled( true );
			if (g == 1)
				genPrev.setEnabled( false );
		} else if ( source instanceof ButtonStart ) {
			start.setEnabled( false );
			stop.setEnabled( true );
			genNext.setEnabled( false );
			genPrev.setEnabled( false );
			fileL.setEnabled( false );
			fileS.setEnabled( false );
			confO.setEnabled( false );
			confL.setEnabled( false );
			( (ButtonStart) source ).start( this );
		} else if ( source instanceof ButtonStop ) {
			( (ButtonStop) source ).stop ( this );
			start.setEnabled( true );
			stop.setEnabled( false );
			fileL.setEnabled( true );
			fileS.setEnabled( true );
			confO.setEnabled( true );
			confL.setEnabled( true );
			
			if (g == 1)
				genPrev.setEnabled( false );
			else
				genPrev.setEnabled( true );
			
			if (g == panelBoard.b.gen)
				genNext.setEnabled( false );
			else
				genNext.setEnabled( true );
		}
		
		if( panelBoard.b != null) {
			if (isRunning == false && g != panelBoard.b.gen)
				start.setEnabled( true );
		}
	}

}