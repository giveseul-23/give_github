package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import Thread.ClientThread;


public class MainClass {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//포트 및 서버ip 연결
		InetSocketAddress iaddr = new InetSocketAddress("192.168.1.103",7000);
		
		//새로운 소켓 생성
		Socket socket = new Socket();

		try {
			socket.connect(iaddr,7000);
			
			InetAddress inetAddr;
			
			if((inetAddr = socket.getInetAddress()) != null) {
				System.out.println("서버 접속성공!"+inetAddr);
			}else {
				System.out.println("서버 접속실패~");
			}
			
			
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//서버로 닉네임 q 받아옴
			String c_name = br.readLine();
			System.out.print(c_name);
			
			String name = "";
			name = sc.next();
			
			pw.println(name);
			pw.flush();
			
			String ssg1 = br.readLine();
			System.out.println(ssg1);
			
			new ClientThread(socket).start();
			
			while(true) {
					//입력받은거 서버로 보내기
					System.out.print("메세지 입력 : ");
					String ssg2 = sc.nextLine();
				
				
					pw.println(ssg2);
					pw.flush();
					
				}
		}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}


