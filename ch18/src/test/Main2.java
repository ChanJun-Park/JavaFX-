package test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main2 {

	public static void main(String[] args) throws IOException {
		Reader rd = new InputStreamReader(System.in);
		
		char[] buffer = new char[100];
		rd.read(buffer);
		
		rd.close();
	}

}
