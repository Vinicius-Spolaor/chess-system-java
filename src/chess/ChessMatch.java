package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch{

	private Board board;
	
	//Constructor
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}
	
	//Methods
	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getIrows()][board.getIcolumns()];
		
		for(int i = 0; i < board.getIrows(); i++) {
			for(int j = 0; j< board.getIcolumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
		
	}
	
	private void placeNewPiece(char ccolumn, int irow, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(ccolumn, irow).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		placeNewPiece('e', 8, new King(board, Color.BLACK));
		placeNewPiece('e', 1, new King(board, Color.WHITE));
	}
	
}
