package gradeTesting;
import java.io.InputStream;
import java.util.Scanner;

public class ScannerConsole implements ScannerInput{

	private Scanner in;
	
	public ScannerConsole(InputStream i) {
		in = new Scanner(i);
	}
	
	@Override
	public String nextLine() {
		return in.nextLine();
	}
	
	public void close() {
		in.close();
	}


}
