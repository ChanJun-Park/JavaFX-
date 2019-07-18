package test;

import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main3 {
	public static void main(String[] args) throws IOException {
		Console con = System.console();
		
		char[] buffer = con.readPassword();
		for (int i = 0; i < buffer.length; i++) {
			System.out.println((int)buffer[i]);
		}
	}
}
