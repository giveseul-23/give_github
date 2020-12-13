package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
			1. 접속을 해야 할 Server의 주소를 설정 - Socket
			2. 소켓 생성
			3. 접속 
			4. 데이터 송수신
		*/
		
		//1. 접속을 해야 할 Server의 주소를 설정 - Socket
		InetSocketAddress sockAddr = new InetSocketAddress("192.168.0.136",9000);
		
		//2. 소켓 생성
		Socket socket = new Socket();
		
		
		try {
			//3. 접속 
			socket.connect(sockAddr, 5000);
			//timeout : 대기시간, 대기시간 이후는 접속하지 않음
			
			InetAddress inetAddr; // 접속정보 확인하기 위한 용도
			if((inetAddr = socket.getInetAddress()) != null) {	//접속성공했다는 뜻
				System.out.println("server 접속성공! : "+ inetAddr);
			}else {
				System.out.println("server 접속실패~");
			}
			
			new ReadThread(socket).start();	//받는게 언제 받을지 모르기때문에 가장 우선순위에 두어야 함
			
			while(true) {
				String msg = "";
				System.out.print("전송문자열 : ");
				msg = sc.nextLine();
				
				//send
				PrintWriter pw = new PrintWriter(socket.getOutputStream());	//getOutputStream() : socket을 읽어들임
				pw.println(msg);	//실질적으로 전송되는 부분
				pw.flush();		
				//flush() : 전송하고 내용을 비우면서 보내줄수 있음, 없으면 오류발생
							//output 해주는 느낌으로 생각!
				/*
				
					BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
					String ssg = br.readLine();
					System.out.println("서버에서 받은 메세지 : "+ssg);
				
				*/
			}
			
			
//			while(true) {
//				String msg = "";
//				System.out.print("전송문자열 : ");
//				msg = sc.next();
//				
//				//send
//				PrintWriter pw = new PrintWriter(socket.getOutputStream());	//getOutputStream() : socket을 읽어들임
//				pw.println(msg);	//실질적으로 전송되는 부분
//				pw.flush();		
//				//flush() : 전송하고 내용을 비우면서 보내줄수 있음, 없으면 오류발생
//							//output 해주는 느낌으로 생각!
//				
//				//recv
//				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//				String ssg = br.readLine();
//				System.out.println("서버에서 받은 메세지 : "+ssg);
//			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}

}
