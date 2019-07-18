package sec07.ex02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket();
			System.out.println("[연결 요청]");
			socket.connect(new InetSocketAddress("localhost", 5001));
			System.out.println("[연결 성공]");
			
			byte[] bytes = null;
			String message = null;
			
			OutputStream os = socket.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(os);
			message = "Hello Server!";
			bytes = message.getBytes("UTF-8");
			bos.write(bytes);
			bos.flush();
			System.out.println("[데이터 보내기 성공]");
			
			InputStream is = socket.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			bytes = new byte[100];
			
			int readByteCount = bis.read(bytes);
			message = new String(bytes, 0, readByteCount, "UTF-8");
			System.out.println("[데이터 받기 성공] : " + message);
			
			bos.close(); os.close();
			bis.close(); is.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(!socket.isClosed()) { 
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
