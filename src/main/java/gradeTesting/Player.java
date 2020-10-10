package gradeTesting;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

	private ArrayList<Ship> ships;
	private ArrayList<Ship> remShips;
	private boolean isAlive;
	
	public Player() {
		ships = new ArrayList<Ship>();
		remShips = new ArrayList<Ship>();
		isAlive = true;
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
	
	private void addShip(int width, ArrayList<Coordinate> coord) throws Exception {
		ships.add(new Ship(width, coord));
	}
	
	private void addShips(ArrayList<Integer> widths, ArrayList<ArrayList<Coordinate>> cords) throws Exception {
		if(widths.size() != cords.size())
			throw new Exception("amount of widths and coords provide must be the same");
		
		for(int i=0; i<widths.size(); i++) {
			ships.add(new Ship(widths.get(i), cords.get(i)));
			remShips.add(new Ship(widths.get(i), cords.get(i)));
		}
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
				break;
			}
				
		}
		
		if (!remShips.get(i).isAlive())
			remShips.remove(i);
		return touched;
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	
	
}
