package Net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import View.ClientFrame;

//rcev
public class ReadThread extends Thread {
	
	Socket socket;
	ClientFrame cf;
	
	public ReadThread(Socket socket, ClientFrame cf) {
		this.socket = socket;
		this.cf = cf;
	}

	@Override
	public void run() {
		super.run();
		
		try {
			while(true) {//계속해서 데이터(packet)을 받을 수 있음
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String str = br.readLine();
				if(str == null) {
					System.out.println("접속끊김");
				}
				
				cf.texta.append(str+"\n"); //클라이언트프레임의 텍스트에리어에 내용 추가
				
				Thread.sleep(300); //대기상태
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
