package test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5 {
	public static void main(String[] args) throws IOException {
		DataInputStream ds = new DataInputStream(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = ds.readInt();
		//String str = br.readLine();
		
		System.out.println(num);
		//System.out.println(str);
		
		//br.close();
		ds.close();
	}
}
