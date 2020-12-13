package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;

public class ClientServer extends Thread{
	Socket socket;
	
	public ClientServer(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		super.run();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String ssg;
			ssg = br.readLine();
			System.out.println("서버로 부터 받은 메세지 : " + ssg);
			Thread.sleep(300);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
