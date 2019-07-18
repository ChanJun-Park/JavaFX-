package sec05.ex05;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerializableReader {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		ClassA v = (ClassA) ois.readObject();
		System.out.println("field1: " + v.field1);
		System.out.println("filed2.field1: " + v.field2.field1);
		System.out.println("filed3: " + v.field3);
		System.out.println("field4: " + v.field4);
		
		ois.close(); bis.close(); fis.close();
	}

}
