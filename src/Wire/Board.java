package Wire;

import java.io.File;

/**
 * Klasa reprezentujaca tablic� kom�rek.
 * Zawiera metody operujace na tablicy i warto�ciach jej p�l.
 * 
 * @author Maciej Tarnowski, Marcin Krasuski
 */
public class Board {
	
	/**
	 * Klasa reprezentuj�ca kom�rk�.
	 * Zawiera metody operuj�ce na warto�ciach kom�rek.
	 * 
	 * @author Maciej Tarnowski, Marcin Krasuski
	 */
	public class Cell {
		
		private int value = 0;
		
		/**
		 * Metoda przypisuje warto�� kom�rce.
		 * 
		 * @param value warto�� do przypisania
		 */
		public void setValue( int value ) {
			this.value = value;
		}
		
		/**
		 * Metoda zwraca warto�� kom�rki.
		 * 
		 * @return warto�� kom�rki
		 */
		public int getValue() {
			return value;
		}
		
		/**
		 * Metoda bada warto�ci s�siaduj�cych kom�rek w celu okre�lenia liczby s�siaduj�cych z dan� kom�rk� g��w elektronu.
		 * 
		 * @param h wsp�rz�dna y
		 * @param w wsp�rz�dna x
		 * @return liczba g��w elektronu
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
		 * Metoda przypisuje kom�rce now� warto�� badaj�c stan planszy z poprzedniej generacji i odnosz�c go do zasad WireWorld.
		 * 
		 * @param h wsp�rz�dna y
		 * @param w wsp�rz�dna x
		 * @return nowa warto�� kom�rki
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
	 * Konstruktor tworzy tablic� kom�rek.
	 * Rozmiary planszy i liczba generacji zale�� od danych podanych w pliku konfiguracyjnym.
	 * 
	 * @param size wielko�� planszy (plansza b�dzie mia�a rozmiar (size x size)
	 * @param gen liczba generacji
	 * @param source �cie�ka pliku konfiguracyjnego
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
	 * Metoda okre�la wielko�� tablicy.
	 * 
	 * @return wielko�� tablicy
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Metoda zwraca kom�rk� o danym po�o�eniu w tablicy.
	 * 
	 * @param i rz�d tablicy (rozpoczynaj�c od 0)
	 * @param j kolumna tablicy (rozpoczynaj�c od 0)
	 * @return szukana kom�rka
	 */
	public Cell getCell( int i, int j ) {
		return cells[i][j];
	}
	
	/**
	 * Metoda wype�nia tablic� nowymi warto�ciami zgodnie z zasadami tworzenia nowej generacji.
	 */
	public void nextGen() {
		Board newBoard = new Board( this.size, this.gen, this.source );
		
		for( int i=0; i<size; i++ )
			for( int j=0; j<size; j++ )
				newBoard.cells[i][j].value = cells[i][j].newValue(i, j);
		
		cells = newBoard.cells;
	}
	
}