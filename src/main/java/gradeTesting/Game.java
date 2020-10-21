package gradeTesting;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	private ArrayList<Player> players;
	private int boardRows;
	private int boardCols;
	private boolean over;
	
	public Game(int boardRows, int boardCols) {
		players = new ArrayList<Player>();
		this.boardRows = boardRows;
		this.boardCols = boardCols;
		over = false;
	}
	
	
	
	private boolean isOver() {return over;}
	
	public void createPlayer() {
		Board b = new Board(boardRows, boardCols);

		Player p = new Player(players.size()+1, b);
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("number of ships: ");
		try {
			/*
			 * read and create number of ships
			 */
			int nShips = Integer.parseInt(in.nextLine());
						
			for(int i=0; i<nShips; i++) {
				
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
				p.addShip(shipCoords.size(), shipCoords);
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
		
		while(!isOver() && players.size()>1) {
			System.out.println("Player " + turn+1 + "'s turn");
			Player p = players.get(turn);
			
			try {
				
				System.out.println("coordinate to attack (coordinate comma separated x,y): ");
				System.out.println();
				
				String[] xy = in.nextLine().split(",");
				boolean success = p.attacked(new Coordinate(Integer.parseInt(xy[0]), Integer.parseInt(xy[1])));
				
				if(success) {
					System.out.println("You hit a ship in position: " + xy[0] + "," + xy[1] );
					
					if(!p.isAlive()) {
						players.remove(turn);
						System.out.println("Player " + p.getPlayerNumber() + " was eliminated!");
						over = players.size()<=1;
					}
					
				}
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		System.out.println("Player " + players.get(0).getPlayerNumber() + " wins!");
		
	}
	
	
	
	
}
