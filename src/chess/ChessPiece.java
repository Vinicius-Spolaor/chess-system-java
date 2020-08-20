package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece{
	
	private Color color;
	private int imoveCount;

	//Constructor
	
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	//Getter
	
	public Color getColor() {
		return color;
	}
	
	public int getImoveCount() {
		return imoveCount;
	}
	
	public void increaseMoveCount() {
		imoveCount ++;
	}
	
	public void decreaseMoveCount() {
		imoveCount --;
	}
	
	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);
	}
	
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		
		return p != null && p.getColor() != color;
	}
	
}
