package gradeTesting;

public class mainView {
	
	private static playerController c;
	
	public mainView(playerController c) {
		this.c = c;
	}
	
	public static void prepareGame() {
		
		System.out.println("Starting game, size of board is 10x10"); 
		System.out.println("You have 10 ships");
		System.out.println("Player 1 create and put your ships");
		c.createPlayer();
		
		System.out.println("Player 2 create and put your ships");
		c.createPlayer();
		
		
	}
	
	public static void printMenu() {
		
		System.out.println("1. See my board");
		System.out.println("2. See enemy board");
		System.out.println("3. Atack");
		System.out.println("4. Surrender");
			
	}
	
	public static void printBoard(Board b) {
		
		for(int i=0; i<= b.rowSize; i++) {
			System.out.println();
			for(int j=0; j<= b.colSize; j++) {
				String stringPrint;
				if(b.getBoard()[i][j] == null) {
					stringPrint = "0";
				}else {
					stringPrint = b.getBoard()[i][j].isTouched(new Coordinate(i,j)) ? "2" : "1";
				}
				System.out.print("|" + stringPrint + "|");
			}
			
			System.out.println();
			System.out.print("");
			for(int j=0; j<=b.colSize; j++) System.out.print(" _ ");
			System.out.println();
		}
	}
}
