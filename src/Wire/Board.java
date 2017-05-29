package Wire;

import java.io.File;

public class Board {
	
	public class Cell {
		
		private int value = 0;
		
		public void setValue( int value ) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
		
		
		public int checkNeighbours( int h, int w ) {
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
	
	
	private int size;
	private Cell cells[][];
	public int gen;
	public File source;
	
	public Board( int size, int gen, File source ) {
		this.size = size;
		this.gen = gen;
		this.source = source;
		
		cells = new Cell[size][size];
		for( int i=0; i<this.size; i++ )
			for( int j=0; j<this.size; j++ )
				cells[i][j] = new Cell();
		}
	
	public int getSize() {
		return size;
	}
	
	public Cell getCell( int i, int j ) {
		return cells[i][j];
	}
	
	
	public void nextGen() {
		Board newBoard = new Board( this.size, this.gen-1, this.source );
		
		for( int i=0; i<size; i++ )
			for( int j=0; j<size; j++ )
				newBoard.cells[i][j].setValue( cells[i][j].newValue( i, j ) );
		
		cells = newBoard.cells;
	}
	
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for( int i=0; i<size; i++ ) {
			for( int j=0; j<size; j++ )
				s.append( Integer.toString( cells[i][j].value ) );
			s.append("\n");
		}
		
		return s.toString();
	}
	
}
