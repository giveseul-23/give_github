package Thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread extends Thread{
	
	Socket socket;
	
	public ClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		super.run();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg = br.readLine();
			System.out.println("받은 메세지 "+ msg);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
		
	
	
}
