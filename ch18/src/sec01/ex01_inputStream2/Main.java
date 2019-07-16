package sec01.ex01_inputStream2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {

	public static void main(String[] args) throws IOException {
		OutputStream os = new FileOutputStream("C:/image/1.txt");
		byte[] arr = "abc".getBytes();
		for (int i = 0; i < arr.length; i++) {
			os.write(arr[i]);
		}
		os.flush();
		os.close();
	}

}
