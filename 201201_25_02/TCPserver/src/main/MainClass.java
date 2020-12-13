package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import thread.SeverThread;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		
			TCP : 	Transmission Control Protocol
					전송			제어		통신규약 
			서버의 종류 
			TCP server
			Web server(Tomcat)
			DB  server
			
			종단 System : Host - PC, Printer, Smart Phone, Scanner
			
			Router - hardware다.
					host들 사이에 상호 데이터를 교환할 수 있는 장비
					
			inter Network	포괄적인 통신망
			
			Protocol - 통신규약
			TCP : Transmission Control Protocol
				  신사적인 프로토콜(신뢰 가능한 프로토콜)
			비유 : 전화 ---> 	상대방이 전화를 받아야지 통신이 시작됨(반드시 연결이 되어야 함)
				  			상대방과 1:1로 주고받는 상황이 만들어져야 됨
				  데이터의 경계가 없음((전송데이터)크기의 제약이 없음)
				 1:1 통신밖에 되지 않음
				 채팅은 TCP 사용
				  
			UDP : User Datagram Protocol
				  비연결형 프로토콜
			비유 : 편지, 지상파 방송  ---> 보내고 받았는지 확인작업을 하지 않음. 신뢰는 조금 약한 편
				 (전송데이터)데이터의 경계가 있음
				 1 대 1		uni cast
				 1 대 다		board cast
				  다 대 다		multi cast
				  
			7 Layer(계층)
			1계층  - Physical Layer 		물리계층
			2계층  - Data Link Layer 		주소를 헤더에 첨부
			3계층  - Network Layer 		IP == Address
			4계층  - Transport Layer 		port 지정
			5계층  - Session Layer			세션 동기화
			6계층  - Presentation Layer 	보안, 압축, 확장
			7계층  - Application Layer		프로그램
			
			Packet(데이터 묶음)
			: 제어정보, 데이터 등이 결합된 형태로 전송되는 실제의 데이터 
			TCP/UDP, IP, Port, String, Object
			
			IP : Internet Protocol	== 주소
			IPv4 : 0 ~ 255. XXX.XXX.XXX.XXX
			IPv6 : 			XXX.XXX.XXX.XXX.XXX.XXX
			
			자기 자신의 접속 IP : 127.0.0.1 or 자기 IPv4 주소 사용(내 컴퓨터의 주소)
			
			port number - (네트워크가 연결된)프로그램의 정보를 가지고 있는 것(컴퓨터 안의 프로그램 하나하나의 주소)
			IP주소는 internet에 존재하는 host(PC)를 식별할 수 있으나
			최종 주체인 process(프로그램)를 식별하지 못하기 때문에 
			프로세스를 구별하기 위해서 지정된 숫자.(0 ~ 1024 : System이 사용중)의 범위는 사용불가
			
			Socket 	유닉스(file(write, read))
			통신을 하기위한 주체(Object)
			IP, Port, TCP/UDP
			
			통신순서
			
			Server(중간자 역할)			Client
		1.	Socket 버전 확인				1. Socket 버전 확인
		2. 	Socket 생성					2. Socket 생성
		3.	IP, Port 설정(binding)
		4. 	listen 
		5. 	accept(항상 대기상태) 	<-----		3. connect
							접속성공
		6.	packet(데이터)의 송수신
			receive(받음)	<-----		send(보냄)
			send			----->		receive
		
		*/
		Socket clientSocket1 = null;	//소켓2
		List<Socket> list = new ArrayList<Socket>();
		
		//HashMap<Socket, String> map;
		
		
		try {
			//문지기 소켓
			ServerSocket servSocket = new ServerSocket(9000);	//소켓1
			//IP, Port, binding, listen
			
			while(true) {
				
				System.out.println("접속 대기중...");
				clientSocket1 = servSocket.accept();
				
				
				
				list.add(clientSocket1); //리스트에 다른 클라이언트를 모아줘서 클라이언트들이 서버에 보낸 글자를 다른 클라이언트에게 보내주기 위해서
				
				/*                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
				
					clientSocket : 접속된 소켓의 정보를 갖고 있는 Socket(1:1 통신밖에 안되니 한 명의 클라이언트만 통신함)
					담당자 소켓 
					TCP Client에서 Socket socket = new Socket();의 생성의미와 동일하지만
					ClientScoket에는 접속한 클라이언트의 주소정보를 받아오는 것뿐!
					
				*/
				
				//접속된 정보를 보기 위함
				System.out.println("접속된 Client 정보 IP: "+clientSocket1.getInetAddress() + 
									", Port : "+clientSocket1.getPort());	
				
				new SeverThread(clientSocket1, list).start();
				
				/*				
				//클라이언트에서 보낸것 확인 recv
				BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String msg = br.readLine();	//실직적으로 받는 부분
	
				System.out.println("클라이언트로부터 받은 메세지 : "+ msg);
				
				//클라이언트에게 보냄
				String ssg = "";
				System.out.print("전송문자열 : ");
				ssg = sc.next();
				
				//send
				PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());
				pw.println(ssg);
				pw.flush();  
 				*/
 
			}
			
//			clientSocket.close();
//			servSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	public static void clientName(Socket clients) {
//		Scanner sc = new Scanner(System.in);
//		HashMap<Socket, String> hmap = new HashMap<Socket, String>();
//		System.out.print("닉네임 입력 해 주세요 : ");
//		String name = sc.next();
//		Socket soc = clients;
//		
//		hmap.put(soc, name);
//		
//	}
	
}
