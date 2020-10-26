package gradeTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


/*
 * In this class we test all methods run correctly
 * We don't considerate negative coordinates
 */
public class ShipTest {

	
	@Test
	public void testConstructor() { //white box
		int width = 3;
		ArrayList<Coordinate> positions = new ArrayList<Coordinate>();
		positions.add(new Coordinate(3,3));
		positions.add(new Coordinate(3,4));
		positions.add(new Coordinate(3,5));
		
		//orientation null
		ArrayList<Coordinate> positions2 = new ArrayList<Coordinate>();
		positions2.add(new Coordinate(3,3));
		positions2.add(new Coordinate(3,4));
		positions2.add(new Coordinate(4,4));
		
		Ship s;
		
		//width != position size
		try {
			s = new Ship(1, positions);
			assertEquals(true, false);
		}catch (Exception e) {
			assertEquals(false, false);
		}
		
		//width <= 0 
		try {
			s = new Ship(0, positions);
			assertEquals(true, false);
		}catch (Exception e) {
			assertEquals(false, false);
		}
		
		//width < 0 
		try {
			s = new Ship(-2, positions);
			assertEquals(true, false);
		}catch (Exception e) {
			assertEquals(false, false);
		}
		
		//null
		try {
			s = new Ship(3, null);
			assertEquals(true, false);
		}catch (Exception e) {
			assertEquals(false, false);
		}
	
		//orientation null
		try {
			s = new Ship(width, positions2);
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
	public void testCheckOrientation() { //white box
		int width = 3;
		ArrayList<Coordinate> positions = new ArrayList<Coordinate>();
		
		
		Ship s;
		try {
			//horizontal
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
			
			try {
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
				assertEquals(false,false);
			}
			
			
			//orientation null
			ArrayList<Coordinate> positions2 = new ArrayList<Coordinate>();
			positions2.add(new Coordinate(3,3));
			positions2.add(new Coordinate(3,4));
			positions2.add(new Coordinate(4,4));
			
			s = new Ship(3, positions2);
			orientation = s.checkOrientation(positions);
			assertEquals(orientation, null);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	@Test
	public void testIsVertical() throws Exception {
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
			
			//test not vertical
			positions = new ArrayList<Coordinate>();
			positions.add(new Coordinate(3,3));
			positions.add(new Coordinate(4,3));
			positions.add(new Coordinate(5,3));
			
			s = new Ship(width, positions);
			orientation = s.checkOrientation(positions);
			assertEquals(orientation, Orientation.HORIZONTAL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			//width 1
			positions = new ArrayList<Coordinate>();
			positions.add(new Coordinate(3,3));
			
			s = new Ship(1, positions);
			Orientation orientation = s.checkOrientation(positions);
			orientation = s.checkOrientation(positions);
			assertEquals(orientation, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			//equal coord last new
			positions = new ArrayList<Coordinate>();
			positions.add(new Coordinate(3,3));
			positions.add(new Coordinate(3,3));
			positions.add(new Coordinate(4,3));
			
			s = new Ship(width, positions);
			Orientation orientation = s.checkOrientation(positions);
			orientation = s.checkOrientation(positions);
			assertEquals(orientation, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testIsHoritzontal() throws Exception {
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
			
			//test not vertical
			positions = new ArrayList<Coordinate>();
			positions.add(new Coordinate(3,3));
			positions.add(new Coordinate(4,3));
			positions.add(new Coordinate(5,3));
			
			s = new Ship(width, positions);
			orientation = s.checkOrientation(positions);
			assertEquals(orientation, Orientation.HORIZONTAL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			//width 1
			positions = new ArrayList<Coordinate>();
			positions.add(new Coordinate(3,3));
			
			s = new Ship(1, positions);
			Orientation orientation = s.checkOrientation(positions);
			orientation = s.checkOrientation(positions);
			assertEquals(orientation, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			//equal coord last new
			positions = new ArrayList<Coordinate>();
			positions.add(new Coordinate(3,3));
			positions.add(new Coordinate(3,3));
			positions.add(new Coordinate(3,4));
			
			s = new Ship(width, positions);
			Orientation orientation = s.checkOrientation(positions);
			orientation = s.checkOrientation(positions);
			assertEquals(orientation, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//@Test
	public void testSunk() {
		
	}
	
	@Test
	public void testTouched() throws Exception {
		int width = 3;
		
		ArrayList<Coordinate> positions = new ArrayList<Coordinate>();
		
		positions.add(new Coordinate(3,3));
		positions.add(new Coordinate(3,4));
		positions.add(new Coordinate(3,5));
		
		Ship s = s = new Ship(width, positions);
		
		assertEquals(s.touch(new Coordinate(3,7)), false);
		
		assertEquals(s.touch(new Coordinate(3,3)), true);
		
		assertEquals(s.touch(new Coordinate(3,4)), true);
		
		assertEquals(s.touch(new Coordinate(4,3)), false);
		
		assertEquals(s.touch(new Coordinate(0,0)), false);
		
		assertEquals(s.touch(new Coordinate(13,10)), false);
		
		assertEquals(s.isAlive(), true);
		
		assertEquals(s.touch(new Coordinate(3,5)), true);
		
		assertEquals(s.isAlive(), false);
		
	}
	
	@Test
	public void testIsTouched() throws Exception {
		int width = 3;
		
		ArrayList<Coordinate> positions = new ArrayList<Coordinate>();
		
		positions.add(new Coordinate(3,3));
		positions.add(new Coordinate(3,4));
		positions.add(new Coordinate(3,5));
		
		Ship s = new Ship(width, positions);
		
		assertEquals(s.isTouched(new Coordinate(3,7)), false);
		
		assertEquals(s.isTouched(new Coordinate(7,3)), false);
		
		assertEquals(s.isTouched(new Coordinate(4,4)), false);
		
		assertEquals(s.isTouched(new Coordinate(3,3)), false);
		
		assertEquals(s.touch(new Coordinate(3,3)), true);
		
		assertEquals(s.isTouched(new Coordinate(3,3)), true);
		
		assertEquals(s.isAlive(), true);
		
		assertEquals(s.isTouched(new Coordinate(3,4)), false);
		
		assertEquals(s.touch(new Coordinate(3,4)), true);
		
		assertEquals(s.isAlive(), true);
		
		assertEquals(s.isTouched(new Coordinate(3,5)), false);
		
		assertEquals(s.touch(new Coordinate(3,5)), true);
		
		assertEquals(s.isAlive(), false);
		
	}
	
}
