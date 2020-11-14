package gradeTesting;

public class mainView {
	 
	private static playerController c;
	private static CustomOutput o;
	
	public mainView(playerController c, CustomOutput output) {
		this.c = c;
		o = output;
	}
	
	public static void prepareGame() throws Exception {
		
		o.println("Starting game, size of board is 10x10"); 
		o.println("You have 10 ships");
		o.println("Player 1 create and put your ships");
		c.createPlayer();
		
		o.println("Player 2 create and put your ships");
		c.createPlayer();
		
	}
	
	public static void printMenu(Player p) {
		
		o.println("Player " + p.getPlayerNumber() + " is your turn, choose the action:");
		o.println("1. See my board");
		o.println("2. See enemy board");
		o.println("3. Atack");
		o.println("4. Surrender");
			
	}
	
	public static void hitBoat(String x, String y) {
		o.println("You hit a ship in position: " + x + "," + y );	
	}
	
	public static void playerEliminated(Player p) {
		o.println("Player " + p.getPlayerNumber() + " was eliminated!");
	}
	
	public static void playerWinner(Player p) {
		o.println("Player " + p.getPlayerNumber() + " wins!");
	}
	
	public static void printBoard(Board b) {
		
		for(int i=0; i<= b.rowSize; i++) {
			o.println();
			for(int j=0; j<= b.colSize; j++) {
				String stringPrint;
				if(b.getBoard()[i][j] == null) {
					stringPrint = "0";
				}else {
					stringPrint = b.getBoard()[i][j].isTouched(new Coordinate(i,j)) ? "2" : "1";
				}
				System.out.print("|" + stringPrint + "|");
			}
			
			o.println();
			System.out.print("");
			for(int j=0; j<=b.colSize; j++) System.out.print(" _ ");
			o.println();
		}
	}
}
