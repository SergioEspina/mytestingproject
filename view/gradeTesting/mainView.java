package gradeTesting;

public class mainView {
	 
	private static playerController c;
	
	public mainView(playerController c) {
		this.c = c;
	}
	
	public static void prepareGame() throws Exception {
		
		System.out.println("Starting game, size of board is 10x10"); 
		System.out.println("You have to create 3 ships. The shape of each must be <=4");
		System.out.println("Player 1 create your ships");
		c.createPlayer();
		
		System.out.println("Player 2 create ships");
		c.createPlayer();
		
	}
	
	public static void printMenu(Player p) {
		
		System.out.println("Player " + p.getPlayerNumber() + " is your turn, choose the action:");
		System.out.println("1. Check my board");
		System.out.println("2. Check enemy board");
		System.out.println("3. Atack");
		System.out.println("4. Surrender");
			
	}
	
	public static void hitBoat(String x, String y) {
		System.out.println("You hit a ship in position: " + x + "," + y );	
	}
	
	public static void playerEliminated(Player p) {
		System.out.println("Player " + p.getPlayerNumber() + " was eliminated!");
	}
	
	public static void playerWinner(Player p) {
		System.out.println("Player " + p.getPlayerNumber() + " wins!");
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
