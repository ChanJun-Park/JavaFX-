package sec05.ex05;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerialVersionExample2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		ClassC classC = (ClassC)ois.readObject();
		System.out.println("field1 : " + classC.field1);
		
		ois.close(); bis.close(); fis.close();
	}

}
