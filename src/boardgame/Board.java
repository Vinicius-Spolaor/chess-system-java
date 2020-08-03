package boardgame;

public class Board {
	
	private int irows;
	private int icolumns;
	private Piece[][] pieces;
	
	//Constructor

	public Board(int irows, int icolumns) {
		this.irows = irows;
		this.icolumns = icolumns;
		pieces = new Piece[irows][icolumns];
	}
	
	//Getters and Setters

	public int getIrows() {
		return irows;
	}

	public void setIrows(int irows) {
		this.irows = irows;
	}

	public int getIcolumns() {
		return icolumns;
	}

	public void setIcolumns(int icolumns) {
		this.icolumns = icolumns;
	}
	
	//Methods
	
	public Piece piece(int irow, int icolumn) {
		return pieces[irow][icolumn];
	}
	
	public Piece piece(Position position) {
		return pieces[position.getIrow()][position.getIcolumn()];
	}
	
	
	
}
