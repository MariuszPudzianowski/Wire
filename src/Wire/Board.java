package Wire;

import java.io.File;

/**
 * Klasa reprezentujaca tablicę komórek.
 * Zawiera metody operujace na tablicy i wartościach jej pól.
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class Board {
	
	/**
	 * Klasa reprezentująca komórkę.
	 * Zawiera metody operujące na wartościach komórek.
	 * 
	 * @author Maciej Tarnowski, Marcin Krasuski
	 */
	public class Cell {
		
		private int value = 0;
		
		/**
		 * Metoda przypisuje wartość komórce.
		 * 
		 * @param value wartość do przypisania
		 */
		public void setValue( int value ) {
			this.value = value;
		}
		
		/**
		 * Metoda zwraca wartość komórki.
		 * 
		 * @return wartość komórki
		 */
		public int getValue() {
			return value;
		}
		
		/**
		 * Metoda bada wartości sąsiadujących komórek w celu określenia liczby sąsiadujących z daną komórką głów elektronu.
		 * 
		 * @param h współrzędna y
		 * @param w współrzędna x
		 * @return liczba głów elektronu
		 */
		private int checkNeighbours( int h, int w ) {
			int neighbours = 0;
			
			if( h > 0 ) {
				if( w > 0)
					if( cells[h-1][w-1].value == 2 )
						neighbours++;
				if( cells[h-1][w].value == 2 )
					neighbours++;
				if( w < size-1 )
					if( cells[h-1][w+1].value == 2 )
						neighbours++;
			}
			
			if( w > 0)
				if( cells[h][w-1].value == 2 )
					neighbours++;
			if( w < size-1 )
				if( cells[h][w+1].value == 2 )
					neighbours++;
			
			if( h < size-1 ) {
				if( w > 0)
					if( cells[h+1][w-1].value == 2 )
						neighbours++;
				if( cells[h+1][w].value == 2 )
					neighbours++;
				if( w < size-1 )
					if( cells[h+1][w+1].value == 2 )
						neighbours++;
			}
			
			return neighbours;
		}
		
		/**
		 * Metoda przypisuje komórce nową wartość badając stan planszy z poprzedniej generacji i odnosząc go do zasad WireWorld.
		 * 
		 * @param h współrzędna y
		 * @param w współrzędna x
		 * @return nowa wartość komórki
		 */
		public int newValue( int h, int w ) {
			if( value == 1) {
				if( checkNeighbours( h, w ) == 1 || checkNeighbours( h, w ) == 2 )
					return 2;
				else
					return 1;
			}
			else if( value == 2)
				return 3;
			else if ( value == 3)
				return 1;
			else
				return 0;
		}
		
	}
	
	
	private final int size;
	public final int gen;
	public final File source;
	
	private Cell cells[][];
	
	/**
	 * Konstruktor tworzy tablicę komórek.
	 * Rozmiary planszy i liczba generacji zależą od danych podanych w pliku konfiguracyjnym.
	 *
	 * @param size wielkość planszy (plansza będzie miała rozmiar (size x size)
	 * @param gen liczba generacji
	 * @param source ścieżka pliku konfiguracyjnego
	 */
	public Board( int size, int gen, File source ) {
		this.size = size;
		this.gen = gen;
		this.source = source;
		
		cells = new Cell[size][size];
		for( int i=0; i<this.size; i++ )
			for( int j=0; j<this.size; j++ )
				cells[i][j] = new Cell();
		}
	
	/**
	 * Metoda określa wielkość tablicy.
	 * 
	 * @return wielkość tablicy
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Metoda zwraca komórkę o danym położeniu w tablicy.
	 * 
	 * @param i rząd tablicy (rozpoczynając od 0)
	 * @param j kolumna tablicy (rozpoczynając od 0)
	 * @return szukana komórka
	 */
	public Cell getCell( int i, int j ) {
		return cells[i][j];
	}
	
	/**
	 * Metoda wypełnia tablicę nowymi wartościami zgodnie z zasadami tworzenia nowej generacji.
	 */
	public void nextGen() {
		Board newBoard = new Board( this.size, this.gen, this.source );
		
		for( int i=0; i<size; i++ )
			for( int j=0; j<size; j++ )
				newBoard.cells[i][j].value = cells[i][j].newValue(i, j);
		
		cells = newBoard.cells;
	}
	
}
