package gradeTesting;

import java.util.ArrayList;

public class Ship {

	public Ship(int width, ArrayList<Coordinate> positions) {
		// TODO Auto-generated constructor stub
		checkOrientation(positions);
	}

	public boolean checkOrientation(ArrayList<Coordinate> positions) {
		
		Coordinate pos = positions.get(0);
		boolean x = false;
		int accumulate;
		for(int i = 1; i < positions.size(); i++) {
			if (pos.getX() == positions.get(i).getX()) {
				accumulate = pos.getX();
				x = true;
			}else if(pos.getY() == positions.get(i).getY()){
				accumulate = pos.getY();
				x = false;
			}else {
				return false;
			}
		}
		return true;
	}
}
