package posting;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 5001));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		while(true) {
			try {
				Socket socket = serverSocket.accept();
				System.out.println("클라이언트와 연결 성공");
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
		
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
