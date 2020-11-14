package gradeTesting;

import java.util.ArrayList;
import java.util.Scanner;

public class playerController {

	private ArrayList<Player> players;
	private int boardRows;
	private int boardCols;
	private boolean over;
	private static mainView view;
	private ScannerInput in;
	private int nShips;
	private CustomOutput output;
	private static final int MAX_FAILED_ATTEMPT = 3;
	private static final int MAX_FAILED_TURNS = 3;
	
	private boolean isOver() {return over;}
	
	public playerController(int boardRows, int boardCols, ScannerInput in, CustomOutput output) {
		players = new ArrayList<Player>();
		this.boardRows = boardRows;
		this.boardCols = boardCols;
		over = false;
		view = new mainView(this, output);
		this.in = in;
		nShips = 3;
		this.output = output;
		
	}
	
	public void createPlayer() throws Exception {
		Board b = new Board(boardRows, boardCols);

		Player p = new Player(players.size()+1, b);
		
		boolean addPlayer = true;
		
		try {
			/*
			 * read and create number of ships
			 */
			//int nShips = Integer.parseInt(in.nextLine());

			boolean insert;
			int failedCords;
			
			for(int i=0; i<nShips; i++) {
				insert = false;
				failedCords = 0;
				
				while(!insert) {
					
					ArrayList<Coordinate> shipCoords = new ArrayList<Coordinate>();
					int x = 0;
					int y = 0;
					output.println("Ship " + i + " coordinates x, y should be separated by coma and a space between different entries(x,y w,z ....)");
					String text = in.nextLine();
					/*
					 * read and create coordinates for each ship
					 */
					for(String coordi : text.split(" ")) {
						String []xy = coordi.split(",");
						x = Integer.parseInt(xy[0]);
						y = Integer.parseInt(xy[1]);
						shipCoords.add(new Coordinate(x,y)); 
					}
					
					//add ship to player
					try {
						p.addShip(shipCoords.size(), shipCoords);
						insert = true;
					}catch(Exception e) {
						
						failedCords += 1;
						if (failedCords >= MAX_FAILED_ATTEMPT) { 
							output.println("You exceded the maximun number of attempts.");
							addPlayer = false;
							break;
						}
						output.println("Coordinates not valid, try again you have " + (MAX_FAILED_ATTEMPT - failedCords) + " more attempts");
						
					}
				}
			}
			
			//add player to list of players
			if (addPlayer) {
				players.add(p);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		output.println();
	
	}
	
	public void play() {
		int turn = 0;
		
		if ( players.size() < 2) {
			
			output.println("Numeró de jugadors inferiors a 2");
			over = true;
			
		}else{
			
			//Scanner in = new Scanner(System.in);
			Player p1 = players.get(0);
			Player p2 = players.get(1);
			
			boolean correct = false;
			
			while(!isOver() && players.size()>1) {
				
				correct = false;
				
				while(!correct) {
					
					view.printMenu(p1);
					
					correct = selectAction(p1, p2);
					
					if(isOver()) {
						correct = true;
						continue;
					}
					
					if(correct) {
						
						Player temp = p1;
						p1=p2;
						p2 = temp;
						correct = true;
						
					}else { //prove if player must be eliminated of the game for failed turns
						Player temp = p1;
						p1=p2;
						p2 = temp;
						correct = false;					
					}

				}
			}
			 
			view.playerWinner(players.get(0));
		}	
		
	}
	
	public boolean selectAction(Player p1, Player p2) {
		
		//Scanner in = new Scanner(System.in);
		int action = Integer.parseInt(in.nextLine());
		boolean res = false;
		
		switch(action) {
			case 1:
				printBoard(p1);
				res = false;
				break;
			case 2:
				printEnemiBoard(p1);
				res = false;
				break;
			case 3:
				res = attack(p1, p2);
				break;
			case 4:
				//surrender(p1);
				view.playerEliminated(p1);
				players.remove(0);
				res = true;
				over = players.size()<=1;
				break;
		}
		
		return res;	
	}
	
	public void printBoard(Player p) {
		view.printBoard(p.getBoard()); 
	}
	
	public void printEnemiBoard(Player p) {
		view.printBoard(p.getEnemiBoard());
	}
	
	public boolean attack(Player p1, Player p2) {
		
		//Scanner in = new Scanner(System.in);
		int failedCords = 0;
		
		while(failedCords < MAX_FAILED_ATTEMPT) {
			
			try {
				
				output.println("coordinate to attack (coordinate comma separated x,y): ");
				output.println();
				
				String[] xy = in.nextLine().split(",");
				Coordinate attack = new Coordinate(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
				boolean success = p2.attacked(attack);
				
				if(success) {
					p1.setEnemi(attack);
					view.hitBoat(xy[0], xy[1]);
					
					if(!p2.isAlive()) {
						players.remove(1);
						view.playerEliminated(p2);
						over = players.size()<=1;
					}
					
				}
				
				return true;
				
			}catch(Exception e) {
				
				failedCords += 1;
				
				if(failedCords >= MAX_FAILED_ATTEMPT) {
					output.println("Turn lost.");
					if(p1.getFailedTurns() >= MAX_FAILED_TURNS) {
						output.println("You exceded the maximun number of attempts");
					}
					p1.setFailedTurns(p1.getFailedTurns() + 1);
					return false;
				}
				output.println("Coordinates not valid, try again you have " + (MAX_FAILED_ATTEMPT - failedCords) + " more attempts.");
							
			}
			
		}
		
		return false;
	}
	
	public void surrender(Player p1) {
		players.remove(0);
		view.playerEliminated(p1);
		over = players.size()<=1;
	}
	
	
	public static void main(String[] args) throws Exception {
		
		ScannerInput in = new ScannerConsole(System.in);
		ConsoleOutput co = new ConsoleOutput();
		
		playerController controller = new playerController(10,10, in, co);
		controller.view.prepareGame();
			
		controller.play();
		
	}
	
}

