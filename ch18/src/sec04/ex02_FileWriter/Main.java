package sec04.ex02_FileWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		File file = new File("C:/Temp/FileWriter_연습.txt");
		FileWriter wr = new FileWriter(file);
		wr.write("FileWriter는 한글로된 \r\n");
		wr.write("문자를 바로 출력할 수 있다.");
		wr.flush();
		wr.close();
	}

}
