package gradeTesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {



	@Test
	public void testConstructor() {
		// equivalent partition invalid board size
		try {
			Board b = new Board(-1, -1);
			assertEquals(false,true);
		}catch(Exception e) {
			assertEquals(true,true);
		}
		
		try {
			Board b = new Board(5, -1);
			assertEquals(false,true);
		}catch(Exception e) {
			assertEquals(true,true);
		}
		
		try {
			Board b = new Board(-1, 10);
			assertEquals(false,true);
		}catch(Exception e) {
			assertEquals(true,true);
		}
		
		
		// equivalent partition valid board size
		try {
			Board b = new Board(5, 5);
			assertEquals(false,true);
		}catch(Exception e) {
			assertEquals(true,true);
		}
		
		try {
			Board b = new Board(2, 2);
			assertEquals(false,true);
		}catch(Exception e) {
			assertEquals(true,true);
		}
		
		
		
		
	}

}
