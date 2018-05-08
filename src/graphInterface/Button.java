package graphInterface;

import javax.swing.JButton;

/**
 * Klasa reprezentuje przycisk znajduj�cy si� na panelu.
 * Przycisk ma okre�lon� wysoko�� (50) i szeroko�� (100).
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class Button extends JButton {
	private final int width = 100;
	private final int height = 50;
	
	/**
	 * Konstruktor tworzy przycisk o sta�ych wymiarach, w po�o�eniu okre�lonym wsp�rz�dnymi x i y oraz o podanej nazwie.
	 * U�ywa do tego metod klasy javax.swing.JButton.
	 * 
	 * @param x wsp�rz�dna x lewego g�rnego rogu przycisku
	 * @param y wsp�rz�dna y lewego g�rnego rogu przycisku
	 * @param name nazwa przycisku reprezentowana przez tekst na przycisku
	 */
	public Button( int x, int y, String name ) {
		this.setBounds( x, y, width, height );
		this.setText( name );
	}
}
