package Thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;

public class NameThread extends Thread{
	
	Socket clientSocket = null;
	HashMap<Socket, String> map = new HashMap<Socket, String>();
	
	public NameThread(Socket clientSocket, HashMap<Socket, String> map) {
		this.clientSocket = clientSocket;
		this.map = map;
	}

	@Override
	public void run() {
		super.run();
		try {
			PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());
			pw.println("닉네임을 입력해 주세요 : ");
			pw.flush();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String name = br.readLine();
			
			map.put(clientSocket, name);
			
			pw.println(name+"님 환영합니다.");
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
