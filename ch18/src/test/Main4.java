package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		System.out.println(str);
		char[] buffer = new char[100];
		int readCnt = br.read(buffer);
		for (int i = 0; i<readCnt; i++) {
			System.out.println((int)buffer[i]);
		}
		
		br.close();
	}
}
