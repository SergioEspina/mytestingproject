package gradeTesting;

import static org.junit.Assert.*;

import org.junit.Test;

public class AutomaticTesting {

	@Test
	public void playerOneWinTest() throws Exception {
		ConsoleOutput co = new ConsoleOutput();		
		MockInput mi = new MockInput(System.in);
		mi.setup("./automatic/1.txt");
		ScannerInput in = mi;
				
		playerController controller = new playerController(10,10, in, co);
		controller.view.prepareGame();
			
		controller.play();
	}
	
	@Test
	public void playerTwoWinTest() throws Exception {
		ConsoleOutput co = new ConsoleOutput();		
		MockInput mi = new MockInput(System.in);
		mi.setup("./automatic/2.txt");
		ScannerInput in = mi;
				
		playerController controller = new playerController(10,10, in, co);
		controller.view.prepareGame();
			
		controller.play();
	}
	
	@Test
	public void playerOneSurrendersTest() throws Exception {
		ConsoleOutput co = new ConsoleOutput();		
		MockInput mi = new MockInput(System.in);
		mi.setup("./automatic/3.txt");
		ScannerInput in = mi;
				
		playerController controller = new playerController(10,10, in, co);
		controller.view.prepareGame();
			
		controller.play();
	}
	
	@Test
	public void playerTwoSurrendersTest() throws Exception {
		ConsoleOutput co = new ConsoleOutput();		
		MockInput mi = new MockInput(System.in);
		mi.setup("./automatic/4.txt");
		ScannerInput in = mi;
				
		playerController controller = new playerController(10,10, in, co);
		controller.view.prepareGame();
			
		controller.play();
	}
	
	@Test
	public void testSmallBoatPlacement() throws Exception {
		ConsoleOutput co = new ConsoleOutput();		
		MockInput mi = new MockInput(System.in);
		mi.setup("./automatic/5.txt");
		ScannerInput in = mi;
				
		playerController controller = new playerController(10,10, in, co);
		controller.view.prepareGame();
			
		controller.play();
	}
	
	@Test
	public void testBigBoatPlacement() throws Exception {
		ConsoleOutput co = new ConsoleOutput();		
		MockInput mi = new MockInput(System.in);
		mi.setup("./automatic/6.txt");
		ScannerInput in = mi;
				
		playerController controller = new playerController(10,10, in, co);
		controller.view.prepareGame();
			
		controller.play();
	}

}
