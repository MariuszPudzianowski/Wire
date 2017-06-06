package Wire;

/**
 * Interfejs okreœlaj¹cy dodawanie obiektu jako zachowanie wspólne dla ka¿dego z nich.
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public interface BoardObject {
	
	/**
	 * Metoda dodaje obiekt okreœlony w pliku konfiguracyjnym do tablicy.
	 * 
	 * @param b tablica
	 * @param ifBack
	 */
	public void addToBoard( Board b, int ifBack );
	
}
