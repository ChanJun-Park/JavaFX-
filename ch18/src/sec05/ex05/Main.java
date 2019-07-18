package sec05.ex05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		oos.writeObject(Integer.valueOf(10));
		oos.writeObject(Double.valueOf(3.14));
		oos.writeObject(new int[] {1 ,2 ,3});
		oos.writeObject(new String("홍길동"));
		
		oos.close();
		bos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		Integer obj1 = (Integer)ois.readObject();
		Double obj2 = (Double)ois.readObject();
		int[] obj3 = (int [])ois.readObject();
		String obj4 = (String)ois.readObject();
		
		ois.close();
		bis.close();
		fis.close();
		
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3[0] + ", " + obj3[1] + ", " + obj3[2]);
		System.out.println(obj4);
	}

}
