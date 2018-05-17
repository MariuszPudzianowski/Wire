package graphInterface;

import Wire.Board;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.JLayeredPane;

/**
 * Klasa reprezentuje obszar planszy z³o¿ony z kwadratów.a
 * Ka¿dy kwadrat mo¿e byæ jednego z czterech kolorów (¿ó³ty, niebieski, czerwony lub bia³y).
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class PanelBoard extends JLayeredPane {
	
	public Board b;
	
	/**
	 * Metoda pokrywa wszystkie kwadraty obszaru planszy zgodnie z jej aktualnym stanem.
	 * Korzysta w tym celu z paczki java.awt oraz metod klasy javax.Swing.JLayeredPane.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		if( b != null && b.getSize() != 0 ) {
			
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
	        
	        int squareSize = 450 / b.getSize();
			
			for( int i=0; i<b.getSize(); i++ ) {
	        	for( int j=0; j<b.getSize(); j++ ) {
	        		if( b.getCell( i,  j ).getValue() == 1 )
	        			g.setColor(Color.YELLOW);
	        		else if( b.getCell( i,  j ).getValue() == 2 )
	        			g.setColor(Color.BLUE);
	        		else if( b.getCell( i,  j ).getValue() == 3 )
	        			g.setColor(Color.RED);
	        		else
	        			g.setColor(Color.WHITE);
	        				
	        		
	        		g.fillRect( 20+squareSize*j, 20+squareSize*i, squareSize, squareSize );
	        		g.setColor(Color.BLACK);
	        		Rectangle2D rect = new Rectangle2D.Double( 20+squareSize*j, 20+squareSize*i, squareSize, squareSize );
	        		g2d.draw(rect);
	        	}
	        }
		}
	}
	
	
	
}
