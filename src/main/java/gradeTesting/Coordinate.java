package gradeTesting;

public class Coordinate {
	private int x;
	private int y;
	
	public Coordinate(){
		// TODO Auto-generated constructor stub
	}
	
	public Coordinate(int i, int j) {
		// TODO Auto-generated constructor stub
		checkCoords(i, j);
		x = i;
		y = j;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean checkCoords(int x, int y) {
		if (x<0 || y<0) {
			return false;
		}
		return true;
	}
}
