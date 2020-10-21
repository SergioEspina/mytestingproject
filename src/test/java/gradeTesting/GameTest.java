package gradeTesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Game g = new Game(12,12);
		g.createPlayer();
		int x= 0;
	}

}
