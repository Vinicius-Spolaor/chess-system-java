package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{

	//Constructor
	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getIrows()][getBoard().getIcolumns()];
		
		Position p = new Position(0, 0);
		
		//Above
		p.setValues(position.getIrow() - 1, position.getIcolumn());
		
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getIrow()][p.getIcolumn()] = true;
			p.setIrow(p.getIrow() - 1);
		}
		
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getIrow()][p.getIcolumn()] = true;
		}
		
		//Left
		p.setValues(position.getIrow(), position.getIcolumn() - 1);
		
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getIrow()][p.getIcolumn()] = true;
			p.setIcolumn(p.getIcolumn() - 1);
		}
		
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getIrow()][p.getIcolumn()] = true;
		}
			
		//Right
		p.setValues(position.getIrow(), position.getIcolumn() + 1);
		
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getIrow()][p.getIcolumn()] = true;
			p.setIcolumn(p.getIcolumn() + 1);
		}
		
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getIrow()][p.getIcolumn()] = true;
		}
		
		//Below
		p.setValues(position.getIrow() + 1, position.getIcolumn());
		
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getIrow()][p.getIcolumn()] = true;
			p.setIrow(p.getIrow() + 1);
		}
		
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getIrow()][p.getIcolumn()] = true;
		}
				
		return mat;
	}
	
	@Override
	public String toString() {
		return "R";
	}
}
