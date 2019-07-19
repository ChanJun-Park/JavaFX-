package posting;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 5001));
			while(true) {
				System.out.println("[연결 수락 대기]");
				Socket socket = serverSocket.accept();
				InetSocketAddress socketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
				System.out.println("[연결 수락] : " + socketAddress.getHostName());
				
				InputStream is = socket.getInputStream();
				byte[] arr = new byte[100];
				int readByteCnt;
				readByteCnt = is.read(arr);
				String message = new String(arr, 0, readByteCnt, "UTF-8");
				System.out.println("[받은 메시지] : " + message);
				is.close();
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
