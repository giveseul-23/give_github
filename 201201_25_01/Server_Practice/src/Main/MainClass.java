package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;

import Thread.NameThread;
import Thread.ServerThread;

public class MainClass {

	public static void main(String[] args) {
		Socket clientSocket = null;
//		List<Socket> list = null; 
		HashMap<Socket, String> map = new HashMap<Socket, String>();
		
		try {
			ServerSocket serverSoc = new ServerSocket(7000);
			
			while(true) {
				System.out.println("접속 대기중...");
				clientSocket = serverSoc.accept();
				
				PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());
				pw.println("닉네임을 입력해 주세요 : ");
				pw.flush();
				
				BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String name = br.readLine();
				
				pw.println(name+"님 환영합니다.");
				pw.flush();
				
				map.put(clientSocket, name);
				
				new ServerThread(clientSocket, map).start();
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
