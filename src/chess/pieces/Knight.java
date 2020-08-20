package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

	public class Knight extends ChessPiece{
		
		public Knight(Board board, Color color) {
			super(board, color);
		}
		
		private boolean canMove(Position position) {
			ChessPiece p = (ChessPiece)getBoard().piece(position);
			return p == null || p.getColor() != getColor();
		}
		
		@Override
		public boolean[][] possibleMoves(){
			boolean[][] mat = new boolean[getBoard().getIrows()][getBoard().getIcolumns()];
		
			Position p = new Position(0, 0);
		

			p.setValues(position.getIrow() - 1, position.getIcolumn() - 2);
			
			if(getBoard().positionExists(p) && canMove(p)) {
				mat[p.getIrow()][p.getIcolumn()] = true;
			}
			
		
			p.setValues(position.getIrow() - 2, position.getIcolumn() - 1);
			
			if(getBoard().positionExists(p) && canMove(p)) {
				mat[p.getIrow()][p.getIcolumn()] = true;
			}
		
			p.setValues(position.getIrow() - 2, position.getIcolumn() + 1);
			
			if(getBoard().positionExists(p) && canMove(p)) {
				mat[p.getIrow()][p.getIcolumn()] = true;
			}	
			
			p.setValues(position.getIrow() - 1, position.getIcolumn() + 2);
			
			if(getBoard().positionExists(p) && canMove(p)) {
				mat[p.getIrow()][p.getIcolumn()] = true;
			}
			
		
			p.setValues(position.getIrow() + 1, position.getIcolumn() + 2);
			
			if(getBoard().positionExists(p) && canMove(p)) {
				mat[p.getIrow()][p.getIcolumn()] = true;
			}
			
		
			p.setValues(position.getIrow() + 2, position.getIcolumn() + 1);
			
			if(getBoard().positionExists(p) && canMove(p)) {
				mat[p.getIrow()][p.getIcolumn()] = true;
			}
			
		
			p.setValues(position.getIrow() + 2, position.getIcolumn() - 1);
			
			if(getBoard().positionExists(p) && canMove(p)) {
				mat[p.getIrow()][p.getIcolumn()] = true;
			}
			
		
			p.setValues(position.getIrow() + 1, position.getIcolumn() - 2);
			
			if(getBoard().positionExists(p) && canMove(p)) {
				mat[p.getIrow()][p.getIcolumn()] = true;
			}
			return mat;
		
		}

		@Override
		public String toString() {
			return "N";
		}
		
	}

