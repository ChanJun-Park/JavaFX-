package sec03.ex_my;

import java.io.Console;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public class Main {

	public static void main(String[] args) throws IOException {
		Console console = System.console();
//		OutputStream os = new FileOutputStream("C:/image/입출력연습.txt");
		Writer writer = new FileWriter("C:/image/입출력연습.txt");
		String str;
		while((str = console.readLine()) != null) {
			writer.write(str);
		}
	
		writer.flush();
		writer.close();
	}

}
