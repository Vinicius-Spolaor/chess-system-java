package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		
		ChessMatch chessMatch = new ChessMatch();
		
		while(true) {
			UI.printBoard(chessMatch.getPieces());
			
			System.out.println();
			
			System.out.print("Origem: ");
			ChessPosition source = UI.readChessPosition(tec);
			
			System.out.println("Destino: ");
			ChessPosition target = UI.readChessPosition(tec);
			
			ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
		}
	}

}
