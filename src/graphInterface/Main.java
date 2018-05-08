package graphInterface;

import java.awt.EventQueue;

/**
 * Klasa g��wna paczki graphInterface zawieraj�ca metod� main().
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