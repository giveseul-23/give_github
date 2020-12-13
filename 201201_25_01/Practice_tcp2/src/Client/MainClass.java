package Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//서버 연결
		InetSocketAddress iAddr = new InetSocketAddress("192.168.0.8", 9000);
	
		//소켓 생성
		Socket socket = new Socket();
		
		//접속
		try {
			socket.connect(iAddr, 5000);
			
			InetAddress addr;
			
			if((addr = socket.getInetAddress()) != null) {
				System.out.println("접속 성공, IP : "+iAddr);
			}else {
				System.out.println("접속 실패");
			}
			
			new ClientServer(socket).start();
			
			while(true) {
				System.out.print("전송 문자열 : ");
				String msg = sc.nextLine();
				
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				pw.println(msg);
				pw.flush();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
