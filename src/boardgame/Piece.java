package boardgame;

public abstract class Piece {
	
	protected Position position;
	private Board board;
	
	//Constructor
	
	public Piece(Board board) {
		this.board = board;
		position = null;
	}
	
	//Getter
	
	protected Board getBoard() {
		return board;
	}

	public abstract boolean[][] possibleMoves(); 
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getIrow()][position.getIcolumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat.length; j++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}