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
	
	public Ship() {
		width = 1;
	}

	public Ship(int width, ArrayList<Coordinate> positions) throws Exception {
		
		if(width <= 0 || width > 4|| positions == null || width != positions.size() )
			throw new Exception("Ship is not well formed");
		 
		this.positions = positions;
		this.width = width;
		
		o = checkOrientation(positions);
		if(o==null && width > 1)
			throw new Exception("Ship doesn't follow the orientation pattern");
		
		remainingParts = (ArrayList<Coordinate>) positions.clone();
		
		
	}
	
	public ArrayList<Coordinate> getPositions(){
		return positions;
	}

	public Orientation checkOrientation(ArrayList<Coordinate> positions) {

		if(isVertical()) {
			return Orientation.VERTICAL;
		}else if(isHorizontal()) {
			return Orientation.HORIZONTAL;
		/*}else if(isDiagonal()) {
			return Orientation.DIAGONAL;*/
		}else
			return null;
	}
	
	private boolean isVertical() {
		int lastX = positions.get(0).getX();
		int lastY = positions.get(0).getY();
		boolean isVertical = true;
		
		if(width == 1) return false;
		
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
		
		if(width == 1) return false;
		
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
	
	/*private boolean isDiagonal() {
		int lastX = positions.get(0).getX();
		int lastY = positions.get(0).getY();
		boolean isDiagonal = true;
		
		if(width == 1) return false;
		
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
	}*/
	
	/*
	 * 
	 * Check if the provided coordinate is an untouched part of the ship.
	 * If the coordinate touches a part of the ship remove it from the remaining active coordinates
	 */
	public boolean touch(Coordinate c) {
		boolean touched = false;
		int i;
		for( i = 0; i< remainingParts.size(); i++) {
			
			Coordinate cord = remainingParts.get(i);
			/*System.out.println("cordX: " + cord.getX() + ", cX " + c.getX());
			System.out.println("cordY: " + cord.getY() + ", cY " + c.getY());*/
			if(cord.getX() == c.getX() && cord.getY() == c.getY()) {
				
				touched = true;
				break;
			}
		}
		if(touched)
			remainingParts.remove(i);
		
		
		return touched;
	}
	
	public boolean isAlive() {
		return remainingParts.size() > 0;
	}
	
	/*
	 *  check if the coordinate has been touched
	 */
	public boolean isTouched(Coordinate c) {
		boolean result = true;
		boolean contain = false;
		
		
		for(Coordinate co : positions) {
			if(co.getX() == c.getX() && co.getY() == c.getY()) {
				contain = true;
				break;
			}
		}
		
		if(!contain) return false;
		
		for(Coordinate co : remainingParts) {
			if(co.getX() == c.getX() && co.getY() == c.getY()) {
				result = false;
				break;
			}
		}
		
		return result;
			
	}
	
	
}
