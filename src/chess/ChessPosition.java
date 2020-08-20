package chess;

import boardgame.Position;

public class ChessPosition {
	
	private char ccolumn;
	private int irow;
	
	//Constructor
	
	public ChessPosition(char ccolumn, int irow) {
		if(ccolumn < 'a' || ccolumn > 'h' || irow < 1 || irow > 8) {
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
		}
		
		this.ccolumn = ccolumn;
		this.irow = irow;
	}

	//Getters and Setters
	
	public char getCcolumn() {
		return ccolumn;
	}

	public int getIrow() {
		return irow;
	}
	
	//Methods
	
	protected Position toPosition() {
		return new Position(8 -  irow, ccolumn - 'a');
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition( (char)('a' + position.getIcolumn()), 8 - position.getIrow());
	}
	
	@Override
	public String toString() {
		return "" + ccolumn + irow;
	}
}
