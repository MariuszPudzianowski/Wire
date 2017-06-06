package Wire;

import java.io.File;

/**
 * Klasa reprezentujaca tablicê komórek.
 * Zawiera metody operujace na tablicy i wartoœciach jej pól.
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class Board {
	
	/**
	 * Klasa reprezentuj¹ca komórkê.
	 * Zawiera metody operuj¹ce na wartoœciach komórek.
	 * 
	 * @author Maciej Tarnowski, Marcin Krasuski
	 */
	public class Cell {
		
		private int value = 0;
		
		/**
		 * Metoda przypisuje wartoœæ komórce.
		 * 
		 * @param value wartoœæ do przypisania
		 */
		public void setValue( int value ) {
			this.value = value;
		}
		
		/**
		 * Metoda zwraca wartoœæ komórki.
		 * 
		 * @return wartoœæ komórki
		 */
		public int getValue() {
			return value;
		}
		
		/**
		 * Metoda bada wartoœci s¹siaduj¹cych komórek w celu okreœlenia liczby s¹siaduj¹cych z dan¹ komórk¹ g³ów elektronu.
		 * 
		 * @param h wspó³rzêdna y
		 * @param w wspó³rzêdna x
		 * @return liczba g³ów elektronu
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
		 * Metoda przypisuje komórce now¹ wartoœæ badaj¹c stan planszy z poprzedniej generacji i odnosz¹c go do zasad WireWorld.
		 * 
		 * @param h wspó³rzêdna y
		 * @param w wspó³rzêdna x
		 * @return nowa wartoœæ komórki
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
	 * Konstruktor tworzy tablicê komórek.
	 * Rozmiary planszy i liczba generacji zale¿¹ od danych podanych w pliku konfiguracyjnym.
	 * 
	 * @param size wielkoœæ planszy (plansza bêdzie mia³a rozmiar (size x size)
	 * @param gen liczba generacji
	 * @param source œcie¿ka pliku konfiguracyjnego
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
	 * Metoda okreœla wielkoœæ tablicy.
	 * 
	 * @return wielkoœæ tablicy
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Metoda zwraca komórkê o danym po³o¿eniu w tablicy.
	 * 
	 * @param i rz¹d tablicy (rozpoczynaj¹c od 0)
	 * @param j kolumna tablicy (rozpoczynaj¹c od 0)
	 * @return szukana komórka
	 */
	public Cell getCell( int i, int j ) {
		return cells[i][j];
	}
	
	/**
	 * Metoda wype³nia tablicê nowymi wartoœciami zgodnie z zasadami tworzenia nowej generacji.
	 */
	public void nextGen() {
		Board newBoard = new Board( this.size, this.gen, this.source );
		
		for( int i=0; i<size; i++ )
			for( int j=0; j<size; j++ )
				newBoard.cells[i][j].value = cells[i][j].newValue(i, j);
		
		cells = newBoard.cells;
	}
	
}