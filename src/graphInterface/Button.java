package graphInterface;

import javax.swing.JButton;

/**
 * Klasa reprezentuje przycisk znajduj¹cy siê na panelu.
 * Przycisk ma okreœlon¹ wysokoœæ (50) i szerokoœæ (100).
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class Button extends JButton {
	private final int width = 100;
	private final int height = 50;
	
	/**
	 * Konstruktor tworzy przycisk o sta³ych wymiarach, w po³o¿eniu okreœlonym wspó³rzêdnymi x i y oraz o podanej nazwie.
	 * U¿ywa do tego metod klasy javax.swing.JButton.
	 * 
	 * @param x wspó³rzêdna x lewego górnego rogu przycisku
	 * @param y wspó³rzêdna y lewego górnego rogu przycisku
	 * @param name nazwa przycisku reprezentowana przez tekst na przycisku
	 */
	public Button( int x, int y, String name ) {
		this.setBounds( x, y, width, height );
		this.setText( name );
	}
}
