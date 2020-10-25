package gradeTesting;

public class Board {
	
	public static int rowSize;
	public static int colSize;
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
	
	public int getColSize() {
		return colSize;
	}
	
	public Ship[][] getBoard(){
		return board;
		
	}
	
	public void print() {
		for(int i=0; i<=rowSize; i++) {
			System.out.println();
			for(int j=0; j<=colSize; j++) {
				String stringPrint;
				if(board[i][j] == null) {
					stringPrint = "0";
				}else {
					stringPrint = board[i][j].isTouched(new Coordinate(i,j)) ? "2" : "1";
				}
				System.out.print("|" + stringPrint + "|");
			}
			
			System.out.println();
			System.out.print("");
			for(int j=0; j<=colSize; j++) System.out.print(" _ ");
			System.out.println();
		}
		
	}
		
}
