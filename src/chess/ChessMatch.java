package chess;

import boardgame.Board;
import boardgame.Position;
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
	
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
		board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
		board.placePiece(new King(board, Color.WHITE), new Position(7, 4));
	}
	
}
