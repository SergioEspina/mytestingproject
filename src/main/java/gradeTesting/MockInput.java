package gradeTesting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MockInput extends ScannerConsole{
	
	String txt;
	int index;
	ArrayList<String> content;

	public MockInput(InputStream i) {
		super(i);
	}
	
	public void setup(String route) throws IOException {
		this.txt = route;
		FileReader fr = new FileReader(txt);
		BufferedReader br = new BufferedReader(fr);
		content = new ArrayList<>();
		String row;
		
		while((row = br.readLine()) != null) {
			content.add(row);
		}
		
		index = 0;
		br.close();
		fr.close();
	}
	
	@Override
	public String nextLine() {
		String row = "";
		if(index < content.size()) {
			row = content.get(index);
			index++;
		}
		return row;
	}
	
	

}
