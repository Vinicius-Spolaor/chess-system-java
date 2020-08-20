package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece{
	
	private ChessMatch chessMatch;
	
	//Constructor
	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board,color);
		this.chessMatch = chessMatch;
	}
	
	@Override
	public boolean[][] possibleMoves(){
		boolean[][] mat = new boolean[getBoard().getIrows()][getBoard().getIcolumns()];
		
		Position p = new Position(0, 0);
		
		if(getColor() == Color.WHITE) {
			p.setValues(position.getIrow() - 1, position.getIcolumn());
			
			if( getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) ) {
				mat[p.getIrow()][p.getIcolumn()] = true;
			}
			
			p.setValues(position.getIrow() - 2, position.getIcolumn());
			Position p2 = new Position(position.getIrow() - 1, position.getIcolumn());
			
			if( getBoard().positionExists(p)  && !getBoard().thereIsAPiece(p)  && 
				getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) &&
				getImoveCount() == 0 ) {
				
				mat[p.getIrow()][p.getIcolumn()] = true;
			}
			
			p.setValues(position.getIrow() - 1, position.getIcolumn() - 1);
			
			if( getBoard().positionExists(p) && isThereOpponentPiece(p) ) {
				mat[p.getIrow()][p.getIcolumn()] = true;
			}
			
			p.setValues(position.getIrow() - 1, position.getIcolumn() + 1);
			
			if( getBoard().positionExists(p) && isThereOpponentPiece(p) ) {
				mat[p.getIrow()][p.getIcolumn()] = true;
			}
			
			// #SpecialMove en passant WHITE
			if(position.getIrow() == 3) {
				Position left = new Position(position.getIrow(), position.getIcolumn() - 1);
				
				if(getBoard().positionExists(left) && 
				   isThereOpponentPiece(left)      &&
				   getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					
					mat[left.getIrow() - 1][left.getIcolumn()] = true;
				}
				
				Position right = new Position(position.getIrow(), position.getIcolumn() +- 1);
				
				if(getBoard().positionExists(right) && 
				   isThereOpponentPiece(right)      &&
				   getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					
					mat[right.getIrow() - 1][right.getIcolumn()] = true;
				}
			}
			
		//black pieces logics
		}else { 
			p.setValues(position.getIrow() + 1, position.getIcolumn());
			
			if( getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) ) {
				mat[p.getIrow()][p.getIcolumn()] = true;
			}
			
			p.setValues(position.getIrow() + 2, position.getIcolumn());
			Position p2 = new Position(position.getIrow() + 1, position.getIcolumn());
			
			if( getBoard().positionExists(p)  && !getBoard().thereIsAPiece(p)  && 
				getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) &&
				getImoveCount() == 0 ) {
				
				mat[p.getIrow()][p.getIcolumn()] = true;
			}
			
			p.setValues(position.getIrow() + 1, position.getIcolumn() - 1);
			
			if( getBoard().positionExists(p) && isThereOpponentPiece(p) ) {
				mat[p.getIrow()][p.getIcolumn()] = true;
			}
			
			p.setValues(position.getIrow() + 1, position.getIcolumn() + 1);
			
			if( getBoard().positionExists(p) && isThereOpponentPiece(p) ) {
				mat[p.getIrow()][p.getIcolumn()] = true;
			}
			
		// #SpecialMove en passant BLACK
			if( position.getIrow() == 4) {
				Position left = new Position(position.getIrow(), position.getIcolumn() - 1);
				
				if(getBoard().positionExists(left) && 
				   isThereOpponentPiece(left)      &&
				   getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					
					mat[left.getIrow() + 1][left.getIcolumn()] = true;
				}
				
				Position right = new Position(position.getIrow(), position.getIcolumn() +- 1);
				
				if(getBoard().positionExists(right) && 
				   isThereOpponentPiece(right)      &&
				   getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					
					mat[right.getIrow() + 1][right.getIcolumn()] = true;
				}
			}
		}
		return mat;
	}

	@Override
	public String toString() {
		return "P";
	}
	
	
}
