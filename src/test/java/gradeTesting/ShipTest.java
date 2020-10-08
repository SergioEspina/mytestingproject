package gradeTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ShipTest {

	@Test
	public void testCheckOrientation() {
		int width = 3;
		ArrayList<Coordinate> positions = new ArrayList<Coordinate>();
		positions.add(new Coordinate(3,3));
		positions.add(new Coordinate(3,4));
		positions.add(new Coordinate(3,5));
		
		Ship s = new Ship(width, positions);
		boolean orientation = s.checkOrientation(positions);
		assertEquals(orientation, true);
		//correct orientation
		
		
		//sunk
		
		//touched
		
		//ok
	}

}
