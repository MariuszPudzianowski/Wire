package Wire;

/**
 * Interfejs okre�laj�cy dodawanie obiektu jako zachowanie wsp�lne dla ka�dego z nich.
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public interface BoardObject {
	
	/**
	 * Metoda dodaje obiekt okre�lony w pliku konfiguracyjnym do tablicy.
	 * 
	 * @param b tablica
	 * @param ifBack
	 */
	public void addToBoard( Board b, int ifBack );
	
}
