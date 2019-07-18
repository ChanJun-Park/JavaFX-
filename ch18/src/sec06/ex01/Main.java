package sec06.ex01;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {

	public static void main(String[] args) {
		InetAddress local;
		try {
			local = InetAddress.getLocalHost();
			System.out.println("내 컴퓨터 ip 주소: " + local.getHostAddress());
			
			InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
			for (InetAddress remote : iaArr) {
				byte[] addr = remote.getAddress();
				System.out.println("www.naver.com IP주소: " + remote.getHostAddress());
				System.out.print("www.naver.com raw IP 주소: " );
				for (byte b : addr) {
					System.out.print(b);
				}
				System.out.println();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
