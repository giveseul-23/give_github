package Thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.List;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ServerThread extends Thread{

	Socket clientSocket;
	HashMap<Socket, String> map;
	
	public ServerThread(Socket clientSocket, HashMap<Socket, String> map) {
		this.clientSocket = clientSocket;
		this.map = map;
	}

	@Override
	public void run() {
		super.run();
		try {
			while(true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String msg= br.readLine();
				System.out.println("서버로부터 받은 메세지 : " +  msg);
				
				for (Socket name : map.keySet()) {
					if(map.keySet() != clientSocket) {
						PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());
						pw.println(name + " : " + msg);
						pw.flush();
					}
				}

				Thread.sleep(500);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
