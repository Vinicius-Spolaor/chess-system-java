package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{
	
	private ChessMatch chessMatch;

	//Constructor
	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	
	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getImoveCount() == 0; 
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getIrows()][getBoard().getIcolumns()];
		
		Position p = new Position(0, 0);
		
		//Above
		p.setValues(position.getIrow() - 1, position.getIcolumn());
		
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getIrow()][p.getIcolumn()] = true;
		}
		
		//Below
		p.setValues(position.getIrow() + 1, position.getIcolumn());
		
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getIrow()][p.getIcolumn()] = true;
		}
			
		//Left
		p.setValues(position.getIrow(), position.getIcolumn() - 1);
		
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getIrow()][p.getIcolumn()] = true;
		}	
		
		//Right
		p.setValues(position.getIrow(), position.getIcolumn() + 1);
		
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getIrow()][p.getIcolumn()] = true;
		}
		
		//Superior Left Diagonal
		p.setValues(position.getIrow() - 1, position.getIcolumn() - 1);
		
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getIrow()][p.getIcolumn()] = true;
		}
		
		//Superior Right Diagonal
		p.setValues(position.getIrow() - 1, position.getIcolumn() + 1);
		
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getIrow()][p.getIcolumn()] = true;
		}
		
		//Inferior Left Diagonal
		p.setValues(position.getIrow() + 1, position.getIcolumn() - 1);
		
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getIrow()][p.getIcolumn()] = true;
		}
		
		//Inferior Right Diagonal
		p.setValues(position.getIrow() + 1, position.getIcolumn() + 1);
		
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getIrow()][p.getIcolumn()] = true;
		}
		
		// #SpecialMove Castling
		if( getImoveCount() == 0 && !chessMatch.getBcheck() ) {
			
			// #SpecialMove Castling Kingside Rook
			Position posT1 = new Position(position.getIrow(), position.getIcolumn() + 3);
			
			if(testRookCastling(posT1)) {
				Position p1 = new Position(position.getIrow(), position.getIcolumn() + 1);
				Position p2 = new Position(position.getIrow(), position.getIcolumn() + 2);
			
				if( getBoard().piece(p1) == null && getBoard().piece(p2) == null ) {
					mat[position.getIrow()][position.getIcolumn() + 2] = true;
				}
			}
			
			// #SpecialMove Castling Queenside Rook
			Position posT2 = new Position(position.getIrow(), position.getIcolumn() - 4);
			
			if(testRookCastling(posT2)) {
				Position p1 = new Position(position.getIrow(), position.getIcolumn() - 1);
				Position p2 = new Position(position.getIrow(), position.getIcolumn() - 2);
				Position p3 = new Position(position.getIrow(), position.getIcolumn() - 3);
				
				if( getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					mat[position.getIrow()][position.getIcolumn() - 2] = true;
				}
			}
		}
		
		return mat;
	}
	
	@Override
	public String toString() {
		return "K";
	}
}
