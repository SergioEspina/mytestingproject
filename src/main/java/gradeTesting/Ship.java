package gradeTesting;

import java.util.ArrayList;

enum Orientation{
	HORIZONTAL,
	VERTICAL,
	DIAGONAL
}

public class Ship {

	private int width;
	private ArrayList<Coordinate> positions;
	private Orientation o;
	private ArrayList<Coordinate> remainingParts;

	public Ship(int width, ArrayList<Coordinate> positions) throws Exception {
		
		if(width < 0 || positions == null || width != positions.size() )
			throw new Exception("Ship is not well formed");
		 
		this.positions = positions;
		
		o = checkOrientation(positions);
		if(o==null)
			throw new Exception("Ship doesn't follow the orientation pattern");
		this.width = width;
		this.positions = positions;
		remainingParts = new ArrayList<Coordinate>();
	}

	public Orientation checkOrientation(ArrayList<Coordinate> positions) {

		if(isVertical()) {
			return Orientation.VERTICAL;
		}else if(isHorizontal()) {
			return Orientation.HORIZONTAL;
		}else if(isDiagonal()) {
			return Orientation.DIAGONAL;
		}else
			return null;
	}
	
	private boolean isInBoundaries() {
		return false;
	}
	
	private boolean isVertical() {
		int lastX = positions.get(0).getX();
		int lastY = positions.get(0).getY();
		boolean isVertical = true;
		
		for (int i = 1; i<width; i++) {

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
		
		for (int i = 1; i<width; i++) {

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
		
		for (int i = 1; i<width; i++) {

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
	
	public boolean touch(Coordinate c) {
		boolean touched = false;
		for(Coordinate cord : remainingParts) {
			if(cord.getX() == c.getX() && cord.getY() == c.getY()) {
				touched = true;
				break;
			}
		}
		
		return touched;
	}
	
	public boolean isAlive() {
		return remainingParts.size() > 0;
	}
	
	public boolean isTouched() {
		return remainingParts.size() == width;
	}
	
	
}
