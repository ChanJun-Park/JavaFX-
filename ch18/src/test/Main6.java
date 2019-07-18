package test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main6 {

	public static void main(String[] args) throws IOException {
//		DataOutputStream d = new DataOutputStream(new FileOutputStream("C:/Temp/test.txt"));
//		
//		d.writeUTF("나랏 말싸미 중국에 달아 서로 뜻이 사맞디 아니하고 \n\n\n 이런 절차로 새로 26글자를 맹가노니 \n");
//		d.writeInt(32);
//		d.flush();
//		d.close();
		
		DataInputStream di = new DataInputStream(new FileInputStream("C:/Temp/test.txt"));
		
		String str = di.readUTF();
		int num = di.readInt();
		
		System.out.println(str);
		System.out.println(num);
		
		di.close();
	}

}
