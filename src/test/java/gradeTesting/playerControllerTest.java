package gradeTesting;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class playerControllerTest {


	//@Test
	public void testCreatePlayer() throws Exception {
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
		
		String [] correctOutput2 = {"should be separated", "not valid", "Ship 0", "Ship 1", "Ship 2", "not valid", "Ship 2"};
		
		
		
		for(int i=0; i < buffer.size(); i++) {
			
			if(!buffer.get(i).contains(correctOutput2[i])) {
				validOutput = false;
				break;
			}
			
		}
		
		assertEquals(validOutput, true);
		
		ob.reset();
		
	}
	
	//@Test
	public void testFinishedGame() throws Exception { //prove the game finished nice, just see the 2 last lines of buffer
		
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
		
		//play the game
		pc.play();
		
		buffer = ob.getBuffer();
		
		boolean validOutput = buffer.get(buffer.size()-1).contains("1 wins");
		
		validOutput = validOutput && buffer.get(buffer.size()-2).contains("2 was eliminated");
		
		assertEquals(validOutput, true);
		
		ob.reset();
		
	}
	
	@Test
	public void turnLost() throws Exception { //prove turn lost and surrender
		
		ConsoleInput ci = new ConsoleInput();
		ci.prepareTurn();
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
		
		//play the game
		pc.play();
		
		buffer = ob.getBuffer();
		
		boolean validOutput = buffer.get(10).contains("Turn lost");
		
		validOutput = validOutput && buffer.get(buffer.size()-2).contains("1 was eliminated");
		
		assertEquals(validOutput, true);
		
		ob.reset();
		
	}
}
