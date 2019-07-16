package sec03.ex_my;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main2 {

	public static void main(String[] args) throws IOException {
		InputStream is = System.in;
		OutputStream os = new FileOutputStream("C:/image/입출력연습2.txt");
		byte[] buffer = new byte[100];
		int readCnt;
		while((readCnt = is.read(buffer)) != -1) {
			os.write(buffer, 0, readCnt);
		}
		os.flush();
		os.close();
		is.close();
	}

}
