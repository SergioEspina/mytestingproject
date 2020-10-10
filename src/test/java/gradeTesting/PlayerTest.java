package gradeTesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws Exception {
		Player p = new Player();
		
		//create ship
		p.createShips();
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

}
