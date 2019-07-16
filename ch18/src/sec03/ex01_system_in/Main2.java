package sec03.ex01_system_in;

import java.io.IOException;
import java.io.InputStream;

public class Main2 {

	public static void main(String[] args) throws IOException {
		InputStream is = System.in;
		
		byte[] data = new byte[100];
		
		System.out.print("이름 : " );
		int nameBytes = is.read(data);
		String name = new String(data, 0, nameBytes - 2);
		
		System.out.print("하고 싶은 말 : ");
		int commentBytes = is.read(data);
		String comment = new String(data, 0, commentBytes - 2);
		
		System.out.println("입력한 이름 : " + name);
		System.out.println("입력한 하고 싶은 말: " + comment);
	}

}
