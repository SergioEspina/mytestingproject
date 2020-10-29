package gradeTesting;

import java.util.ArrayList;

import org.junit.Test;

public class playerControllerTest {


	@Test
	public void test() {
		ConsoleInput ci = new ConsoleInput();
		OutputBuffer ob = new OutputBuffer();
		ArrayList<String> buffer;
		
		playerController pc = new playerController(10,10, ci, ob);
		
		
		//create player 1
		pc.createPlayer();
		
		buffer = ob.getBuffer();
		ob.reset();

		//create player 2
		pc.createPlayer();
		
		buffer = ob.getBuffer();
		ob.reset();
		
	}

}
