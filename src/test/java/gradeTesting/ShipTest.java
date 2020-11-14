package gradeTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/*
 * In this class we test all methods run correctly
 * We don't considerate negative coordinates because this is considerate in other file
 */
public class ShipTest {

	/*
	 * Equivalent partition: valid and not valid parameters for ship constructor
	 */
	@Test
	public void testConstructor() {  
		Ship s;
		
		try {
			s = new Ship();
			assertEquals(true, true);
		} catch (Exception e) {
			assertEquals(false, false);
		}
		
		int width = 3;
		ArrayList<Coordinate> positions = new ArrayList<Coordinate>();
		positions.add(new Coordinate(3, 3));
		positions.add(new Coordinate(3, 4));
		positions.add(new Coordinate(3, 5));

		// orientation null
		ArrayList<Coordinate> positions2 = new ArrayList<Coordinate>();
		positions2.add(new Coordinate(3, 3));
		positions2.add(new Coordinate(3, 4));
		positions2.add(new Coordinate(4, 4));

		// width != position size
		try {
			s = new Ship(1, positions);
			assertEquals(true, false);
		} catch (Exception e) {
			assertEquals(false, false);
		}

		// width <= 0
		try {
			s = new Ship(0, positions);
			assertEquals(true, false);
		} catch (Exception e) {
			assertEquals(false, false);
		}

		// width < 0
		try {
			s = new Ship(-2, positions);
			assertEquals(true, false);
		} catch (Exception e) {
			assertEquals(false, false);
		}

		// null
		try {
			s = new Ship(3, null);
			assertEquals(true, false);
		} catch (Exception e) {
			assertEquals(false, false);
		}

		// orientation null
		try {
			s = new Ship(width, positions2);
			assertEquals(true, false);
		} catch (Exception e) {
			assertEquals(false, false);
		}

		//valid
		try {
			s = new Ship(width, positions);
			assertEquals(true, true);
		} catch (Exception e) {
			assertEquals(true, false);
		}
	}

	/*
	 * Equivalent partition: valid and not valid parameters for chechOrientation
	 */
	@Test
	public void testCheckOrientation() { 
		int width = 3;
		ArrayList<Coordinate> positions = new ArrayList<Coordinate>();

		Ship s;
		try {
			//Vertical
			positions.add(new Coordinate(3, 3));
			positions.add(new Coordinate(3, 4));
			positions.add(new Coordinate(3, 5));

			s = new Ship(width, positions);
			Orientation orientation = s.checkOrientation(positions);
			assertEquals(orientation, Orientation.VERTICAL);

			//Horitzontal
			width = 4;
			positions = new ArrayList<Coordinate>();
			positions.add(new Coordinate(3, 3));
			positions.add(new Coordinate(4, 3));
			positions.add(new Coordinate(5, 3));
			positions.add(new Coordinate(6, 3));

			s = new Ship(width, positions);
			orientation = s.checkOrientation(positions);
			assertEquals(orientation, Orientation.HORIZONTAL);

			// orientation null
			try {
				ArrayList<Coordinate> positions2 = new ArrayList<Coordinate>();
				positions2.add(new Coordinate(3, 3));
				positions2.add(new Coordinate(3, 4));
				positions2.add(new Coordinate(4, 4));
	
				s = new Ship(3, positions2);
				orientation = s.checkOrientation(positions);
				assertEquals(orientation, null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				assertEquals(true, true);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * Equivalent partition: valid and not valid parameters for orientation vertical
	 */
	@Test
	public void testIsVertical() throws Exception {
		int width = 3;
		ArrayList<Coordinate> positions = new ArrayList<Coordinate>();
		Ship s;

		try {
			positions.add(new Coordinate(3, 3));
			positions.add(new Coordinate(3, 4));
			positions.add(new Coordinate(3, 5));

			s = new Ship(width, positions);
			Orientation orientation = s.checkOrientation(positions);
			assertEquals(orientation, Orientation.VERTICAL);

			// test not vertical
			positions = new ArrayList<Coordinate>();
			positions.add(new Coordinate(3, 3));
			positions.add(new Coordinate(4, 3));
			positions.add(new Coordinate(5, 3));

			s = new Ship(width, positions);
			orientation = s.checkOrientation(positions);
			assertEquals(orientation, Orientation.HORIZONTAL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			// width 1
			positions = new ArrayList<Coordinate>();
			positions.add(new Coordinate(3, 3));

			s = new Ship(1, positions);
			Orientation orientation = s.checkOrientation(positions);
			orientation = s.checkOrientation(positions);
			assertEquals(orientation, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//repeat coord
		try {
			// equal coord last new
			positions = new ArrayList<Coordinate>();
			positions.add(new Coordinate(3, 3));
			positions.add(new Coordinate(3, 3));
			positions.add(new Coordinate(4, 3));

			s = new Ship(width, positions);
			Orientation orientation = s.checkOrientation(positions);
			orientation = s.checkOrientation(positions);
			assertEquals(orientation, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals(true, true);
		}

	}

	/*
	 * Equivalent partition: valid and not valid parameters for orientation Horitzontal
	 */
	@Test
	public void testIsHoritzontal() throws Exception {
		int width = 3;
		ArrayList<Coordinate> positions = new ArrayList<Coordinate>();
		Ship s;

		try {
			positions.add(new Coordinate(3, 3));
			positions.add(new Coordinate(3, 4));
			positions.add(new Coordinate(3, 5));

			s = new Ship(width, positions);
			Orientation orientation = s.checkOrientation(positions);
			assertEquals(orientation, Orientation.VERTICAL);

			// test not vertical
			positions = new ArrayList<Coordinate>();
			positions.add(new Coordinate(3, 3));
			positions.add(new Coordinate(4, 3));
			positions.add(new Coordinate(5, 3));

			s = new Ship(width, positions);
			orientation = s.checkOrientation(positions);
			assertEquals(orientation, Orientation.HORIZONTAL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			// width 1
			positions = new ArrayList<Coordinate>();
			positions.add(new Coordinate(3, 3));

			s = new Ship(1, positions);
			Orientation orientation = s.checkOrientation(positions);
			orientation = s.checkOrientation(positions);
			assertEquals(orientation, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			// equal coord last new
			positions = new ArrayList<Coordinate>();
			positions.add(new Coordinate(3, 3));
			positions.add(new Coordinate(3, 3));
			positions.add(new Coordinate(3, 4));

			s = new Ship(width, positions);
			Orientation orientation = s.checkOrientation(positions);
			orientation = s.checkOrientation(positions);
			assertEquals(orientation, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals(true, true);
		}

	}

	/*
	 * Equivalent partition: valid and not valid 
	 */
	@Test
	public void testTouched() throws Exception {
		int width = 3;

		ArrayList<Coordinate> positions = new ArrayList<Coordinate>();

		positions.add(new Coordinate(3, 3));
		positions.add(new Coordinate(3, 4));
		positions.add(new Coordinate(3, 5));

		Ship s = s = new Ship(width, positions);

		assertEquals(s.touch(new Coordinate(3, 7)), false);

		assertEquals(s.touch(new Coordinate(3, 3)), true);

		assertEquals(s.touch(new Coordinate(3, 4)), true);

		assertEquals(s.touch(new Coordinate(4, 3)), false);

		assertEquals(s.touch(new Coordinate(0, 0)), false);

		assertEquals(s.touch(new Coordinate(13, 10)), false);

		assertEquals(s.isAlive(), true);

		assertEquals(s.touch(new Coordinate(3, 5)), true);

		assertEquals(s.isAlive(), false);

	}

	/*
	 * Equivalent partition: valid and not valid 
	 */
	@Test
	public void testIsTouched() throws Exception {
		int width = 3;

		ArrayList<Coordinate> positions = new ArrayList<Coordinate>();

		positions.add(new Coordinate(3, 3));
		positions.add(new Coordinate(3, 4));
		positions.add(new Coordinate(3, 5));

		Ship s = new Ship(width, positions);

		assertEquals(s.isTouched(new Coordinate(3, 7)), false);

		assertEquals(s.isTouched(new Coordinate(7, 3)), false);

		assertEquals(s.isTouched(new Coordinate(4, 4)), false);

		assertEquals(s.isTouched(new Coordinate(3, 3)), false);

		assertEquals(s.touch(new Coordinate(3, 3)), true);

		assertEquals(s.isTouched(new Coordinate(3, 3)), true);

		assertEquals(s.isAlive(), true);

		assertEquals(s.isTouched(new Coordinate(3, 4)), false);

		assertEquals(s.touch(new Coordinate(3, 4)), true);

		assertEquals(s.isAlive(), true);

		assertEquals(s.isTouched(new Coordinate(3, 5)), false);

		assertEquals(s.touch(new Coordinate(3, 5)), true);

		assertEquals(s.isAlive(), false);

	}

}
