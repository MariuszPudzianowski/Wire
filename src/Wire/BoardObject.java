package Wire;

/**
 * Interfejs określający dodawanie obiektu jako zachowanie wspólne dla każdego z nich.
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public interface BoardObject {
	
	/**
	 * Metoda dodaje obiekt określony w pliku konfiguracyjnym do tablicy.
	 *
	 * @param b tablica
	 * @param ifBack
	 */
	public void addToBoard( Board b, int ifBack );
	
}
