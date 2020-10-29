package gradeTesting;

public class ConsoleOutput implements CustomOutput{

	@Override
	public void println(String line) {
		System.out.println(line);
		
	}

	@Override
	public void print(String line) {
		System.out.print(line);
	}

	@Override
	public void println() {
		System.out.println();
		
	}

	@Override
	public void print() {
	}

}
