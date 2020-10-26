package gradeTesting;

import java.util.ArrayList;
import java.util.Scanner;

public class playerController {

	private ArrayList<Player> players;
	private int boardRows;
	private int boardCols;
	private boolean over;
	private static mainView view;
	
	private boolean isOver() {return over;}
	
	public playerController(int boardRows, int boardCols) {
		players = new ArrayList<Player>();
		this.boardRows = boardRows;
		this.boardCols = boardCols;
		over = false;
		view = new mainView(this);
	}
	
	public void createPlayer() {
		Board b = new Board(boardRows, boardCols);

		Player p = new Player(players.size()+1, b);
		
		Scanner in = new Scanner(System.in);
		
		try {
			/*
			 * read and create number of ships
			 */
			//int nShips = Integer.parseInt(in.nextLine());
			int nShips = 1;
			boolean insert;
						
			for(int i=0; i<nShips; i++) {
				insert = false;
				
				while(!insert) {
					
					ArrayList<Coordinate> shipCoords = new ArrayList<Coordinate>();
					int x = 0;
					int y = 0;
					System.out.println("Ship " + i + " coordinates x, y should be separated by coma and a space between different entries(x,y w,z ....)");
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
						e.printStackTrace();
					}
				}
				
			}
			
			//add player to list of players
			players.add(p);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
	
	}
	
	public void play() {
		int turn = 0;
		Scanner in = new Scanner(System.in);
		Player p1 = players.get(0);
		Player p2 = players.get(1);
		boolean correct = false;
		
		while(!isOver() && players.size()>1) {
			correct = false;
			
			while(!correct) {
				
				view.printMenu(p1);
				
				correct = selectAction(p1, p2);
				
				if(correct) {
					
					Player temp = p1;
					p1=p2;
					p2 = temp;
					correct = true;
					
				}else {
					correct = false;					
				}

			}
		}
		 
		view.playerWinner(players.get(0));
		
	}
	
	public boolean selectAction(Player p1, Player p2) {
		
		Scanner in = new Scanner(System.in);
		int action = Integer.parseInt(in.nextLine());
		boolean res = false;
		
		switch(action) {
			case 1:
				printBoard(p1);
				res = false;
			case 2:
				printEnemiBoard(p1);
				res = false;
			case 3:
				res = attack(p1, p2);
			/*case 4:
				surrender(p1);
				res = true;*/
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
		
		Scanner in = new Scanner(System.in);
		
		try {
			
			System.out.println("coordinate to attack (coordinate comma separated x,y): ");
			System.out.println();
			
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
			if(e.getMessage().equals("OutR"))
			e.printStackTrace();
			return false;
		}
		
	}
	
	public void surrender(Player p1) {
		players.remove(0);
		view.playerEliminated(p1);
		over = players.size()<=1;
	}
	
	
	public static void main(String[] args) {
		
		playerController controller = new playerController(10,10);
		controller.view.prepareGame();
			
		controller.play();
		
	}
	
}

