package graphInterface;

import javax.swing.JButton;

/**
 * Klasa reprezentuje przycisk znajdujący się na panelu. A
 * Przycisk ma określoną wysokość (50) i szerokość (100).
 *
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class Button extends JButton {
	private final int width = 100;
	private final int height = 50;
	
	/**
	 * Konstruktor tworzy przycisk o stałych wymiarach, w położeniu określonym współrzędnymi x i y oraz o podanej nazwie.
	 * Używa do tego metod klasy javax.swing.JButton.
	 * 
	 * @param x współrzędna x lewego górnego rogu przycisku
	 * @param y współrzędna y lewego górnego rogu przycisku
	 * @param name nazwa przycisku reprezentowana przez tekst na przycisku
	 */
	public Button( int x, int y, String name ) {
		this.setBounds( x, y, width, height );
		this.setText( name );
	}
}
