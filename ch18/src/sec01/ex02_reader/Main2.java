package sec01.ex02_reader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Main2 {
	public static void main(String[] args) throws IOException {
		Reader reader = new FileReader("C:/image/test.txt");
		Writer writer = new FileWriter("C:/image/testcopy.txt");
		
		char[] buffer = new char[100];
		int readCnt;
		while((readCnt = reader.read(buffer)) != -1) {
			writer.write(buffer, 0, readCnt);
		}
		writer.flush();
		writer.close();
		reader.close();
	}
}
