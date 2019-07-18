package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("C:\\Temp\\file.txt");
		char[] buffer = new char[100];
		fr.read(buffer);
		
		fr.close();
	}

}
