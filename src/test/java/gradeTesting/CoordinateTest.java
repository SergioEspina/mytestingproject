package gradeTesting;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoordinateTest {

	@Test
	public void testCheckCoords() {
		Coordinate cord = new Coordinate();
		boolean res = cord.checkCoords(1, 1);
		assertEquals(res, true);
		
		res = cord.checkCoords(-1, 1);
		assertEquals(res, false);
	}

}
