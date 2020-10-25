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
			int nShips = 10;
						
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
	
	public static void main(String[] args) {
		
		playerController controller = new playerController(10,10);
		
		view.prepareGame();
		
	}
	
}

