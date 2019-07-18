package sec05.ex06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class NonSerializableParentExampel {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		Child child = new Child();
		child.field1 = "홍길동";
		child.field2 = "홍삼원";
		oos.writeObject(child);
		
		oos.flush(); bos.close(); fos.close();
		
		FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		Child v = (Child) ois.readObject();
		System.out.println("field1: " + v.field1);
		System.out.println("field2: " + v.field2);
		
		ois.close(); bis.close(); fis.close();
		
	}

}
