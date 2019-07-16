package sec03.ex02_system_out;

import java.io.IOException;
import java.io.OutputStream;

public class Main {

	public static void main(String[] args) throws IOException {
		OutputStream os = System.out;
		
		for (byte b = 48; b < 58; b++) {
			os.write(b);
		}
		os.write(10);
		
		for (byte b = 97; b < 123; b++) {
			os.write(b);
		}
		os.write(10);
		
		String hangul = "가나다";
		byte[] hangulBytes = hangul.getBytes();
		System.out.println("한글 글자 바이트수 : " + hangulBytes.length);
		os.write(hangulBytes);
		os.flush();
		
		os.close();
	}

}
