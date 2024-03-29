package posting;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChattingClient {
	Socket socket;
	
	void startClient() {
		// connect()와 read() 메소드는 블로킹 되기 때문에 별도의 스레드를 생성해서 처리합니다.
		Thread thread = new Thread() {
			@Override
			public void run() {
				socket = new Socket();
				try {
					System.out.println("[서버에 연결 요청 중]");
					socket.connect(new InetSocketAddress("13.209.66.84", 5001));
					System.out.println("[서버와 연결 완료]");
				} catch (IOException e) {
					System.out.println("[서버와 통신 안됨]");
					if(!socket.isClosed()) {
						stopClient();
					}
					return;
				}
				receive();
			}
		};
		thread.start();
	}

	void stopClient() {
		if(socket!=null && !socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	void receive() {
		while(true) {
			byte[] arr = new byte[100];
			try {
				InputStream is = socket.getInputStream();
				int readByteCnt = is.read(arr);
				if (readByteCnt == -1) {throw new IOException();}
				String message = new String(arr, 0, readByteCnt, "UTF-8");
				System.out.println("[메시지 수신] : " + message);
			} catch (IOException e) {
				System.out.println("서버와 통신 안됨");
				stopClient();
				break;
			}
			
		}
	}
	
	void send(String message) {
		// write() 메소드는 블로킹 되기 때문에 별도의 스레드에서 실행합니다.
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					byte[] arr = message.getBytes("UTF-8");
					OutputStream os = socket.getOutputStream();
					os.write(arr);
					os.flush();
				} catch(Exception e) {
					System.out.println("서버와 통신 안됨");
					stopClient();
				}
			}
		};
		thread.start();
	}
	
	public static void main(String[] args) {
		ChattingClient chattingClient = new ChattingClient();
		chattingClient.startClient();
		Scanner sc = new Scanner(System.in);
		while(true) {
			String message = sc.nextLine();
			if (message.equals("stop")) {
				break;
			}
			chattingClient.send(message);
		}
		chattingClient.stopClient();
	}

}
