package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

	public Bishop(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getIrows()][getBoard().getIcolumns()];
		
		Position p = new Position(0, 0);
		
		//Superior Right Diagonal
		p.setValues(position.getIrow() - 1, position.getIcolumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getIrow()][p.getIcolumn()] = true;
			p.setValues(p.getIrow() - 1, p.getIcolumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getIrow()][p.getIcolumn()] = true;
		}
		
		//Superior Left Diagonal
		p.setValues(position.getIrow() - 1, position.getIcolumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getIrow()][p.getIcolumn()] = true;
			p.setValues(p.getIrow() - 1, p.getIcolumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getIrow()][p.getIcolumn()] = true;
		}
		
		//Inferior Left Diagonal
		p.setValues(position.getIrow() + 1, position.getIcolumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getIrow()][p.getIcolumn()] = true;
			p.setValues(p.getIrow() + 1, p.getIcolumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getIrow()][p.getIcolumn()] = true;
		}
		
		//Inferior Right Diagonal
		p.setValues(position.getIrow() + 1, position.getIcolumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getIrow()][p.getIcolumn()] = true;
			p.setValues(p.getIrow() + 1, p.getIcolumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getIrow()][p.getIcolumn()] = true;
		}
		
		return mat;
	}
	
	@Override
	public String toString() {
		return "B";
	}
	
}