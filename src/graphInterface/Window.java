package graphInterface;

import javax.swing.JFrame;

/**
 * Klasa reprezentuje okno, w kt�rym otwierana jest aplikacja.
 * Okno ma okre�lon� wysoko�� (670) i szeroko�� (500).
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class Window extends JFrame {
	
	private final int height = 670;
	private final int width = 500;
	
	/**
	 * Konstruktor tworzy okno symulacji WireWorld.
	 * Pos�uguje si� do tego metodami klasy javax.swing.JFrame. Dodaje do okna obiekty klas PanelBoard i Panel.
	 */
	public Window() {
		super( "WireWorld" );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		setSize( width, height );
		setResizable( false );
		setLocationRelativeTo( null );
		
		Panel buttons = new Panel( this, new PanelBoard() );
		
		add( buttons );
		add( buttons.board );
		
		setVisible( true );
		
	}
}