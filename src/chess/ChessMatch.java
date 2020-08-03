package chess;

import boardgame.Board;

public class ChessMatch{

	private Board board;
	
	//Constructor
	public ChessMatch() {
		board = new Board(8, 8);
	}
	
	//Method
	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getIrows()][board.getIcolumns()];
		
		for(int i = 0; i < board.getIrows(); i++) {
			for(int j = 0; j< board.getIcolumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
		
	}
	
}
