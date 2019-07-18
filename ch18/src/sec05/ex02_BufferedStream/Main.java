package sec05.ex02_BufferedStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		long start = 0;
		long end = 0;
		
		FileInputStream fis1 = new FileInputStream("C:\\Temp\\gocoo.png");
		start = System.currentTimeMillis();
		while(fis1.read() != -1) {}
		end = System.currentTimeMillis();
		System.out.println("사용하지 않을때: " + (end-start) + "ms");
		fis1.close();
		
		FileInputStream fis2 = new FileInputStream("C:\\Temp\\gocoo.png");
		BufferedInputStream bis = new BufferedInputStream(fis2);
		start = System.currentTimeMillis();
		while(bis.read() != -1) {}
		end = System.currentTimeMillis();
		System.out.println("사용할 때 : " + (end - start) + "ms");
		bis.close();
		fis2.close();
	}

}
