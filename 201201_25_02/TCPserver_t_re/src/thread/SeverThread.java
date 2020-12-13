package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class SeverThread extends Thread{
	Scanner sc = new Scanner(System.in);
	
	Socket clientSocket;
	List<Socket> list;
	
	public SeverThread(Socket clientSocket, List<Socket> list) {
		this.clientSocket = clientSocket;
		this.list = list;
	}

	@Override
	public void run(){
		super.run();
		
		
		try {
			while(true) {
				//클라이언트에서 보낸것 확인 recv
				BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String msg = br.readLine();	//실직적으로 받는 부분
		
				System.out.println("클라이언트로부터 받은 메세지 : "+ msg);
				
				//send
				for (int i = 0; i < list.size(); i++) {
					Socket s = list.get(i);
					if(s != clientSocket) {	//나 이외의 사람에게 보내줘
						PrintWriter pw = new PrintWriter(s.getOutputStream());
						pw.println(msg);
						pw.flush();
					}
				}
				
				Thread.sleep(500);
			}
		}catch (Exception e) {
			System.out.println("연결이 끊긴 IP:"+clientSocket.getInetAddress());	//클라이언트가 끊긴 경우
			list.remove(clientSocket); //remove에 index와 object 둘다 가능
			
			//남은 client를 확인
			for (Socket soc : list) {
				System.out.println("접속이 되어 있는 IP: " + soc.getInetAddress() + " Port: "+soc.getPort());
			}
			
			try {
				clientSocket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
}
