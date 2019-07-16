package sec01.ex01_inputStream2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main2 {

	public static void main(String[] args) throws IOException {
		OutputStream os = new FileOutputStream("C:/image/1.txt");
		byte[] arr = "안녕하세요".getBytes();
		System.out.println(arr.length);
		
		os.flush();
		os.close();
	}

}
