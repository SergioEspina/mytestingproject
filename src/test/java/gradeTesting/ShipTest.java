package gradeTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ShipTest {

	
	@Test
	public void testConstructor() {
		int width = 3;
		ArrayList<Coordinate> positions = new ArrayList<Coordinate>();
		positions.add(new Coordinate(3,3));
		positions.add(new Coordinate(3,4));
		positions.add(new Coordinate(3,5));
		
		Ship s;
		
		try {
			s = new Ship(1, positions);
			assertEquals(true, false);
		}catch (Exception e) {
			assertEquals(false, false);
		}
		
		try {
			s = new Ship(0, positions);
			assertEquals(true, false);
		}catch (Exception e) {
			assertEquals(false, false);
		}
		
		try {
			s = new Ship(width, positions);
			assertEquals(true, true);
		}catch (Exception e) {
			assertEquals(true, false);
		}
	}
	
	
	@Test
	public void testCheckOrientation() {
		int width = 3;
		ArrayList<Coordinate> positions = new ArrayList<Coordinate>();
		
		
		Ship s;
		try {
			
			positions.add(new Coordinate(3,3));
			positions.add(new Coordinate(3,4));
			positions.add(new Coordinate(3,5));
			
			s = new Ship(width, positions);
			Orientation orientation = s.checkOrientation(positions);
			assertEquals(orientation, Orientation.VERTICAL);
			
			width=4;
			positions = new ArrayList<Coordinate>();
			positions.add(new Coordinate(3,3));
			positions.add(new Coordinate(4,3));
			positions.add(new Coordinate(5,3));
			positions.add(new Coordinate(6,3));
			
			
			s = new Ship(width, positions);
			orientation = s.checkOrientation(positions);
			assertEquals(orientation, Orientation.HORIZONTAL);
			
			width=5;
			positions = new ArrayList<Coordinate>();
			positions.add(new Coordinate(10,9));
			positions.add(new Coordinate(9,8));
			positions.add(new Coordinate(8,7));
			positions.add(new Coordinate(7,6));
			positions.add(new Coordinate(6,5));
			orientation = s.checkOrientation(positions);
			
			s = new Ship(width, positions);
			orientation = s.checkOrientation(positions);
			assertEquals(orientation, Orientation.DIAGONAL);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	
	@Test
	public void testSunk() {
		
	}
	
	@Test
	public void testTouched() {
		
	}

}
