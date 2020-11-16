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
	 * White and Black box Equivalent partition: valid and not valid parameters for
	 * ship constructor Decision coverage, condition coverage
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
		// min size
		ArrayList<Coordinate> positions0 = new ArrayList<Coordinate>();
		positions0.add(new Coordinate(1, 1));

		// Horitzontal
		ArrayList<Coordinate> positions = new ArrayList<Coordinate>();
		positions.add(new Coordinate(3, 3));
		positions.add(new Coordinate(3, 4));
		positions.add(new Coordinate(3, 5));

		// Vertical
		ArrayList<Coordinate> positions1 = new ArrayList<Coordinate>();
		positions1.add(new Coordinate(3, 3));
		positions1.add(new Coordinate(4, 3));
		positions1.add(new Coordinate(5, 3));

		// orientation null
		ArrayList<Coordinate> positions2 = new ArrayList<Coordinate>();
		positions2.add(new Coordinate(3, 3));
		positions2.add(new Coordinate(3, 4));
		positions2.add(new Coordinate(4, 4));

		// orientation null
		ArrayList<Coordinate> positions6 = new ArrayList<Coordinate>();
		positions6.add(new Coordinate(3, 3));
		positions6.add(new Coordinate(3, 3));
		positions6.add(new Coordinate(3, 4));

		// max size of position
		ArrayList<Coordinate> positions3 = new ArrayList<Coordinate>();
		positions3.add(new Coordinate(4, 3));
		positions3.add(new Coordinate(4, 4));
		positions3.add(new Coordinate(4, 5));
		positions3.add(new Coordinate(4, 6));

		// position of coords are not sequencial
		ArrayList<Coordinate> positions4 = new ArrayList<Coordinate>();
		positions4.add(new Coordinate(3, 3));
		positions4.add(new Coordinate(3, 5));
		positions4.add(new Coordinate(3, 7));

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
			s = new Ship(-1, positions);
			assertEquals(true, false);
		} catch (Exception e) {
			assertEquals(false, false);
		}

		// width < 4
		try {
			s = new Ship(5, null);
			assertEquals(true, false);
		} catch (Exception e) {
			assertEquals(false, false);
		}

		// positions null
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

		// orientation null
		try {
			s = new Ship(width, positions6);
			assertEquals(true, false);
		} catch (Exception e) {
			assertEquals(false, false);
		}

		// invalid separated positions for a ship in the same row 3,3 3,5 3,7
		try {
			s = new Ship(3, positions4);
			assertEquals(true, false);
		} catch (Exception e) {
			assertEquals(false, false);
		}

		// valid Horitzontal
		try {
			s = new Ship(width, positions);
			assertEquals(true, true);
		} catch (Exception e) {
			assertEquals(true, false);
		}

		// valid size max
		try {
			s = new Ship(4, positions3);
			assertEquals(true, true);
		} catch (Exception e) {
			assertEquals(true, false);
		}

		// valid size min
		try {

			s = new Ship(1, positions0);
			assertEquals(true, true);
		} catch (Exception e) {
			assertEquals(true, false);
		}

		// valid Vertical
		try {
			s = new Ship(3, positions1);
			assertEquals(true, true);
		} catch (Exception e) {
			assertEquals(true, false);
		}

	}

	/*
	 * Black and white box Equivalent partition: valid and not valid parameters for
	 * chechOrientation Loop Testing for checkHoritzontal and checkVertical
	 */
	@Test
	public void testCheckOrientation() {
		int width = 3;
		ArrayList<Coordinate> positions = new ArrayList<Coordinate>();

		Ship s;
		try {

			// Horitzontal and vertical avoid loop
			try {
				ArrayList<Coordinate> positions2 = new ArrayList<Coordinate>();
				positions2.add(new Coordinate(3, 3));

				s = new Ship(1, positions2);
				Orientation orientation = s.checkOrientation(positions2);
				assertEquals(orientation, null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				assertEquals(true, true);
			}

			// Vertical 1 iteration
			positions = new ArrayList<Coordinate>();
			positions.add(new Coordinate(3, 3));
			positions.add(new Coordinate(3, 4));

			s = new Ship(2, positions);
			Orientation orientation = s.checkOrientation(positions);
			assertEquals(orientation, Orientation.VERTICAL);

			// Vertical 2 iteration
			positions = new ArrayList<Coordinate>();
			positions.add(new Coordinate(3, 3));
			positions.add(new Coordinate(3, 4));
			positions.add(new Coordinate(3, 5));

			s = new Ship(3, positions);
			orientation = s.checkOrientation(positions);
			assertEquals(orientation, Orientation.VERTICAL);

			// Vertical 3 iteration
			positions = new ArrayList<Coordinate>();
			positions.add(new Coordinate(3, 3));
			positions.add(new Coordinate(3, 4));
			positions.add(new Coordinate(3, 5));
			positions.add(new Coordinate(3, 6));

			s = new Ship(4, positions);
			orientation = s.checkOrientation(positions);
			assertEquals(orientation, Orientation.VERTICAL);

			// Horitzontal 1 iteration
			width = 2;
			positions = new ArrayList<Coordinate>();
			positions.add(new Coordinate(3, 3));
			positions.add(new Coordinate(4, 3));

			s = new Ship(width, positions);
			orientation = s.checkOrientation(positions);
			assertEquals(orientation, Orientation.HORIZONTAL);

			// Horitzontal 2 iteration
			width = 3;
			positions = new ArrayList<Coordinate>();
			positions.add(new Coordinate(3, 3));
			positions.add(new Coordinate(4, 3));
			positions.add(new Coordinate(5, 3));

			s = new Ship(width, positions);
			orientation = s.checkOrientation(positions);
			assertEquals(orientation, Orientation.HORIZONTAL);

			// Horitzontal 3 iteration
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

			// orientation null
			try {
				ArrayList<Coordinate> positions2 = new ArrayList<Coordinate>();
				positions2.add(new Coordinate(3, 3));
				positions2.add(new Coordinate(3, 5));
				positions2.add(new Coordinate(4, 7));

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
	 * Black and white box Equivalent partition: valid and not valid parameters for
	 * orientation vertical
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

		// repeat coord
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
	 * Equivalent partition: valid and not valid parameters for orientation
	 * Horitzontal Black box
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
	 * Equivalent partition: valid and not valid Black box
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
	 * Equivalent partition: valid and not valid Black box
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
