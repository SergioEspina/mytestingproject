package gradeTesting;

public class Board {
	
	private int rowSize;
	private int colSize;
	private Ship[][] board;
			
	public Board(int x, int y) {
		board = new Ship[x][y];
		colSize = y-1;
		rowSize = x-1;
		
		initBoard();
	}
	
	private void initBoard() {
		for(int i=0; i<=rowSize; i++) {
			for(int j=0; j<=colSize; j++) {
				board[i][j]= null;
			}
		}
	}
	
	public int getRowSize() {
		return rowSize;
	}
	
	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}
	
	public int getColSize() {
		return colSize;
	}
	
	public void setColSize(int colSize) {
		this.colSize = colSize;
	}
	
	public Ship[][] getBoard(){
		return board;
		
	}
		
}
