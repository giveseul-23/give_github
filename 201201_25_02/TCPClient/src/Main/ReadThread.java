package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ReadThread extends Thread{
	Scanner sc = new Scanner(System.in);
	
	Socket soc;
	
	public ReadThread(Socket soc) {
		this.soc = soc;
	}

	@Override
	public void run() {
		super.run();
		
		try {
			
			while(true) {
				//recv
				BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
				String ssg = br.readLine();
				System.out.println("서버에서 받은 메세지 : "+ssg);
				
				Thread.sleep(300);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	
}
