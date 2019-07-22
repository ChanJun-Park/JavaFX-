package sec03.ex07_String_Buffer;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class Main {

	public static void main(String[] args) {
		Charset charset = Charset.forName("UTF-8");
		
		// 문자열 -> 인코딩 -> ByteBuffer
		String data = "안녕하세요";
		ByteBuffer byteBuffer = charset.encode(data);
		
		// ByteBuffer -> 디코딩 -> CharBuffer -> 문자열
		data = charset.decode(byteBuffer).toString();
		System.out.println("문자열 복원: " + data);
	}

}
