package graphInterface;

import java.awt.EventQueue;

/**
 * Klasa g³ówna paczki graphInterface zawieraj¹ca metodê main().
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class Main {
	
	/**
	 * Metoda main().
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Window();
				
			}
		});
	}
}