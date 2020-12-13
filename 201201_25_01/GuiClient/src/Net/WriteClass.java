package Net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import View.ClientFrame;
import View.Id;

//write
public class WriteClass {
	
	Socket socket;
	ClientFrame cf;
	
	String id;	//id
	String msg;	//클라이언트프레임 클래스 텍스트필드에서 가져오는 메세지 내용
	
	public WriteClass(ClientFrame cf) {
		this.cf = cf;
		this.socket = cf.socket;
	}
	
	public void sendMessage() {
		
		try {
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			//첫번째 전송일때 
			if(cf.isFirst == true) {
				//서버 주소 취득
				InetAddress iaddr = socket.getInetAddress();
				String ip = iaddr.getHostAddress(); //IPv4 주소가 나옴
				id = Id.textf.getText();	//ID클래스에서 대화명(채팅방 이름) 취득
				
				msg = "["+id+"]님 로그인("+ip+")"; //누가 로그인했는지 메세지출력
				
				cf.setTitle("접속자 : "+ id);
			}
			
			//그 다음부터 전송	-> 채팅 메시지
			else {
				msg = "["+id+"]"+cf.textf.getText();
			}
			
			pw.println(msg);
			pw.flush();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
