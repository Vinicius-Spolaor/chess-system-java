package boardgame;

public class Board {
	
	private int irows;
	private int icolumns;
	private Piece[][] pieces;
	
	//Constructors
	
	public Board() {
	}

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
	
	
	
	
}
