
public class LifeBoard {

	private final int rows, cols;
	private int gen = 1;
	private boolean[][] board;

	/** Skapar en spelplan med rows rader och cols kolonner. Spelplanen �r fr�n
	    b�rjan tom, dvs alla rutorna �r tomma och generationsnumret �r 1. */	
	public LifeBoard(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.board = new boolean [rows][cols];
	}

	/** Ger true om det finns en individ i rutan med index row, col, false annars. 
	    Om index row, col �r utanf�r spelplanen returneras false */
	public boolean get(int row, int col) {
		if (row >= rows || row < 0 || col >= cols || col < 0) {
			return false;
		}
		return board[row][col];
	}

	/** Lagrar v�rdet val i rutan med index row, col */
	public void put(int row, int col, boolean val) {
			board[row][col] = val;
	}

	/** Tar reda p� antalet rader */
	public int getRows() {
		return this.rows;
	}

 	/** Tar reda p� antalet kolonner */
	public int getCols() {
		return this.cols;
	}

	/** Tar reda p� aktuellt generationsnummer */
	public int getGeneration() {
		return this.gen;
	}

	/** �kar generationsnumret med ett */
	public void increaseGeneration() {
		this.gen++;
		System.out.println(gen);
	}
}