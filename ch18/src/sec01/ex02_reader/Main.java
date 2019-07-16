package sec01.ex02_reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new FileReader("C:/image/test.txt");
		int c;
		while((c = reader.read()) != -1) {
			char charData = (char)c;
			System.out.print(charData);
		}
		
		reader.close();
	}

}
