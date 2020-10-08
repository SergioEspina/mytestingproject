package gradeTesting;

import java.util.ArrayList;

public class Ship {
	
	private int width;
	private ArrayList<Coordinate> positions;

	public Ship(int width, ArrayList<Coordinate> positions) {
		
		// TODO Auto-generated constructor stub
		checkOrientation(positions);
		
		this.width = width;
		this.positions = positions;
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
	
	private boolean isInBoundaries() {
		return false;
	}
	
	private boolean isVertical() {
		int lastX = positions.get(0).getX();
		int lastY = positions.get(0).getY();
		boolean isVertical = true;
		
		for (int i = 1; i<positions.size(); i++) {

			int currX = positions.get(i).getX();
			int currY = positions.get(i).getY();
			
			if(lastX != currX || currY - lastY != 1) {
				isVertical = false;
				break;
			}
			
			lastX = currX;
			lastY = currY;
		}
		
		return isVertical;
	}
	
	private boolean isHorizontal() {
		int lastX = positions.get(0).getX();
		int lastY = positions.get(0).getY();
		boolean isHorizontal = true;
		
		for (int i = 1; i<positions.size(); i++) {

			int currX = positions.get(i).getX();
			int currY = positions.get(i).getY();
			
			if(lastY != currY || currX - lastX != 1) {
				isHorizontal = false;
				break;
			}
			
			lastX = currX;
			lastY = currY;
		}
		
		return isHorizontal;
	}
	
	private boolean isDiagonal() {
		int lastX = positions.get(0).getX();
		int lastY = positions.get(0).getY();
		boolean isDiagonal = true;
		
		for (int i = 1; i<positions.size(); i++) {

			int currX = positions.get(i).getX();
			int currY = positions.get(i).getY();
			
			if(lastX - currX  != 1 || lastY - currY != 1) {
				isDiagonal = false;
				break;
			}
			
			lastX = currX;
			lastY = currY;
		}
		
		return isDiagonal;
	}
	
	
}
