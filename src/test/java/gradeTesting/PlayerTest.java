package gradeTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	@Before
	public void setUp() throws Exception {
	}

	//@Test
	public void test() throws Exception {
		Board b = new Board(12, 12);
		Player p = new Player(b);
		
		//create ship
		
		//readint
		
		//readcoord
		
		//attack
		
		
		//attacked
		assertEquals(p.attacked(new Coordinate(3,3)),true);
		assertEquals(p.attacked(new Coordinate(7,7)),false);
		assertEquals(p.attacked(new Coordinate(3,4)),true);
		assertEquals(p.attacked(new Coordinate(3,6)),false);
		assertEquals(p.attacked(new Coordinate(3,3)),true);
		
		assertEquals(p.isAlive(),true);
		
		assertEquals(p.attacked(new Coordinate(3,5)),true);
		
		assertEquals(p.isAlive(),false);
		//hasShips
		
		
	}
	
	@Test //Test for the coords with enemy atacked you, the coord was tested before if was valid or not
	public void attacked() throws Exception {
		Board b = new Board(12, 12);
		Player p = new Player(b);
		
		//Create a ship
		ArrayList<Coordinate> positions = new ArrayList<Coordinate>();
		positions.add(new Coordinate(5,5));
		positions.add(new Coordinate(5,6));
		//put a ship in the board
		p.addShip(2, positions);
		
		
		assertEquals(p.attacked(new Coordinate(3,3)),false);
		assertEquals(p.attacked(new Coordinate(7,7)),false);
		assertEquals(p.attacked(new Coordinate(5,5)),true);
		assertEquals(p.isAlive(),true);
		
		assertEquals(p.attacked(new Coordinate(3,6)),false);
		assertEquals(p.attacked(new Coordinate(3,3)),false);
		assertEquals(p.attacked(new Coordinate(5,6)),true);
		
		//assertEquals(p.isAlive(), false); for tomorrow
		
	}
	
	@Test //Test for the coords insert by player to make a ship in the board, white box??
	public void testCheckCoordsBoards() throws Exception {
		Board b = new Board(12, 12);
		Player p = new Player(b);
		
		//Create a ship
		ArrayList<Coordinate> positions = new ArrayList<Coordinate>();
		positions.add(new Coordinate(5,5));
		positions.add(new Coordinate(5,6));
		Ship s1 = new Ship(2, positions);
		//put a ship in the board
		b.getBoard()[5][5] = s1;
		b.getBoard()[5][6] = s1;
		
		
		assertEquals(p.checkCoordsBoards(-1, -1), false);//Negative case, out of board fronter
		assertEquals(p.checkCoordsBoards(12, 2), false);//Negative case, out of board fronter row
		assertEquals(p.checkCoordsBoards(2, 12), false);//Negative case, out of board fronter col
		assertEquals(p.checkCoordsBoards(5, 6), false);//Negative case, one boat in this position
		assertEquals(p.checkCoordsBoards(2, 2), true);//Positive case, nice position to put a float
		
	}

}
