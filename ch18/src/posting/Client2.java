package posting;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client2 {

	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			socket = new Socket();
			System.out.println("[연결 요청 대기]");
			socket.connect(new InetSocketAddress("localhost", 5001));
			System.out.println("[연결 성공]");
			OutputStream os = socket.getOutputStream();
			byte[] arr = "안녕하세요".getBytes("UTF-8");
			os.write(arr);
			os.flush();
			System.out.println("[메시지 전송 성공]");
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
