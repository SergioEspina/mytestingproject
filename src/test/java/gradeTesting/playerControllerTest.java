package gradeTesting;

import org.junit.Test;

public class playerControllerTest {


	@Test
	public void test() {
		ConsoleInput ci = new ConsoleInput();
		playerController pc = new playerController(10,10, ci);
		
		//create player 1
		pc.createPlayer();
		
		//create player 2
		pc.createPlayer();
		
	}

}
