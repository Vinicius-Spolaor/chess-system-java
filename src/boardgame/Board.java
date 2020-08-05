package boardgame;

public class Board {
	
	private int irows;
	private int icolumns;
	private Piece[][] pieces;
	
	//Constructor

	public Board(int irows, int icolumns) {
		if(irows < 1 || icolumns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column.");
		}
		
		this.irows = irows;
		this.icolumns = icolumns;
		pieces = new Piece[irows][icolumns];
	}
	
	//Getters and Setters

	public int getIrows() {
		return irows;
	}

	public int getIcolumns() {
		return icolumns;
	}
	
	//Methods
	
	public Piece piece(int irow, int icolumn) {
		if(!positionExists(irow, icolumn)) {
			throw new BoardException("Position not on the board.");
		}
		
		return pieces[irow][icolumn];
	}
	
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board.");
		}
		
		return pieces[position.getIrow()][position.getIcolumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
				throw new BoardException("There is already a piece on position " + position + ".");
		}
		
		pieces[position.getIrow()][position.getIcolumn()] = piece;
		piece.position = position;
		
	}
	
	private boolean positionExists(int irow, int icolumn) {
		return irow >= 0 && irow < irows && icolumn >= 0 && icolumn < icolumns;
	}
	
	public boolean positionExists(Position position){
		return positionExists(position.getIrow(), position.getIcolumn());
	}

	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board.");
		}
		
		return piece(position) != null;
	}
	
}
