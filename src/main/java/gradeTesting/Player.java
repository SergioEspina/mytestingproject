package gradeTesting;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

	private ArrayList<Ship> ships;
	private ArrayList<Ship> remShips;
	private boolean isAlive;
	private Board board;
	
	public Player(Board board) {
		ships = new ArrayList<Ship>();
		remShips = new ArrayList<Ship>();
		isAlive = true;
		this.board = board;
	}
	
	public void createShips() throws Exception {
		Scanner in = new Scanner(System.in);
		
		int n = readInt(in, "enter number of ships: ", "number of ships must be an integer and greater than 0");
		
		for(int i=0; i<n; i++) {
			int width = readInt(in, "enter number of ship's positions: ", "number of positions must be an integer and greater than 0");
			ArrayList<Coordinate> coords = new ArrayList<Coordinate> ();
			for(int j = 0; j<width; j++) {
				coords.add(readCoord(in));
			}
			addShip(width, coords);
		}
		
		in.close();
		 
	}
	
	public void addShip(int width, ArrayList<Coordinate> coord) throws Exception {
		
		for(int i = 0; i < coord.size(); i++) {
			if(!checkCoordsBoards(coord.get(i).getX(), coord.get(i).getY())) throw new Exception("Coords not correct");
		}
		
		Ship boat = new Ship(width, coord);
		ships.add(boat);
		remShips.add(boat);
		//afegir al taulell
	}
	
	public Coordinate play() {
		Scanner in = new Scanner(System.in);
		Coordinate c  = readCoord(in);
		in.close();
		return c;
	}
	
	private int readInt(Scanner in, String message, String errorMsg) {		
		int n = 0;
		while(n<=0) {
			System.out.println(message);
			try {
				String line = in.nextLine();
				n = Integer.parseInt(line);
				if(n <= 0)
					throw new Exception("");
			}catch(Exception e) {
				System.out.println(errorMsg);
			}
		}
		
		
		return n;
	}
	
	private Coordinate readCoord(Scanner in) {
		String c = in.nextLine();
		Coordinate coord = null;
		
		while(!c.matches("\\d{1,2}\\s*,\\s*\\d{1,2}")) {
			System.out.println("enter coordinates: ");
			c = in.nextLine();
		}
		
		String [] coordStr = c.split(",");
		coord = new Coordinate(Integer.parseInt(coordStr[0]), Integer.parseInt(coordStr[1]));
		
		return coord;
	}
	
	public boolean attacked(Coordinate c) {
		boolean touched = false;
		int i;
		for(i=0; i<remShips.size(); i++) {
			touched = remShips.get(i).touch(c);
			if(touched) {
				if (!remShips.get(i).isAlive()) remShips.remove(i);
				//System.out.println("Ship sunk");
				break;
			}
				
		}
		
		return touched;
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	
	public boolean checkCoordsBoards(int x, int y) {
		
		if (x<0 || y<0) {
			return false;
		}else if(x > board.getRowSize()){
			return false;
		}else if(y > board.getColSize()){
			return false;
		}else if(board.getBoard()[x][y] != null) {
			return false;
		}
		
		return true;
	}
	
}
