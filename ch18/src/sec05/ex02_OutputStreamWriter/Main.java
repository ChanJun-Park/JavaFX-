package sec05.ex02_OutputStreamWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Main {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("C:/Temp/file.txt");
		Writer writer = new OutputStreamWriter(fos);
		
		String data = "바이트 출력 스트림을 문자 출력 스트림으로 변환";
//		byte[] buffer = data.getBytes();
//		fos.write(buffer);
//		fos.flush();
//		fos.close();
		writer.write(data);

		writer.flush();
		writer.close();
		System.out.println("파일 저장이 끝났습니다");
	}

}
