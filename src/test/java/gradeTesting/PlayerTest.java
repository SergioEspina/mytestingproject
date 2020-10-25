package gradeTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test //Test for the coords with enemy atacked you, the coord was tested before if was valid or not
	public void testAddShip() throws Exception {
		Board b = new Board(12, 12);
		Player p = new Player(0, b);
		
		//Create a ship
		ArrayList<Coordinate> positions = new ArrayList<Coordinate>();
		positions.add(new Coordinate(5,5));
		positions.add(new Coordinate(5,6));
		//put a ship in the board
		p.addShip(2, positions);
		assertNotNull(p.getBoard().getBoard()[5][5]);
		assertNotNull(p.getBoard().getBoard()[5][6]);
		assertNull(p.getBoard().getBoard()[2][2]);
		
		//position on board with a ship 
		try {
			positions = new ArrayList<Coordinate>();
			positions.add(new Coordinate(5,5));
			p.addShip(1, positions);
		}catch (Exception e) {
			assertEquals(false, false);
		}
		
		//negative coords for a ship
		try {
			positions = new ArrayList<Coordinate>();
			positions.add(new Coordinate(-1,5));
			p.addShip(1, positions);
		}catch (Exception e) {
			assertEquals(false, false);
		}
		
		//negative coords for a ship
		try {
			positions = new ArrayList<Coordinate>();
			positions.add(new Coordinate(1,-5));
			p.addShip(1, positions);
		}catch (Exception e) {
			assertEquals(false, false);
		}
		
		//max width ship
		try {
			positions = new ArrayList<Coordinate>();
			positions.add(new Coordinate(1,1));
			positions.add(new Coordinate(1,2));
			positions.add(new Coordinate(1,3));
			positions.add(new Coordinate(1,4));
			positions.add(new Coordinate(1,5));
			positions.add(new Coordinate(1,6));
			p.addShip(6, positions);
		}catch (Exception e) {
			assertEquals(false, false);
		}
		
	}
	
	@Test //Test for the coords with enemy atacked you, the coord was tested before if was valid or not
	public void attacked() throws Exception {
		Board b = new Board(12, 12);
		Player p = new Player(0, b);
		
		//Create a ship
		ArrayList<Coordinate> positions = new ArrayList<Coordinate>();
		positions.add(new Coordinate(5,5));
		positions.add(new Coordinate(5,6));
		//put a ship in the board
		p.addShip(2, positions);
		
		try {
			p.attacked(new Coordinate(-5,5));
		}catch (Exception e) {
			assertEquals(false, false);
		}
		
		assertEquals(p.attacked(new Coordinate(3,3)),false);
		assertEquals(p.attacked(new Coordinate(7,7)),false);
		assertEquals(p.attacked(new Coordinate(5,5)),true);
		assertEquals(p.isAlive(),true);
		
		assertEquals(p.attacked(new Coordinate(3,6)),false);
		assertEquals(p.attacked(new Coordinate(3,3)),false);
		assertEquals(p.attacked(new Coordinate(5,6)),true);
		
		assertEquals(p.isAlive(), false);
		
	}
	
	
	@Test //Test for the coords insert by player to make a ship in the board, white box??
	public void testCheckCoordsBoards() throws Exception {
		Board b = new Board(12, 12);
		Player p = new Player(0, b);
		
		//Create a ship
		ArrayList<Coordinate> positions = new ArrayList<Coordinate>();
		positions.add(new Coordinate(5,5));
		positions.add(new Coordinate(5,6));
		Ship s1 = new Ship(2, positions);
		//put a ship in the board
		b.getBoard()[5][5] = s1;
		b.getBoard()[5][6] = s1;
		
		
		assertEquals(p.checkCoordsBoards(-1, -1), false);//Negative case, out of board fronter
		assertEquals(p.checkCoordsBoards(-1, 1), false);//Negative case, out of board fronter
		assertEquals(p.checkCoordsBoards(1, -1), false);//Negative case, out of board fronter
		assertEquals(p.checkCoordsBoards(12, 2), false);//Negative case, out of board fronter row
		assertEquals(p.checkCoordsBoards(2, 12), false);//Negative case, out of board fronter col
		
	}

}
