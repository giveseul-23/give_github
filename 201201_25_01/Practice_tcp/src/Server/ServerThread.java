package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class ServerThread extends Thread{
	
	Socket cSocket;
	List<Socket> list;
	
	public ServerThread(Socket cSocket, List<Socket> list) {
		this.cSocket = cSocket;
		this.list = list;
	}

	@Override
	public void run() {
		super.run();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
			String msg = br.readLine();
			System.out.println("클라이언트에게 받은 메세지 : "+msg);
			
			for (int i = 0; i < list.size(); i++) {
				Socket s = list.get(i);
				if(s != cSocket) {
					PrintWriter pw = new PrintWriter(s.getOutputStream());
					pw.println(msg);
					pw.flush();
				}
			}
			
			Thread.sleep(500);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
