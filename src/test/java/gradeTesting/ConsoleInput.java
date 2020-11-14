package gradeTesting;

import java.util.ArrayList;

/*
 * this class is a mock of object for the user input
 */
public class ConsoleInput implements ScannerInput {

	ArrayList<ArrayList<String>> listOfInputs;
	ArrayList<String> p1Ships;
	ArrayList<String> p2Ships;

	ArrayList<String> pAttack;

	private int lastInputProvided;
	private int providedInputs;

	public ConsoleInput() {
		lastInputProvided = 0;
		providedInputs = 0;

		p1Ships = new ArrayList<String>();
		p2Ships = new ArrayList<String>();
		pAttack = new ArrayList<String>();

		// ships for player 1
		p1Ships.add("-1,-2 1,3 1,4");
		p1Ships.add("1,2 1,3 1,4");
		p1Ships.add("2,2 2,3 2,4");
		p1Ships.add("3,1 3,2 3,3");

		// ships for player 2
		p2Ships.add("1,2 1,-3 -1,4");
		p2Ships.add("1,2 1,3 1,4");
		p2Ships.add("2,2 2,3 2,4");
		p2Ships.add("2,2 2,3 2,4");
		p2Ships.add("3,1 3,2 3,3");

		/*
		 * in order to attack, before sending any coordinates, the attack options must
		 * be chosen (1 - print board, 2 - print enemy board, 3- attack)
		 */

		// player1 attacks which will fail
		pAttack.add("3");
		pAttack.add("1,2");

		// player2 attacks which will fail
		pAttack.add("3");
		pAttack.add("4,4");

		// player1 attacks which will fail
		pAttack.add("3");
		pAttack.add("1,3");

		// player2 attacks which will fail
		pAttack.add("3");
		pAttack.add("4,4");

		// player1 attacks which will fail
		pAttack.add("3");
		pAttack.add("1,4");

		// player2 attacks which will fail
		pAttack.add("3");
		pAttack.add("4,4");

		// player1 attacks which will fail
		pAttack.add("3");
		pAttack.add("2,2");

		// player2 attacks which will fail
		pAttack.add("3");
		pAttack.add("4,4");

		// player1 attacks which will fail
		pAttack.add("3");
		pAttack.add("2,3");

		// player2 attacks which will fail
		pAttack.add("3");
		pAttack.add("4,4");

		// player1 attacks which will fail
		pAttack.add("3");
		pAttack.add("2,4");

		// player2 attacks which will fail
		pAttack.add("3");
		pAttack.add("4,4");

		// player1 attacks which will fail
		pAttack.add("3");
		pAttack.add("3,1");

		// player2 attacks which will fail
		pAttack.add("3");
		pAttack.add("4,4");

		// player1 attacks which will fail
		pAttack.add("3");
		pAttack.add("3,2");

		// player2 attacks which will fail
		pAttack.add("3");
		pAttack.add("4,4");

		// player1 attacks which will fail
		pAttack.add("3");
		pAttack.add("3,3");

		// add all lists to a list of inputs
		listOfInputs = new ArrayList<ArrayList<String>>();

		listOfInputs.add(p1Ships);
		listOfInputs.add(p2Ships);
		listOfInputs.add(pAttack);

	}

	public void prepareTurn() {
		lastInputProvided = 0;
		providedInputs = 0;

		p1Ships = new ArrayList<String>();
		p2Ships = new ArrayList<String>();
		pAttack = new ArrayList<String>();

		// ships for player 1
		p1Ships.add("-1,-2 1,3 1,4");
		p1Ships.add("1,2 1,3 1,4");
		p1Ships.add("2,2 2,3 2,4");
		p1Ships.add("3,1 3,2 3,3");

		// ships for player 2
		p2Ships.add("1,2 1,-3 -1,4");
		p2Ships.add("1,2 1,3 1,4");
		p2Ships.add("2,2 2,3 2,4");
		p2Ships.add("2,2 2,3 2,4");
		p2Ships.add("3,1 3,2 3,3");

		// player1 attacks which will fail
		pAttack.add("3");
		pAttack.add("1,-2");
		pAttack.add("1,-2");
		pAttack.add("1,-2");

		// player2 attacks which will fail
		pAttack.add("3");
		pAttack.add("4,4");

		// player1 attacks which will fail
		pAttack.add("4");

		// add all lists to a list of inputs
		listOfInputs = new ArrayList<ArrayList<String>>();

		listOfInputs.add(p1Ships);
		listOfInputs.add(p2Ships);
		listOfInputs.add(pAttack);
	}

	public void prepareFailedCreateShip() {
		lastInputProvided = 0;
		providedInputs = 0;

		p1Ships = new ArrayList<String>();
		p2Ships = new ArrayList<String>();
		pAttack = new ArrayList<String>();

		// ships for player 1
		p1Ships.add("1,2 1,3 1,4");
		p1Ships.add("2,2 2,3 2,4");
		p1Ships.add("3,1 3,2 3,3");

		// ships for player 2
		p2Ships.add("1,2 1,3 1,4");
		p2Ships.add("2,2 2,3 2,4");
		p2Ships.add("-3,1 3,2 3,3");
		p2Ships.add("-3,1 3,2 3,3");
		p2Ships.add("-3,1 3,2 3,3");

		// add all lists to a list of inputs
		listOfInputs = new ArrayList<ArrayList<String>>();

		listOfInputs.add(p1Ships);
		listOfInputs.add(p2Ships);
		listOfInputs.add(pAttack);
	}
	

	@Override
	public String nextLine() {

		if (providedInputs == listOfInputs.get(lastInputProvided).size()) {
			lastInputProvided++;
			providedInputs = 0;
		}

		String in = listOfInputs.get(lastInputProvided).get(providedInputs);
		providedInputs++;

		return in;
	}

}
