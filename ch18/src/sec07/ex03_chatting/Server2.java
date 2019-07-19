package sec07.ex03_chatting;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server2 {
	ExecutorService executorService;
	ServerSocket serverSocket;
	List<Client> connections = new Vector<Client>();
	
	void startServer() {
		executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		try {
			serverSocket = new ServerSocket();
//			serverSocket.bind(new InetSocketAddress("172.31.30.158", 5001));
//			serverSocket.bind(new InetSocketAddress("localhost", 5001));
			serverSocket.bind(new InetSocketAddress("172.31.42.147", 5001));
		} catch (Exception e) {
			if (!serverSocket.isClosed()) {stopServer();}
			e.printStackTrace();
		}
		
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						Socket socket = serverSocket.accept();
						String message = "[연결 수락: " + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName() + "]";
						System.out.println(message);
						
						Client client = new Client(socket);
						connections.add(client);
						System.out.println("[연결 개수: " + connections.size() + "]");
					} catch(Exception e) {
						if (!serverSocket.isClosed()) {stopServer();}
						break;
					}
				}
			}
		};
		executorService.submit(runnable);
	}
	void stopServer() {
		try {
			Iterator<Client> iterator = connections.iterator();
			while(iterator.hasNext()) {
				Client client = iterator.next();
				client.socket.close();
				iterator.remove();
			}
			if(serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();
			}
			if (executorService != null && !executorService.isShutdown()) {
				executorService.shutdown();
			}
			System.out.println("서버 멈춤");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	class Client {
		Socket socket;
		
		Client(Socket socket) {
			this.socket = socket;
			receive();
		}
		
		void receive() {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						while(true) {
							byte[] byteArr = new byte[100];
							InputStream inputStream = socket.getInputStream();
							
							// 클리이언트가 비정상 종료 했을 경우 IOException 발생
							int readByteCount = inputStream.read(byteArr);
							
							// 클라이언트가 정상적으로 Socket close()를 호출한 경우
							if(readByteCount == -1) {throw new IOException();}
							
							String message = "[요청 처리: " + socket.getRemoteSocketAddress() + ": "
									+ Thread.currentThread().getName() + "]";
							System.out.println(message);
							
							String data = new String(byteArr, 0, readByteCount, "UTF-8");
							
							for (Client client : connections) {
								client.send(data);  // 모든 클라이언트에게 보냄
							}
						}
					} catch(Exception e) {
						try {
							connections.remove(Client.this);
							String message ="[클라이언트 통신 안됨: " + socket.getRemoteSocketAddress() + 
									": " + Thread.currentThread().getName() + "]";
							System.out.println(message);
							
							socket.close();
						} catch(Exception e2) {}
					}
					
				}
			};
			executorService.submit(runnable);
		}
		void send(String data) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						byte[] byteArr = data.getBytes();
						OutputStream outputStream = socket.getOutputStream();
						outputStream.write(byteArr);
						outputStream.flush();
					} catch (Exception e) {
						try {
							String message = "[클라이언트 통신 안됨: " + socket.getRemoteSocketAddress() + ": " +
												Thread.currentThread().getName() + "]";
							System.out.println(message);
							
							connections.remove(Client.this);
							socket.close();
						} catch(IOException e2) {}
					}
				}
			};
			executorService.submit(runnable);
		}
	}
	public static void main(String[] args) {
		Console cs = System.console();
		Server2 sv2 = new Server2();
		sv2.startServer();
		String cmd = cs.readLine();
		if(cmd.equals("stop")) {
			sv2.stopServer();
		}
	}

}
