package Main;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import Net.ReadThread;
import View.ClientFrame;
import View.Id;

public class MainClass {
	public static void main(String[] args) throws Exception{ 
		
		//new Id(null, null);
		
		//new ClientFrame(null);	//클라이언트 프레임에서 new Id(this, wc); 아이디 클래스 생성중
		
		Socket socket = new Socket("192.168.1.103", 9000);
		System.out.println("Server Connection Success!");
		
		ClientFrame cf = new ClientFrame(socket);
		
		new ReadThread(socket, cf).start();
	}
}
