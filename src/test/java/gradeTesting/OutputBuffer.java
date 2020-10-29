package gradeTesting;

import java.util.ArrayList;

public class OutputBuffer implements CustomOutput{
	
	ArrayList<String> buffer;

	public OutputBuffer() {
		buffer = new ArrayList<String>();
	}
	@Override
	public void println(String line) {
		// TODO Auto-generated method stub
		buffer.add(line);
		
	}

	@Override
	public void print(String line) {
		// TODO Auto-generated method stub
		buffer.add(line);
		
	}
	

	@Override
	public void println() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public void reset() {
		buffer = new ArrayList<String>();
	}
	
	public ArrayList<String> getBuffer(){
		return buffer;
	}

}
