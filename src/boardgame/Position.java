package boardgame;

public class Position {
	
	private int irow;
	private int icolumn;
	
	//Constructors
	
	public Position() {
	}
	
	public Position(int irow, int icolumn) {
		this.irow = irow;
		this.icolumn = icolumn;
	}
	
	//Getters and Setters

	public int getIrow() {
		return irow;
	}

	public void setIrow(int irow) {
		this.irow = irow;
	}

	public int getIcolumn() {
		return icolumn;
	}

	public void setIcolumn(int icolumn) {
		this.icolumn = icolumn;
	}
	
	@Override
	public String toString() {
		return irow + ", " + icolumn;
	}
	
	

}
