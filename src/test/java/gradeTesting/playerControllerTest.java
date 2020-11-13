package gradeTesting;

import static org.junit.Assert.assertEquals;

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
		
		boolean validOutput = true;
		
		String [] correctOutput = {"should be separated", "not valid", "Ship 0", "Ship 1", "Ship 2"};
		
		
		
		for(int i=0; i < buffer.size(); i++) {
			
			if(!buffer.get(i).contains(correctOutput[i])) {
				validOutput = false;
				break;
			}
			
			
		}
		
		assertEquals(validOutput, true);
		
		ob.reset();
		

		//create player 2
		pc.createPlayer();
		
		buffer = ob.getBuffer();
		
		
		validOutput = true;
		
		String [] correctOutput2 = {"should be separated", "not valid", "Ship 0", "Ship 1", "Ship 2", "not valid"};
		
		
		
		for(int i=0; i < buffer.size(); i++) {
			
			if(!buffer.get(i).contains(correctOutput2[i])) {
				validOutput = false;
				break;
			}
			
			
		}
		
		assertEquals(validOutput, true);
		
		ob.reset();
		
	}

}
