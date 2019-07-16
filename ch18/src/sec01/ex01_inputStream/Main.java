package sec01.ex01_inputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {

	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("C:/image/1.png");
		OutputStream os = new FileOutputStream("C:/image/copy.png");
		byte[] buffer = new byte[100];
		int readByteNo;
		while((readByteNo = is.read(buffer)) != -1) {
			os.write(buffer, 0, readByteNo);
		}
		os.flush();
		os.close();
		is.close();
	}

}
