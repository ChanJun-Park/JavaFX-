package sec05.ex01_InputStreamReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new InputStreamReader(System.in);
		int readCharNo;
		char[] buffer = new char[100];
		while((readCharNo = reader.read(buffer)) != -1) {
			String str = new String(buffer, 0, readCharNo);
			System.out.println(str);
		}
		reader.close();
	}

}
